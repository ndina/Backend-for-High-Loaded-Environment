package actors

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import Operations._

object BankAccount{
  def props(banks: scala.collection.mutable.Map[Int, ActorRef], bankRef:ActorRef):
  Props = Props(new BankAccount(banks, bankRef))
}

class BankAccount(banks: scala.collection.mutable.Map[Int, ActorRef], bankRef:ActorRef) extends Actor with ActorLogging{
  override def receive: Receive = {
    case msg @ CreateBankAccount(id: Int, name: String, money: Int) =>
      log.info(s"Created Bank Account with id: $id")
      val bank = context.actorOf(Bank.props(id, name, money, bankRef))
      banks += id -> bank
      sender() ! ReplyFromBank(s"Bank Account with id $id succesfully created")

    case msg @ UpdateBankAccount(id: Int, name: String) =>
      val bank = banks.get(id)
      val senderRef = sender()
      bank match {
        case Some(actorRef) =>
          actorRef ! UpdateBankAccount(id, name)
          context.become(waitingResponseFromBank(senderRef))
        case None =>
          sender() ! ReplyFromBank(s"Cannot find Bank Account with id $id")
      }

    case msg @ GetBankAccount(id: Int) =>
      log.info(s"Getting info from Bank Account with id $id")
      val bank = banks.get(id)
      val senderRef = sender()
      bank match {
        case Some(actorRef) =>
          actorRef ! GetBankAccount(id)
          context.become(waitingResponseFromBank(senderRef))
        case None =>
          sender() ! ReplyFromBank(s"Cannot find Bank Account with id $id")
      }

    case msg @ DeleteBankAccount(id: Int) =>
      log.info(s"Deleting Bank Account with id $id")
      val bank  = banks.get(id)
      bank match {
        case Some(actorRef) =>
          context.stop(actorRef)
          banks -= id
          sender() ! ReplyFromBank(s"Deleted Bank Account with id $id")
        case None =>
          sender() ! ReplyFromBank(s"Connot find Bank account with id $id")

      }

    case msg @ AddMoneyToBankAccount(bankId:Int, money:Int) =>
      log.info(s"Adding money to Bank Account with id $bankId")
      val bank = banks.get(bankId)
      bank match {
        case Some(actorRef) =>
          actorRef ! AddMoneyToBankAccount(bankId, money)
          context.become(waitingResponseFromBank(sender()))
        case None =>
          sender() ! ReplyFromBank(s"Cannot find Bank Account with id $bankId")
      }

    case msg @ GetMoneyFromBank(bankId: Int, money:Int) =>
      log.info(s"Getting money from Bank Account with id $bankId")
      val bank = banks.get(bankId)
      val senderRef = sender()

      bank match {
        case Some(actorRef) =>
          actorRef ! GetMoneyFromBank(bankId, money)
          context.become(waitingResponseFromBank(senderRef))
        case None =>
          sender() ! ReplyFromBank(s"Cannot get money from Bank accoung with id $bankId")
      }

    case msg @ GetBankInfo(info:String) =>
      bankRef ! GetBankInfo(info)
      context.become(waitingResposeFromBankService(sender()))

  }

  def waitingResponseFromBank(ref: ActorRef): Receive = {
    case msg @ ReplyFromBank(info:String) =>
      log.info("Waiting Response from Bank Account")
      ref ! msg
      context.become(receive)
  }

  def waitingResposeFromBankService(ref: ActorRef): Receive ={
    case msg =>
      log.info("Waiting response from Bank Service")
      ref ! msg
      context.become(receive)
  }
}