package BasicAlgorithms.HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      int temp = scanner.nextInt();
      List<Integer> list = Fenjie.fenjie(temp);
      for (Integer integer : list) {
        System.out.print(integer + " ");
      }
    }
  }
}
