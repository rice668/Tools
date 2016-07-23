package DesignPattern.Dynamic_Proxy;

import java.lang.reflect.Proxy;

/**
 *
 * 下面通过实例具体介绍，假如现在我们想统计某个类所有函数的执行时间，
 * 传统的方式是在类的每个函数前打点统计，动态代理方式如下(这个是一个挺不错的应用)：
 *
 * 实现动态代理包括三步：
 (1). 新建委托类；
 (2). 实现InvocationHandler接口，这是负责连接【代理类】和【委托类】的中间类必须实现的接口；
 (3). 通过Proxy类新建代理类对象。
 开发者提供了委托类 B，程序动态生成了代理类 A。开发者还需要提供一个实现了InvocationHandler的子类 C，
 子类 C 连接代理类 A 和委托类 B，它是代理类 A 的委托类，委托类 B 的代理类。用户直接调用代理类 A 的对象，
 A 将调用转发给委托类 C，委托类 C 再将调用转发给它的委托类 B。

 动态代理类是在调用Proxy.newProxyInstance(…)函数时生成的。


 */
public class Main {
  public static void main(String[] args) {
    // create proxy instance
    TimingInvocationHandler timingInvocationHandler =
            new TimingInvocationHandler(new OperateImpl());
    // 创建代理实现由Proxy实现
    Operate operate = (Operate)(Proxy.newProxyInstance(
            Operate.class.getClassLoader(),
            new Class[] {Operate.class},
            timingInvocationHandler));

    // 任务的调用转发通过InvocationHandler实现
    operate.operateMethod1();
    operate.operateMethod2();
    operate.operateMethod3();
  }
}