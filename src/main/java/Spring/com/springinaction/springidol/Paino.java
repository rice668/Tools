package Spring.com.springinaction.springidol;

import Spring.com.springinaction.springidol.Interface.Instrument;

public class Paino implements Instrument {
  public Paino() {
  }

  public void play() {
    System.out.println("Plink Plink Plink");
  }

  @Override
  public String toString() {
    return "Belongs to Paino";
  }
}
