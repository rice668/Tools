package BasicAlgorithms;

/**
  * Created by root on 16-1-12.
  * https://leetcode.com/problems/single-number/
  */

object SingleNumber extends App {

  def singleNumber(nums:Array[Int]): Int = {
    nums.foldLeft[Int](0)(_^_)
  }

  val arr = Array(1,2,2,3,3,4,5,6,6,5,4,1,9)
  println(singleNumber(arr))

}