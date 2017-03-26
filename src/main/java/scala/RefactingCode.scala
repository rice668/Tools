//package scala
//import scala.C.C
//
//class A {
// val str = null
// val f = (str: String) => {
//    if (str != null) {
//      C.RIGHT
//    } else {
//      C.TOP
//    }
//  }
// val errorType: C = C.parse(f, str)
//}
//
//class B {
//  val str = "123"
//  val f = (str: String) => {
//    if (str.length > 12) {
//      C.TOP
//    } else {
//      C.BOTTOM
//    }
//  }
//  val errorType: C = C.parse(f, str)
//}
//
//class D {
//  val str = "123"
//  val errorType: C = parse(str)
//  def parse(str: String): C = {
//    if (str.length < 1) C.BOTTOM else C.LEFT
//  }
//}
//
//class ReconsitutionD {
//  val str = "123"
//  val f = (str: String) => {
//    if (str.length < 1) C.BOTTOM else C.LEFT
//  }
//  val errorType: C = C.parse(f, str)
//}
//
//object AAA extends App {
//  println(new D().errorType)
//  println(new ReconsitutionD().errorType)
//}