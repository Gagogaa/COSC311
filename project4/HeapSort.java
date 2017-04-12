public class HeapSort implements Sorter {
  @Override
  public void sort(int[] a){
    Heap theHeap = new Heap(a);
    theHeap.sortit();
  }

  // the heap for the heap sort
  public class Heap {
    private int[] heapArray; 
    private int maxSize;  // size of array
    private int currentSize;  // number of items in array

    public Heap(int[] array){
      maxSize = array.length;
      currentSize = array.length;
      heapArray = array;
      heapify();
    }

    // pop an item off the top of the heap
    public int pop(){ // delete item with max key
      int root = heapArray[0]; // (assumes non-empty list)
      heapArray[0] = heapArray[--currentSize];
      trickleDown(0);
      return root;
    }

    // ensure that the index is in the proper spot in relation to its parents
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
 
    // converts the array to a heap
    public void heapify(){
      for(int j = heapArray.length / 2 - 1; j >= 0; j--)
        trickleDown(j);
    }

    // converts the heap into a sorted array
    public void sortit(){
      for(int j = heapArray.length - 1; j >= 0; j--){ // remove from heap and store at array end
        heapArray[j] = pop();
      }
    }
  }
}
