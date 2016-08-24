package BasicAlgorithms.String;

import java.util.Scanner;

/**
 * Created by mingleizhang on 2016/8/23.
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入例子:
 * hello world
 * 输出例子:
 * 5
 */
public class LastWordLengthInString {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    String[] strings = str.split(" ");
    System.out.println(strings[strings.length - 1].length());
  }
}
