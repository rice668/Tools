package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/27.
 * http://www.nowcoder.com/practice/48b3cb4e3c694d9da5526e6255bb73c3?tpId=37&tqId=21236&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class SentenceReverse {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      StringBuilder str = new StringBuilder(scanner.nextLine()).reverse();
      String[] strs = str.toString().split(" ");
      StringBuilder sb = new StringBuilder();
      for (int i = 0 ; i< strs.length;i++) {
        sb.append(new StringBuilder(strs[i]).reverse()).append(" ");
      }
      System.out.println(sb.toString().trim());
    }
  }
}
