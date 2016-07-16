package scala.spark

import org.apache.spark.scheduler.{SparkListenerStageSubmitted, SparkListenerJobStart, SparkListenerStageCompleted, SparkListener}

/**
  * Created by root on 16-3-16.
  */
class CustomSparkListener extends SparkListener {
  override def onJobStart(jobStart: SparkListenerJobStart): Unit = {
    println(s"Start Job --------------- Job started with ${jobStart.stageInfos.size} stages: $jobStart")
  }


  override def onStageSubmitted(stageSubmitted: SparkListenerStageSubmitted): Unit = {
    println(s"Stage Summitted ---------------- ${stageSubmitted.stageInfo.stageId} submitted with ${stageSubmitted.stageInfo.numTasks} tasks.")
  }

  override def onStageCompleted(stageCompleted: SparkListenerStageCompleted): Unit = {
    println(s"Stage Complete-----------Stage ${stageCompleted.stageInfo.stageId} completed with ${stageCompleted.stageInfo.numTasks} tasks.")
  }
}
