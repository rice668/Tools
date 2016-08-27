package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/25.
 * Unlike substrings, subsequences are not required to occupy consecutive positions within the original sequences.
 * 要注意连续公共字串和公共字串的区别
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */
public class LongestCommonSubsequence {

  static String LCSeq(String a, String b) {
    String x;
    String y;
    int aLen = a.length();
    int bLen = b.length();
    if (aLen == 0 || bLen == 0) {
      return "";
    } else if (a.charAt(aLen - 1) == b.charAt(bLen - 1)) {
      return LCSeq(a.substring(0, aLen - 1), b.substring(0, bLen - 1)) + b.charAt(bLen - 1);
    } else {
      x = LCSeq(a, b.substring(0, bLen - 1));
      y = LCSeq(a.substring(0, aLen - 1), b);
    }
    return (x.length() > y.length()) ? x : y;
  }

  /**
   * http://www.sanfoundry.com/java-program-longest-common-subsequence-algorithm/
   */
  static String longestSubSeq(String str1, String str2) {
    int l1 = str1.length();
    int l2 = str2.length();
    int[][] arr = new int[l1 + 1][l2 + 1];
    for (int i = l1 - 1; i >= 0; i--) {
      for (int j = l2 - 1; j >= 0; j--) {
        if (str1.charAt(i) == str2.charAt(j))
          arr[i][j] = arr[i + 1][j + 1] + 1;
        else
          arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
      }
    }

    int i = 0, j = 0;
    StringBuffer sb = new StringBuffer();
    while (i < l1 && j < l2) {
      if (str1.charAt(i) == str2.charAt(j)) {
        sb.append(str1.charAt(i));
        i++;
        j++;
      }
      else if (arr[i + 1][j] >= arr[i][j + 1])
        i++;
      else
        j++;
    }
    return sb.toString();
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String a = scanner.nextLine();
      String b = scanner.nextLine();
      System.out.println(LCSeq(a, b));
    }
  }
}
