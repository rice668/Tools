package DesignPattern.Static_Proxy;

/**
 * Created by root on 16-7-22.
 * 静态代理: 静态代理中代理类和委托类也常常继承同一父类或实现同一接口。
 */
public class ProxyPatternDemo {
  public static void main(String[] args) {
    Image image = new ProxyImage("test_10mb.jpg"); // 并没有使用真正的类，而是使用了代理类

    image.display();
    System.out.println("");
    image.display();
  }
}
