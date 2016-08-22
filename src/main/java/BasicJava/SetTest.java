package BasicJava;

import scala.collection.mutable.HashTable;

import java.util.*;

public class SetTest {

  public static void printSet(Set<?> s) {
    for (Object o : s) {
      System.out.println(o);
    }
  }

  public static void main(String[] args) {
    HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList(1, 2, 3));
    printSet(s1);

    HashSet<String> s2 = new HashSet<String>(Arrays.asList("a", "b", "c"));
    printSet(s2);


  }
}
