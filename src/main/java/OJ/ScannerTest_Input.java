package OJ;

import java.util.Scanner;

/**
 * OJ的输入格式，3种
 */
public class ScannerTest_Input {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
//    // 预先不知道输入数据的组数
//    while (scanner.hasNext()) {
//      int a = scanner.nextInt();
//      int b = scanner.nextInt();
//      System.out.println(a + b);
//    }

    // 预先知道数组的组数
    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      System.out.println(a+b);
    }
      // 只有一组数据
//    String str1 = scanner.next();
//    String str2 = scanner.next();
//    System.out.println(str1 + str2);

  }
}
