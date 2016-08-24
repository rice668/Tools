package BasicAlgorithms.String;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/23.
 * 题目描述
 * <p>
 * 写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * <p>
 * 输入描述:
 * 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 * <p>
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 * <p>
 * 输入例子:
 * ABCDEF
 * A
 * 输出例子:
 * 1
 * 测试用例:
 * ABCaD
 * a
 * 对应输出应该为:
 * 2
 */
public class CountCharacter {

  private int getnum(String str, String c) {
    int num = 0;
    int len = str.length();
    str = str.toLowerCase();
    c = c.toLowerCase();
    for (int i = 0; i < len; i++) {
      if (str.charAt(i) == c.charAt(0)) {
        num++;
      }
    }
    return num;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    while (input.hasNextLine()) {
      int result;
      CountCharacter inst = new CountCharacter();
      String sc = input.nextLine();
      String ch = input.nextLine();
      result = inst.getnum(sc, ch);
      System.out.println(result);
    }
  }
}
