package BasicAlgorithms.SortAndSearch;

import java.util.*;

/**
 * Created by mingleizhang on 2016/8/23.
 * 注意迭代的情况和poll的情况，记住这是一个动态调整堆的过程
 */

class StudentInfo {
  private String str;
  private int age;
  private int id;
  StudentInfo() {}
  StudentInfo(String str, int age, int id) {
    this.str = str;
    this.age = age;
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "StudentInfo{" +
            "str='" + str + '\'' +
            ", age=" + age +
            ", id=" + id +
            '}';
  }
}

public class OrderByAge {
  public static void main(String[] args) {
    StudentInfo s1 = new StudentInfo("John", 15, 1);
    StudentInfo s2 = new StudentInfo("Sam", 17, 2);
    StudentInfo s3 = new StudentInfo("Max", 23, 8);
    StudentInfo s4 = new StudentInfo("Jack", 12, 9);
    StudentInfo s5 = new StudentInfo("Zap", 17, 3);

    PriorityQueue<StudentInfo> priorityQueue = new PriorityQueue<StudentInfo>(10, new Comparator<StudentInfo>() {
      @Override
      public int compare(StudentInfo s1, StudentInfo s2) {
        return s1.getAge() - s2.getAge();
      }
    });
    priorityQueue.add(s1);
    priorityQueue.add(s2);
    priorityQueue.add(s3);
    priorityQueue.add(s4);
    priorityQueue.add(s5);

    /**
     * 这样的结果和下面的结果是不同的，因为迭代的话输出的是最初的堆的元素；而采用poll，会动态的调整堆里面的元素。
     */
    Iterator<StudentInfo> iterator = priorityQueue.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next().toString());
    }

    System.out.println("------------");

    System.out.println(priorityQueue.poll().toString());
    System.out.println(priorityQueue.poll().toString());
    System.out.println(priorityQueue.poll().toString());
    System.out.println(priorityQueue.poll().toString());
    System.out.println(priorityQueue.poll().toString());
  }
}





















