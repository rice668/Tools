package BasicAlgorithms.HuaWei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by mingleizhang on 2016/8/25.
 * http://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&tqId=21231&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 注意，此题目要求输出的结果按照Key进行排序，用TreeMap
 */
public class MergeTableRecord {

  /**
   * 网友的解答
   */
  void solveByNetFriend() {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        int s=sc.nextInt();
        int value=sc.nextInt();
        if (map.containsKey(s)) {
          map.put(s, map.get(s) + value);
        } else
          map.put(s, value);
      }
      for (Integer key : map.keySet()) {
        System.out.println(key + " " + map.get(key));
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      TreeMap<Integer, Integer> hashMap = new TreeMap<Integer, Integer>(); // 记住这个在里面，不要放到while循环的外面
      int count = Integer.parseInt(scanner.nextLine());
      for (int i = 0; i < count; i++) {
        String[] strings = scanner.nextLine().split(" ");
        if (hashMap.containsKey(Integer.parseInt(strings[0]))) {
          hashMap.put(Integer.parseInt(strings[0]), hashMap.get(Integer.parseInt(strings[0])) + Integer.parseInt(strings[1]));
        } else {
          hashMap.put(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
        }
      }
      for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
        Integer keys = entry.getKey();
        Integer value = entry.getValue();
        System.out.println(keys + " " + value);
      }
    }
  }
}






























