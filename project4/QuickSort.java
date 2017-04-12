public class QuickSort implements Sorter {
  int[] array;

  @Override
  public void sort(int[] a){
    array = a;
    recQuickSort(0, a.length - 1);
  }

  public void recQuickSort(int left, int right){
    if(right - left <= 0) // if size <= 1,
      return;
    else {
      int pivot = array[right];
      int partition = partitionIt(left, right, pivot);
      recQuickSort(left, partition-1); // sort left side
      recQuickSort(partition+1, right); // sort right side
    }
  } // end recQuickSort()

  public int partitionIt(int left, int right, int pivot) {
    int leftPtr = left - 1; // left (after ++)
    int rightPtr = right; // right-1 (after --)
    while(true){
      // find bigger item
      while(array[++leftPtr] < pivot); // (nop)

      // find smaller item
      while(rightPtr > 0 && array[--rightPtr] > pivot); // (nop)

      if(leftPtr >= rightPtr) // if pointers cross,
        break; // partition done
      else  // not crossed, so
        swap(leftPtr, rightPtr); // swap elements

    } // end while(true)

    swap(leftPtr, right); // restore pivot
    return leftPtr; // return pivot location
  } // end partitionIt()

//--------------------------------------------------------------Quicksort
  public void swap(int dex1, int dex2) { // swap two elements
    int temp = array[dex1]; // A into temp
    array[dex1] = array[dex2]; // B into A
    array[dex2] = temp;  // temp into B
  } // end swap(
}
