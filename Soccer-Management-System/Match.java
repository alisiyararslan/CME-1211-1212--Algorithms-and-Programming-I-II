
public class Match {
	private String home_team;
	private int number_of_goals_home_team;
	private String away_team;
	private int number_of_goals_away_team;
	private int refreeID1;
	private int refreeID2;
	private int refreeID3;
	private int stadiumID;
	public Match(String home_team, int number_of_goals_home_team, String away_team, int number_of_goals_away_team,
			int refreeID1, int refreeID2, int refreeID3, int stadiumID) {
		
		this.home_team = home_team;
		this.number_of_goals_home_team = number_of_goals_home_team;
		this.away_team = away_team;
		this.number_of_goals_away_team = number_of_goals_away_team;
		this.refreeID1 = refreeID1;
		this.refreeID2 = refreeID2;
		this.refreeID3 = refreeID3;
		this.stadiumID = stadiumID;
	}
	public String getHome_team() {
		return home_team;
	}
	public void setHome_team(String home_team) {
		this.home_team = home_team;
	}
	public int getNumber_of_goals_home_team() {
		return number_of_goals_home_team;
	}
	public void setNumber_of_goals_home_team(int number_of_goals_home_team) {
		this.number_of_goals_home_team = number_of_goals_home_team;
	}
	public String getAway_team() {
		return away_team;
	}
	public void setAway_team(String away_team) {
		this.away_team = away_team;
	}
	public int getNumber_of_goals_away_team() {
		return number_of_goals_away_team;
	}
	public void setNumber_of_goals_away_team(int number_of_goals_away_team) {
		this.number_of_goals_away_team = number_of_goals_away_team;
	}
	public int getRefreeID1() {
		return refreeID1;
	}
	public void setRefreeID1(int refreeID1) {
		this.refreeID1 = refreeID1;
	}
	public int getRefreeID2() {
		return refreeID2;
	}
	public void setRefreeID2(int refreeID2) {
		this.refreeID2 = refreeID2;
	}
	public int getRefreeID3() {
		return refreeID3;
	}
	public void setRefreeID3(int refreeID3) {
		this.refreeID3 = refreeID3;
	}
	public int getStadiumID() {
		return stadiumID;
	}
	public void setStadiumID(int stadiumID) {
		this.stadiumID = stadiumID;
	}
	
	


}
	
	


