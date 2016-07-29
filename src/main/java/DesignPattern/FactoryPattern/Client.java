package DesignPattern.FactoryPattern;

/**
 * http://www.runoob.com/design-pattern/factory-pattern.html
 */
public class Client {
  public static void main(String[] args) {
    ShapeFactory shapeFactory = new ShapeFactory();
    Shape shape = shapeFactory.getShape("square");
    shape.draw();
  }
}
