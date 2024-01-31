import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		SingleLinkedList SLL1=new SingleLinkedList();// creat necessary linked list
		SingleLinkedList SLL2=new SingleLinkedList();
		SingleLinkedList SLL3=new SingleLinkedList();
		SingleLinkedList SLL4=new SingleLinkedList();
		SingleLinkedList SLL5=new SingleLinkedList();
		SingleLinkedList SLL6=new SingleLinkedList();
		
		SLL6.addToEnd(10);//add wheel elements
		SLL6.addToEnd(20);
		SLL6.addToEnd(30);
		SLL6.addToEnd(40);
		SLL6.addToEnd(100);
		SLL6.addToEnd(200);
		SLL6.addToEnd(300);
		SLL6.addToEnd(400);
		SLL6.addToEnd("Bankrupt");
		SLL6.addToEnd("Bankrupt");
		
		
		try {//file reading operations
		      File myObj = new File("D:\\animals.txt");//file path
		      Scanner myReader = new Scanner(myObj,"UTF-8");// first reader 
		      while (myReader.hasNextLine()) {
		    	  SLL1.add(myReader.nextLine());
		      }
		      myReader.close();

		} 
		catch (FileNotFoundException e) {//error catch
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
		try {//file reading operations
		      File myObj = new File("D:\\HighScoreTable.txt");//file path
		      Scanner myReader = new Scanner(myObj,"UTF-8");// first reader
		      while (myReader.hasNextLine()) {
		    	  String name=myReader.nextLine();
		    	  String score=myReader.nextLine();
		    	  SLL3.addHighScoreTable(name,Integer.parseInt(score));//addBigToSmall
		      }
		      myReader.close();

		} 
		catch (FileNotFoundException e) {//error catch
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		

		for(int i = 0; i < 26; i++){// add alphabet using ascii table
			SLL2.addToEnd((char)(65 + i));//
		}

		
		
		
		
		
		Random rnd=new Random();
		int x=rnd.nextInt(SLL1.size());// create a number among 0 and sll1 size
		String animal=(String)SLL1.whichCharacter(x);// take randomly Generated Animal using random x number
		for (int i = 0; i < animal.length(); i++) {
			SLL4.addToEnd(animal.charAt(i));//add each letter to sll4
			SLL5.addToEnd('-');// add '-' for each letter
		}

		int step=1;
		int score=0;
		System.out.println("Randomly generated number: "+(x+1));
		System.out.println("**************************************************************************************************************************************");
		while (true) {
			
			System.out.print("Word:  ");
			SLL5.display();
			System.out.print("             Step: "+step+"          Score:      "+score+"            ");
			SLL2.display();
			System.out.println();
			if (!SLL5.search('-')) {// game ending control. If there is no "-" in the word on the game screen
				break;
			}
			
			int create_number_in_wheel=rnd.nextInt(10)+1;// create a number among 1 and 10 
			int wheel= (int) SLL6.whichCharacter(create_number_in_wheel);//find which number the randomly generated number corresponds to on the wheel
			System.out.println("Wheel: "+wheel);
			
			if (wheel!=0) {// check wheel value is not bankrupt
				int RandomLetter=rnd.nextInt(SLL2.size());// guess a letter
				char randomlyGeneratedLetter=(char) SLL2.whichCharacter(RandomLetter);//guess a letter find which letter the randomly generated letter corresponds to on the alphabet
				System.out.print("Guess: ");
				System.out.println(randomlyGeneratedLetter);
				SLL2.remove(randomlyGeneratedLetter);
				
				if (SLL4.search(randomlyGeneratedLetter)) {// if guess is available
					for (int i = 0; i < SLL4.size(); i++) {//walk all word

						if (String.valueOf((char)SLL4.whichCharacter(i)).equalsIgnoreCase(String.valueOf(randomlyGeneratedLetter))) {//find letter
							score+=wheel;
							SLL5.updateLinkedList(i, randomlyGeneratedLetter);//change suitable "-" to letter
						}
					}
				} 
				
			} else {
				System.out.println("!!!BANKRUPT!!!");
				score=0;

			}
			
			
			
			
			step++;
			

			System.out.println("**************************************************************************************************************************************");
			
		}
		System.out.println();
		System.out.println("You get "+score +"TL !!! ");
		
		
		System.out.println("\n\nHigh Score Table");
		
		if (!SLL3.searchHighScoreTable(score)) {
			SLL3.addHighScoreTable("You",score);
			SLL3.top10highScore();//only shows top 10 score
		}
		else {
			SLL3.addHighScoreTable("You",score);
		}
		
		
		SLL3.displayHighScoreTable();
		
		SLL3.writeLastHighScoreTable();
		

	}

}
