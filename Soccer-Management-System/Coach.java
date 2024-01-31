

public class Coach {
	private String name;
	private Address address;
	private Phone phone;
	private String team;
	private Date start_date;
	private Date end_date;
	private int salary;
	private static int count=1;
	private  int coachID=1;
	
	
	public Coach(String name, Address address, Phone phone, String team, Date start_date, Date end_date, int salary) {
		
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.team = team;
		this.start_date = start_date;
		this.end_date = end_date;
		this.salary = salary;
		coachID=count;
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
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getCoachID() {
		return coachID;
	}
	public void setCoachID(int coachID) {
		this.coachID = coachID;
	}
	


}
