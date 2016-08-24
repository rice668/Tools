package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/24.
 * http://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&tqId=21228&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */
public class HexConverter {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    while (sc.hasNext()) {
      String str=sc.nextLine().substring(2);
      System.out.println(Integer.parseInt(str,16));
    }
  }
}
