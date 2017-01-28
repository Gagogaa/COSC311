
public Index {
	private IndexRecord data[];
	private int nextIndex;
  private int maxSize;

	public Index(){
		maxSize = 100;
		nextIndex = 0;
		data = new IndexRecord[maxSize];
	}

	public Index(int size){
		maxSize = size;
		nextIndex = 0;
		data = new IndexRecord[maxSize];
	}
		
	// return index of key, -1 if not found
	public int find(IndexRecord key){
		int hi,lo,mid;
		mid = 0;
		hi = nextIndex - 1;
		lo = 0;
		while(lo <= hi){
			mid=(lo + hi) / 2;
			if(data[mid] == key) break;
			if(data[mid].compareTo(key) < 0)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return(data[mid] == key? mid : -1);
	}

	public boolean insert(IndexRecord newValue){
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
	
	public boolean delete(IndexRecord key){
		int where, j;
		where = find(key);
		if (where == -1) return false;
		for(j = where + 1; j < nextIndex; j++)
			data[j - 1] = data[j];
		nextIndex--;
		return true;
	}

	// prints the array in accending or decending order
	// or should this return a string?
	// public static void printIt(Index list, int order){
	// 	for(int j = 0;)
	// }
	// TODO toString and print methods?

	// decrements all indexes with a value =< the given param
	// for deleting in the main unordered array
	// number should be the index of the value that was just deleted from the main array
	public void decrementIndexes(int number){
		for(int j = 0; j < nextIndex; j++){
			if(data[j].getIndex() =< number)
				data[j].decrement();
		}
	}
}
