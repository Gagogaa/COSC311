// a simple data holding object
public class Stats {
  // System.currentTimeMillis()
  private long acendingTime;
  private long decendingTime;
  private long randomTime;

  // 3 arg constructor
  public void Stats(long a, long d, long r){
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

  public long getRandomeTime(){
    return randomTime;
  }
}
