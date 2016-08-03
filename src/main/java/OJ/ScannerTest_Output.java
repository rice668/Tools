package OJ;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.Scanner;

/**
 * OJ的输出格式 1： 不需要输出case数 2：要输出case数 3：每个case之后有空行 4：两个case之间有空行
 */
public class ScannerTest_Output {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedInputStream(System.in));
//    // 1： 不需要输出case数
//    while (scanner.hasNext()) {
//      int a = scanner.nextInt();
//      int b = scanner.nextInt();
//      System.out.println(a + b);
//    }

//    // 2：要输出case数
//    int n = scanner.nextInt();
//    for (int i = 0; i < n; i++) {
//      int a = scanner.nextInt();
//      int b = scanner.nextInt();
//      System.out.println("Case " + (i+1) + " " + (a+b));
//    }

    // 3：每个case之后有空行
    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      System.out.println("Case " + (i+1) + " " + (a+b) + "\n");
      new BufferedOutputStream(System.out).toString();
    }
  }
}
