package scala.spark

import org.apache.spark.{SparkConf, SparkContext}

object WordCount_2 extends App {
  val fold = "/root/Tools/src/main/java/scala/output"
  val conf = new SparkConf().setAppName("WordCount").setMaster("local[8]")
  val sc = new SparkContext(conf)

  val lines = sc.textFile("/root/Tools/src/main/java/scala/original_data/hello", 1)
  val pairs = lines.flatMap(s => s.split(",")).map(s => Tuple2(s,1))
  val count = pairs.reduceByKey((a, b) => a+b)
  count.sortByKey(false).collect.foreach(println)
}