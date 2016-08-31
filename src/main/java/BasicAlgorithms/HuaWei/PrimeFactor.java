package BasicAlgorithms.HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/24.
 * http://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607?tpId=37&tqId=21229&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 蘑菇鸡面试题
 */
public class PrimeFactor {

  public static List<Integer> Fenjie(long num) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 2; i <= num; ) {
      if (num % i == 0) {
        num = num / i;
        list.add(i);
      } else {
        i++;
      }
    }
    return list;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      long params = sc.nextLong();
      List result = Fenjie(params);
      for (int i = 0; i < result.size(); i++) {
        System.out.print(result.get(i) + " "); // 必须写在一个行上才可以通过
      }
    }
  }
}
