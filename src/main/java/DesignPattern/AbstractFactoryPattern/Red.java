package DesignPattern.AbstractFactoryPattern;

/**
 * Created by root on 16-7-29.
 */
public class Red implements Color {
  @Override
  public void fill() {
    System.out.println("Inside Red::fill() method.");
  }
}
