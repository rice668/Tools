package BasicJava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangminglei on 2016/8/31.
 */

public class Fenjie {

  public static List<Integer> fenjie(int num) {
    List<Integer> list = new ArrayList<Integer>();
      for (int i = 2; i <= num;) {
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
    List<Integer> list = Fenjie.fenjie(1);
    for (Integer integer : list) {
      System.out.println(integer);
    }
  }
}
