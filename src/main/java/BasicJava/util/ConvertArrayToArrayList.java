package BasicJava.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * how to convert the following array to an ArrayList
 */
public class ConvertArrayToArrayList {

  public static void main(String[] args) {

    Integer[] array = {new Integer(1), new Integer(2), new Integer(3)};
    ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(array));
    arrayList.add(7);
  }
}
