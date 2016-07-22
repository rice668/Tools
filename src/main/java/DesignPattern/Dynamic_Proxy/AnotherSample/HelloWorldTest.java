package DesignPattern.Dynamic_Proxy.AnotherSample;

/**
 * Created by root on 16-7-22.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 本质还是反射
 * 目前Java开发包中包含了对动态代理的支持，但是其实现只支持对接口的的实现。
 * 其实现主要通过java.lang.reflect.Proxy类和java.lang.reflect.InvocationHandler接口。
 * Proxy类主要用来获取动态代理对象，InvocationHandler接口用来约束调用者实现
 * <p/>
 * 以下为模拟案例，通过动态代理实现在方法调用前后向控制台输出两句字符串
 */
public class HelloWorldTest {

  public static void main(String[] args) {

    // new HelloWorldImpl() 是要代理的对象
    InvocationHandler handler = new HelloWorldHandler(new HelloWorldImpl());

    //创建动态代理对象
    HelloWorld proxy = (HelloWorld) Proxy.newProxyInstance(
            HelloWorld.class.getClassLoader(),
            new Class[] {HelloWorld.class},
            handler);
    proxy.sayHelloWorld();
  }
}