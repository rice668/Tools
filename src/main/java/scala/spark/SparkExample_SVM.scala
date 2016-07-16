package scala.spark

import org.apache.spark.{SparkConf, SparkContext}

import org.apache.spark.sql.SQLContext
import org.apache.spark.ml.classification.LogisticRegression

/**
  * Just for testing......
  */
object SparkExample_SVM extends App {
  val conf = new SparkConf().setMaster("local[8]").setAppName("LogisticRegressionWithElasticNetExample")
  val sc = new SparkContext(conf)
  val sqlCtx = new SQLContext(sc)
  // $example on$
  // Load training data
  val training = sqlCtx.read.format("libsvm").load("/root/Tools/src/main/java/scala/original_data/sample_libsvm_data.txt")

  val lr = new LogisticRegression()
    .setMaxIter(10)
    .setRegParam(0.01)
    .setElasticNetParam(1)

  // Fit the model
  val lrModel = lr.fit(training)

  // Print the coefficients and intercept for logistic regression
  println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")
  // $example off$

  sc.stop()

}