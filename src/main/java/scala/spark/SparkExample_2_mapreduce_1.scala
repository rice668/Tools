package scala.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * total length for a text
  */
object SparkExample_2_mapreduce_1 extends App with MySparkContext {
  //  lines is merely a pointer to the file.
  val lines = sc.textFile("/root/Tools/src/main/java/scala/original_data/hello")

  // lineLength is not immediately computed, due to laziness.
  val lineLength = lines.map(x => x.length)

  // reduce is an action.
  val totalLength = lineLength.reduce((a, b) => a + b)
  println(totalLength)

}