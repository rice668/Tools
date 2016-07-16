package BasicJava.util;

import java.util.Arrays;

class Student implements Comparable<Student> {

  private String name;
  private int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int compareTo(Student stu) {
    if (stu.getScore() > this.score) {
      return -1;
    } else if (stu.getScore() < this.score) {
      return 1;
    }
    return 0;
  }
}

public class TestArrays {
  public static void main(String[] args) {
    Student[] students = new Student[7];
    Student stu1 = new Student("Tom", 4);
    Student stu2 = new Student("Harry", 1);
    Student stu3 = new Student("Joon", 5);
    Student stu4 = new Student("TYoms", 2);
    Student stu5 = new Student("ASuys", 3);
    Student stu6 = new Student("Jhash", 5);
    Student stu7 = new Student("Opsas", 5);
    students[0] = stu1;
    students[1] = stu2;
    students[2] = stu3;
    students[3] = stu4;
    students[4] = stu5;
    students[5] = stu6;
    students[6] = stu7;
    Arrays.sort(students);
    for (Student stu : students) {
      System.out.println(stu.getName());
    }
  }
}
