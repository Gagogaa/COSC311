  public class Heap {
    private int[] heapArray; 
    private int maxSize;  // size of array
    private int currentSize;  // number of items in array

    // TODO remove this
    public Heap(int mx) {
      maxSize = mx;
      currentSize = 0;
      heapArray = new int[maxSize];
    }

    public Heap(int[] array){
      maxSize = array.length;
      currentSize = array.length;
      heapArray = array;
      heapify();
    }

    // the pop method
    public int pop(){ // delete item with max key
      int root = heapArray[0]; // (assumes non-empty list)
      heapArray[0] = heapArray[--currentSize];
      trickleDown(0);
      return root;
    }

    // TODO look through here if i get any strange errors
    public void trickleDown(int index){
      int largerChild;
      int top = heapArray[index];  // save root

      while(index < currentSize / 2){ // not on bottom row
        int leftChild = 2 * index + 1;
        int rightChild = leftChild + 1; // find larger child

        if(rightChild < currentSize &&  // right child exists?
          heapArray[leftChild] <
          heapArray[rightChild])
          largerChild = rightChild;
        else
          largerChild = leftChild;

        // top >= largerChild?
        if(top >= heapArray[largerChild])
          break;

        // shift child up
        heapArray[index] = heapArray[largerChild];
        index = largerChild;  // go down
      } // end while
      heapArray[index] = top; // root to index
    }
 
    // converts an array to a heap
    public void heapify(){
      for(int j = heapArray.length / 2 - 1; j >= 0; j--)
        trickleDown(j);
    }

    public void insertAt(int index, int value){ 
      heapArray[index] = value; 
    }

    public void incrementSize(){ 
      currentSize++; 
    }

    public void sortit(){
      for(int j = heapArray.length - 1; j >= 0; j--){ // remove from heap and store at array end
        int biggestNode = pop();
        insertAt(j, biggestNode);
      }
    }
  }

