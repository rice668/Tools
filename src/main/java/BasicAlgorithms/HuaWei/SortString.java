package BasicAlgorithms.HuaWei;

import java.util.Arrays;

/**
 * Created by mingleizhang on 2016/8/27.
 */
public class SortString {
  public static void main(String[] args) {
    String str = "bcda";
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    System.out.println(new String(chars));
  }
}
