
public class Phone {
	private int country_code;
	private int area_code;
	private int number;
	
	
	public Phone(int country_code, int area_code, int number) {
		this.country_code = country_code;
		this.area_code = area_code;
		this.number = number;
	}
	
	
	public int getCountry_code() {
		return country_code;
	}
	public void setCountry_code(int country_code) {
		this.country_code = country_code;
	}
	public int getArea_code() {
		return area_code;
	}
	public void setArea_code(int area_code) {
		this.area_code = area_code;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	

}
