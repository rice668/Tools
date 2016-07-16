package scala

import org.apache.spark.ml.Pipeline
import org.apache.spark.sql.SQLContext
import scala.spark.MySparkContext

/**
  * Created by root on 16-3-22.
  */
object PipelineExample extends App with MySparkContext {
  val pipeline = new Pipeline("First Pipeline")
  val sqlContext = new SQLContext(sc)
  val dfRDD = sc.parallelize(0 to 9).map(_ * 1)

}
