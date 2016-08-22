package DesignPattern.Inheritance;

/**
 * Created by root on 16-7-29.
 */
class Bee extends Insect {

  public Bee(int size, String color) {
    super(size, color);
  }

  public void move() {
    System.out.println("Fly");
  }

  public void attack() {
    move();
//    super.attack();
    System.out.println("Attack"); // 这样写不符合软件工程中重用的思想
  }
}