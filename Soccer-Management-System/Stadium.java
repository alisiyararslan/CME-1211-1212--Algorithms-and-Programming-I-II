
public class Stadium {
	private String name;
	private String city;
	private int capacity;
	private boolean lightning;
	private String surface;
	private static int count=1;
	private  int stadiumID=1;
	public Stadium(String name, String city, int capacity, boolean lightning, String surface) {
		
		this.name = name;
		this.city = city;
		this.capacity = capacity;
		this.lightning = lightning;
		this.surface = surface;
		stadiumID=count;
		count++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public boolean isLightning() {
		return lightning;
	}
	public void setLightning(boolean lightning) {
		this.lightning = lightning;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public int getStadiumID() {
		return stadiumID;
	}
	public void setStadiumID(int stadiumID) {
		this.stadiumID = stadiumID;
	}
	
	
	
	

	
}


