package BasicJava.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Keep the order of data you had inserted into.
 */
public class LinkedHashMapTest {
  public static void main(String[] args) {
    LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
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
}
