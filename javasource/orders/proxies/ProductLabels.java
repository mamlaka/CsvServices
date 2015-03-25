// This file was generated by Mendix Business Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package orders.proxies;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixIdentifier;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * 
 */
public class ProductLabels
{
	private final IMendixObject productLabelsMendixObject;

	private final IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final String entityName = "Orders.ProductLabels";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		LabelId("LabelId"),
		Label("Label");

		private String metaName;

		MemberNames(String s)
		{
			metaName = s;
		}

		@Override
		public String toString()
		{
			return metaName;
		}
	}

	public ProductLabels(IContext context)
	{
		this(context, Core.instantiate(context, "Orders.ProductLabels"));
	}

	protected ProductLabels(IContext context, IMendixObject productLabelsMendixObject)
	{
		if (productLabelsMendixObject == null)
			throw new IllegalArgumentException("The given object cannot be null.");
		if (!Core.isSubClassOf("Orders.ProductLabels", productLabelsMendixObject.getType()))
			throw new IllegalArgumentException("The given object is not a Orders.ProductLabels");

		this.productLabelsMendixObject = productLabelsMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'ProductLabels.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static orders.proxies.ProductLabels initialize(IContext context, IMendixIdentifier mendixIdentifier) throws CoreException
	{
		return orders.proxies.ProductLabels.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.getSudoContext() can be used to obtain sudo access).
	 */
	public static orders.proxies.ProductLabels initialize(IContext context, IMendixObject mendixObject)
	{
		return new orders.proxies.ProductLabels(context, mendixObject);
	}

	public static orders.proxies.ProductLabels load(IContext context, IMendixIdentifier mendixIdentifier) throws CoreException
	{
		IMendixObject mendixObject = Core.retrieveId(context, mendixIdentifier);
		return orders.proxies.ProductLabels.initialize(context, mendixObject);
	}

	public static java.util.List<orders.proxies.ProductLabels> load(IContext context, String xpathConstraint) throws CoreException
	{
		java.util.List<orders.proxies.ProductLabels> result = new java.util.ArrayList<orders.proxies.ProductLabels>();
		for (IMendixObject obj : Core.retrieveXPathQuery(context, "//Orders.ProductLabels" + xpathConstraint))
			result.add(orders.proxies.ProductLabels.initialize(context, obj));
		return result;
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws CoreException
	{
		Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(IContext context) throws CoreException
	{
		Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(IContext context)
	{
		Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of LabelId
	 */
	public final Long getLabelId()
	{
		return getLabelId(getContext());
	}

	/**
	 * @param context
	 * @return value of LabelId
	 */
	public final Long getLabelId(IContext context)
	{
		return (Long) getMendixObject().getValue(context, MemberNames.LabelId.toString());
	}

	/**
	 * Set value of LabelId
	 * @param labelid
	 */
	public final void setLabelId(Long labelid)
	{
		setLabelId(getContext(), labelid);
	}

	/**
	 * Set value of LabelId
	 * @param context
	 * @param labelid
	 */
	public final void setLabelId(IContext context, Long labelid)
	{
		getMendixObject().setValue(context, MemberNames.LabelId.toString(), labelid);
	}

	/**
	 * @return value of Label
	 */
	public final String getLabel()
	{
		return getLabel(getContext());
	}

	/**
	 * @param context
	 * @return value of Label
	 */
	public final String getLabel(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.Label.toString());
	}

	/**
	 * Set value of Label
	 * @param label
	 */
	public final void setLabel(String label)
	{
		setLabel(getContext(), label);
	}

	/**
	 * Set value of Label
	 * @param context
	 * @param label
	 */
	public final void setLabel(IContext context, String label)
	{
		getMendixObject().setValue(context, MemberNames.Label.toString(), label);
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final IMendixObject getMendixObject()
	{
		return productLabelsMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final IContext getContext()
	{
		return context;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final orders.proxies.ProductLabels that = (orders.proxies.ProductLabels) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static String getType()
	{
		return "Orders.ProductLabels";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@Deprecated
	public String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}