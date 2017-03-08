/* 
	 Name: Gregory Mann
	 Assignment Number: 1
	 COSC 311 - Winter 2017
*/

/*
 * this class is a simple unordered array class that pushes 
 * deleted items onto a stack 
 *
 */

public class DataBaseArray {
	private DataBaseRecord data[];
	private int maxSize;
	private int nextIndex;
	private Stack deleteStack;

	public DataBaseArray(){
		maxSize = 100;
		nextIndex = 0;
		deleteStack = new Stack(maxSize);
		data = new DataBaseRecord[maxSize];
	}

	public DataBaseArray(int sz){
		maxSize = sz;
		nextIndex = 0;
		deleteStack = new Stack(maxSize);
		data = new DataBaseRecord[maxSize];
	}

	// returns -1 if the data base is full otherwise it returns the
	// index the data was stored in
	public int add(String i, String f, String l){
		if(nextIndex == maxSize && deleteStack.isEmpty()) // fails to add person due to being full
			return -1;
	  else {
			// grab from the stack first
			int spot = (deleteStack.isEmpty() ? nextIndex : deleteStack.pop());
			
			data[spot] = new DataBaseRecord(i, f, l);

			// this condition is used to increment nextIndex if it was used to store the record
			return (nextIndex == spot ? nextIndex++ : spot);
		}
	}

	// returns -1 if the delete stack is full (this would indicate that you've deleted more items
	// than the database can hold)
	public boolean delete(int loc){
		return deleteStack.push(loc);
	}

	// returns the object at the specified location 
	public DataBaseRecord getByIndex(int loc){
		return data[loc];
	}
}
