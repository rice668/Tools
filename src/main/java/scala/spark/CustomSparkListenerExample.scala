package scala.spark

import org.apache.spark.{SparkContext, SparkConf}

/**
  * It's a example for developing Custom SparkListener to monitor DAGScheduler
  *
  * Reference to : https://jaceklaskowski.gitbooks.IO/mastering-apache-spark/content/exercises/spark-exercise-custom-scheduler-listener.html
  */

object CustomSparkListenerExample {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("WordCount").setMaster("local[8]")
    val sc = new SparkContext(conf)
    sc.addSparkListener(new CustomSparkListener())
    val lines = sc.textFile("/root/Tools/src/main/java/scala/original_data/metadata.txt", 4).cache()
    println(lines.count())
  }
}
