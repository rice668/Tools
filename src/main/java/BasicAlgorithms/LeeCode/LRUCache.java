package BasicAlgorithms.LeeCode;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhangminglei on 2016/9/4.
 * https://leetcode.com/problems/lru-cache/
 * http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.

   set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
   it should invalidate the least recently used item before inserting a new item.
 */


public class LRUCache {

  private Map<Integer, Integer> map;

  public LRUCache(int capacity) {
    map = new LinkedCappedHashMap<Integer, Integer>(capacity);
  }

  public int get(int key) {
    if(!map.containsKey(key)) {
      return -1;
    }
    return map.get(key);
  }

  public void set(int key, int value) {
    map.put(key,value);
  }

  private static class LinkedCappedHashMap<K,V> extends LinkedHashMap<K,V> {

    int maximumCapacity;

    LinkedCappedHashMap(int maximumCapacity) {
      super(16, 0.75f, true);
      this.maximumCapacity = maximumCapacity;
    }

    protected boolean removeEldestEntry(Map.Entry eldest) {
      return size() > maximumCapacity;
    }
  }
}
