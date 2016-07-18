package Akka

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Not finished!
  */
object SchedulerExample extends App {
  case object Count
  class SchedulerActor extends Actor {
    var n = 0
    def receive = {
      case Count => {
        n += 1
        println(n)
      }
    }

    def foo = println("Normal method")
  }
  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props[SchedulerActor], "Actor")

  actor != Count
  Thread.sleep(2000)
  system.awaitTermination()

}
