package scala.spark

/**
  * find the line with the most words.
  */
object SparkExample extends App with MySparkContext {

  val lines_1 = sc.textFile("/root/Downloads/Match")
    .map(lines => lines.split(" ").size)
    .reduce((a, b) => Math.max(a, b))

  println("************" + lines_1)
}