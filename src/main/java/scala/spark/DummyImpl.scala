package scala.spark

import com.github.stuxuhai.jpinyin.{PinyinHelper, PinyinFormat}
import org.apache.spark.sql.catalyst.expressions.ScalaUdf
import org.apache.spark.sql.{Row, DataFrame}
import org.apache.spark.sql.functions._
import com.ctrip.ml.DiArguments._
import com.ctrip.ml.tools.Metadata
import org.apache.spark.sql.types.{ByteType}
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Created by zhangminglei on 2016/3/13.
  * mingleizhang@ctrip.com
  */
class DummyImpl extends Metadata {

  /**
    *
    * @param originalTable the table which do dummy, usually was a hive table
    * @param metadataTable the table derived from originalTable, usually was a hive table too
    * @param rate condition for filter dummy variable
    * @param columnName specific columns which will map category variable to dummy variable. Note that these columns include in originalTable
    *
    *                   For example if you just one column make dummy, Code like : `create_dummy(table_name, table_name_, 5, people)`
    *
    *                   Otherwise [[ more than one column make dummy ]]
    *                   ` val arr = Array("peopel, age, sex") `
    *                   ` create_dummy(table_name, table_name_, 5, arr) `
    */
  def create_dummy(originalTable: String, metadataTable: String, rate: Double, columnName: Array[String]): (DataFrame, ArrayBuffer[String]) = {
    if (originalTable == null || metadataTable == null)
      throw new NullPointerException("originalTable or metadataTable is null")
    if (rate < 0 || columnName.length == 0)
      throw new IllegalArgumentException("rate = " + rate)
    val number = 100
    val recordTopN = 10
    val df_originTable = sqlContext.sql("select * from " + originalTable).toDF
    val strSQL: String = "select " + " top_1," + " top_2," + " top_3," + " top_4," + " top_5," + " top_6," + " top_7," + " top_8," + " top_9," + " top_10," +
      " top1_ratio," + " top2_ratio," + " top3_ratio," + " top4_ratio," + " top5_ratio," + " top6_ratio," + " top7_ratio," + " top8_ratio," + " top9_ratio," +
      " top10_ratio" + " from " + metadataTable
    val colnameData = sqlContext.sql("select colname" + " from " + metadataTable).collect
    val metadata = sqlContext.sql(strSQL).toDF().collect
    val trans_n_rate: Double = rate / number
    val top10_and_radio = new Array[mutable.HashMap[String, Double]](columnName.length)
    // Don't worry, Although there are three for loop, but the time complexity of amortized analysis is perfect. Cause every loop's constant factor is very very small.
    for (j <- columnName.indices) {
      top10_and_radio(j) = new mutable.HashMap[String, Double]
      for (k <- colnameData.indices) {
        for (i <- 0 until recordTopN if metadata(k)(i + recordTopN).toString.toDouble >= trans_n_rate) {
          if (columnName(j).equals(colnameData(k)(0))) {
            top10_and_radio(j).put(metadata(k)(i).toString, metadata(k)(i + recordTopN).toString.toDouble)
          }
        }
      }
    }
    // record data from different column in case of cross-footing
    val array = new Array[Array[String]](columnName.length)
    for (i <- top10_and_radio.indices) {
      val iter = top10_and_radio(i).keysIterator
      array(i) = new Array[String](top10_and_radio(i).size)
      var j = 0
      while (iter.hasNext) {
        array(i)(j) = iter.next(); j += 1
      }
    }
    val judgeChinese: (String => Boolean) = (str: String) => {
      if (!((str(0) >= 'A' && str(0) <= 'Z') || (str(0) >= 'a' && str(0) <= 'z'))) true else false
    }
    val index: (Any => (Any => Byte)) = (value: Any) => {
      (a: Any) =>
        if (value.equals(a) || value == a)
          1
        else
          0
    }
    val transChinese: (String => String) = (str: String) => {
      if (judgeChinese(str)) PinyinHelper.convertToPinyinString(str, "", PinyinFormat.WITHOUT_TONE) else str
    }
    var temp = df_originTable
    val dummyColList = ArrayBuffer[String]()
    for (i <- array.indices; j <- array(i).indices) {
      val dummyColumnName = columnName(i) + "_" + transChinese(array(i)(j))
      dummyColList += dummyColumnName
      temp = temp.withColumn(dummyColumnName, callUDF(index(array(i)(j)), ByteType, df_originTable(columnName(i))))
      temp.show()
    }
    (temp, dummyColList)
  }
}