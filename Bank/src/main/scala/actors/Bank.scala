package actors
import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import Operations._

object Bank {
  def props(id: Int, name: String, money: Int, bankRef: ActorRef):
  Props = Props(new Bank(id, name, money, bankRef))
}

class Bank(id: Int, name: String, money: Int, bankRef: ActorRef) extends Actor with ActorLogging {
  var bankName: String = name

  override def receive: Receive = {
    case msg @ GetBankAccount(id) =>
      sender() ! ReplyFromBank(s"Information about this Bank Account: $id, $bankName, $money")
    case msg @ UpdateBankAccount(id: Int, newName: String) =>
      bankName = newName
      context.parent ! ReplyFromBank(s"Name of Bank Account with id $id changed to $newName")
    case msg @ AddMoneyToBankAccount(bankId: Int, money: Int) =>
      bankRef ! AddMoneyToBankAccount(bankId, money)
      context.become(waitingBankApproval())
    case msg @ GetMoneyFromBank(bankId: Int, money: Int) =>
      bankRef ! GetMoneyFromBank(bankId, money)
      context.become(waitingBankApproval())
  }
  def waitingBankApproval(): Receive ={
    case msg @ ReplyFromBank(info) =>
      context.parent ! msg
      context.become(receive)
  }



}
