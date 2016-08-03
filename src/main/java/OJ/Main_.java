package OJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_ {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      if (n < 1 || m > 75) {
        System.exit(0);
      }
      int[][] multiArr = new int[n][m];
      for (int i = 0; i < multiArr[0].length; i++) {
        for (int j = 0; j < multiArr.length; j++) {
          multiArr[i][j] = scanner.nextInt();
        }
      }
      int[] arr = new int[n * m];
      int count = 0;
      for (int i = 0; i < multiArr[0].length; i++) {
        for (int j = 0; j < multiArr.length; j++) {
          arr[count++] = multiArr[i][j];
        }
      }
      Arrays.sort(arr);
      System.out.println(arr[0]);
    }
  }
}
