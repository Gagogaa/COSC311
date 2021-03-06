/* 
	 Name: Gregory Mann
	 Assignment Number: 2
	 COSC 311 - Winter 2017
*/

/*
 * this class is an implementation of a Binary search tree
 *
 */

public class BinarySearchTree {
	private Node head, pointer, parent; // pointer and parent are here because oops

	public BinarySearchTree(){
    head = null;
	}

	public BinarySearchTree(int size){
    head = null;
	}

  // genaric node class with two pointers
	private class Node {
		private Node left, right;
		private IndexRecord data;

		public Node (IndexRecord data){
			this.data = data;
		}

		public Node getRight(){
			return right;
		}

		public void setRight(Node right){
			this.right = right;
		}

		public Node getLeft(){
			return left;
		}

		public void setLeft(Node left){
			this.left = left;
		}

		public IndexRecord getData(){
			return data;
		}
	}

	// This method takes a search string to find search within the database array
	// return index of the key in the database array or -1 if not found
	public int findIt(String str){
		IndexRecord key = new IndexRecord(str, 0);
    Node pointer = head;
    int comp = 0;

		// iterate until a match is found or the pointer runs off the end of the list
		while (pointer != null){
      comp = pointer.getData().compareTo(key);

			if(comp == 0) 
        break;
      else if(comp > 0)
        pointer = pointer.getRight();
      else 
        pointer = pointer.getLeft();
		}

		return (pointer == null ? -1 : pointer.getData().getIndex());
	}
	
	// takes a string as the "key" and the location its at in the database array
	// returns true
	public boolean add(String str, int loc){
		IndexRecord key = new IndexRecord(str, loc);

    Node prevPointer = null;
    Node pointer = head;
    int comp = 0;
		Node newNode = new Node(key);

    // if nothing is in the list
    if(head == null){
      head = newNode;
    } else {
      // loop through until the match is found or pointer = null
		  while (pointer != null){
        comp = pointer.getData().compareTo(key);
        prevPointer = pointer;

        if(comp > 0)
          pointer = pointer.getRight();
        else 
          pointer = pointer.getLeft();
		  }

      // set the correct child of the previouse pointer to the new node
      if(comp > 0)
        prevPointer.setRight(newNode);
      else
        prevPointer.setLeft(newNode);
    }
		return true;
	}

	// removes something from the array based on the location in the databasae array
	// returns false if it couldnt find it in the array and true if it was deleted
	public boolean delete(int num){
    pointer = null; 
    parent = null;

    // loops through and sets the parent and pointer
    recursiveFind(null, head, num);

    // of no match was found return null
    if(pointer == null) return false;

    // if pointer has two children
    if(pointer.getLeft() != null && pointer.getRight() != null){
      Node extra = pointer.getLeft();
      Node extraParent = pointer;

      // loop until you get the in order predecessor and its parent
      while(extra.getRight() != null){
        extraParent = extra;
        extra = extra.getRight();
      }

      // set the left and right references for the replacement node
      if(extraParent == pointer){
        extra.setRight(pointer.getRight());
      } else {
        extraParent.setRight(extra.getLeft());
        extra.setLeft(pointer.getLeft());
        extra.setRight(pointer.getRight());
      }

      // set the pointers for the parent node
      if(head == pointer){
        head = extra;
      } else {
        if(parent.getLeft() == pointer)
          parent.setLeft(extra);
        else
          parent.setRight(extra);
      }
    } else { // pointer only has less than two children
      if(head == pointer){
        head = getChild(pointer);
      } else {
        if(parent.getLeft() == pointer)
          parent.setLeft(getChild(pointer));
        else
          parent.setRight(getChild(pointer));
      }
    }

    return true;
	}

  // returns a reference to the child of a node
  private Node getChild(Node n){
    if(n.getLeft() == null)
      return n.getRight();
    else
      return n.getLeft();
  }

  // finds the node i want to delete and its parent
  private void recursiveFind(Node par, Node current, int loc){
    // reached the end of the tree
    if(current == null){
    // found a match set parent and pointer
    } else if(current.getData().getIndex() == loc){
      parent = par;
      pointer = current;
    } else {
      // recursive call to continue searching through the list
      recursiveFind(current, current.getRight(), loc);
      recursiveFind(current, current.getLeft(), loc);
    }
  }

  // prints the tree in ascending order
  public void printAscending(DataBaseArray a){
    ascend(head, a);
  };

  // a recursive healper method for printAscending
  private void ascend(Node n, DataBaseArray a){
    if(n != null){
      ascend(n.getRight(), a);
      System.out.println(a.getByIndex(n.getData().getIndex()).toString());
      ascend(n.getLeft(), a);
    }
  };

  // prints the tree in descending order
  public void printDescending(DataBaseArray a){
    decend(head, a);
  };
 
  // a recursive healper method for printDescending
  private void decend(Node n, DataBaseArray a){
    if(n != null){
      decend(n.getLeft(), a);
      System.out.println(a.getByIndex(n.getData().getIndex()).toString());
      decend(n.getRight(), a);
    }
  } 
}
