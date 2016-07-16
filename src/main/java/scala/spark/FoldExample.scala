package scala.spark

/**
  * Created by root on 16-3-22.
  */
object FoldExample extends App with MySparkContext {
  val input = sc.parallelize(List(1, 2, 3, 4))
  val result = input.fold(0) { (x, y) => (x + y) }
  println(result)
}