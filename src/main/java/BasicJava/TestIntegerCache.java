package BasicJava;

/**
 * Created by root on 16-8-7.
 */
public class TestIntegerCache {
  public static void main(String[] args) throws Exception {
    Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

    System.out.println(f1 == f2); // 只能缓存在 -128 到 127 之间
    System.out.println(f3 == f4);

    Class<?> cl = Class.forName("java.lang.String");
    System.out.println(cl.getName());

  }
}
