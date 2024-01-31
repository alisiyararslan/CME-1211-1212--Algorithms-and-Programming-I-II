import java.util.Random;

public class Main {
	
	static void display(Queue q) {//print queue
		for (int i = 0; i < q.size(); i++) {
			System.out.print(q.peek()+" ");
			q.enqueue(q.dequeue());
		}
		
	}

	public static void main(String[] args) {
		
		Random rnd=new Random();
		Queue bag1=new Queue(2000);
		Queue bag2=new Queue(2000);
		Queue player1=new Queue(2000);
		Queue player2=new Queue(2000);
		int player1_point=0;
		int player2_point=0;
		
		
		for (int i = 1; i < 18; i++) {// add numbers from 1 to 17
			bag1.enqueue(i);
		}
		
		int count_add_number=0;
		
		while (count_add_number<7) {// add random numbers for player1
			int number=rnd.nextInt(17)+1;
			boolean flag=true;
			for (int i = 0; i < player1.size(); i++) {
				if ((Integer)player1.peek()==number) {//if the number is already in the queue  flag will be false
					flag=false;
				}
				player1.enqueue(player1.dequeue());
			}
			if (flag) {//if the number is not  already in the queue  so number will be added 
				player1.enqueue(number);
				count_add_number++;
			}
			
		}
		
		count_add_number=0;
		while (count_add_number<7) {// add random numbers for player2
			int number=rnd.nextInt(17)+1;
			boolean flag=true;
			for (int i = 0; i < player2.size(); i++) {
				if ((Integer)player2.peek()==number) {//if the number is already in the queue  flag will be false
					flag=false;
				}
				player2.enqueue(player2.dequeue());
			}
			if (flag) {//if the number is not  already in the queue  so number will be added 
				player2.enqueue(number);
				count_add_number++;
			}
			
		}
		
		int player1_birinci_çinko=0;
		int player2_birinci_çinko=0;
		
		System.out.println("**********************************************************************************");
		while (true) {
			int number=rnd.nextInt(17)+1;
			
			
			boolean bag1_flag=true;
			boolean bag2_flag=true;
			
			
			
			for (int i = 0; i < bag2.size(); i++) {//randomly selected element should not be in bag2
				if ((Integer)bag2.peek()==number) {
					bag2_flag=false;
					
				}
				bag2.enqueue(bag2.dequeue());
			}
			for (int i = 0; i < bag1.size(); i++) {//the random element must be chosen from the numbers in bag1
				if ((Integer)bag1.peek()==number) {
					bag1_flag=false;
					
				}
				bag1.enqueue(bag1.dequeue());
			}
			

			
			
			if (bag2_flag&&!bag1_flag) {//if the chosen number is a suitable number
				System.out.print("Player1: ");
				display(player1);
				
				System.out.printf("%30s ", "Bag1    ");
				display(bag1);
				System.out.println();
				System.out.print("Player2: ");
				display(player2);
				
				System.out.printf("%30s ", "Bag2    ");
				display(bag2);
				System.out.println();
				System.out.println("Randomly selected number: "+number);
				
				
				if (player1.size()==4&&player1_birinci_çinko==0) {
					System.out.println("Player1 gets $10 (Birinci Çinko)");
					player1_point+=10;
					player1_birinci_çinko++;
				}
				if (player2.size()==4&&player2_birinci_çinko==0) {
					System.out.println("Player2 gets $10 (Birinci Çinko)");
					player2_point+=10;
					player2_birinci_çinko++;
				}
				
				
				
				
				
				int bag1_size=bag1.size();//save it as the length is constantly changing
				for (int i = 0; i < bag1_size; i++) {//delte the number from bag1
					
					if ((Integer)bag1.peek()==number) {//check if the number is exist
						bag1.dequeue();
					}
					else {
						bag1.enqueue(bag1.dequeue());
					}
				}
				bag2.enqueue(number);//add the number to bag2
				
				
				int player1_size=player1.size();//save it as the length is constantly changing
				for (int i = 0; i < player1_size; i++) {//delte the number from player1 if exist
					
					if ((Integer)player1.peek()==number) {//check if the number is exist
						player1.dequeue();
					}
					else {
						player1.enqueue(player1.dequeue());
					}
				}
				
				int player2_size=player2.size();//save it as the length is constantly changing
				for (int i = 0; i < player2_size; i++) {//delte the number from player2 if exist
					
					if ((Integer)player2.peek()==number) {//check if the number is exist
						player2.dequeue();
					}
					else {
						player2.enqueue(player2.dequeue());
					}
				}
				
				
				
				
				System.out.println("**********************************************************************************");
				
			}
			
			if (player1.size()==0||player2.size()==0) {
				System.out.print("Player1: ");
				display(player1);
				for (int i = 0; i < 20-player1.size(); i++) {
					System.out.print(" ");
				}
				System.out.printf("%15s ", "Bag1    ");
				display(bag1);
				System.out.println();
				System.out.print("Player2: ");
				display(player2);
				for (int i = 0; i < 20-player2.size(); i++) {
					System.out.print(" ");
				}
				System.out.printf("%15s ", "Bag2    ");
				display(bag2);
				System.out.println();
			}
			
			
			
			if (player1.size()==0&&player2.size()==0) {
				System.out.println("**********************************************************************************");
				System.out.println("Player1 and Player2 are the winner !!!");
				player1_point+=30;
				player2_point+=30;
				break;
			}
			if (player1.size()==0) {
				System.out.println("**********************************************************************************");
				System.out.println("Player1 is the winner !!!");
				player1_point+=30;
				break;
			}
			if (player2.size()==0) {
				System.out.println("**********************************************************************************");
				System.out.println("Player2 is the winner !!!");
				player2_point+=30;
				break;
			}
			
			
			
			
			
			
		}
		
		
		System.out.println("Player1 gets $"+player1_point);
		System.out.println("Player2 gets $"+player2_point);
		
		


		
	}

}
