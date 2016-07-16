package scala

import java.util.Random

import scala.spark.MySparkContext

/**
  * Created by root on 16-3-14.
  */
object FlatMap_Example extends App with MySparkContext {
  //  val li = List(1, 2, 3)
  //
  //  val res = li.flatMap(x => x match {
  //    case 3 => List(3, 1)
  //    case _ => List(x * 2)
  //  })
  //  print(res)
  //  println()
  //
  //  // As a compare, we give an example of Map.
  //  val res2 = li.map(x => x match {
  //    case 3 => List(3, 1)
  //    case _ => x * 2
  //  })
  //
  //  print(res2)

  val testCol = sc.parallelize(1 to 10).flatMap { p =>
    val random = new Random
    val intArr = new Array[Int](1)
    intArr(0) = random.nextInt()
    intArr
  }.collect.foreach(println)

}
