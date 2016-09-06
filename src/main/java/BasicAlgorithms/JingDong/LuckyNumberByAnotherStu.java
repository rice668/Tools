package BasicAlgorithms.JingDong;

import java.util.Scanner;

/**
 * Created by zhangminglei on 2016/9/6.
 */

public class LuckyNumberByAnotherStu {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    int[] arr = new int[a];
    for (int i = 0; i < a; i++) {
      arr[i] = s.nextInt();
    }

    for (int k = 0; k < arr.length; k++) {
      int num = 0;
      for (int j = 1; j <= arr[k]; j++) {
        int d = 0;
        d = countOne(j);
        int c = j / 100 + (j % 100) / 10 + j % 10;
        if (c == d) {
          num++;
        }
      }
      System.out.println(num);
    }
  }

  public static int countOne(int n) {
    int count = 0;
    while (n > 0) {
      if (n != 0) {
        n = n & (n - 1);
        count++;
      }
    }
    return count;
  }

}

