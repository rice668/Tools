package scala

/**
  * Created by root on 16-3-17.
  */
object SystemInfoTime extends App {
  val startTime = System.nanoTime

  Thread.sleep(30000)

  println((System.nanoTime - startTime) / 1e9 + " s" )
}
