package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/26.
 * http://www.nowcoder.com/practice/98dc82c094e043ccb7e0570e5342dd1b?tpId=37&tqId=21298&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class CommonStringLength {

  public static int getCommonStrLength(String str1, String str2) {
    int len1 = str1.length();
    int len2 = str2.length();
    int[][] dp = new int[len1 + 1][len2 + 1];
    for (int i = 0; i <= len1; i++) {
      for (int j = 0; j <= len2; j++) {
        dp[i][j] = 0;
      }
    }
    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = 0;   //区别在这儿
        }
      }
    }
    int max = 0;
    for (int i = 0; i <= len1; i++) {
      for (int j = 0; j <= len2; j++) {
        if (max < dp[i][j])
          max = dp[i][j];
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = "";
    String str2 = "";
    while (sc.hasNext()) {
      str1 = sc.nextLine();
      str2 = sc.nextLine();
      System.out.println(getCommonStrLength(str1, str2));
    }
  }
}
