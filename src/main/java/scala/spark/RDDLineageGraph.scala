package scala.spark

/**
  * Created by root on 16-3-17.
  * https://jaceklaskowski.gitbooks.IO/mastering-apache-spark/content/spark-rdd.html#lineage
  * RDD Lineage Graph
  */
object RDDLineageGraph extends App with MySparkContext{

  val r00 = sc.parallelize(0 to 9)
  val r01 = sc.parallelize(0 to 90 by 10)
  val r10 = r00 cartesian r01
  val r11 = r00.map(n => (n, n))

  val r12 = r00 zip r01
  r12.collect().foreach(println)

  // def keyBy[K](f: T => K): RDD[(K, T)]
  val r13 = r01.keyBy(_ / 20)
  r13.collect().foreach(println)

  val r20 = Seq(r11, r12, r13).foldLeft(r10)(_ union _)
  r20.collect().foreach(println)


}
