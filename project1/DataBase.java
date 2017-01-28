// i think that this also needs some basic error handling
public class DataBase {
	private DataBaseRecord data[];
	private int nextIndex;
	private int maxSize;

	/*
	 * add the 3 index records  
	 */
	public DataBase(){
		maxSize = 100;
		nextIndex = 0;
		data = new DataBaseRecord[maxSize];
	}
	
	public DataBase(int sz){
		maxSize = sz;
		nextIndex = 0;
		data = new DataBaseRecord[maxSize];
	}
	
	// TODO: reimplement these as an unordered array
	// return index of key, -1 if not found
	public int find(DataBaseRecord key){
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

	// This array is not suppose to b eordered so make it a normal array
	public boolean insert(DataBaseRecord newValue){
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
	
	public boolean delete(DataBaseRecord key){
		int where, j;
		where = find(key);
		if (where == -1) return false;
		for(j = where + 1; j < nextIndex; j++)
			data[j - 1] = data[j];
		nextIndex--;
		return true;
	}
	
	// Consiter making this a toString method
	// this should probably be replaced with the print via index method
	public void printIt(){
		int j;
		for(j = 0; j < nextIndex; j++)
			System.out.println(data[j]);
	}
}
