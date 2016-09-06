package BasicAlgorithms.JD;

/**
 * Created by zhangminglei on 2016/9/6.
 */
public class TestDiDi {

  static int foo(int num) {
    return num & ~num;
  }

  public static void main(String[] args) {
    System.out.println(foo(2^31 - 3));
  }
}
