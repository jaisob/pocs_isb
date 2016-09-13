package project.ebd;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class EventRegister {
	
	/**    
	 * <attribute name="dateTimeProcessed" type="date" generator="dateTime"/>
        <attribute name="client" type="string" script="person.givenName + ' ' + person.familyName"/>
        <attribute name="street" type="string" script="address.street"/>
        <attribute name="postalCode" type="string" script="address.postalCode"/>
        <attribute name="city" type="string" script="address.city"/>
        <attribute name="country" type="string" script="country.isoCode"/>
        <attribute name="phone" type="string" script="address.mobilePhone"/>    
        <attribute name="ipClient" type="string" pattern="55\.[0-2][0-5][0-5]\.[0-2][0-5][0-5]\.[0-2][0-5][0-5]"/>
        <attribute name="ipServer" type="string" pattern="192\.168\.0\.[0-2][0-5][0-5]"/>
	 * */

	private final Date dateTimeProcessed;
	private final String client;
	private final String street;
	private final String postalCode;
	private final String city;
	private final String country;
	private final String phone;
	private final String ipClient;
	private final String ipServer;
	
	public EventRegister(Date dateTimeProcessed, String client,	String street, String postalCode, String city, String country,
			String phone, String ipHost, String ipServer) {
		super();
		this.dateTimeProcessed = dateTimeProcessed;
		this.client = client;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.ipClient = ipHost;	
		this.ipServer =  ipServer;
		
	}
	
	public String JsonOutput(){
		
		Gson gson = new Gson();
		JsonObject eventObject = new JsonObject();
		eventObject.addProperty("dateTimeProcessed", dateTimeProcessed.toString());
		eventObject.addProperty("user", client);
		eventObject.addProperty("street", street);
		eventObject.addProperty("postalCode", postalCode);
		eventObject.addProperty("city", city);
		eventObject.addProperty("country", country);
		eventObject.addProperty("phone", phone);
		eventObject.addProperty("ipClient", ipClient);
		eventObject.addProperty("ipServer", ipServer);

		return gson.toJson(eventObject);
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}


	public static EventRegister getInstance(Object[] args) {
		
		Date dateTimeProcessed = (Date) args[0];
		String client = args[1].toString();
		String street = args[2].toString();
		String postalCode = args[3].toString();
		String city = args[4].toString();
		String country = args[5].toString();
		String phone = args[6].toString();
		String ipClient = args[7].toString();
		String ipServer = args[8].toString();

		return new EventRegister( dateTimeProcessed,  client,  street,  postalCode,
				city,  country,  phone,  ipClient, ipServer);
		
	}

	/**
	 * @return the dateTimeProcessed
	 */
	public Date getDateTimeProcessed() {
		return dateTimeProcessed;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the ipClient
	 */
	public String getIpClient() {
		return ipClient;
	}

	/**
	 * @return the ipServer
	 */
	public String getIpServer() {
		return ipServer;
	}

}
