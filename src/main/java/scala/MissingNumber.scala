package scala

/**
  * Created by root on 16-1-12.
  * https://leetcode.com/problems/missing-number/
  */
object MissingNumber extends App {
  def missingNumber(nums: Array[Int]): Int = {
    val n = nums.length
    val totalSum = n*(n+1)/2
    totalSum - nums.foldLeft(0)((sum,i) => sum + i) // or foldLeft(0)(_^_)
  }
  println(missingNumber(Array(0,1,2,3,4,5,8,6)))
}