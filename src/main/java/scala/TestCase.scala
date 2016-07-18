package scala

/**
  * Created by root on 16-7-18.
  */
object TestCase extends App {

  case object One

  case object Two

  case class Address(street: String)

  case class Person(name: String, age: Int, address: Address)

  val alice = Person("Alice", 25, Address("Fuck you, that's why"))
  val max = Person("Max", 21, Address("Fuck me, that's why"))

  for (person <- Seq(alice, max)) {
    person match {
      case Person("Alice", 25, Address("Fuck you, that's why")) => {
        println("Hi, Alice")
      }
      case _ => {
        println("Fuck Nothing!")
      }
    }
  }

}
