package scala.spark

/**
  * Created by root on 16-3-17.
  */

import java.util.Random

/**
  * Usage: GroupByTest [numMappers] [numKVPairs] [valSize] [numReducers]
  */
object GroupByTest extends MySparkContext {
  def main(args: Array[String]) {
    sc.addSparkListener(new CustomSparkListener())
    val numMappers = 100
    val numKVPairs = 10000
    val valSize = 1000
    val numReducers = 36
    val pairs1 = sc.parallelize(0 until numMappers, numMappers).flatMap { p =>
      val ranGen = new Random
      val arr = new Array[(Int, Array[Byte])](numKVPairs)
      for (i <- 0 until numKVPairs) {
        val byteArr = new Array[Byte](valSize)
        ranGen.nextBytes(byteArr)
        arr(i) = (ranGen.nextInt(Int.MaxValue), byteArr)
      }
      arr
    }.cache
    // Enforce that everything has been calculated and in cache
    println("--------------" + pairs1.count) // That will cause a job to run
    println("--------------" + pairs1.groupByKey(numReducers).count)

    sc.stop()
  }
}