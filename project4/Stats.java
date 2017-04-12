// a simple data storage object
public class Stats {
  private long acendingTime, decendingTime, randomTime;
  private int[] acendingData, decendingData, randomData;

  // 6 arg constructor
  public Stats(long a, long d, long r, int[] ad, int[] dd, int[] rd){
    acendingTime = a;
    decendingTime = d;
    randomTime = r;
    acendingData = ad;
    decendingData = dd; 
    randomData = rd;
  }

  public long getAcendingTime(){
    return acendingTime;
  }

  public long getDecendingTime(){
    return decendingTime;
  }

  public long getRandomTime(){
    return randomTime;
  }

  public int[] getAcendingData(){
    return acendingData;
  }

  public int[] getDecendingData(){
    return decendingData; 
  }

  public int[] getRandomData(){
    return randomData;
  }
}
