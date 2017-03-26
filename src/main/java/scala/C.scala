package scala

object C extends App {

  implicit def doubleTasasasoHackCodeInt(d: Double): Int = d.toInt

  val x: Int = 34.8
  println(x)

  implicit def toInt(s: String): Int = s.toInt

  val y: Int = "123"

}