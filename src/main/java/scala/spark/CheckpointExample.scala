package scala.spark

/**
  * Created by root on 16-3-18.
  */
object CheckpointExample extends App with MySparkContext {

  sc.setCheckpointDir("/root/Tools/src/main/java/scala/checkpoint")
  val data = Array[(Int, Char)](
    (1, 'a'), (2, 'b'),
    (3, 'c'), (4, 'd'),
    (5, 'e'), (3, 'f'),
    (2, 'g'), (1, 'h'))
  val pairs = sc.parallelize(data, 3) // make the data to a RDD
  pairs.checkpoint
  pairs.count
  val result = pairs.groupByKey(2)
  result.foreachWith(i => i)((x, i) => println("[PartitionIndex " + i + "] " + x))

  println(result.toDebugString)

}
