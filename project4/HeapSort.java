public class HeapSort implements Sorter {
  @Override
  public void sort(int[] a){}

  class Node{
    private int iData; // data item (key)

    public Node(int key){ 
      iData = key; 
    }

    public int getKey(){ 
      return iData; 
    }
  } 

  class Heap {
    private Node[] heapArray;
    private int maxSize;  // size of array
    private int currentSize;  // number of items in array

    public Heap(int mx) {
      maxSize = mx;
      currentSize = 0;
      heapArray = new Node[maxSize];
    }

    public Node remove(){ // delete item with max key
      Node root = heapArray[0]; // (assumes non-empty list)
      heapArray[0] = heapArray[--currentSize];
      return root;
    }

    public void trickleDown(int index){
      int largerChild;
      Node top = heapArray[index];  // save root
      while(index < currentSize/2){ // not on bottom row
        int leftChild = 2*index+1;
        int rightChild = leftChild+1; // find larger child
        if(rightChild < currentSize &&  // right child exists?
           heapArray[leftChild].getKey() <
           heapArray[rightChild].getKey())
          largerChild = rightChild;
        else
          largerChild = leftChild;

        // top >= largerChild?
        if(top.getKey() >= heapArray[largerChild].getKey())
          break;

        // shift child up
        heapArray[index] = heapArray[largerChild];
        index = largerChild;
        // go down
      } // end while
      heapArray[index] = top; // root to index
    }
    
    public void insertAt(int index, Node newNode){ 
      heapArray[index] = newNode; 
    }

    public void incrementSize(){ 
      currentSize++; 
    }
  } 

  // TODO: see how it uses the heap for heap sort
  // make a heapify method and then the sort
  class HeapSortApp{
    public static void main(String[] args) throws IOException
  {

  int size, j;
  System.out.print(“Enter number of items: “);
  size = getInt();
  Heap theHeap = new Heap(size);
  for(j=0; j<size; j++)
  // fill array with
  {
  //
  random nodes
  int random = (int)(java.lang.Math.random()*100);
  Node newNode = new Node(random);
  theHeap.insertAt(j, newNode);
  theHeap.incrementSize();
  }
  System.out.print(“Random: “);
  theHeap.displayArray(); // display random array
  for(j=size/2-1; j>=0; j--)
  theHeap.trickleDown(j);
  System.out.print(“Heap:
  theHeap.displayArray();
  theHeap.displayHeap();
  // make random array into heap
  “);
  // display heap array
  // display heap
  for(j=size-1; j>=0; j--)
  // remove from heap and
  {
  //
  store at array end
  Node biggestNode = theHeap.remove();
  theHeap.insertAt(j, biggestNode);
  }
  System.out.print(“Sorted: “);
  theHeap.displayArray();
  // display sorted array
  } // end main()
}
