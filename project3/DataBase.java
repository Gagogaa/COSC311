/* 
	 Name: Gregory Mann
	 Assignment Number: 2
	 COSC 311 - Winter 2017
*/

/*
 * this class is a data structure manager and front end for the 
 * driver program.
 *
 */

import java.util.*;

public class DataBase {
	private DataBaseArray myDB;
	private int nextIndex;
	private int maxSize;
	private BinarySearchTree id, first, last;

	private Scanner keyboard = new Scanner(System.in);
	
	public DataBase(){
		maxSize = 100;
		nextIndex = 0;
		myDB = new DataBaseArray(maxSize);
		id = new BinarySearchTree(maxSize);
		first = new BinarySearchTree(maxSize);
		last = new BinarySearchTree(maxSize);
	}
	
	public DataBase(int sz){
		maxSize = sz;
		nextIndex = 0;
		myDB = new DataBaseArray(maxSize);
		id = new BinarySearchTree(maxSize);
		first = new BinarySearchTree(maxSize);
		last = new BinarySearchTree(maxSize);
	}

	// an interactive add method for the driver
	public void addIt(){
		String i, f ,l;
		
		System.out.print("Please enter an id: ");
		i = keyboard.next();
		System.out.print("Please enter first name: ");
		f = keyboard.next();
		System.out.print("Please enter last name: ");
		l = keyboard.next();

		add(i, f, l);
	}

	// an add method that takes 3 strings to add a person to the database 
	// id, firstName, lastName
	public void add(String i, String f, String l){

		if(id.findIt(i) == -1){ // if the id is free to use
			int loc = myDB.add(i, f, l);
			
			if(loc == -1){ // fails to add person due to being full
				System.out.println("Sorry the database is full");
				System.out.println("");
			} else {
				id.add(i, loc);
				first.add(f, loc);
				last.add(l, loc);
			}
			
		} else {
			System.out.println("Sorry " + f + " " + l + " cannot be added the id of " + i + " has already been taken.");
			System.out.println("");
		}
	}
	
	// an interactive delete method for the driver
	// it takes in a string from the user and looks for a corresponding id to delete
	public void deleteIt(){
		System.out.print("Please enter an id: ");
		int loc = id.findIt(keyboard.next());
		
		if(loc == -1)
			System.out.println("ID not Found");
		else {
			// call the db to string and split it into tokens so they can be passed to the
			// the index delete methods
			
			myDB.delete(loc);
			id.delete(loc);
			first.delete(loc);
			last.delete(loc);
			System.out.println("Deleted");
		}
		System.out.println("");
	}

	// interactive find method for the driver
	// it takes in a string from the user and returns the corresponding
	// id, firstname, and lastname 
	public void findIt(){
		System.out.print("Please enter an id: ");
		int loc = id.findIt(keyboard.next());
		
		if(loc == -1)
			System.out.println("ID not Found");
		else
			System.out.println(myDB.getByIndex(loc).toString());
		System.out.println("");
	}

	// A negative number for dir prints decending order otherwise it prints accending
	private void printIndex(BinarySearchTree index, int dir){
		if(dir < 0){ // print descending
      index.printDescending(myDB);
		} else { // print ascending
      index.printAscending(myDB);
		}
		System.out.println("");
	}

	// these methods display the contents of the database
	
	public void ListByIDAscending(){
		printIndex(id, 0);
	}

	public void ListByIDDescending(){
		printIndex(id, -1);
	}

	public void ListByFirstAscending(){
		printIndex(first, 0);
	}

	public void ListByFirstDescending(){
		printIndex(first, -1);
	}

	public void ListByLastAscending(){
		printIndex(last, 0);
	}

	public void ListByLastDescending(){
		printIndex(last, -1);
	}
}
