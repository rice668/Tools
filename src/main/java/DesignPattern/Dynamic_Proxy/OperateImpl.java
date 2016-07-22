package DesignPattern.Dynamic_Proxy;

/**
 * Created by root on 16-7-22.
 * 这是一个委托类,实现Operate接口。每个函数简单输出字符串，并等待一段时间。
 * 动态代理要求委托类必须实现了某个接口，比如这里委托类OperateImpl实现了Operate，原因会后续在微博公布。
 */
public class OperateImpl implements Operate {

  // 这个函数的执行时间就是睡眠时间
  public void operateMethod1() {
//    System.out.println("Invoke operateMethod1");
    sleep(110);
  }

  public void operateMethod2() {
//    System.out.println("Invoke operateMethod2");
    sleep(120);
  }

  public void operateMethod3() {
//    System.out.println("Invoke operateMethod3");
    sleep(130);
  }

  private static void sleep(long millSeconds) {
    try {
      Thread.sleep(millSeconds);
    } catch (InterruptedException e) {
      e.getMessage();
    }
  }
}
