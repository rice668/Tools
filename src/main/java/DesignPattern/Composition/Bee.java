package DesignPattern.Composition;

/**
 * 蜜蜂有一个攻击的功能，那么这部分用接口进行设计，实现一个什么功能。
 * 蜜蜂是一个昆虫，并且有着攻击的功能。
 */
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