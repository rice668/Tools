package BasicAlgorithms.SortAndSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by mingleizhang on 2016/8/23.
 */
public class CountSameAge {
  public static void main(String[] args) throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D:\\Tools\\src\\main\\java\\BasicAlgorithms\\testfile.txt")));
    bufferedReader.readLine();
    HashMap<Integer, Integer> stuMap = new HashMap<Integer, Integer>();
    StudentInfo[] stu = new StudentInfo[5];
    for (int i = 0; i < 5; i++) {
      String[] str = bufferedReader.readLine().split(" ");
      stu[i] = new StudentInfo(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
      if (stuMap.containsKey(stu[i].getAge())) {
        stuMap.put(stu[i].getAge(), stuMap.get(stu[i].getAge()) + 1);
      } else {
        stuMap.put(stu[i].getAge(), 1);
      }
    }
    Set<Map.Entry<Integer, Integer>> entrySet = stuMap.entrySet();
    Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
    while (iterator.hasNext()) {
      Map.Entry<Integer, Integer> entry = iterator.next();
      System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
  }
}
