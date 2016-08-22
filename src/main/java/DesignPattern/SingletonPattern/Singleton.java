package DesignPattern.SingletonPattern;

/**
 * Created by root on 16-8-12.
 */
public class Singleton {

  private static Singleton instance;

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  public static void main(String[] args) {

  }
}
