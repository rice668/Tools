package BasicAlgorithms.HuaWei;

/**
 * Created by mingleizhang on 2016/8/25.
 */
public class GetGCD_Of_TwoNumber {

  static long gcd(long x, long y) {
    if (y == 0)
      return x;
    else
      return gcd(y, x % y);
  }

  public static void main(String[] args) {
    System.out.println(gcd(18, 9));
  }
}
