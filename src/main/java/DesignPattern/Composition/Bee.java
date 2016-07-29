package DesignPattern.Composition;

// This wrapper class wrap an Attack object

class Bee extends Insect implements Attack {
  private Attack attack;

  public Bee(int size, String color, Attack attack) {
    super(size, color);
    this.attack = attack;
  }

  public void move() {
    attack.move();
  }

  public void attack() {
    attack.attack();
  }
}