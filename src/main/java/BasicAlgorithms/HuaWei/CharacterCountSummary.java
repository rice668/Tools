package BasicAlgorithms.HuaWei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/27.
 * http://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&tqId=21233&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class CharacterCountSummary {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      HashSet<Character> hashSet = new HashSet<Character>();
      char[] chs = scanner.nextLine().toCharArray();
      for (int i = 0; i < chs.length;i++) {
        hashSet.add(chs[i]);
      }
      int count = 0;
      for (Character ch : hashSet) {
        if ((int)ch >= 0 && (int)ch <= 127) {
          count ++;
        }
      }
      System.out.println(count);
    }
  }
}
