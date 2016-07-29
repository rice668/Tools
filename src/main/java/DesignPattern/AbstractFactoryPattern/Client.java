package DesignPattern.AbstractFactoryPattern;

/**
 * http://www.runoob.com/design-pattern/abstract-factory-pattern.html
 */
public class Client {
  public static void main(String[] args) {
    //获取形状工厂
    AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

    Shape shape2 = shapeFactory.getShape("RECTANGLE");
    shape2.draw();

    Shape shape3 = shapeFactory.getShape("SQUARE");
    shape3.draw();

    AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
    Color color1 = colorFactory.getColor("RED");
    color1.fill();

    Color color2 = colorFactory.getColor("Green");
    color2.fill();
  }
}
