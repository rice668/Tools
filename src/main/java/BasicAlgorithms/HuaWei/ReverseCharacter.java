package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/27.
 * http://www.nowcoder.com/practice/cc57022cb4194697ac30bcb566aeb47b?tpId=37&tqId=21329&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class ReverseCharacter {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String str = scanner.nextLine();
      System.out.println(new StringBuilder(str).reverse());
    }
  }
}