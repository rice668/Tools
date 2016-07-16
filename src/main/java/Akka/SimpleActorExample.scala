package Akka

import akka.actor.{Props, ActorSystem, Actor}

/**
  * Created by root on 16-7-16.
  */
object SimpleActorExample extends App {
  class SimpleActor extends Actor {
    def receive = {
      case s:String => println(s)
      case i:Int => println(i)
    }

    def foo = println("Normal method")
  }
  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props[SimpleActor], "SimpleActor")

  actor ! "Hi Bro."
  actor ! 123

}
