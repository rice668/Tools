package OJ;

/**
 * Created by root on 16-7-31.
 */
public class TryTest {

  int test(int b) {
    try {
      b+=10;
      return b;
    }
    finally {
      b+=10;
      return b;
    }
  }

  public static void main(String[] args) {
    System.out.println(new TryTest().test(10));
  }
}
