package scala.spark

import java.io.File

import org.apache.spark.{SparkConf, SparkContext}

import scala.util.FileUtil

/**
  * Created by root on 16-3-14.
  * With the doc refer to "http://spark.apache.org/docs/latest/submitting-applications.html#master-urls"
  *
  * Further (self-)development
  *
  * Please read the questions and give answers first before looking at the link given.

    Why are there two files under the directory?
    How could you have only one?
    How to filter out words by name?
    How to count words?
  *
  */

object WordCount extends App with MySparkContext {
  val fold = "/root/Tools/src/main/java/scala/output"
  // lines :=
  // zhang li
  // wang wang
  // uu ii uu

  val lines = sc.textFile("/root/Tools/src/main/java/scala/original_data/metadata.txt", 1).cache()

  // string[] := [ zhang,li,wang,wang,uu,ii,uu ]
  val words = lines.flatMap(_.split(",")).filter(!_.equals("ii"))
  println(words.first())
  println("The document have totally " + words.count() + " number of words without ii")

  // during := string[] = [(zhang,1),(wang,1),(wang,1),(uu,1),(ii,1),(uu,1)]
  val during = words.map(w => (w, 1))

  // wc = (li,1)
      //  (uu,2)
      //  (zhang,1)
      //  (wang,2)
  val wc = during.reduceByKey(_ + _)
//  wc.foreach(println)
//  FileUtil.deleteDir(new File(fold))
//  wc.saveAsTextFile("/root/Tools/src/main/java/scala/output")
}
