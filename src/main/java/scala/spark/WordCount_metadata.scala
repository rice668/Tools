package scala.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
  *
  */

object WordCount_metadata extends App {
  val conf = new SparkConf().setAppName("WordCount").setMaster("local[8]")
  val sc = new SparkContext(conf)

  val lines = sc.textFile("/root/Tools/src/main/java/scala/original_data/metadata.txt")

  // if you don't write this line of code, it will calculate by every character.
  val newLines = lines.map(x => x.split(","))

  val totalNumber = newLines.map(x => x.length)
  val numberOfWords = totalNumber.reduce((a, b) => a + b)
  println("*********" + numberOfWords)
}
