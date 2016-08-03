package OJ;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 6174黑洞数字
 */
public class Main {

  static int increase(Integer num) {
    String str = num.toString();
    char[] ch = str.toCharArray();
    int[] arr = new int[ch.length];
    for (int i = 0; i < ch.length; i++) {
      arr[i] = ch[i];
    }
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      ch[i] = (char) arr[i];
    }
    str = new String(ch);
    return Integer.parseInt(str);
  }

  static int decrease(Integer num) {
    String str = num.toString();
    char[] ch = str.toCharArray();
    int[] arr = new int[ch.length];
    for (int i = 0; i < ch.length; i++) {
      arr[i] = ch[i];
    }
    Arrays.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      ch[i] = (char) arr[i];
    }
    str = new String(ch);
    StringBuilder sb = new StringBuilder(str);
    return Integer.parseInt(sb.reverse().toString());
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedInputStream(System.in));
    int inputNumber = scanner.nextInt();
    if (decrease(inputNumber) == increase(inputNumber)) {
      System.out.println("N-N = 0000");
      System.exit(0);
    }
    int a = decrease(inputNumber);
    int b = increase(inputNumber);
    int temp = a - b;
    while ((temp) != 6174) {
      System.out.println(a + "-" + b + "=" + (temp));
      a = decrease(temp);
      b = increase(temp);
      temp = a - b;
    }
    System.out.println(a + "-" + b + "=" + (temp));
  }
}
