package scala

/**
  * Created by root on 16-2-17.
  */

import scala.collection.mutable.ArrayBuffer

/**
  * Created by root on 16-1-12.
  * https://leetcode.com/problems/number-of-1-bits/
  */
object NumberOf_1_Bits extends App {

  // you need to treat n as an unsigned value
  def hummingWeight(n: Int): (Int, ArrayBuffer[Int]) = {
    val arrBuffer = ArrayBuffer[Int]()
    var alt_n = n
    var count = 0
    while (alt_n > 0) {
      if ((alt_n & 1) == 1){
        count+=1
        arrBuffer.+=(1)
      } else {
        arrBuffer.+=(0)
      }
      alt_n >>= 1
    }
    (count, arrBuffer.reverse)
  }
  println (hummingWeight(10))
}