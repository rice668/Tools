package scala

/**
  * Created by root on 16-3-26.
  */
object DebugExample extends App {
  var s = 0
  for (j <- 1 to 100) {
    s += j
  }
  println(s)
}
