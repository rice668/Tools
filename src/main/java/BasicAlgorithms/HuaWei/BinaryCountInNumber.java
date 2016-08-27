package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/27.
 * http://www.nowcoder.com/practice/440f16e490a0404786865e99c6ad91c9?tpId=37&tqId=21238&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * public class Main{
 public static void main(String[] args){
 Scanner scan = new Scanner(System.in);
 int n = scan.nextInt();
 int count = 0;
 while(n>0){
 if((n&1)>0){
 count++;
 }
 n=n>>1;
 }
 System.out.println(count);
 }
 }
 *
 */
public class BinaryCountInNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      int num = scanner.nextInt();
      int result = 0;
      while(num != 0) {
        num = num & (num-1);
        result ++;
      }
      System.out.println(result);
    }
  }
}
