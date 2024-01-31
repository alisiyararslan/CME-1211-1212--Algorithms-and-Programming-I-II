

public class Team {//outer class
	public  class Player {//inner class
		private int license_number;
		private String name;
		private Date birthdate;
		private String nationality;
		private Address address;
		private Phone phone;
		private String team;
		private Date start_date;
		private Date end_date;
		private int salary;
		private String position_role;
		public Player(int license_number, String name, Date birthdate, String nationality, Address address, Phone phone,
				String team, Date start_date, Date end_date, int salary, String position_role) {
			
			this.license_number = license_number;
			this.name = name;
			this.birthdate = birthdate;
			this.nationality = nationality;
			this.address = address;
			this.phone = phone;
			this.team = team;
			this.start_date = start_date;
			this.end_date = end_date;
			this.salary = salary;
			this.position_role = position_role;
		}
		public int getLicense_number() {
			return license_number;
		}
		public void setLicense_number(int license_number) {
			this.license_number = license_number;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getBirthdate() {
			return birthdate;
		}
		public void setBirthdate(Date birthdate) {
			this.birthdate = birthdate;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
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
		public String getPosition_role() {
			return position_role;
		}
		public void setPosition_role(String position_role) {
			this.position_role = position_role;
		}
		

	}
	private String name;
	private int year;
	private int cups;
	private String colors;
	private int point;
	private static int count=1;
	private  int teamID=1;
	
	public Team(String name,int year,int cups, String colors) {
		this.name=name;
		this.year=year;
		this.cups=cups;
		this.colors=colors;
		teamID=count;
		count++;
		
	}
	
	public Team(String name,int year,int cups, String colors,int point) {
		this(name,year,cups,colors);
		this.point=point;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCups() {
		return cups;
	}

	public void setCups(int cups) {
		this.cups = cups;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}
	
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	


}
