package BasicJava.util;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {

  /**
   * This code from  org.apache.hadoop.security.NullGroupsMapping
   *
   * if your method (which returns an empty list) is called very often, this approach may
   * even give you slightly better performance both CPU and memory wise.
   *
   * @return an empty list
   */
  public List<String> getGroups(String user) {
    return Collections.emptyList();
  }

  /**
   * Returning new ArrayList<Foo> always creates a new instance of the object so it has a
   * very slight extra cost associated with it which may give you a reason to use
   * Collections.emptyList. I like using emptyList just because it's more readable.
   */
  public List<String> getGroupsByArrayList(String user) {
    return new ArrayList<String>();
  }


  /**
   * Select student score 5 only.
   */
  public static List<Student> select(Student[] stu) {
    for (Student student : stu) {
      if (student.getScore() == 5) {
        return Lists.newArrayList(student);
      }
    }
    return Collections.emptyList();
  }

  public static void main(String[] args) {
    Student[] students = new Student[7];
    Student stu1 = new Student("Tom", 4);
    Student stu2 = new Student("Harry", 1);
    Student stu3 = new Student("Joon", 5);
    students[0] = stu1;
    students[1] = stu2;
    students[2] = stu3;
    List<Student> list = TestCollections.select(students);
    for (Student stu : list) {
      System.out.println(stu.getName());
    }
  }
}
