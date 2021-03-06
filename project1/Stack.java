/* 
	 Name: Gregory Mann
	 Assignment Number: 1
	 COSC 311 - Winter 2017
*/

/*
 * this class is a simple stack of ints
 * 
 */
public class Stack {
	private int data[];
	private int nextIndex;
	private int maxSize;

	public Stack(){
		nextIndex = 0;
	  maxSize = 100;
		data = new int[maxSize];
	}

	public Stack(int sz){
		nextIndex = 0;
	  maxSize = sz;
		data = new int[maxSize];
	}

	// pushes x onto the stack retruns false if the stack
	// is full else it returns true
	public boolean push(int x){
		if(this.isFull())
			return false;
		else {
			data[nextIndex++] = x;
			return true;
		}
	}

	// returns -1 if the array is empty
	// otherwise it returns the item on top
	// of the stack and decrements the pointer
	public int pop(){
		if(this.isEmpty())
			return -1;
		else
			return data[--nextIndex];
	}

	// returns -1 for an empty array
	// otherwise it returns the item
	// on top of the stack
	public int peek(){
		if(this.isEmpty())
			return -1;
		else
			return data[nextIndex - 1];
	}

	// returns true if the stack is empty
	// otherwise it returns false
	public boolean isEmpty(){
		return nextIndex == 0;
	}

	// returns true if the stack is full
	// otherwise it returns false
	public boolean isFull(){
		return nextIndex > maxSize;
	}
}
