package DesignPattern.SingletonPattern;

/**
 * Created by root on 16-8-12.
 */
public class Singleton_2 {

  private static Singleton_2 singleton_2 = new Singleton_2();

  private Singleton_2() {}

  public static Singleton_2 getInstance() {
    return singleton_2;
  }

  public static void main(String[] args) {
    Singleton_2 singleton_2 = getInstance();
  }
}
