package BasicAlgorithms;

/**
 * 给我一个数组［1，2，5，10，20，50，100］，可以从里面取若干个数，要求得出和为100的不同取法有多少？
 *
 * 递归思路：假设 count(n)表示和为n的取法有count种，那么当n为100的时候，有count(100)种，
 * 假设已经取出了1，那么只要取出和为99的有多少种即可，假设已经取出了2，那么只要取出和为98的
 * 有多少种即可，递归式子为 ： count(n) = count(n-1) + count(n-2) + ...
 */
public class GetSumOf100 {

  public int count(int target) {
    if (target < 0) // 如果不小于0，取5的话，count就没有匹配的数值了
      return 0;
    if (target == 1)
      return 1;
    return count(target - 1) + count(target - 2) + count(target - 5)
            + count(target - 10) + count(target - 20) + count(target - 50)
            + count(target - 100);
  }


  public static void main(String[] args) {
    System.out.println(new GetSumOf100().count(5));
  }
}
