/* 
	 Name: Gregory Mann
	 Assignment Number: 2
	 COSC 311 - Winter 2017
*/

/*
 * this class is an implementation of a doubly linked double ended ordered linked list
 *
 */

public class LinkedList {
	private Node front, back, iterator;

	public LinkedList(){
		front = null;
		back = null;
		iterator = front;
	}

	public LinkedList(int size){
		front = null;
		back = null;
		iterator = front;
	}

	private class Node {
		private Node prev, next;
		private IndexRecord data;

		public Node (IndexRecord data){
			this.data = data;
		}

		public Node getNext(){
			return next;
		}

		public void setNext(Node next){
			this.next = next;
		}

		public Node getPrevious(){
			return prev;
		}

		public void setPrevious(Node prev){
			this.prev = prev;
		}

		public IndexRecord getData(){
			return data;
		}
	}

	// This method takes a search string to find search within the database array
	// return index of the key in the database array or -1 if not found
	public int findIt(String str){
		IndexRecord key = new IndexRecord(str, 0);

		iteratorInitFront();

		// iterate until a match is found or the pointer runs off the end of the list
		while (hasNext()){
			if(iterator.getData().compareTo(key) == 0) break;
			iterator = iterator.getNext();
		}

		return (iterator == null ? -1 : iterator.getData().getIndex());
	}
	
	// takes a string as the "key" and the location its at in the database array
	// returns true
	public boolean add(String str, int loc){
		IndexRecord newValue = new IndexRecord(str, loc);
		iteratorInitFront();

		// iterate through the list and stop on the first element thats greater than the new value
		while (hasNext()){
			if (iterator.getData().compareTo(newValue) > 0) break;
			iterator = iterator.getNext();
		}

		Node newNode = new Node(newValue);

		// add newNode into the list
		newNode.setNext(iterator);
		if (iterator == null) {	// newNode is the greatest thing in the list
			newNode.setPrevious(back);
			if (back != null)
				back.setNext(newNode);
			back = newNode;
		} else {	// newNode is not the greatest thing in the list
			newNode.setPrevious(iterator.getPrevious());
			if (iterator.getPrevious() != null)
				iterator.getPrevious().setNext(newNode);
			iterator.setPrevious(newNode);
		}
		if (front == iterator)
			front = newNode;
		return true;
	}

	// removes something from the array based on the location in the databasae array
	// returns false if it couldnt find it in the array and true if it was deleted
	public boolean delete(int num){
		iteratorInitFront();

		// iterate to the matching Node
		while (hasNext()){
			if (iterator.getData().getIndex() == num) break;
			iterator = iterator.getNext();
		}

		// if the match isn't found
		if (front == null || iterator == null)
			return false;

		// delete the node
		if (iterator == front){
			front = front.getNext();
			front.setPrevious(null);
		} else if (iterator == back){
			back = back.getPrevious();
			back.setNext(null);
		} else {
			iterator.getPrevious().setNext(iterator.getNext());
			iterator.getNext().setPrevious(iterator.getPrevious());
		}
		return true;
	}
	
	// moves the iterator to the front of the array
	public void iteratorInitFront(){
		iterator = front;
	}

	// moves the iterator to the back of the array
	public void iteratorInitBack(){
		iterator = back;
	}

	// returns true if another element is within next pointer locaion
	// returns false otherwise
	public boolean hasNext(){
		if(iterator == null)
			return false;
		return true;
	}
	
	// returns true if another element is within previous pointer locaion
	// returns false otherwise
	public boolean hasPrevious(){
		if(iterator == null)
			return false;
		return true;
	}

	// returns the index stored within the record at the pointer location
	// then increments the pointer 
	public int getNext(){
		int val = iterator.getData().getIndex();
		iterator = iterator.getNext();
		return val;
	}

	// returns the index stored within the record at the pointer location
	// then decrements the pointer 
	public int getPrevious(){
		int val = iterator.getData().getIndex();
		iterator = iterator.getPrevious();
		return val;
	}
}
