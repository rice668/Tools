package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/24.
 * http://www.nowcoder.com/practice/3ab09737afb645cc82c35d56a5ce802a?tpId=37&tqId=21230&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class GetApproximation {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String str = scanner.nextLine();
      char[] ch = str.toCharArray();
      int index = 0;
      for (int i = 0;i < ch.length;i++) {
        if (ch[i] == '.') {
          index = i;
        }
      }
      if ((ch[index + 1]) >= '5') {
        System.out.println(Integer.parseInt(str.substring(0, index)) + 1);
      } else {
        System.out.println(Integer.parseInt(str.substring(0, index)));
      }
    }
  }
}
