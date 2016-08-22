package BasicJava.Reflection_IOC_AOP;

import java.util.Scanner;

/**
 * Created by root on 16-8-16.
 */

class Student<T>{
  void test() {

  }

}

public class Test {
  public static void main(String[] args) throws Exception {
    Student.class.newInstance().test();
    System.out.println();
  }
}
