package BasicAlgorithms.DiDi;

/**
 * Created by zhangminglei on 2016/9/6.
 */
public class TestDiDi {

  static int foo(int num) {
    return num & ~num;
  }

  public static void main(String[] args) {
    System.out.println(foo(2^31 - 3));

    String str1 = new String("Hello");
    String str2 = new String("Hello");
    if (str1 == str2) {
      System.out.println("True");
    }

    String str3 = "Hello";
    String str4 = "Hello";
    char chars[] = {'h','e','l','l','o'};
    if (str3 == str4) {
      System.out.println("True");
    }

    if (str3.equals(chars)) {
      System.out.println("=True");
    }

  }
}
