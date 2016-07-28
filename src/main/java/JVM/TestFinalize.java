package JVM;

class Car {
  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    System.out.println("Invoke");
  }

  @Override
  public String toString() {
    return "Car";
  }
}

public class TestFinalize {
  public static void main(String[] args) {
    while (true) {
      Car car = new Car();
    }
  }
}
