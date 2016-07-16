package scala.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  * One common data flow pattern is MapReduce, as popularized by Hadoop. Spark can implement MapReduce flows easily.
  *
  * Here, we combined the flatMap, map, and reduceByKey transformations to compute the per-word counts in the file
  * as an RDD of (String, Int) pairs.
  */
object SparkExample_2_mapreduce extends App {
  val conf = new SparkConf().setMaster("local[8]").setAppName("1")
  val sc = new SparkContext(conf)
  for (i <- 1 to 100) { // With the iterator times grow, the time consume will smaller and smaller.
    val lines_1 = sc.textFile("/root/Tools/src/main/java/scala/original_data/hello").cache()
    val lines_1_RDD = lines_1.flatMap(lines => lines.split(" ")).map(x => Tuple2(x, 1)).reduceByKey((a, b) => a + b)
    lines_1_RDD.foreach(println)
  }
}