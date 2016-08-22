package BasicJava;

import java.util.Arrays;

/**
 * Created by root on 16-8-18.
 */

class A {
  private String str;

  A(String str) {
    this.str = str;
  }

  public String getStr() {
    return str;
  }
}

public class CopyArray {

  static void swap(A a1, A a2) {
    A temp = a1;
    a1 = a2;
    a2 = temp;
  }

  public static void main(String[] args) {
    A a1 = new A("A1");
    A a2 = new A("A2");
    swap(a1, a2);
    System.out.println(a1.getStr());
  }
}
