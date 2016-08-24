package BasicAlgorithms.HuaWei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/24.
 * http://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&tqId=21226&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class RandomByMingMing {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
      HashSet<Integer> set = new HashSet<Integer>();
      int count = scanner.nextInt();
      for (int i = 0; i < count; i++) {
        set.add(scanner.nextInt());
      }
      ArrayList<Integer> arrayList = new ArrayList<Integer>();
      arrayList.addAll(set); // 集合之间相互转化
      Integer[] arr = new Integer[arrayList.size()];
      Integer[] results = arrayList.toArray(arr);
      Arrays.sort(results);
      for (int i = 0; i < set.size(); i++) {
        System.out.println(results[i]);
      }
    }
  }
}
