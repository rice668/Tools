package BasicAlgorithms.HuaWei;

/**
 * Created by mingleizhang on 2016/8/25.
 * Unlike substrings, subsequences are not required to occupy consecutive positions within the original sequences.
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 */
public class LongestCommonSubsequence {

  static String LCS(String a, String b) {

    String x;
    String y;
    int aLen = a.length();
    int bLen = b.length();
    if (aLen == 0 || bLen == 0) {
      return "";
    } else if (a.charAt(aLen - 1) == b.charAt(bLen - 1)) {
      return LCS(a.substring(0, aLen - 1), b.substring(0, bLen - 1)) + b.charAt(bLen - 1);
    } else {
      x = LCS(a, b.substring(0, bLen - 1));
      y = LCS(a.substring(0, aLen - 1), b);
    }
    return (x.length() > y.length()) ? x : y;
  }

  public static void main(String[] args) {
    String a = "computeryuii";
    String b = "houseboatasyasasuasaiasasi";
    double startTime = System.currentTimeMillis();
    System.out.println(LCS(a, b));
    System.out.println(System.currentTimeMillis() - startTime);
  }
}
