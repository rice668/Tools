package scala

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by root on 16-3-17.
  */
object JoinExample extends App {

  val conf = new SparkConf().setAppName("JoinExample").setMaster("local[8]")
  val sc = new SparkContext(conf)

  val kv = (0 to 5) zip Stream.continually(5)
  val kw  = (0 to 5) zip Stream.continually(10)

  val kvR = sc.parallelize(kv)
  val kwR = sc.parallelize(kw)

  val joined = kvR join kwR
  joined.toDebugString

}
