package BasicJava.ThreadPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.nowcoder.com/questionTerminal/25deb8d21e7d442e86c90302d6e03133
 *
 * G答案的执行顺序可以是：
 线程一：A、B、C
 线程二：A
 线程一：printAll()，输出A B C A
 线程二：B、C
 线程二：printAll()，输出A B C A B C
 故总得输出为  A B C A A B C A B C
 *
 * 不可能连续出现3个A
 */
public class NameList {
  private List names = new ArrayList();
  public synchronized void add(String name) {
    names.add(name);
  }
  public synchronized void printAll() {
    for (int i = 0; i < names.size(); i++) {
      System.out.print(names.get(i));
    }
  }

  public static void main(String[]args) {
    final NameList sl = new NameList();
    for (int i = 0; i < 2; i++) {
      new Thread() {
        public void run() {
          sl.add("A ");
          sl.add("B ");
          sl.add("C ");
          sl.printAll();
        }
      }.start();
    }
  }
}
