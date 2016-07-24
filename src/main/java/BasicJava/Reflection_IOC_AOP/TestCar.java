package BasicJava.Reflection_IOC_AOP;

/**
 * Created by root on 16-7-24.
 */
public class TestCar {

  void test1() throws Exception {
    Class.forName("BasicJava.Reflection_IOC_AOP.Car");
  }

  void test２() throws Exception {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    Class clazz = loader.loadClass("BasicJava.Reflection_IOC_AOP.Car");
  }

  public static void main(String[] args) {
    // test1代码的执行会出触发类的静态代码块
    // test2代码的执行不会触发类的静态代码块
  }
}
