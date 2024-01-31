import java.io.FileWriter;
import java.io.IOException;

public class SingleLinkedList {

	private Node head;
	
	public void add(Object dataToAdd) {//add big to small
		if (head==null) {//if linklist is empty
			Node newnode=new Node(dataToAdd);//create new node
			head=newnode;//set head to newnode
		} 
		else if (((String) head.getData()).compareTo((String)dataToAdd)>0){//add an element to the beginning
			Node newnode=new Node(dataToAdd);//create new node
			newnode.setLink(head);//connect newnode to head
			head=newnode;//set head to newnode
		}
		else {
			Node temp=head;
			Node previous=null;
			while (temp!=null&&((String) dataToAdd).compareTo((String)temp.getData())>0) {//walk until find a smaller number
				previous=temp;
				temp=temp.getLink();
				
			}
			
			if (temp==null) {//add to end
				Node newnode=new Node(dataToAdd);//create new node
				previous.setLink(newnode);
			}
			else {//add to middle
				Node newnode=new Node(dataToAdd);//create new node
				newnode.setLink(previous.getLink());//link newnode to the next element from previous
				previous.setLink(newnode);//connect previous to newnode
			}
		}
	}
	
	
	public void addHighScoreTable(Object name,Object score) {//add big to small for high score table
		if (head==null) {//if linklist is empty
			Node newnode=new Node(name,score);//create new node
			head=newnode;//set head to newnode
		} 
		else if ((Integer)score>(Integer)head.getData2()){//(//add an element to the beginning
			Node newnode=new Node(name,score);//create new node
			newnode.setLink(head);//connect newnode to head
			head=newnode;//set head to newnode
		}
		else {
			Node temp=head;
			Node previous=null;
			while (temp!=null&&(Integer)score<(Integer)temp.getData2()) {//walk until find a smaller number
				previous=temp;
				temp=temp.getLink();//switch to the next node each time.
				
			}
			
			if (temp==null) {//add to end
				Node newnode=new Node(name,score);//create new node
				previous.setLink(newnode);
			}
			else {//add to middle
				Node newnode=new Node(name,score);//create new node
				newnode.setLink(previous.getLink());//link newnode to the next element from previous
				previous.setLink(newnode);//connect previous to newnode
			}
		}

	}
	
	public void addToEnd(Object data) {
	Node newNode=new Node(data);//create new node
	if (head==null) {//if linklist is empty
		head=newNode;//set head to newnode
	} 
	else {//add to end
		Node temp=head;
		while (temp.getLink()!=null) {//walk until end
			temp=temp.getLink();//switch to the next node each time.
		}
		temp.setLink(newNode);//connect temp to newnode
	}
}
	

	public void remove(Object dataToDelete) {
		boolean flag=true;
		if (head==null) {// write error message if linked list is empty
			System.out.println("linked list is empty");
		}
		else if (size()==1) {//if linklist has only one element destroy it
			head=null;
		}
		else {
			while ((char)head.getData()==(char)dataToDelete) {// remove start and pass all elements which equal head
				head=head.getLink();
				flag=false;
			}
			
			Node temp=head;
			Node previous=null;
			while (temp!=null) {// walk all linklist
				if ((char)temp.getData()==(char)dataToDelete) {//remove element which equal data to delete
					previous.setLink(temp.getLink());//previous is before the node I need to remove. Going forward one times from previous, it skips the number which i need to remove.
					temp=previous;
					flag=false;
				}
				previous=temp;
				temp=temp.getLink();//switch to the next node each time.
			}
			if (flag) {
				System.out.println("not found");
			}
		}
	}
	
	public void display() {
		if (head==null) {
			System.out.println("linked list is empty");
		} 
		else {
			Node temp=head;
			while (temp!=null) {// walk all linklist
				System.out.print(temp.getData()+" ");//print data of current temp
				temp=temp.getLink();//switch to the next node each time.
			}
		}
		
	}
	
	public void displayHighScoreTable() {// only high score table
		if (head==null) {// write error message if linked list is empty
			System.out.println("linked list is empty");
		} 
		else {
			Node temp=head;
			while (temp!=null) {// walk all linklist
				System.out.println(temp.getData()+" "+temp.getData2());//print data of current temp
				temp=temp.getLink();//switch to the next node each time.
			}
		}
		
	}
	
	public boolean search(char c) {
		boolean flag=false;
		if (head==null) {// write error message if linked list is empty
			System.out.println("linked list is empty");
		} 
		else {
			Node temp=head;
			while (temp!=null) {// walk all linklist
				if (String.valueOf(c).equalsIgnoreCase(String.valueOf(temp.getData()))) {// check wheter data of temp searced element are equal or not
					flag=true;//
				}
				temp=temp.getLink();//switch to the next node each time.
				
			}
		}
		return flag;
	}
	
	public int size() {
		int count=0;
		if (head==null) {// write error message if linked list is empty
			System.out.println("linked list is empty");
		} 
		else {
			Node temp=head;
			while (temp!=null) {// walk all linklist
				count++;// increase count evety step
				temp=temp.getLink();//switch to the next node each time.
				
			}
		}
		return count;
	}
	

	public Object whichCharacter(int order) {//get a number ordinal number and find the element with that ordinal number in the linkedlist
		int count=0;
		Object letter = 0;
		if (head==null) {//Print error message if head equals null
			System.out.println("linked list is empty");
			
		} 
		else {
			Node temp=head;//keep head at temp
			while (temp!=null) {//browse the link list from start to finish
				if (count==order) {//Did it come to the given number order
					if (temp.getData().equals("Bankrupt")) {//Return 0 if the element in that sequence value is "bankrupt"
						letter=0;
					} else {//return that sequence value
						letter=  temp.getData();
					}
					
				}
				temp=temp.getLink();//switch to the next node each time.
				count++;
			}

		}
		return letter;
		
		
	}

	public void updateLinkedList(int order,Object data) {//Substitute the letter "-" with letter  if the correct letter was guessed.
		
		Node temp=head;//keep head at temp
		Node previous=null;
		int count=0;
		while (temp!=null&&(count<order)) {//advance from the beginning to the given sequence number
			previous=temp;//node before temp
			temp=temp.getLink();//switch to the next node each time.
			count++;
			
		}
		
		if (temp==null) {//add end
			Node newnode=new Node(data);
			previous.setLink(newnode);// previous is last node this stiuation link newnode to previous
		}
		else {
			Node newnode=new Node(data);
			if (order==0) {//add start
				
				head=newnode;//destroy head and upload head with newnode
				newnode.setLink(temp.getLink());//temp = before head then link newnode with after temp node 

			}
			else {//add middle
				newnode.setLink(previous.getLink().getLink());//previous is before the node I need to change. Going forward two times from previous, it skips the number which i need to change.
				previous.setLink(newnode);//Make a connection between the previous element and the new point I need to change.
			}
			
		}
	}
	
	public void top10highScore() {
		Node temp=head;
		Node previous=null;
		while (temp.getLink()!=null) {//walk until find a smaller number
			previous=temp;
			temp=temp.getLink();//switch to the next node each time.
		}
		previous.setLink(null);

	}
	public boolean searchHighScoreTable(int c) {
		boolean flag=false;
		if (head==null) {// write error message if linked list is empty
			System.out.println("linked list is empty");
		} 
		else {
			Node temp=head;
			while (temp!=null) {// walk all linklist
				if (c==(int)temp.getData2()) {// check wheter data of temp searced element are equal or not
					flag=true;//
				}
				temp=temp.getLink();//switch to the next node each time.
				
			}
		}
		return flag;
	}
	
	public void writeLastHighScoreTable() {// write high score table on the txt 
		try {
		      FileWriter myWriter = new FileWriter("D:\\HighScoreTable.txt");
		     
		      Node temp=head;
		      while (temp!=null) {
		    	  myWriter.write((String) temp.getData()+"\n");
		    	  myWriter.write((int) temp.getData2()+"\n");
		    	  temp=temp.getLink();
		    	  
				
			}
		      myWriter.close();
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
			}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
