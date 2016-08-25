package BasicAlgorithms.HuaWei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/24.
 * http://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&tqId=21226&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * 输入例子:
 11
 10
 20
 40
 32
 67
 40
 20
 89
 300
 400
 15

 输出例子:
 10
 15
 20
 32
 40
 67
 89
 300
 400
 *
 */
public class RandomByMingMing {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
      HashSet<Integer> set = new HashSet<Integer>(); // 记住这个在里面，不要放到while循环的外面
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
