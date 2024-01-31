
public class Address {
	private String street;
	private String town;
	private String city;
	private String country;
	
	
	public Address(String street, String town, String city) {// first constructor for country attributes is not entered
		this.street = street;
		this.town = town;
		this.city = city;
		
	}
	public Address(String street, String town, String city, String country) {// second constructor for all attributes are entered
		this(street,town,city);
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
