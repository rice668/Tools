package scala

import java.util.Random

import scala.spark.MySparkContext

/**
  * Created by root on 16-3-14.
  */
object FlatMap_Example_1 extends App with MySparkContext {
  val testCol = sc.parallelize(1 to 5).flatMap { p =>
    val arr = new Array[Int](5)
    for (i <- 0 to 4) {
      arr(i) = p
    }
    arr
  }
}
