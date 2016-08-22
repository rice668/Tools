package BasicJava.CallBack;

/**
 * From : http://blog.csdn.net/xiaanming/article/details/8703708/#comments
 * 所谓回调：就是A类中调用B类中的某个方法C，然后B类中反过来调用A类中的方法D，D这个方法就叫回调方法
 *
 */
public class Test {

  public static void main(String[] args) {
    /**
     * new 一个小李
     */
    Li li = new Li();

    /**
     * new 一个小王
     */
    Wang wang = new Wang(li);

    /**
     * 小王问小李问题
     */
    wang.askQuestion("1 + 1 = ?");
  }
}
