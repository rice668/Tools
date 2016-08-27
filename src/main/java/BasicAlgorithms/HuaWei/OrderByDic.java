package BasicAlgorithms.HuaWei;

import java.util.*;

/**
 * Created by mingleizhang on 2016/8/27.
 * http://www.nowcoder.com/practice/5af18ba2eb45443aa91a11e848aa6723?tpId=37&tqId=21237&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 */
public class OrderByDic {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      int count = Integer.parseInt(scanner.nextLine());
      LinkedList<String> list = new LinkedList<String>();
      for (int i = 0 ; i < count ;i ++) {
        list.add(scanner.nextLine());
      }
      Collections.sort(list, new Comparator<String>() {
        @Override
        public int compare(String str1, String str2) {
          return str1.compareTo(str2);
        }
      });
      for(String s:list)
        System.out.println(s);
    }
  }
}
