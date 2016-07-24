package scala

import scala.collection.mutable.ArrayBuffer

/**
  * Created by root on 16-1-12.
  * https://leetcode.com/problems/reverse-bits/
  */
object reverseBits extends App {

  /**
    * you need treat n as an unsigned value
    *
    */
  def reverseBits(n: Int): Int = {
    val arrBuffer = ArrayBuffer[Int]()
    var alt_n = n
    while (alt_n > 0) {
      if ((alt_n & 1) == 1){
        arrBuffer.+=(1)
      } else {
        arrBuffer.+=(0)
      }
      alt_n >>= 1
    }
    val newArrBuffer = arrBuffer.reverse
    while (newArrBuffer.length < 32) {
      newArrBuffer.insert(0, 0)
    }
    var count = 0
    for (i <- newArrBuffer.indices) {
      count = count + Math.pow(2, i).toInt*newArrBuffer(i)
    }
    count
  }
  println(reverseBits(964176192))
}