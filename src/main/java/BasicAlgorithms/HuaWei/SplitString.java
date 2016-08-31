package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/24.
 * http://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * <p>
 * static List splitStrings(String fir, String sec) {
 * ArrayList<String> list = new ArrayList<String>();
 * if (fir.length() < 8) {
 * int added = 8 - fir.length();
 * StringBuilder sb = null;
 * for(int i = 0;i < added ; i++) {
 * sb = new StringBuilder(fir);
 * sb.append('0');
 * }
 * list.add(sb.toString());
 * } else {
 * list.add(fir.substring(0,8));
 * String newStr = fir.substring(7, fir.length());
 * StringBuilder sb = new StringBuilder(newStr);
 * sb.append(sec);
 * if (sb.length() < 8) {
 * int added = 8 - fir.length();
 * StringBuilder sb1 = null;
 * for(int i = 0;i < added ; i++) {
 * sb1 = new StringBuilder(fir);
 * sb1.append('0');
 * }
 * list.add(sb1.toString());
 * } else {
 * <p>
 * }
 * }
 * return list;
 * }
 * <p>
 * public static void main(String[] args) {
 * Scanner scanner = new Scanner(System.in);
 * List<String> list;
 * while (scanner.hasNext()) {
 * String firLine = scanner.nextLine();
 * String secLine = scanner.nextLine();
 * list = splitStrings(firLine, secLine);
 * for (int i = 0 ; i < list.size();i ++) {
 * System.out.println(list.get(i)); // 不能写成list[i], 这是数组的表示方法
 * }
 * }
 * }
 */
public class SplitString {

  public static void split(String s) {
    while (s.length() >= 8) {
      System.out.println(s.substring(0, 8));
      s = s.substring(8); // 关键这个重载函数得知道，不光要知道substring(str1, str2)
    }
    if (s.length() < 8 && s.length() > 0) {
      s = s + "00000000000000"; // 这是一个好思路
      System.out.println(s.substring(0, 8));
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String s = scanner.nextLine();
      split(s);
    }
  }
}






