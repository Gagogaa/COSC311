/* 
	 Name: Gregory Mann
	 Assignment Number: 1
	 COSC 311 - Winter 2017
*/

/*
 * this class is a simple container for an index and a comparison object
 *
 */

public class IndexRecord {
	private String element;
	private int index;

	public IndexRecord(String elem, int ind){
		element = new String(elem);
		index   = ind;
	}
	
	public int compareTo(IndexRecord otherIndexRecord){
		return (element.compareTo(otherIndexRecord.element));
	}

	// reutrns the index of the item in the main database array
	public int getIndex(){
		return index;
	}
}
