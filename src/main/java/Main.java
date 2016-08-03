

import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner buf = new Scanner(new InputStreamReader(System.in));
    String str;
    HashSet<String> set = new HashSet<String>();
    try {
      str = buf.nextLine();
      while (!"".equals(str)) {
        String splits[] = str.split(" ");
        for (int i = 0; i < splits.length; i++) {
          set.add(splits[i]);
        }
        str = buf.nextLine();
      }
    } catch (Exception e) {
      System.err.println("str: " + e);
    }
    System.out.println(set.size());
  }
}

