public class MergeSort implements Sorter {
  int[] array;

  @Override
  public void sort(int[] a){
    array = a;

    int[] workspace = new int[a.length];
    reMergeSort(workspace, 0, a.length - 1);
  }

  private void reMergeSort(int[] workspace, int lowerBound, int upperBound){
    if(lowerBound == upperBound)
      return;
    else{
      int mid = (lowerBound + upperBound) / 2;

      // sort lower half
      reMergeSort(workspace, lowerBound, mid);

      // sort upper half
      reMergeSort(workspace, mid + 1, upperBound);

      // merge them
      merge(workspace, lowerBound, mid + 1, upperBound);
    }
  }

  // mergeing process
  private void merge(int[] workspace, int lowPtr, int highPtr, int upperBound){
    int j = 0; // workspace index
    int lowerBound = lowPtr;
    int mid = highPtr - 1;
    int n = upperBound - lowerBound + 1; // number of items

    while(lowPtr <= mid && highPtr <= upperBound)
      if(array[lowPtr] < array[highPtr])
        workspace[j++] = array[lowPtr++];
      else
        workspace[j++] = array[highPtr++];

    while(lowPtr <= mid)
      workspace[j++] = array[lowPtr++];

    while(highPtr <= upperBound)
      workspace[j++] = array[highPtr++];

    for(j = 0; j < n; j++){
      array[lowerBound + j] = workspace[j];
    }
  }
}
