
public class Refree {

	private String name;
	private Address address;
	private Phone phone;
	private int salary;
	private static int count=1;
	private  int refereeID=1;
	public Refree(String name, Address address, Phone phone, int salary) {
		
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.salary = salary;
		refereeID=count;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getRefereeID() {
		return refereeID;
	}
	public void setRefereeID(int refereeID) {
		this.refereeID = refereeID;
	}
	

}
