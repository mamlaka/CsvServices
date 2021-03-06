package csvservices.impl;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixIdentifier;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.UserException;
import com.mendix.systemwideinterfaces.core.meta.IMetaAssociation;
import com.mendix.systemwideinterfaces.core.meta.IMetaPrimitive;

import java.io.*;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ako on 2/10/2015.
 */
public class CsvImporter {
    private static ILogNode logger = Core.getLogger(CsvImporter.class.getName());

    /*
     * Create new entities for uploaded stuff
     */
    public void csvToEntities(IContext context, Writer writer, String moduleName, String entityName, InputStream inputStream) throws IOException {
        logger.info("csvToEntities");
        final String csvSplitter = (",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        int lineNo = 0;
        String[] attributeNames = null;
        String[] attributeFormats = null;
        Format[] attributeFormatters = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        while ((line = bufferedReader.readLine()) != null) {
            if (line.startsWith("#") || line.length() == 0) {
                continue;
            }
            if (lineNo == 0) {
                // Header line
                attributeNames = line.split(csvSplitter);
                attributeFormats = new String[attributeNames.length];
                attributeFormatters = new Format[attributeNames.length];
                for (int i = 0; i < attributeNames.length; i++) {
                    attributeNames[i] = attributeNames[i].trim();
                    attributeNames[i] = attributeNames[i].replaceAll("^\"|\"$", "");
                    if (attributeNames[i].indexOf("(") >= 0) {
                        // format included in braces
                        attributeFormats[i] = attributeNames[i].substring(attributeNames[i].indexOf("(") + 1, attributeNames[i].length() - 1);
                        attributeNames[i] = attributeNames[i].substring(0, attributeNames[i].indexOf("("));
                        attributeFormatters[i] = new SimpleDateFormat(attributeFormats[i]);
                    }
                    logger.info("attribute: " + attributeNames[i] + ", format: " + attributeFormats[i]);
                }
            } else {
                IMendixObject object = null;
                try {
                    object = Core.instantiate(context, moduleName + "." + entityName);
                    String[] values = line.split(csvSplitter);
                    for (int i = 0; i < values.length; i++) {
                        values[i] = values[i].trim();
                        logger.info(String.format("value: %s = %s", attributeNames[i], values[i]));
                        /*
                         * check if reference
                         */
                        if (attributeNames[i].contains(".")) {
                            String[] refInfo = attributeNames[i].split("\\.");
                            logger.info("Assoc: " + refInfo[0]);

                            IMetaAssociation assoc = Core.getMetaAssociation(moduleName + "." + refInfo[0]);
                            logger.info("Assoc: " + assoc.getName() + ", " + assoc.getParent().getName() + " - " + assoc.getChild().getName());
                            /*
                             * check if reference set
                             */

                            if (values[i].startsWith("[") && values[i].endsWith("]")) {
                                // reference set
                                String[] refs = values[i].replaceAll("^\\[|\\]$", "").split(";");
                                // find referenced objects
                                List<IMendixIdentifier> ids = new ArrayList();
                                for (int ri = 0; ri < refs.length; ri++) {
                                    logger.info("ref: " + refs[ri]);
                                    String xpath = String.format("//%s[%s=%s]", assoc.getChild().getName(), refInfo[1], refs[ri]);
                                    logger.info("xpath = " + xpath);
                                    List<IMendixObject> refObjectList = Core.retrieveXPathQuery(context, xpath);
                                    if (refObjectList.size() == 1) {
                                        logger.info("ref object uuid: " + refObjectList.get(0).getId().toLong());
                                        ids.add(refObjectList.get(0).getId());
                                    } else {
                                        logger.info("found more than one object on ref");
                                    }
                                }
                                // add reference to object
                                object.setValue(context, assoc.getName(), ids);
                            } else {
                                // reference
                                String xpath = String.format("//%s[%s=%s]", assoc.getChild().getName(), refInfo[1], values[i]);
                                logger.info("reference xpath: " + xpath);
                                try {
                                    List<IMendixObject> refObjectList = Core.retrieveXPathQuery(context, xpath);
                                    logger.info("references obj id: " + refObjectList.get(0).getId().toLong());
                                    object.setValue(context, assoc.getName(), refObjectList.get(0).getId());
                                } catch (Exception e) {
                                    logger.info("Failed to set reference: " + e.getMessage());
                                }
                            }

                        } else {
                            /*
                             * set attribute value
                             */
                            IMetaPrimitive primitive = object.getMetaObject().getMetaPrimitive(attributeNames[i]);
                            IMetaPrimitive.PrimitiveType type = primitive.getType();
                            logger.info("attribute type: " + type.name());
                            values[i] = values[i].trim();
                            if (type.equals(IMetaPrimitive.PrimitiveType.DateTime)) {
                                try {
                                    if (attributeFormats[i] != null) {
                                        object.setValue(context, attributeNames[i], attributeFormatters[i].parseObject(values[i].replaceAll("^\"|\"$", "")));
                                    } else {
                                        object.setValue(context, attributeNames[i], dateTimeFormat.parse(values[i].replaceAll("^\"|\"$", "")));
                                    }
                                } catch (ParseException e) {
                                    try {
                                        object.setValue(context, attributeNames[i], dateFormat.parse(values[i].replaceAll("^\"|\"$", "")));
                                    } catch (ParseException e1) {
                                        try {
                                            object.setValue(context, attributeNames[i], dateFormat2.parse(values[i].replaceAll("^\"|\"$", "")));
                                        } catch (ParseException e2) {
                                            logger.warn("failed to parse date: " + values[i]);
                                        }
                                    }
                                }
                            } else {
                                object.setValue(context, attributeNames[i], values[i].replaceAll("^\"|\"$", ""));
                            }
                        }
                    }
                    logger.info("commiting object: " + object);
                    Core.commit(context, object);
                } catch (CoreException e) {
                    logger.warn("failed to create object: " + object);
                } catch (UserException e2) {
                    logger.warn("failed to create object: " + e2.getMessage());
                } catch (MendixRuntimeException e3) {
                    logger.warn("failed to create object: " + e3.getMessage());
                }
            }
            lineNo++;
        }
        logger.info("objects created: " + lineNo);
    }

}
