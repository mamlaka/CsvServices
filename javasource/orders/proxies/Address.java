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
public class Address
{
	private final IMendixObject addressMendixObject;

	private final IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final String entityName = "Orders.Address";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		AddressId("AddressId"),
		Street("Street"),
		City("City"),
		County("County"),
		State("State"),
		Zipcode("Zipcode"),
		Country("Country"),
		Latitude("Latitude"),
		Longitude("Longitude"),
		Billing_Address("Orders.Billing_Address"),
		Delivery_Address("Orders.Delivery_Address");

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

	public Address(IContext context)
	{
		this(context, Core.instantiate(context, "Orders.Address"));
	}

	protected Address(IContext context, IMendixObject addressMendixObject)
	{
		if (addressMendixObject == null)
			throw new IllegalArgumentException("The given object cannot be null.");
		if (!Core.isSubClassOf("Orders.Address", addressMendixObject.getType()))
			throw new IllegalArgumentException("The given object is not a Orders.Address");

		this.addressMendixObject = addressMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'Address.load(IContext, IMendixIdentifier)' instead.
	 */
	@Deprecated
	public static orders.proxies.Address initialize(IContext context, IMendixIdentifier mendixIdentifier) throws CoreException
	{
		return orders.proxies.Address.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.getSudoContext() can be used to obtain sudo access).
	 */
	public static orders.proxies.Address initialize(IContext context, IMendixObject mendixObject)
	{
		return new orders.proxies.Address(context, mendixObject);
	}

	public static orders.proxies.Address load(IContext context, IMendixIdentifier mendixIdentifier) throws CoreException
	{
		IMendixObject mendixObject = Core.retrieveId(context, mendixIdentifier);
		return orders.proxies.Address.initialize(context, mendixObject);
	}

	public static java.util.List<orders.proxies.Address> load(IContext context, String xpathConstraint) throws CoreException
	{
		java.util.List<orders.proxies.Address> result = new java.util.ArrayList<orders.proxies.Address>();
		for (IMendixObject obj : Core.retrieveXPathQuery(context, "//Orders.Address" + xpathConstraint))
			result.add(orders.proxies.Address.initialize(context, obj));
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
	 * @return value of AddressId
	 */
	public final Long getAddressId()
	{
		return getAddressId(getContext());
	}

	/**
	 * @param context
	 * @return value of AddressId
	 */
	public final Long getAddressId(IContext context)
	{
		return (Long) getMendixObject().getValue(context, MemberNames.AddressId.toString());
	}

	/**
	 * Set value of AddressId
	 * @param addressid
	 */
	public final void setAddressId(Long addressid)
	{
		setAddressId(getContext(), addressid);
	}

	/**
	 * Set value of AddressId
	 * @param context
	 * @param addressid
	 */
	public final void setAddressId(IContext context, Long addressid)
	{
		getMendixObject().setValue(context, MemberNames.AddressId.toString(), addressid);
	}

	/**
	 * @return value of Street
	 */
	public final String getStreet()
	{
		return getStreet(getContext());
	}

	/**
	 * @param context
	 * @return value of Street
	 */
	public final String getStreet(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.Street.toString());
	}

	/**
	 * Set value of Street
	 * @param street
	 */
	public final void setStreet(String street)
	{
		setStreet(getContext(), street);
	}

	/**
	 * Set value of Street
	 * @param context
	 * @param street
	 */
	public final void setStreet(IContext context, String street)
	{
		getMendixObject().setValue(context, MemberNames.Street.toString(), street);
	}

	/**
	 * @return value of City
	 */
	public final String getCity()
	{
		return getCity(getContext());
	}

	/**
	 * @param context
	 * @return value of City
	 */
	public final String getCity(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.City.toString());
	}

	/**
	 * Set value of City
	 * @param city
	 */
	public final void setCity(String city)
	{
		setCity(getContext(), city);
	}

	/**
	 * Set value of City
	 * @param context
	 * @param city
	 */
	public final void setCity(IContext context, String city)
	{
		getMendixObject().setValue(context, MemberNames.City.toString(), city);
	}

	/**
	 * @return value of County
	 */
	public final String getCounty()
	{
		return getCounty(getContext());
	}

	/**
	 * @param context
	 * @return value of County
	 */
	public final String getCounty(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.County.toString());
	}

	/**
	 * Set value of County
	 * @param county
	 */
	public final void setCounty(String county)
	{
		setCounty(getContext(), county);
	}

	/**
	 * Set value of County
	 * @param context
	 * @param county
	 */
	public final void setCounty(IContext context, String county)
	{
		getMendixObject().setValue(context, MemberNames.County.toString(), county);
	}

	/**
	 * @return value of State
	 */
	public final String getState()
	{
		return getState(getContext());
	}

	/**
	 * @param context
	 * @return value of State
	 */
	public final String getState(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.State.toString());
	}

	/**
	 * Set value of State
	 * @param state
	 */
	public final void setState(String state)
	{
		setState(getContext(), state);
	}

	/**
	 * Set value of State
	 * @param context
	 * @param state
	 */
	public final void setState(IContext context, String state)
	{
		getMendixObject().setValue(context, MemberNames.State.toString(), state);
	}

	/**
	 * @return value of Zipcode
	 */
	public final String getZipcode()
	{
		return getZipcode(getContext());
	}

	/**
	 * @param context
	 * @return value of Zipcode
	 */
	public final String getZipcode(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.Zipcode.toString());
	}

	/**
	 * Set value of Zipcode
	 * @param zipcode
	 */
	public final void setZipcode(String zipcode)
	{
		setZipcode(getContext(), zipcode);
	}

	/**
	 * Set value of Zipcode
	 * @param context
	 * @param zipcode
	 */
	public final void setZipcode(IContext context, String zipcode)
	{
		getMendixObject().setValue(context, MemberNames.Zipcode.toString(), zipcode);
	}

	/**
	 * @return value of Country
	 */
	public final String getCountry()
	{
		return getCountry(getContext());
	}

	/**
	 * @param context
	 * @return value of Country
	 */
	public final String getCountry(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.Country.toString());
	}

	/**
	 * Set value of Country
	 * @param country
	 */
	public final void setCountry(String country)
	{
		setCountry(getContext(), country);
	}

	/**
	 * Set value of Country
	 * @param context
	 * @param country
	 */
	public final void setCountry(IContext context, String country)
	{
		getMendixObject().setValue(context, MemberNames.Country.toString(), country);
	}

	/**
	 * @return value of Latitude
	 */
	public final String getLatitude()
	{
		return getLatitude(getContext());
	}

	/**
	 * @param context
	 * @return value of Latitude
	 */
	public final String getLatitude(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.Latitude.toString());
	}

	/**
	 * Set value of Latitude
	 * @param latitude
	 */
	public final void setLatitude(String latitude)
	{
		setLatitude(getContext(), latitude);
	}

	/**
	 * Set value of Latitude
	 * @param context
	 * @param latitude
	 */
	public final void setLatitude(IContext context, String latitude)
	{
		getMendixObject().setValue(context, MemberNames.Latitude.toString(), latitude);
	}

	/**
	 * @return value of Longitude
	 */
	public final String getLongitude()
	{
		return getLongitude(getContext());
	}

	/**
	 * @param context
	 * @return value of Longitude
	 */
	public final String getLongitude(IContext context)
	{
		return (String) getMendixObject().getValue(context, MemberNames.Longitude.toString());
	}

	/**
	 * Set value of Longitude
	 * @param longitude
	 */
	public final void setLongitude(String longitude)
	{
		setLongitude(getContext(), longitude);
	}

	/**
	 * Set value of Longitude
	 * @param context
	 * @param longitude
	 */
	public final void setLongitude(IContext context, String longitude)
	{
		getMendixObject().setValue(context, MemberNames.Longitude.toString(), longitude);
	}

	/**
	 * @return value of Billing_Address
	 */
	public final orders.proxies.Customers getBilling_Address() throws CoreException
	{
		return getBilling_Address(getContext());
	}

	/**
	 * @param context
	 * @return value of Billing_Address
	 */
	public final orders.proxies.Customers getBilling_Address(IContext context) throws CoreException
	{
		orders.proxies.Customers result = null;
		IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Billing_Address.toString());
		if (identifier != null)
			result = orders.proxies.Customers.load(context, identifier);
		return result;
	}

	/**
	 * Set value of Billing_Address
	 * @param billing_address
	 */
	public final void setBilling_Address(orders.proxies.Customers billing_address)
	{
		setBilling_Address(getContext(), billing_address);
	}

	/**
	 * Set value of Billing_Address
	 * @param context
	 * @param billing_address
	 */
	public final void setBilling_Address(IContext context, orders.proxies.Customers billing_address)
	{
		if (billing_address == null)
			getMendixObject().setValue(context, MemberNames.Billing_Address.toString(), null);
		else
			getMendixObject().setValue(context, MemberNames.Billing_Address.toString(), billing_address.getMendixObject().getId());
	}

	/**
	 * @return value of Delivery_Address
	 */
	public final orders.proxies.Customers getDelivery_Address() throws CoreException
	{
		return getDelivery_Address(getContext());
	}

	/**
	 * @param context
	 * @return value of Delivery_Address
	 */
	public final orders.proxies.Customers getDelivery_Address(IContext context) throws CoreException
	{
		orders.proxies.Customers result = null;
		IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Delivery_Address.toString());
		if (identifier != null)
			result = orders.proxies.Customers.load(context, identifier);
		return result;
	}

	/**
	 * Set value of Delivery_Address
	 * @param delivery_address
	 */
	public final void setDelivery_Address(orders.proxies.Customers delivery_address)
	{
		setDelivery_Address(getContext(), delivery_address);
	}

	/**
	 * Set value of Delivery_Address
	 * @param context
	 * @param delivery_address
	 */
	public final void setDelivery_Address(IContext context, orders.proxies.Customers delivery_address)
	{
		if (delivery_address == null)
			getMendixObject().setValue(context, MemberNames.Delivery_Address.toString(), null);
		else
			getMendixObject().setValue(context, MemberNames.Delivery_Address.toString(), delivery_address.getMendixObject().getId());
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final IMendixObject getMendixObject()
	{
		return addressMendixObject;
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
			final orders.proxies.Address that = (orders.proxies.Address) obj;
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
		return "Orders.Address";
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