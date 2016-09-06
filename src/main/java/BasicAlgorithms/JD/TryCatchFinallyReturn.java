package BasicAlgorithms.JD;

/**
 * Created by zhangminglei on 2016/9/6.
 */
public class TryCatchFinallyReturn {

  static int test() {
    try {
      // ... do
      System.out.println("hello");
      return 1;
    } catch (Exception e) {
      return 2;
    } finally {
      return 3;
    }
  }

  public static void main(String[] args) {
    System.out.println(test());
    char[] chars = {'h','e'};
    String str = "he";
  }
}
