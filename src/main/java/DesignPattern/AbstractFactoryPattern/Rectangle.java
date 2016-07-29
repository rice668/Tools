package DesignPattern.AbstractFactoryPattern;

/**
 * Created by root on 16-7-29.
 */
public class Rectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Inside Rectangle::draw() method.");
  }
}
