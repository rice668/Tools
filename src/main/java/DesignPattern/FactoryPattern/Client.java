package DesignPattern.FactoryPattern;

/**
 * http://www.runoob.com/design-pattern/factory-pattern.html
 *
 * 工厂模式的好处是，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的
 * 接口来指向新创建的对象。
 *
 */
public class Client {
  public static void main(String[] args) {
    ShapeFactory shapeFactory = new ShapeFactory();
    Shape shape = shapeFactory.getShape("square");
    shape.draw();
  }
}
