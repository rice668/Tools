package scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object WordCount_3 extends App with MySparkContext {
  val fold = "/root/Tools/src/main/java/scala/output"
  //  sc.stop() // for trigger the assertNotStopped method
  val lines = sc.textFile("/root/Tools/src/main/java/scala/original_data/metadata.txt", 1).cache()
  println(lines.count())
}