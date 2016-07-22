package DesignPattern.Dynamic_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by root on 16-7-22.
 */
public class TimingInvocationHandler implements InvocationHandler {

  private Object target;

  public TimingInvocationHandler(Object target) {
    this.target = target;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    long start = System.currentTimeMillis();
    Object obj = method.invoke(target, args);
    System.out.println(method.getName() + " cost time is:" + (System.currentTimeMillis() - start));
    return obj;
  }
}
