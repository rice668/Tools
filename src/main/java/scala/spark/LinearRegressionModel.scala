package scala.spark

import org.apache.spark.mllib.linalg.Vector

/**
  * Created by root on 16-7-20.
  */
class LinearRegressionModel(a: Double, b: Double) extends Serializable {
  def predict(testData: Vector): Double = {
    a + testData.toArray(0) * b
  }

  /**
    * predict y from x for missing imputation
    */
  def reversePredict(testData: Vector): Double = {
    (testData.toArray(0) - a) / b
  }
}