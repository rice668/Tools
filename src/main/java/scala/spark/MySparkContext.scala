package scala.spark

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by root on 16-3-17.
  */
trait MySparkContext {
  val conf = new SparkConf().setAppName("ExampleOfSpark").setMaster("local[8]")
  val sc = new SparkContext(conf)
}
