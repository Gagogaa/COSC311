// TODO: think about implementing this as an interface
// also think about the delete method! (it should probably be done by index) Ill need to change
// the index of all the elements that were moved in the
// parent array
public class IndexRecord {
	private String element;
	private int index;

	public IndexRecord(String elem, int ind){
		element = new String(elem);
		index   = ind;
	}

	public String toString(){
		return new String(element);
	}

	public int compareTo(IndexRecord otherIndexRecord){
		return(element.compareTo(otherIndexRecord.element));
	}

	public int getIndex(){
		return index;
	}

	public void decrement(){
		index--;
	}
}
