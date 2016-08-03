package BasicAlgorithms.String;

import java.util.HashMap;

/**
 * Created by hash-X on 2016/1/3.
 */
public class FirstOccurOnce {

  // BitMap way.
  public static char firstOccurOnceByASCII(String str) {
    double start = System.currentTimeMillis();
    int[] ascii = new int[200];
    char[] chars = str.toCharArray();
    char ch = '*';
    for (int i = 0; i < chars.length; i++) {
      ascii[((int) chars[i])]++;
    }
    for (int i = 0; i < ascii.length; i++) {
      if (ascii[i] == 1) {
        ch = ((char) i);
        break;
      }
    }
    double end = System.currentTimeMillis() - start;
    System.out.println("ASCII:  " + end);
    return ch;
  }

  public static char firstOccurOnceByHashMap(String str) {
    double start = System.currentTimeMillis();
    if (str == null)
      throw new NullPointerException();
    char[] ch = str.toCharArray();
    HashMap hashMap = new HashMap<Character, Integer>();
    for (int i = 0; i < ch.length; i++) {
      if (!hashMap.containsKey(ch[i])) {
        hashMap.put(ch[i], 1);
      } else {
        Integer integer = (Integer) hashMap.get(ch[i]);
        hashMap.put(ch[i], ++integer);
      }
    }
    char ch_1 = '*';
    for (int i = 0; i < ch.length; i++) {
      if ((Integer) hashMap.get(ch[i]) == 1) {
        ch_1 = ch[i];
      }
    }
    double end = System.currentTimeMillis() - start;
    System.out.println("HashMap:  " + end);
    return ch_1;
  }

  public static void main(String[] args) {
    String str = "abaccdeffabaccdeffabaccdeffabaabaccdeffabaccdeffabaccdeffabaabaccdeffabaccdeffabaccdeffaba";
    System.out.println(FirstOccurOnce.firstOccurOnceByASCII(str));
    System.out.println(FirstOccurOnce.firstOccurOnceByHashMap(str));
  }
}