package BasicJava.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by root on 16-7-12.
 */
public class TestMapEntry {

  /**
   * old method
   */
  static void accessMapByMethod1() {
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("1", "one");
    map.put("2", "Two");
    map.put("3", "Three");
    Set keys = map.keySet();
    if (null != keys) {
      Iterator iterator = keys.iterator();
      while (iterator.hasNext()) {
        String str = (String) iterator.next(); // 向下造型, 因为你不能说机器是空调
        String value = map.get(str);
        System.out.println(value);
      }
    }
  }

  /**
   * Below method is better than the upside method.
   */
  static void accessMapByMethod2() {
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("1", "one");
    map.put("2", "Two");
    map.put("3", "Three");
    map.put("4", "Four");
    map.put("Six", "Fuck you");
    map.put("5", "Five");
    map.put("6", "Six");
    map.put("Bitch", "Retarded");
    map.put("7", "Seven");
    for (Map.Entry<String, String> entry : map.entrySet()) {
      String keys = entry.getKey();
      String value = entry.getValue();
      System.out.println(value);
    }
  }

  public static void main(String[] args) {
    TestMapEntry.accessMapByMethod2();
  }
}
