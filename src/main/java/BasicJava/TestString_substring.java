package BasicJava;

/**
 * http://www.programcreek.com/2013/09/the-substring-method-in-jdk-6-and-jdk-7/
 */
public class TestString_substring {
  public static void main(String[] args) {
    String x = "abcdef"; // immutable
    x = x.substring(1,3);
    System.out.println(x);
  }
}
