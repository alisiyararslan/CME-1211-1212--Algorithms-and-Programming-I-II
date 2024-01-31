import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Main {
	
	public static void display(Stack stack) {//prints the stack from start to finish
		Stack temp=new Stack(stack.size());//create a temporary stack to avoid losing the sent stack
		while (!stack.isEmpty()) {//print on the screen until the submitted stack is empty and add it to a temporary stack
			System.out.print(stack.peek()+" ");
			temp.push(stack.pop());
		}
		
		while (!temp.isEmpty()) {//add a temporary stack to the submitted stack until it is empty
			stack.push(temp.pop());
		}
	}
	
	public static Stack deleteElement(Stack stack,int num,int x) {
		Stack temp_for_stack_reverse=new Stack(x);//reverse
		while (!stack.isEmpty()) {//first reverse for queue
			temp_for_stack_reverse.push(stack.pop());
		}
		Stack temp_for_stack=new Stack(x);//protect stack
		while (!temp_for_stack_reverse.isEmpty()) {
			if (temp_for_stack_reverse.size()==num) {//if size equal to given num just pop
				
				temp_for_stack_reverse.pop();
			}
			else {//if size is not equal to given num pop and push temp stack
				temp_for_stack.push(temp_for_stack_reverse.pop());
			}
		}
		while (!temp_for_stack.isEmpty()) {//reverse stack
			temp_for_stack_reverse.push(temp_for_stack.pop());
		}
		while (!temp_for_stack_reverse.isEmpty()) {//protect stack
			stack.push(temp_for_stack_reverse.pop());
		}
		
		
		return stack;
	}
	

	public static void main(String[] args) {
		Stack fruitStack=new Stack(15);
		Stack fruitStackReversed=new Stack(15);
		
		try {//file reading operations
		      File myObj = new File("D:\\highscoretable.txt");//file path
		      Scanner myReader = new Scanner(myObj,"UTF-8");// first reader for add stack
		      while (myReader.hasNextLine()) {
		    	  fruitStackReversed.push(myReader.nextLine());
		      }
		      myReader.close();

		    } 
		catch (FileNotFoundException e) {//error catch
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		while (!fruitStackReversed.isEmpty()) {
			fruitStack.push(fruitStackReversed.pop());
		}
		
		Stack high_score_stack=new Stack(40);
		Stack high_score_stackReversed=new Stack(40);
		
		try {//file reading operations
		      File myObj2 = new File("D:\\highscoretable.txt");//file path
		      Scanner myReader2 = new Scanner(myObj2,"UTF-8");// first reader for add stack
		      while (myReader2.hasNextLine()) {
		    	  high_score_stackReversed.push(myReader2.nextLine());
		      }
		      myReader2.close();

		    } 
		catch (FileNotFoundException e) {//error catch
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		while (!high_score_stackReversed.isEmpty()) {
			high_score_stack.push(high_score_stackReversed.pop());
		}
		

		int x=5;
		Stack stack1=new Stack(x);
		Stack stack2=new Stack(x);
		Stack fruitsId=new Stack(x);
		
		Random rnd =new Random();
		Stack tempSearch=new Stack(x);
		
		while (fruitsId.size()<x) {//add random fruit queue without same
			int num=rnd.nextInt(fruitStack.size())+1;
			boolean flag=false;
			while(!fruitsId.isEmpty()) {
				if (fruitsId.peek()==(Integer)num ) {// make flag true if the element already added stack
					flag=true;
				}
				tempSearch.push(fruitsId.pop());
			}
			while (!tempSearch.isEmpty()) {
				fruitsId.push(tempSearch.pop());
				
			}
			if (!flag) {// ad id if fruit is not in fruits id
				fruitsId.push(num);
			}
		}
		

		Stack tempFruitsId=new Stack(x);
		Stack tempFruitStack=new Stack(15);
		
		while (!fruitsId.isEmpty()) {//create stack1 with fruits using id
			
				if ((Integer)fruitStack.size()==(Integer)fruitsId.peek()) {//if id equal to stack's size ,add stack1
					tempFruitsId.push(fruitsId.pop());
					stack1.push(fruitStack.peek());
					while (!fruitStack.isEmpty()) {//for protect
						
						tempFruitStack.push(fruitStack.pop());
					}
					while (!tempFruitStack.isEmpty()) {//If the goal is achieved, it can be added without checking
						fruitStack.push(tempFruitStack.pop());
					}
				}
				else {//add element tempFruitStack for protect fruits
					tempFruitStack.push(fruitStack.pop());
				}

		}
		while (!tempFruitsId.isEmpty()) {
			fruitsId.push(tempFruitsId.pop());;
			
		}
		

		//randomly change id order for stack 2
		Stack fruitsId2=new Stack(x);
		Stack fruitsId2odd=new Stack(x);
		Stack fruitsId2even=new Stack(x);
		while (!fruitsId.isEmpty()) {
			int num_fruitsId2=rnd.nextInt(10);// create a number from 1 to 10 
			if (num_fruitsId2%2==0) {//if number is even add even stack
				fruitsId2even.push(fruitsId.pop());
			}
			else if (num_fruitsId2%2==1) {//if number is odd add odd stack
				fruitsId2odd.push(fruitsId.pop());
			}
		}
		while (!fruitsId2even.isEmpty()) {//sum even and odd stacks
			fruitsId2.push(fruitsId2even.pop());
		}
		while (!fruitsId2odd.isEmpty()) {//sum even and odd stacks
			fruitsId2.push(fruitsId2odd.pop());
		}


		while (!fruitsId2.isEmpty()) {//create stack2 with fruits using id
			
			if ((Integer)fruitStack.size()==(Integer)fruitsId2.peek()) {//if id equal to stack's size ,add stack2
				tempFruitsId.push(fruitsId2.pop());
				stack2.push(fruitStack.peek());
				while (!fruitStack.isEmpty()) {//for protect
					
					tempFruitStack.push(fruitStack.pop());
				}
				while (!tempFruitStack.isEmpty()) {//If the goal is achieved, it can be added without checking
					fruitStack.push(tempFruitStack.pop());
				}
			}
			else {//add element tempFruitStack for protect fruits
				tempFruitStack.push(fruitStack.pop());
			}

	}
	while (!tempFruitsId.isEmpty()) {
		fruitsId2.push(tempFruitsId.pop());;
		
	}
	

	//Game
	int score=0;
	int step=0;
	int wonCount=0;
	while (!stack1.isEmpty()&&!stack2.isEmpty()) {
		
		int random_stack1_index=rnd.nextInt(x-wonCount)+1;//generate random numbers with remain fruits length
		int random_stack2_index=rnd.nextInt(x-wonCount)+1;
		System.out.print("Stack1:  ");
		display(stack1);
		System.out.println();
		System.out.print("Stack2:  ");
		display(stack2);
		System.out.println();
		System.out.println("Randomly generated numbers: "+random_stack1_index+"  "+random_stack2_index);
		

		//find which fruit for stack1
		Stack temp_for_stack=new Stack(x);
		Stack reversed_stack=new Stack(x);
		Stack reversed_stack2=new Stack(x);
		String fruit_stack="";
		while (!stack1.isEmpty()) {
			reversed_stack2.push(stack1.peek());//protect stack1
			reversed_stack.push(stack1.pop());//reverse stack1
			
		}
		while (!reversed_stack2.isEmpty()) {//protect stack1
			stack1.push(reversed_stack2.pop());
		}

		while(!reversed_stack.isEmpty()) {
			if ((Integer)reversed_stack.size()==random_stack1_index) {
				fruit_stack=(String)reversed_stack.peek();//fruit represented by the randomly generated number
				while (!reversed_stack.isEmpty()) {//Now that the fruit is found, add the remaining elements without checking
					temp_for_stack.push(reversed_stack.pop());
				}
			}
			else {//add element does not reach yet
				temp_for_stack.push(reversed_stack.pop());
			}
		}
		while (temp_for_stack.isEmpty()) {//protect stack
			reversed_stack.push(temp_for_stack.pop());
		}
			

		//find which fruit for stack2
		Stack temp_for_stack_2=new Stack(x);
		Stack reversed_stack_2=new Stack(x);
		Stack reversed_stack2_2=new Stack(x);
		String fruit_stack_2="";
		while (!stack2.isEmpty()) {
			reversed_stack2_2.push(stack2.peek());//protect stack2
			reversed_stack_2.push(stack2.pop());//reverse stack2
			
		}
		while (!reversed_stack2_2.isEmpty()) {
			stack2.push(reversed_stack2_2.pop());//protect stack2
		}

		while(!reversed_stack_2.isEmpty()) {
			if ((Integer)reversed_stack_2.size()==random_stack2_index) {
				fruit_stack_2=(String)reversed_stack_2.peek();//fruit represented by the randomly generated number
				while (!reversed_stack_2.isEmpty()) {//Now that the fruit is found, add the remaining elements without checking
					temp_for_stack_2.push(reversed_stack_2.pop());
				}
			}
			else {//add element does not reach yet
				temp_for_stack_2.push(reversed_stack_2.pop());
			}
		}
		while (temp_for_stack_2.isEmpty()) {//protect stack
			reversed_stack_2.push(temp_for_stack_2.pop());
		}
		

		if (fruit_stack_2.equals(fruit_stack)) {//delete fruit if same
			
			stack1=deleteElement(stack1, random_stack1_index, x);
			stack2=deleteElement(stack2, random_stack2_index, x);
			score+=20;
			wonCount++;

		}
		else {
			score--;
		}

		System.out.println("score="+score);
		if(step!=0)System.out.println("step="+step);
		
		step++;
		
		System.out.println("********************************************");

	}
	

	//add names and scores
	Stack names=new Stack(high_score_stack.size()/2+1);
	Stack scores=new Stack(high_score_stack.size()/2+1);
	while (!high_score_stack.isEmpty()) {//read two line each time
		names.push(high_score_stack.pop());
		String a=(String)high_score_stack.pop();//first take string form
		int b=Integer.parseInt(a);//change form string to int
		scores.push(b);
	}
	names.push("You");//add name "you"
	scores.push((Integer)score);// add your score
	

	//sort
	Stack tempStack = new Stack(scores.size());//create temp stacks
	Stack tempStack2 = new Stack(names.size());
	while(!scores.isEmpty())
	{
		String currentName=(String)names.pop();
		int currentData=(Integer) scores.pop();
		
		while(!tempStack.isEmpty() && (Integer)tempStack.peek() > currentData) {
			scores.push(tempStack.pop());
			names.push(tempStack2.pop());
		}
		tempStack.push(currentData);
		tempStack2.push(currentName);
		
	}
	
	
	//High Score table
	System.out.println("The game is over.\r\n"
			+ "High Score table:");
	Stack tempStack_temp = new Stack(tempStack.size());
	Stack tempStack2_temp = new Stack(tempStack2.size());
	while (!tempStack.isEmpty()) {
    	System.out.println(tempStack2.peek()+"     "+tempStack.peek());
    	
    	tempStack_temp.push(tempStack.pop());//score
    	tempStack2_temp.push(tempStack2.pop());//name
	}
	while (!tempStack2_temp.isEmpty()) {
		tempStack2.push(tempStack2_temp.pop());//name
		tempStack.push(tempStack_temp.pop());//score
		
	}
	
	
	//file write operations
	File outFile = new File ("highscoretable.txt");//writing path
    FileWriter fWriter = null;
	try {
		fWriter = new FileWriter (outFile);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
    PrintWriter pWriter = new PrintWriter (fWriter);
    while (!tempStack.isEmpty()) {
    	pWriter.println (tempStack2.pop());//write name
    	pWriter.println (tempStack.pop());//write scores
		}
    
    pWriter.close();
	


	}

}
