package Spring.com.springinaction.springidol;

import Spring.com.springinaction.springidol.Interface.Instrument;

public class Saxophone implements Instrument {
  public Saxophone() {
  }

  public void play() {
    System.out.println("TOOT TOOT TOOT");
  }

  @Override
  public String toString() {
    return "Belongs to Saxophone";
  }
}
