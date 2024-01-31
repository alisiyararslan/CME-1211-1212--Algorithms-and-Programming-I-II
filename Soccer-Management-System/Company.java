
public class Company {
	private String name;
	private Address address;
	private Phone phone;
	private String team;
	private static int count=1;
	private  int companyID=1;
	public Company(String name, Address address, Phone phone, String team) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.team = team;
		companyID=count;
		count++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	
	

	
}
