package scala

/**
  * Created by root on 15-12-5.
  */
object BasicGrammer {

  // calculate x square, anonymous functions,
  (x:Int) => x*x
  (x:Int, y:Int) => x + y

  // Define function you want, and apply it
  def power(x:Int):Int = {if (x == 0) 1 else 2*power(x-1)}
  def id(x:Int):Int = x
  def square(x:Int):Int = x * x

  // calculate sum function f(x) = anything you want, start with a, end with b
  // high-order function, incredible, wonderful
  def sum(f:(Int)=>Int, a:Int, b:Int):Int = {
    if (a > b) 0 else f(a) + sum(f, a + 1, b)
  }

  def sumPowersOfTwo(a:Int, b:Int):Int = sum(power, a, b)
  def sumInts(a:Int, b:Int):Int = sum(id, a, b)
  def sumsquare(a:Int, b:Int):Int = sum(square, a, b)

  def main(args: Array[String]): Unit = {
    //    println(sumPowersOfTwo(1,3))
    //    println(sumInts(1,3))
    //    println(sumsquare(1,3))
    val a: Char = 'z' // if 65536, will wrong
    val b: Byte = 'z' // if 128, will wrong
    println(a)
    println(b)
  }
}