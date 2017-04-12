import java.io.File;
import java.io.PrintWriter;
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
    // TODO: make this into a method
    System.out.println("Merege Sort: ");
    printTime(mergeSortStats);

    // write out the files
    System.out.println("Please enter the prefix for the file names");
    Scanner keyboard = new Scanner(System.in);
    String prefix = keyboard.next();
    keyboard.close();

    writeData(prefix, mergeSortStats);
  }

  // prints the results out the the screen
  private void printTime(Stats data){
    System.out.println("\t Acending Time: " + data.getAcendingTime());
    System.out.println("\t Decending Time: " + data.getDecendingTime());
    System.out.println("\t Random Time: " + data.getRandomTime());
    System.out.println();
  }

  // writes the sorted data out to a file for inspection
  private static void writeData(String prefix, Stats data){
    File acending = new File(prefix + "-acendingSorted.txt");
    File decending = new File(prefix + "-decendingSorted.txt");
    File random = new File(prefix + "-randomSorted.txt");

    writeToDisk(data.getAcendingData(), acending);
    writeToDisk(data.getDecendingData(), decending);
    writeToDisk(data.getRandomData(), random);
  }

  // writes files to the disk
  private static void writeToDisk(int[] a, File file){
    try {
      PrintWriter write = new PrintWriter(file);

      for(int i = 0; i < a.length; i++){
        write.println(a[i]);
      }

      write.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }

  // reads data in from the files
  private static void readData(String filename, int[] array){
    int i = 0;
    try {
      Scanner file = new Scanner(new File(filename));

      while(file.hasNextInt())
        array[i++] = file.nextInt();

      file.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }

  // returns a Stats object containing the results of the benchmark
  private static Stats benchmark(Sorter method, int[] acendingData, int[] decendingData, int[] randomData){
    int[] acd = copy(acendingData);
    int[] dcd = copy(decendingData);
    int[] rad = copy(randomData);
    long acendingTime = timing(method, acd);
    long decendingTime = timing(method, dcd);
    long randomTime = timing(method, rad);
    return new Stats(acendingTime, decendingTime, randomTime, acd, dcd, rad);
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
