public class HeapSort implements Sorter {

  @Override
  public void sort(int[] a){
    Heap theHeap = new Heap(a);
    theHeap.sortit();
  }
}
