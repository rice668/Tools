package BasicJava.Reflection_IOC_AOP;

/**
 * Created by root on 16-7-23.
 */
public class Car {

  static {
    System.out.println("Hello==================");
  }

  private String brand;
  private String color;
  private int maxSpeed;


  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public Car(){}

  public Car(String brand,String color,int maxSpeed){
    this.brand = brand;
    this.color = color;
    this.maxSpeed = maxSpeed;
  }

  public void introduce() {
    System.out.println(toString());
  }

  @Override
  public String toString() {
    return "Car{" +
            "brand='" + brand + '\'' +
            ", color='" + color + '\'' +
            ", maxSpeed=" + maxSpeed +
            '}';
  }

  public static void main(String[] args) {
    Car car = new Car();
    car.introduce();

  }

}
