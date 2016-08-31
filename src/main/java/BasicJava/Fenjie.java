package BasicJava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangminglei on 2016/8/31.
 */

public class Fenjie {

  public static List<Integer> fenjie(int num) {
    int init = num;
    List<Integer> list = new ArrayList<Integer>();
    if (num == 1) {
      list.add(1);
      return list;
    } else {
      for (int i = 2; i <= num; i++) {
        if (num % i == 0) {
          num = num / i;
          list.add(i);
        }
      }
      int count = 1;
      for (Integer integer : list) {
        count *= integer;
      }
      if (init / count != 1) {
        list.add(init/count);
      }
      return list;
    }
  }

  public static void main(String[] args) {
    List<Integer> list = Fenjie.fenjie(12);
    for (Integer integer : list) {
      System.out.println(integer);
    }
  }
}
