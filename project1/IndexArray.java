/* 
	 Name: Gregory Mann
	 Assignment Number: 1
	 COSC 311 - Winter 2017
*/

/*
 * this class is an implementation of an ordered array 
 *
 */

public class IndexArray {
	private IndexRecord data[];
	private int nextIndex;
	private int maxSize;
	private int iterator;

	public IndexArray(){
		maxSize = 100;
		nextIndex = 0;
		iterator = 0;
		data = new IndexRecord[maxSize];
	}

	public IndexArray(int size){
		maxSize = size;
		nextIndex = 0;
		iterator = 0;
		data = new IndexRecord[maxSize];
	}

	// This method takes a search string to find search WITHIN THE LOCAL ARRAY 
	// return index of the key IN THE LOCAL ARRAY or -1 if not found
	public int find(String str){
		IndexRecord key = new IndexRecord(str, 0);
		if(nextIndex > 0){
			int hi,lo,mid;
			mid = 0;
			hi = nextIndex - 1;
			lo = 0;
			while(lo <= hi){
				mid = (lo + hi) / 2;
				if(data[mid].compareTo(key) == 0) break;
				if(data[mid].compareTo(key) < 0)
					lo = mid + 1;
				else
					hi = mid - 1;
			}
			return(data[mid].compareTo(key) == 0 ? mid : -1);
		} else {
			return -1;
		}
	}
	
	// This method takes a search string to find search WITHIN THE DATABASE ARRAY
	// return index of the key IN THE DATABASE ARRAY or -1 if not found
	public int findIt(String str){
		int loc = find(str);
		return (loc == -1 ? -1 : data[loc].getIndex());
	}

	// takes a string as the "key" and the location its at in the database array
	// returns false if the array is full otherwise it returns true
	public boolean add(String str, int loc){
		IndexRecord newValue = new IndexRecord(str, loc);
		int j;
		
		if (nextIndex == maxSize) return false;
		// use insertion loop from class to insert new element into sorted array
		for(j = nextIndex - 1; j >= 0; j--){
			if (data[j].compareTo(newValue) < 0) break;
			data[j + 1] = data[j];
		}
		data[j + 1] = newValue;
		nextIndex++;
		return true;
	}

	// removes something from the array based on the local location in the local data array
	// returns false if it couldnt find it in the array and true if it was deleted
	public boolean delete(int num){
		int where, j;
		where = findByIndex(num);
		
		if (where == -1) return false;
		for(j = where + 1; j < nextIndex; j++)
			data[j - 1] = data[j];
		
		nextIndex--;
		return true;
	}

	// finds the local location of a record based on its location in the DATABASE array
	// returns the local location in the array
	public int findByIndex(int num){
		int loc = -1;
		for(int i = 0; i < nextIndex; i++){
			if(data[i].getIndex() == num){
				loc = i;
				break;
			} 
		}
		return loc;
	}
	
	// moves the iterator to the front of the array
	public void iteratorInitFront(){
		iterator = 0;
	}

	// moves the iterator to the back of the array
	public void iteratorInitBack(){
		iterator = nextIndex -1;
	}

	// returns true if another element is within next pointer locaion
	// returns false otherwise
	public boolean hasNext(){
		if(iterator < nextIndex)
			return true;
		return false;
	}
	
	// returns true if another element is within previous pointer locaion
	// returns false otherwise
	public boolean hasPrevious(){
		if(iterator > -1)
			return true;
		return false;
	}

	// returns the index stored within the record at the pointer location
	// then increments the pointer 
	public int getNext(){
		return data[iterator++].getIndex();
	}

	// returns the index stored within the record at the pointer location
	// then decrements the pointer 
	public int getPrevious(){
		return data[iterator--].getIndex();
	}
}
