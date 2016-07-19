package scala.spark

import com.ctrip.ml.mlib.LinearRegressionModel
import org.apache.spark.sql.DataFrame
import scala.collection.mutable
import org.apache.spark.sql.functions._
import java.lang._
import com.ctrip.ml.launcher.DiArguments._

/**
  * Created by zhangminglei on 2016/3/15.
  * mingleizhang@ctrip.com
  */
class MissingImputation extends Serializable {

  /**
    *
    * @param source the table but with missing value
    * @param modelMap `key` was a tuple contains dv, iv. `value` was a model which predict the missing value using y,a,b
    * @return a table without missing value
    */
  def imputation(source: DataFrame, modelMap: mutable.HashMap[(String, String), LinearRegressionModel]): DataFrame = {
    val predictX: (Double, Double, Double) => Double = (y: Double, a: Double, b: Double) => (y - a) / b
    val iterator = modelMap.keysIterator
    var temp = source
    while (iterator.hasNext) {
      val keyValue = iterator.next()
      val missValueImp: (Double, Double) => Double = (arg1: Double, arg2: Double) =>
        if (arg1 != null && arg2 == null)
          predictX(arg1, modelMap.get((keyValue._1, keyValue._2)).get.a, modelMap.get((keyValue._1, keyValue._2)).get.b)
        else arg2
      val sqlUDF = udf(missValueImp)
      temp = temp.withColumn(keyValue._2 + "_im", sqlUDF(source(keyValue._1), source(keyValue._2)))
    }
    temp
  }

  /**
    *
    * @param tableName  a table already in hive but with missing value
    * @param newTableName a new table in hive without missing value, you must specific a table name for it
    * @param dataPath a text file contains `y = ax + b` from HDFS or a local file system (available on all nodes)
    *
    * About `[dataPath]`
    * dataPath as `hdfs://localhost:9000/data.txt` or `/root/data.txt`
    * see `Configuration.getProperty("fs.defaultFS") get ip `localhost` & port `9000` in hadoop`
    *
    * For more detailed information, see
    * https://github.com/apache/hadoop/blob/trunk/hadoop-common-project/hadoop-common/src/main/java/org/apache/hadoop/conf/Configuration.java
    *
    */
  def getDataSourceFromFSAndSavedAsNewTable(tableName: String, newTableName: String, dataPath: String) = {
    val df = sqlContext.sql("select * from " + tableName)
    val file = sc.textFile(dataPath)
    val dataSource = file.collect()
    val hashMap = new mutable.HashMap[(String, String), LinearRegressionModel]()
    for (i <- dataSource.indices) {
      hashMap.put((dataSource(i).charAt(0).toString, dataSource(i).charAt(2).toString), new LinearRegressionModel(dataSource(i).reverse.charAt(2), dataSource(i).reverse.charAt(0)))
    }
    imputation(df, hashMap).write.saveAsTable(newTableName)
    sqlContext.sql("drop table " + newTableName)
  }
}