import java.io.File;
import java.util.*;

public class Program4 {
  public static void main(String[] args){
    String acendingText = "dataAscend.txt";
    String decendingText = "dataDescend.txt";
    String randomText = "dataRandom.txt";

    int[] acendingData = new int[10000];
    int[] decendingData = new int[10000];
    int[] randomData = new int[10000];

    readData(acendingText, acendingData);
    readData(decendingText, decendingData);
    readData(randomText, randomData);

    // create the sort objects
    //HeapSort heap = new HeapSort();
    //QuickSort quick = new QuickSort();
    MergeSort merge = new MergeSort();

    // TODO: implement the sorts and print the time in a human readable format
    //Stats heapSortStats = benchmark(heap, acendingData, decendingData, randomData);
    //Stats quickSortStats = benchmark(quick, acendingData, decendingData, randomData);
    Stats mergeSortStats = benchmark(merge, acendingData, decendingData, randomData);

    // TODO: display the data

    System.out.println("Acending Time: " + mergeSortStats.getAcendingTime());
    System.out.println("Decending Time: " + mergeSortStats.getDecendingTime());
    System.out.println("Random Time: " + mergeSortStats.getRandomTime());
    System.out.println();
  }

  // reads data in from the files
  private static void readData(String filename, int[] array){
    int i = 0;
    try {
      Scanner file = new Scanner(new File(filename));

      while(file.hasNextInt())
        array[i++] = file.nextInt();

    } catch(Exception e){
      e.printStackTrace();
    }
  }

  // returns a Stats object containing the results of the benchmark
  private static Stats benchmark(Sorter method, int[] acendingData, int[] decendingData, int[] randomData){
    // TODO: copy the arrays that are being passed in because they will overrite the data
    long acendingTime = timing(method, copy(acendingData));
    long decendingTime = timing(method, copy(decendingData));
    long randomTime = timing(method, copy(randomData));
    return new Stats(acendingTime, decendingTime, randomTime);
  }

  // return a deep copy of an array
  private static int[] copy(int[] a){
    int[] b = new int[a.length];

    for(int i = 0; i < a.length; i++){
      b[i] = a[i];
    }

    return b;
  }

  private static long timing(Sorter method, int[] data){
    long startTime = System.nanoTime();
    method.sort(data);
    return System.nanoTime() - startTime;
  }
}
