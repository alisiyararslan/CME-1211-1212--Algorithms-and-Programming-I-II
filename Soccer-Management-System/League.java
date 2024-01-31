import java.io.*;
import java.util.Scanner;

public class League {
	
	
	// all array are dynamic so length can be here 0
		static Team[] teams=new Team[0];
		static Stadium[] stadiums=new Stadium[0];
		static Refree[] refrees=new Refree[0];
		static Company[] companies=new Company[0];
		static Match[] matches=new Match[0];
		static Team.Player[] players=new Team.Player[0];
		static Coach[] coaches=new Coach[0];
		
		//error check for date
		
		public static boolean checkDate(Date _date) {
			boolean flag=true;
			if ((_date.getMonth()==1||_date.getMonth()==3||_date.getMonth()==5||_date.getMonth()==7||_date.getMonth()==8||_date.getMonth()==10||_date.getMonth()==12)&&(_date.getDay()>31||_date.getDay()<0)) {//see if that month has the 31st day
				flag=false;
			}
			else if ((_date.getMonth()==4||_date.getMonth()==6||_date.getMonth()==9||_date.getMonth()==11)&&(_date.getDay()>30||_date.getDay()<0)) {//see if that month has the 30st day
				flag=false;
			}
			else if (_date.getMonth()==2) {//february process
				if ((_date.getYear()%4==0)&&(_date.getDay()>29||_date.getDay()<0)) {//see if that year is a leap year
					flag=false;
				}
				else if (!(_date.getYear()%4==0)&&(_date.getDay()>28||_date.getDay()<0)) {//see if that year is not a leap year
					flag=false;
				}
			}
			else if (_date.getYear()<0||_date.getMonth()<0||_date.getMonth()>12) {
				flag=false;
			}
			return flag;
		}
		
		//error check for match in a stadium that is not stored in the system 
		
			public static boolean checkStadium(Stadium[] _stadiums,Match _match) {//!
				
				
				for (int i = 0; i < _stadiums.length; i++) {//Search the stadium of the match through all stadiums
					if (_stadiums[i].getStadiumID()==_match.getStadiumID()) {
						return true;
					}
				}
				return false;

			}
			
			
		//error check for match in a refree that is not stored in the system 
		
			public static boolean checkRefree(Refree[] _refrees,Match _match) {
				boolean refree1=false;
				boolean refree2=false;
				boolean refree3=false;
				
				
				for (int i = 0; i < _refrees.length; i++) {//search for match referees among all referees
					if (_refrees[i].getRefereeID()==_match.getRefreeID1()) {
						refree1=true;
					}
					if (_refrees[i].getRefereeID()==_match.getRefreeID2()) {
						refree2=true;
					}
					if (_refrees[i].getRefereeID()==_match.getRefreeID3()) {
						refree3=true;
					}
				}
				return refree1&&refree2&&refree3;

			}
		
		
		
		//error check for Contract start date must be smaller than the contract end date 
		
		
		public static boolean checkStartDate_EndDate(Date _start_date,Date _end_date) {
			boolean flag =true;
			
			if (_start_date.getYear()>_end_date.getYear()) {//just compare the years
				flag =false;
			}
			else if ((_start_date.getYear()==_end_date.getYear())&&(_start_date.getMonth()>_end_date.getMonth())) {//just compare the months if years are equal
				flag =false;
			}
			else if ((_start_date.getYear()==_end_date.getYear())&&(_start_date.getMonth()==_end_date.getMonth())&&(_start_date.getDay()>_end_date.getDay())) {//just compare the days if years and months are equal
				flag =false;
			}
			
			
			
			return flag;
		}
		
		
		//error check for number cannot be negative
		
		public static boolean checkPositive(int number) {
			if (number<0) {//return false if number is negative
				return false;
			}
			return true;
		}
		
		
		
		
		
		
		//TEAM
		
		
		public static Team[] addTeam(String name,int year, int cups, String colors,Team[] teams) {
			Team[] added_teams=new Team[teams.length+1];//create a new array that is 1 longer than the current length
			
			for (int i = 0; i < teams.length; i++) {//add current elements
				added_teams[i]=teams[i];
				
			}
			added_teams[teams.length]=new Team(name,year,cups,colors);//add new element
			
			return added_teams;		
			
			
		}
		
		public static void listTeam(Team[] teams) {
			System.out.println("*************************************************\n"
					+ "                   TEAMS\n"
					+ "*************************************************");
			
			for (int i = 0; i < teams.length; i++) {//list properties in order
				System.out.println((i+1)+". Team");
				System.out.println("Name    :"+teams[i].getName());
				System.out.println("Year    :"+teams[i].getYear());
				System.out.println("Cups    :"+teams[i].getCups());
				System.out.println("Colors  :"+teams[i].getColors());
				System.out.println("Points  :"+teams[i].getPoint());
				for (int j = 0; j < coaches.length; j++) {//spot and print that team's coach
					if (coaches[j].getTeam().equals(teams[i].getName())) {
						System.out.println("Coach   :"+coaches[j].getName());
					}
				}
				System.out.println("Team ID :"+teams[i].getTeamID());
				System.out.println("*************************************************");
			}
		}
		public static Team[] sortTeam(Team[] teams) {//sort teams by score
			boolean sorted=false;
			Team temp;
			while (!sorted) {
				sorted=true;
				for (int i = 0; i < teams.length-1; i++) {//
					if (teams[i].getPoint()<teams[i+1].getPoint()) {//compare two elements and swap large and small
						temp=teams[i+1];
						teams[i+1]=teams[i];
						teams[i]=temp;
						sorted=false;
					}
				}
				
			}
			
			return teams;
		}
		
		public static void scores(Team[] teams) {
			System.out.println("Scores:");
			String winner="";
			for (int i = 0; i < teams.length; i++) {//determine the first team
				if (teams[i].getPoint()==teams[0].getPoint()) {
					winner+=teams[i].getName()+"  ";
				}
				System.out.println((i+1)+")"+teams[i].getName()+"----->"+teams[i].getPoint());
			}
			System.out.println("Winner :"+winner);
			
			
		}
		
		
		
		//COACH
		public static Coach[] addCoach(String name, Address address, Phone phone, String team, Date start_date, Date end_date, int salary,Coach[] coaches) {
			Coach[] added_coaches=new Coach[coaches.length+1];//create a new array that is 1 longer than the current length
			
			for (int i = 0; i < coaches.length; i++) {//add current elements
				added_coaches[i]=coaches[i];
			}
			
			added_coaches[coaches.length]=new Coach(name,  address,  phone,  team,  start_date,  end_date,  salary);//add new element
			
			return added_coaches;
			
		}
		public static void listCoach(Coach[] coaches) {
			System.out.println("                   COACHES\n"
					+ "*************************************************");
			
			for (int i = 0; i < coaches.length; i++) {//list properties in order
				System.out.println((i+1)+". Coach");
				System.out.println("Name     :"+coaches[i].getName());
				System.out.println("Address  :\n"
						+ "     Street  :"+coaches[i].getAddress().getStreet()
						+ "\n     Town    :"+coaches[i].getAddress().getTown()
						+ "\n     City    :"+coaches[i].getAddress().getCity()
						+ "\n     Country :"+coaches[i].getAddress().getCountry());
				System.out.println("Phone    :"+coaches[i].getPhone().getCountry_code()+" "+coaches[i].getPhone().getArea_code()+" "+coaches[i].getPhone().getNumber());
				System.out.println("Team     :"+coaches[i].getTeam());
				System.out.println("Starting the contract date  :"+coaches[i].getStart_date().getDay()+"/"+coaches[i].getStart_date().getMonth()+"/"+coaches[i].getStart_date().getYear());
				System.out.println("End the contract date  :"+coaches[i].getEnd_date().getDay()+"/"+coaches[i].getEnd_date().getMonth()+"/"+coaches[i].getEnd_date().getYear());
				System.out.println("Salary   :"+coaches[i].getSalary());
				System.out.println("Coach ID :"+coaches[i].getCoachID());
						
				
				System.out.println("*************************************************");
			}
		}
		
		static Team myteam=new Team(" ",0,0,"");//occured only for the inner class
		
		//PLAYER
		
		public  static Team.Player[] addPlayer(int license_number, String name, Date birthdate, String nationality, Address address, Phone phone,
				String team, Date start_date, Date end_date, int salary, String position_role,Team.Player[] players) {
			Team.Player[] added_players=new Team.Player[players.length+1];//create a new array that is 1 longer than the current length
			
			for (int i = 0; i < players.length; i++) {//add current elements
				added_players[i]=players[i];
			}
			added_players[players.length]=myteam.new Player( license_number,  name,  birthdate,  nationality,  address,  phone,team,  start_date,  end_date,  salary,  position_role);//add new element
			
			return added_players;
			
		}
		
		public static boolean containPlayer(int license_number,Team.Player[] players) {//Check if there is a player on the given id
			
			for (int i = 0; i < players.length; i++) {
				if (players[i].getLicense_number()==license_number) {
					return true;
				}
			}
			return false;
		}
		
		public static Team.Player[] deletePlayer(int license_number,Team.Player[] players) {//delete player in given id
			Team.Player[] deleted_players=new Team.Player[League.players.length-1];//create a new array that is 1 shorter than the current length
			int index=0;
			for (int i = 0; i < players.length; i++) {//add all elements except the given id
				if (players[i].getLicense_number()!=license_number) {
					deleted_players[index]=players[i];
					index++;
				}
			}
			return deleted_players;
		}
		
		public static void listPlayer(Team.Player[] players) {
			System.out.println("                   PLAYERS\n"
					+ "*************************************************");
			
			for (int i = 0; i < players.length; i++) {//list properties in order
				System.out.println((i+1)+". Player");
				System.out.println("License number :"+players[i].getLicense_number());
				System.out.println("Name        :"+players[i].getName());
				System.out.println("Birthdate   :"+players[i].getBirthdate().getDay()+"/"+players[i].getBirthdate().getMonth()+"/"+players[i].getBirthdate().getYear());
				System.out.println("Nationality :"+players[i].getNationality());
				System.out.println("Address  :\n"
						+ "     Street  :"+players[i].getAddress().getStreet()
						+ "\n     Town    :"+players[i].getAddress().getTown()
						+ "\n     City    :"+players[i].getAddress().getCity()
						+ "\n     Country :"+players[i].getAddress().getCountry());
				System.out.println("Phone    :"+players[i].getPhone().getCountry_code()+" "+players[i].getPhone().getArea_code()+" "+players[i].getPhone().getNumber());
				System.out.println("Team     :"+players[i].getTeam());
				System.out.println("Starting the contract date  :"+players[i].getStart_date().getDay()+"/"+players[i].getStart_date().getMonth()+"/"+players[i].getStart_date().getYear());
				System.out.println("End the contract date  :"+players[i].getEnd_date().getDay()+"/"+players[i].getEnd_date().getMonth()+"/"+players[i].getEnd_date().getYear());
				System.out.println("Salary   :"+players[i].getSalary());
				System.out.println("Position role:"+players[i].getPosition_role());
						
				
				System.out.println("*************************************************");
			}
		}
		
		
		//STADIUM
		
		public static Stadium[] addStadium(String name, String city, int capacity, boolean lightning, String surface,Stadium[] stadiums) {
			Stadium[] added_stadiums=new Stadium[stadiums.length+1];//create a new array that is 1 longer than the current length
			
			for (int i = 0; i < stadiums.length; i++) {//add current elements
				added_stadiums[i]=stadiums[i];
			}
			
			added_stadiums[stadiums.length]= new Stadium( name,  city,  capacity,  lightning,  surface);//add new element
			
			
			return added_stadiums;
		}
		
		public static void listStadium(Stadium[] stadiums) {
			System.out.println("                   STADIUMS\n"
					+ "*************************************************");
			
			for (int i = 0; i < stadiums.length; i++) {//list properties in order
				System.out.println((i+1)+". Stadium");
				
				System.out.println("Name        :"+stadiums[i].getName());
				System.out.println("City        :"+stadiums[i].getCity());
				System.out.println("Capacity    :"+stadiums[i].getCapacity());
				System.out.println("Lightning   :"+stadiums[i].isLightning());
				System.out.println("Surface     :"+stadiums[i].getSurface());
				System.out.println("Stadium ID  :"+stadiums[i].getStadiumID());
				
						
				
				System.out.println("*************************************************");
		}
		
		
		}
		
		public static void biggestStadium(Stadium[] stadiums) {// find the biggest stadium
			int temp=0;
			String name="";
			for (int i = 0; i < stadiums.length; i++) {
				if (stadiums[i].getCapacity()>temp) {//replace the previous one if you find the bigger one
					temp=stadiums[i].getCapacity();
					name=stadiums[i].getName();
				}
				else if (stadiums[i].getCapacity()==temp) {//add up with previous if you find equal
					name+="  "+stadiums[i].getName();
				}
			}
			System.out.println("The biggest stadium :"+name+" \n"
					+ "capacity  :" +temp );
			
		}
		
		
		
		
		
		//REFREE
		
		public static Refree[] addRefree(String name, Address address, Phone phone, int salary,Refree[] refrees) {
			
			Refree[] added_refrees=new Refree[refrees.length+1];//create a new array that is 1 longer than the current length
			
			for (int i = 0; i < refrees.length; i++) {//add current elements
				added_refrees[i]=refrees[i];
			}
			
			added_refrees[refrees.length]=new Refree( name,  address,  phone,  salary);//add new element
			
			return added_refrees;
		}
		
		public static void listRefree(Refree[] refrees) {
			System.out.println("                   REFREES\n"
					+ "*************************************************");
			
			for (int i = 0; i < refrees.length; i++) {//list properties in order
				System.out.println((i+1)+". Refree");
				
				System.out.println("Name     :"+refrees[i].getName());
				
				System.out.println("Address  :\n"
						+ "     Street  :"+refrees[i].getAddress().getStreet()
						+ "\n     Town    :"+refrees[i].getAddress().getTown()
						+ "\n     City    :"+refrees[i].getAddress().getCity()
						+ "\n     Country :"+refrees[i].getAddress().getCountry());
				System.out.println("Phone     :"+refrees[i].getPhone().getCountry_code()+" "+refrees[i].getPhone().getArea_code()+" "+refrees[i].getPhone().getNumber());
				System.out.println("Salary    :"+refrees[i].getSalary());
				System.out.println("Refree ID :"+refrees[i].getRefereeID());

						
				
				System.out.println("*************************************************");
			}
		}
		
		
		public static void increaseSalariesRefree(Refree[] refrees) {//increase the salary of all referees by ten percent
			for (int i = 0; i < refrees.length; i++) {
				int new_salary=refrees[i].getSalary()+(refrees[i].getSalary()*10)/100;
				refrees[i].setSalary(new_salary);
			}
		}
		
		
		//COMPANY
		public static Company[] addCompany(String name, Address address, Phone phone, String team,Company[] companies) {
			
			Company[] added_companies=new Company[companies.length+1];//create a new array that is 1 longer than the current length
			
			for (int i = 0; i < companies.length; i++) {//add current elements
				added_companies[i]=companies[i];
			}
			
			added_companies[companies.length]=new Company( name,  address,  phone,team);//add new element
			
			return added_companies;
		}
		public static void listCompany(Company[] companies) {
		System.out.println("                   COMPANIES\n"
				+ "*************************************************");
		
		for (int i = 0; i < companies.length; i++) {//list properties in order
			System.out.println((i+1)+". Company");
			
			System.out.println("Name     :"+companies[i].getName());
			
			System.out.println("Address  :\n"
					+ "     Street  :"+companies[i].getAddress().getStreet()
					+ "\n     Town    :"+companies[i].getAddress().getTown()
					+ "\n     City    :"+companies[i].getAddress().getCity()
					+ "\n     Country :"+companies[i].getAddress().getCountry());
			System.out.println("Phone   :"+companies[i].getPhone().getCountry_code()+" "+companies[i].getPhone().getArea_code()+" "+companies[i].getPhone().getNumber());
			System.out.println("Team    :"+companies[i].getTeam());

					
			
			System.out.println("*************************************************");
		}
	}
		
		//MATCH
		
		public static Match[] addMatch(String home_team, int number_of_goals_home_team, String away_team, int number_of_goals_away_team,
				int refreeID1, int refreeID2, int refreeID3, int stadiumID,Match[] matches) {
				
			Match[] added_matches=new Match[matches.length+1];//create a new array that is 1 longer than the current length
				
				for (int i = 0; i < matches.length; i++) {//add current elements
					added_matches[i]=matches[i];
				}
				
				added_matches[matches.length]=new Match(  home_team,  number_of_goals_home_team,  away_team,  number_of_goals_away_team,//add new element
						 refreeID1,  refreeID2,  refreeID3,  stadiumID);
				
				return added_matches;
			}
			
			public static Team[] awarded_point(Match match,Team[] teams) {//calculate points
				

				String won_team="";
				
				if (match.getNumber_of_goals_home_team()>match.getNumber_of_goals_away_team()) {//identify the winning team
					won_team=match.getHome_team();
				}
				else if (match.getNumber_of_goals_home_team()<match.getNumber_of_goals_away_team()) {//identify the winning team
					won_team=match.getAway_team();
				}

				if (!won_team.equals("")) {//If there is a winning team
					for (int i = 0; i < teams.length; i++) {
						if (teams[i].getName().equals(won_team)) {//add 3 points to the winning team
							teams[i].setPoint(teams[i].getPoint()+3);
						}
					}
				}
				else {//If there is not a winning team
					for (int i = 0; i < teams.length; i++) {
						if (teams[i].getName().equals(match.getHome_team())) {//add 1 point to the tied team
							teams[i].setPoint(teams[i].getPoint()+1);
						}
						else if (League.teams[i].getName().equals(match.getAway_team())) {//add 1 point to the tied team
							teams[i].setPoint(teams[i].getPoint()+1);
						}
					}
				}
				return teams;
				
				
			}
			public static void listMatch(Match[] matches) {
				System.out.println("                   MATCHES\n"
						+ "*************************************************");
				
				for (int i = 0; i < matches.length; i++) {//list properties in order
					System.out.println((i+1)+". Match");
					
					System.out.println("Home team name   :"+matches[i].getHome_team());
					System.out.println("Number of goals home team  :"+matches[i].getNumber_of_goals_home_team());
					System.out.println("Home team name   :"+matches[i].getAway_team());
					System.out.println("Number of goals home team  :"+matches[i].getNumber_of_goals_away_team());
					System.out.println("1st referee's ID  :"+matches[i].getRefreeID1());
					System.out.println("2st referee's ID  :"+matches[i].getRefreeID2());
					System.out.println("3st referee's ID  :"+matches[i].getRefreeID3());


							
					
					System.out.println("*************************************************");
				}
			}
			
			public static void main(String[] args) {
				int count_of_row=0;

				String[] rows=null;

				
				try {//file reading operations
				      File myObj = new File("input.txt");//file path
				      Scanner myReader = new Scanner(myObj,"UTF-8");// first reader for determine find how many rows
				      while (myReader.hasNextLine()) {
				        //String data = myReader.nextLine();
				    	myReader.nextLine();
				        count_of_row++;
				      }
				      myReader.close();
				      
				      rows =new String[count_of_row];//new array with the length of the number of rows found
				      int row_count=0;
				      Scanner myReader2 = new Scanner(myObj,"UTF-8");// second saving the read lines to array
				      while (myReader2.hasNextLine()) {
				        rows[row_count]=myReader2.nextLine();
				        row_count++;
				      }
				      myReader2.close();
				    } catch (FileNotFoundException e) {//error catch
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
				
				boolean no_error=false;//Are there any errors in the program?
				for (int i = 0; i < count_of_row; i++) {
					
					String[] each_row=rows[i].split(";");
					
					
					
					
					if (each_row[0].equals("AddTeam")) {
						if (each_row.length>5) {
							System.out.println("!!! LENGTH ERROR !!! more than 4 parameters cannot be entered for add team.");//error message for length
							break;
						}
						if (each_row.length<5) {
							System.out.println("!!! LENGTH ERROR !!! less than 4 parameters cannot be entered for add team.");//error message for length
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[2]))) {//error message for sign
							System.out.println("!!! SIGN ERROR !!! number of year cannot be negative (Add Team)");
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[3]))) {//error message for cups
							System.out.println("!!! SIGN ERROR !!! number of cups cannot be negative (Add Team)");
							break;
						}
						
						
						
						teams=addTeam(each_row[1],Integer.parseInt(each_row[2]),Integer.parseInt(each_row[3]),each_row[4],teams);// add  if there is not any error
						
						
						
						
					}
					else if (each_row[0].equals("AddCoach")) {
						if (each_row.length>17) {
							System.out.println("!!! LENGTH ERROR !!! more than 16 parameters cannot be entered for add coach.");//error message for length
							break;
						}
						if (each_row.length<17) {
							System.out.println("!!! LENGTH ERROR !!! less than 16 parameters cannot be entered for add coach.");//error message for length
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[16]))) {//error message for salary
							System.out.println("!!! SIGN ERROR !!! number of salary cannot be negative (Add Coach)");
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[6]))||!checkPositive(Integer.parseInt(each_row[7]))||!checkPositive(Integer.parseInt(each_row[8]))) {//error message for phone
							System.out.println("!!! SIGN ERROR !!! phone number cannot contain negative numbers (Add Coach)");
							break;
						}
						
						Address address=new Address(each_row[2],each_row[3],each_row[4],each_row[5]);
						Phone phone=new Phone(Integer.parseInt(each_row[6]),Integer.parseInt(each_row[7]),Integer.parseInt(each_row[8]));
						Date start_date=new Date(Integer.parseInt(each_row[10]),Integer.parseInt(each_row[11]),Integer.parseInt(each_row[12]));
						Date end_date=new Date(Integer.parseInt(each_row[13]),Integer.parseInt(each_row[14]),Integer.parseInt(each_row[15]));
						
						if (!checkDate(start_date)) {
							System.out.println("!!! DATE ERROR !!! start date is not in the calendar. (Add Coach)");//error message for date
							break;
						}
						if (!checkDate(end_date)) {
							System.out.println("!!! DATE ERROR !!! end date is not in the calendar. (Add Coach)");//error message for date
							break;
						}
						if (!checkStartDate_EndDate(start_date,end_date)) {
							System.out.println("!!! DATE ERROR !!! start date cannot be greater than end date. (Add Coach)");//error message for date
							break;
						}
						
						
						
						coaches=addCoach(each_row[1],address,phone,each_row[9],start_date,end_date,Integer.parseInt(each_row[16]),coaches);// add  if there is not any error
					}
					else if (each_row[0].equals("AddPlayer")) {

							if (each_row.length>23) {
								System.out.println("!!! LENGTH ERROR !!! more than 22 parameters cannot be entered for add player.");//error message for length
								break;
							}
							if (each_row.length<23) {
								System.out.println("!!! LENGTH ERROR !!! less than 22 parameters cannot be entered for add player.");//error message for length
								break;
							}
							if (!checkPositive(Integer.parseInt(each_row[11]))||!checkPositive(Integer.parseInt(each_row[12]))||!checkPositive(Integer.parseInt(each_row[13]))) {//error message for phone
								System.out.println("!!! SIGN ERROR !!! phone number cannot contain negative numbers (Add Player)");
								break;
							}
							
							if (!checkPositive(Integer.parseInt(each_row[1]))) {//error message for license number
								System.out.println("!!! SIGN ERROR !!! number of license number cannot be negative (Add Player)");
								break;
							}
							if (!checkPositive(Integer.parseInt(each_row[21]))) {//error message for salary
								System.out.println("!!! SIGN ERROR !!! number of salary cannot be negative (Add Player)");
								break;
							}
							Address address=new Address(each_row[7],each_row[8],each_row[9],each_row[10]);
							Phone phone=new Phone(Integer.parseInt(each_row[11]),Integer.parseInt(each_row[12]),Integer.parseInt(each_row[13]));
							Date start_date=new Date(Integer.parseInt(each_row[15]),Integer.parseInt(each_row[16]),Integer.parseInt(each_row[17]));
							Date end_date=new Date(Integer.parseInt(each_row[18]),Integer.parseInt(each_row[19]),Integer.parseInt(each_row[20]));
							Date birth_date=new Date(Integer.parseInt(each_row[3]),Integer.parseInt(each_row[4]),Integer.parseInt(each_row[5]));
							
							if (!checkDate(birth_date)) {
								System.out.println("!!! DATE ERROR !!! birth date is not in the calendar. (Add Player)");//error message for birth date
								break;
							}
							if (!checkDate(start_date)) {
								System.out.println("!!! DATE ERROR !!! start date is not in the calendar. (Add Player)");//error message for date
								break;
							}
							if (!checkDate(end_date)) {
								System.out.println("!!! DATE ERROR !!! end date is not in the calendar. (Add Player)");//error message for date
								break;
							}
							if (!checkStartDate_EndDate(start_date,end_date)) {
								System.out.println("!!! DATE ERROR !!! start date cannot be greater than end date. (Add Player)");//error message for date
								break;
							}
							
							players=addPlayer(Integer.parseInt(each_row[1]),each_row[2],birth_date,each_row[6],address,phone,each_row[14],start_date,end_date,Integer.parseInt(each_row[21]),each_row[22],players);// add  if there is not any error
						
						
					}
					else if (each_row[0].equals("DeletePlayer")) {
						if (each_row.length>2) {
							System.out.println("!!! LENGTH ERROR !!! more than 2 parameters cannot be entered for delete player.");//error message for length
							break;
						}
						if (each_row.length<2) {
							System.out.println("!!! LENGTH ERROR !!! less than 2 parameters cannot be entered for delete player.");//error message for length
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[1]))) {//error message for sign
							System.out.println("!!! SIGN ERROR !!! number of license number cannot be negative (Delete Player)");
							break;
						}
						if (!containPlayer(Integer.parseInt(each_row[1]),players)) {//error message for does not contain player
							System.out.println("!!! PLAYER ERROR !!! there is no player in this id number. (Delete Player)");
							break;
						}
						players=deletePlayer(Integer.parseInt(each_row[1]),players);
					}
					else if (each_row[0].equals("AddStadium")) {
						if (each_row.length>6) {
							System.out.println("!!! LENGTH ERROR !!! more than 5 parameters cannot be entered for add stadium.");//error message for length
							break;
						}
						if (each_row.length<6) {
							System.out.println("!!! LENGTH ERROR !!! less than 5 parameters cannot be entered for add stadium.");//error message for length
							break;
						}
						boolean lightning;
						if (each_row[4].equals("true")) {
							lightning=true;
						}
						else if(each_row[4].equals("false")) {
							lightning=false;
						}
						else {//error message for lightning must be boolean
							System.out.println("!!! BOOLEAN ERROR !!! lightning parameter must be boolean (Add Stadium)");
							break;
						}
						
						if (!checkPositive(Integer.parseInt(each_row[3]))) {//error message for SIGN
							System.out.println("!!! SIGN ERROR !!!  number of capacity cannot be negative (Add Stadium)");
							break;
						}
						
						stadiums=addStadium(each_row[1],each_row[2],Integer.parseInt(each_row[3]),lightning,each_row[5],stadiums);// add  if there is not any error
					}
					else if (each_row[0].equals("AddReferee")) {
						if (each_row.length>10) {
							System.out.println("!!! LENGTH ERROR !!! more than 9 parameters cannot be entered for add referee.");//error message for length
							break;
						}
						if (each_row.length<10) {
							System.out.println("!!! LENGTH ERROR !!! less than 9 parameters cannot be entered for add referee.");//error message for length
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[9]))) {//error message for SIGN
							System.out.println("!!! SIGN ERROR !!! number of salary cannot be negative (Add Referee)");
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[6]))||!checkPositive(Integer.parseInt(each_row[7]))||!checkPositive(Integer.parseInt(each_row[8]))) {//error message for phone
							System.out.println("!!! SIGN ERROR !!! phone number cannot contain negative numbers (Add Referee)");
							break;
						}
						
						Phone phone=new Phone(Integer.parseInt(each_row[6]),Integer.parseInt(each_row[7]),Integer.parseInt(each_row[8]));
						Address address=new Address(each_row[2],each_row[3],each_row[4],each_row[5]);
						refrees=addRefree(each_row[1],address,phone,Integer.parseInt(each_row[9]),refrees);// add  if there is not any error
					}
					else if (each_row[0].equals("AddCompany")) {
						if (each_row.length>10) {
							System.out.println("!!! LENGTH ERROR !!! more than 9 parameters cannot be entered for add company.");//error message for length
							break;
						}
						if (each_row.length<10) {
							System.out.println("!!! LENGTH ERROR !!! less than 9 parameters cannot be entered for add company.");//error message for length
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[6]))||!checkPositive(Integer.parseInt(each_row[7]))||!checkPositive(Integer.parseInt(each_row[8]))) {//error message for phone
							System.out.println("!!! SIGN ERROR !!! phone number cannot contain negative numbers (Add Company)");
							break;
						}
						
						
						Address address=new Address(each_row[2],each_row[3],each_row[4],each_row[5]);
						Phone phone=new Phone(Integer.parseInt(each_row[6]),Integer.parseInt(each_row[7]),Integer.parseInt(each_row[8]));
						companies=addCompany(each_row[1],address,phone,each_row[9],companies);// add  if there is not any error
					}
					else if (each_row[0].equals("AddMatch")) {
						if (each_row.length>9) {
							System.out.println("!!! LENGTH ERROR !!! more than 8 parameters cannot be entered for add match.");//error message for length
							break;
						}
						if (each_row.length<9) {
							System.out.println("!!! LENGTH ERROR !!! less than 8 parameters cannot be entered for add match.");//error message for length
							break;
						}
						Match _match=new Match(each_row[1],Integer.parseInt(each_row[2]),each_row[3],Integer.parseInt(each_row[4]),Integer.parseInt(each_row[5]),Integer.parseInt(each_row[6]),
								Integer.parseInt(each_row[7]),Integer.parseInt(each_row[8]));
						if (!checkRefree(refrees, _match)) {//If there is no referee in this id
							System.out.println("!!! REFREE ERROR !!! There is no referee in this id to conduct a match .");
							break;
						}
						if (!checkStadium(stadiums, _match)) {//If there is no stadium in this id
							System.out.println("!!! STADIUM ERROR !!! There is no stadium in this id where the match will be played (Add Match)");
							break;
						}
						
						if (!checkPositive(Integer.parseInt(each_row[2]))) {//error message for number of goals
							System.out.println("!!! SIGN ERROR !!!  home team's number of goals cannot be negative (Add Match)");
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[4]))) {//error message for number of goals
							System.out.println("!!! SIGN ERROR !!! away team's number of goals cannot be negative (Add Match)");
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[5]))) {//error message for refree id
							System.out.println("!!! SIGN ERROR !!! number of first refree's id cannot be negative (Add Match)");
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[6]))) {//error message for refree id
							System.out.println("!!! SIGN ERROR !!! number of second refree's id cannot be negative (Add Match)");
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[7]))) {//error message for refree id
							System.out.println("!!! SIGN ERROR !!! number of third refree's id cannot be negative (Add Match)");
							break;
						}
						if (!checkPositive(Integer.parseInt(each_row[8]))) {//error message for stadium id
							System.out.println("!!! SIGN ERROR !!! number of stadium id cannot be negative (Add Match)");
							break;
						}
						
						matches=addMatch(each_row[1],Integer.parseInt(each_row[2]),each_row[3],Integer.parseInt(each_row[4]),Integer.parseInt(each_row[5]),Integer.parseInt(each_row[6]),
								Integer.parseInt(each_row[7]),Integer.parseInt(each_row[8]),matches);// add  if there is not any error
						teams=awarded_point(new Match(each_row[1],Integer.parseInt(each_row[2]),each_row[3],Integer.parseInt(each_row[4]),Integer.parseInt(each_row[5]),Integer.parseInt(each_row[6]),
								Integer.parseInt(each_row[7]),Integer.parseInt(each_row[8])), teams);//add points to teams
					}
					if (i+1==count_of_row) {//There is no mistake if it could come to the end
						no_error=true;
					}
					
				}
				
				if (no_error) {//if there is no error
					//process
					
					
					
					Team[] sorted_teams=sortTeam(teams);//sort team
					scores(sorted_teams);
					
					System.out.println();
					biggestStadium(stadiums);//find biggest stadium
					System.out.println();
					
					
					increaseSalariesRefree(refrees);//increase sallary for refree
					
					//list informations
					listTeam(teams);
					listCoach(coaches);
					listPlayer(players);
					listStadium(stadiums);
					listRefree(refrees);
					listCompany(companies);
					listMatch(matches);
					
				}
}
			
			
			
			}
