// imports up here
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

  }
  
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

  //public Stats benchmark(Sorter method, int[] acendingData, int[] decendingData, int[] randomData){}

  //public int timeing(Sorter method, int[] data){}

}
