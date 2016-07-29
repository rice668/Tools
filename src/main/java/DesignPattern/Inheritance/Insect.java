package DesignPattern.Inheritance;

/**
 * Created by root on 16-7-29.
 */
class Insect {
  private int size;
  private String color;

  public Insect(int size, String color) {
    this.size = size;
    this.color = color;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void move() {
    System.out.println("Move");
  }

  public void attack() {
    move(); //assuming an insect needs to move before attacking
    System.out.println("Attack");
  }
}