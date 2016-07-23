package BasicAlgorithms.DynamicProgramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

  public int climbStairsByRecursion(int n) {
    if (n == 1 || n == 0) {
      return 1;
    }
    return climbStairsByRecursion(n - 1) + climbStairsByRecursion(n - 2);
  }

  /**
   * DP, 用一张表存储中间结果
   */
  public int climbStairsBy(int n) {
    if (n == 0 || n == 1 || n == 2) {
      return n;
    }
    int[] table = new int[n];
    table[0] = 1; // 一个台阶的时候为一种
    table[1] = 2; // 两个台阶的时候为两种走法
    int result = 0;
    for (int i = 2; i < n; i++) {
      table[i] = table[i - 1] + table[i - 2];
      result = table[i];
    }
    return result;
  }

  /**
   * 观察数据的变化，赋值的变化
   * f(4) = f(3) + f(2)
   * f(5) = f(4) + f(3)
   */
  public int climbStairs(int n) {
    if (n == 0 || n == 1 || n == 2) {
      return n;
    }
    int stepOne = 1, stepTwo = 2;
    int result = 0;
    for (int i = 3; i <= n; i++) {
      result = stepOne + stepTwo;
      stepOne = stepTwo;
      stepTwo = result;
    }
    return result;
  }

  public static void main(String[] args) {
    ClimbingStairs c = new ClimbingStairs();
    System.out.println(c.climbStairs(20));
    System.out.println(c.climbStairsBy(20));
    System.out.println(c.climbStairsByRecursion(20));
  }
}
