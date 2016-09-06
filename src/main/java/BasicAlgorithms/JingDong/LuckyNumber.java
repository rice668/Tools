package BasicAlgorithms.JingDong;

import java.util.Scanner;

/**
 * Created by zhangminglei on 2016/9/5.
 */
public class LuckyNumber {

  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    while (cin.hasNextInt()) {
      int temp = 0;
      int count = cin.nextInt();
      int[] arr = new int[count];
      for (int i = 0; i < count; i++) {
        int numbers = cin.nextInt();
        arr[i] = numbers;
      }
      for (int j = 0; j < arr.length; j++) {
        int num = arr[j];
        for (int k = 1; k <= num; k++) {
          if (gn(k) == fn(k)) {
            temp++;
          }
        }
        System.out.println(temp);
        temp = 0;
      }
    }
  }
  static int fn(int num) {
    int count = 0;
    char[] chs = String.valueOf(num).toCharArray();
    for (int i = 0; i < chs.length; i++) {
      count += ((int) chs[i] - 48);
    }
    return count;
  }

  static int gn(int num) {
    int result = 0;
    while (num != 0) {
      num = num & (num - 1);
      result++;
    }
    return result;
  }
}
