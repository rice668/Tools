package BasicJava;

/**
 * Created by zhangminglei on 2016/9/6.
 */

class HelloB extends HelloA {
  public HelloB() {
    System.out.println("HelloB");
  }
  // 这个为构造代码块
  {
    System.out.println("I’m B class");
  }

  static {
    System.out.println("static B");
  }

  public static void main(String[] args) {
    new HelloB();
  }
}

class HelloA {
  public HelloA() {
    System.out.println("HelloA");
  }

  {
    System.out.println("I’m A class");
  }

  static {
    System.out.println("static A");
  }
}

public class TestStaticAndContext {
  public static void main(String[] args) {
    new HelloB();
  }
}
