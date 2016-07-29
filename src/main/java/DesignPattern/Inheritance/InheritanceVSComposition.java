package DesignPattern.Inheritance;

/**
 * http://www.importnew.com/12907.html
 * 继承机制是有缺点的：子类依赖于父类的实现细节，如果父类产生了变更，子类的后果将不堪设想。
 *
 */
public class InheritanceVSComposition {
  public static void main(String[] args) {
    Insect i = new Bee(1, "red");
    i.attack();
  }
}
