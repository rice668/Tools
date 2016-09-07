package BasicAlgorithms.DynamicProgramming;

/**
 * Created by zhangminglei on 2016/9/6.
 * https://leetcode.com/problems/maximum-subarray/
 */
public class ContinuousMaximumSubArray {

  public static int maxSubArrayByTwo(int[] nums) {
    int length = nums.length;
    int max = Integer.MIN_VALUE;
    int tmp = 0;
    for (int i = 0; i < length; i++) {
      tmp += nums[i];
      if (tmp > max) {
        max = tmp;
      }
      if (tmp < 0) {
        tmp = 0;
      }
    }
    return max;
  }

  /**
   *  JAVA 6-line DP soulution
   *   O(n) runtime, O(1) space
    */
  public static int maxSubArray(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] >= 0) { // 如果以第i-1结尾的数组的值大于等于0
        nums[i] = nums[i - 1] + nums[i]; // 那么以i结尾的数组的值就替换为num[i-1] + nums[i]
      } else {
        nums[i] = nums[i];
      } // else 分支可以不写
    }
    int maxSum = nums[0];
    for (int i = 0 ; i < nums.length ; i++) {
      if (nums[i] > maxSum) {
        maxSum = nums[i];
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = {1, -4, 3, -5, 6, -1, 8};
    System.out.println(maxSubArray(arr));
  }
}
