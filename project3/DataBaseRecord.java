/* 
	 Name: Gregory Mann
	 Assignment Number: 1
	 COSC 311 - Winter 2017
*/

/*
 * this class is a nothing more than a data container
 *
 */

public class DataBaseRecord {
	private String id;
	private String firstName;
	private String lastName;
	
	public DataBaseRecord(String i, String f, String l){
		id        = new String(i);
		firstName = new String(f);
		lastName  = new String(l);
	}
	
	public String toString(){ 
		return(id + " " + firstName + " " + lastName);
	}
}
