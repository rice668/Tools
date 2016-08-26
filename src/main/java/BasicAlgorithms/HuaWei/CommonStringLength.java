package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/26.
 * http://www.nowcoder.com/practice/98dc82c094e043ccb7e0570e5342dd1b?tpId=37&tqId=21298&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class CommonStringLength {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = "";
    String str2 = "";
    while(sc.hasNext()) {
      str1 = sc.next();
      str2 = sc.next();
      System.out.println(LCString(str1, str2).length());
    }
  }

  // error
  static String LCString(String a, String b) {
    String x;
    String y;
    int aLen = a.length();
    int bLen = b.length();
    if (aLen == 0 || bLen == 0) {
      return "";
    } else if (a.charAt(aLen - 1) == b.charAt(bLen - 1)) {
      return LCString(a.substring(0, aLen - 1), b.substring(0, bLen - 1)) + b.charAt(bLen - 1);
    } else {
      return "";
    }
  }


//  public static int getCommonStrLength(String str1, String str2) {
//    int len1 = str1.length();
//    int len2 = str2.length();
//    int[][] dp = new int[len1+1][len2+1];
//    for(int i=0;i<=len1;i++) {
//      for(int j=0;j<=len2;j++) {
//        dp[i][j] = 0;
//      }
//    }
//    for(int i=1;i<=len1;i++) {
//      for(int j=1;j<=len2;j++) {
//        if(str1.charAt(i-1) == str2.charAt(j-1)){
//          dp[i][j] = dp[i-1][j-1] + 1;
//        }else{
//          dp[i][j] = 0;   //区别在这儿
//        }
//      }
//    }
//    int max = 0;
//    for(int i=0;i<=len1;i++){
//      for(int j=0;j<=len2;j++){
//        if(max < dp[i][j])
//          max = dp[i][j];
//      }
//    }
//    return max;
//  }
//
//  private static int getCommonStrLengthByAnother(String s1, String s2) {
//    int ans = 0;
//    int len1 = s1.length();
//    int len2 = s2.length();
//    String  max = (len1 > len2 ? s1 : s2);
//    String  min = (s1 == max ? s2 : s1);
//    for (int i = 0; i <= min.length(); i++) {
//      for (int j = 0; j <=min.length()-i; j++) {
//        if(max.contains(min.substring(j, j+i)))
//          ans=i;
//      }
//    }
//    return ans;
//  }

}
