
public class DataBaseRecord {
	private String firstName;
	private String lastName;
	private String id;
	
	public DataBaseRecord(String f, String l, String i){
		firstName = new String(f);
		lastName  = new String(l);
		id        = new String(i);
	}
	
	public String toString(){ 
		return(LastName + " " + credits + "  " + gpa);
	}

	// I don't think that this needs a compair to because the database
	// is implemented as a unordered array
	public int compareTo(DataBaseRecord otherDataBaseRecord){
		return(id.compareTo(otherDataBaseRecord.id));
	}
}
