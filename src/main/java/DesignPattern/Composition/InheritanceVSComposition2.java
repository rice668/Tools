package DesignPattern.Composition;


/**
 * 以下两条原则说明了应该如何选择继承与组合：
 * 如果存在一种IS-A的关系（比如Bee“是一个Insect），并且一个类需要向另一个类暴露所有的方法接口，
 * 那么更应该用继承的机制。如果存在一种HAS-A的关系（比如Bee“有一个”attack功能），那么更应该运用组合。
 */

public class InheritanceVSComposition2 {
  public static void main(String[] args) {
    Bee a = new Bee(1, "black", new AttackImpl("fly", "move"));
    a.attack();

    // if you need another implementation of move()
    // there is no need to change Insect, we can quickly use new method to attack

    Bee b = new Bee(1, "black", new AttackImpl("fly", "sting"));
    b.attack();

  }
}