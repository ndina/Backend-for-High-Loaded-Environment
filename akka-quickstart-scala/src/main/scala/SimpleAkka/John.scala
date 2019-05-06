package SimpleAkka

import akka.actor.{Actor, ActorLogging}

class John extends Actor with ActorLogging{
  case class Greeter(s: String)
  case class SayingBuy(s: String)

  def receive = {
    case Greeter(s) =>
      log.info("Accepted message!")
      sender() ! ???


  }

}
