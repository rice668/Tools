package BasicAlgorithms.HuaWei;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/27.
 */
public class ReverseString {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String str = scanner.nextLine();
      System.out.println(new StringBuilder(str).reverse());
    }
  }
}
