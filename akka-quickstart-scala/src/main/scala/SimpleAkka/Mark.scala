package SimpleAkka

import akka.actor.{Actor, ActorLogging}

object Mark {
  def props() = Props_
}

class Mark extends Actor with ActorLogging{

  case class ReplyToJohn(s:String)
  case class SayGoodByr(s:String)
  def receive = {
    case Greeter()
  }

}
