// a simple data storage object
public class Stats {
  //TODO set the array data refs
  private long acendingTime, decendingTime, randomTime;
  private int[] acendingData, decendingData, randomData;

  // 3 arg constructor
  public Stats(long a, long d, long r){
    acendingTime = a;
    decendingTime = d;
    randomTime = r;
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

  public String toString(){
    return "Hello, world";
  }
}
