package BasicJava;

/**
 * Created by root on 16-7-20.
 * http://stackoverflow.com/questions/1913098/what-is-the-difference-between-an-interface-and-abstract-class
 */

/**
 * I say all motor vehicles should look like this
 * An interface is a contract: the guy writing the interface says,
 * "hey, I accept things looking that way", and the guy using the
 * interface says "Ok, the class I write looks that way".An interface
 * is an empty shell, there are only the signatures of the methods, which
 * implies that the methods do not have a body. The interface can't do anything. It's just a pattern.
 */
interface MotorVehicle {
  void run();

  int getFuel();
}

// my team mate complies and writes vehicle looking that way
class Car implements MotorVehicle {

  int fuel;

  public void run() {
    System.out.println("Wrroooooooom");
  }


  public int getFuel() {
    return this.fuel;
  }
}

//**********************************

/**
 * They have something more : you can define a behavior for them. It's more
 * about a guy saying, "these classes should look like that, and they have
 * that in common, so fill in the blanks!".
 */
// I say all motor vehicles should look like this :　// 机动车
abstract class MotorVehicle_ {

  int fuel;

  // they ALL have fuel, so why not let others implement this?
  // let's make it for everybody
  int getFuel() {
    return this.fuel;
  }

  // that can be very different, force them to provide their
  // implementation
  abstract void run();
}

// my team mate complies and writes vehicle looking that way
class Car_ extends MotorVehicle_ {
  void run() {
    System.out.println("Wrroooooooom");
  }
}

public class Interface_AbstructClass_Diff {

}
