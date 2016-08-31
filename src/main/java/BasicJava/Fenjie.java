package BasicJava;

import java.util.ArrayList;

/**
 * Created by zhangminglei on 2016/8/31.
 */

public class Fenjie {

  public static ArrayList<Integer> fenjie(int num) {
    int init = num;
    ArrayList<Integer> list = new ArrayList<Integer>();
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

  public static void main(String[] args) {
    ArrayList<Integer> list = Fenjie.fenjie(15);
    for (Integer integer : list) {
      System.out.println(integer);
    }
  }
}
