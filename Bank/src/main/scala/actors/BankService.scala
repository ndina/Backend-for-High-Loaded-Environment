package actors
import akka.actor.{Actor, ActorLogging, Props}
import Operations.{AddMoneyToBankAccount, GetMoneyFromBank, GetBankInfo, ReplyFromBank}

object BankService {
  def props(money: Int):Props = Props(new BankService(money))
}

class BankService(money: Int) extends Actor with ActorLogging{
  override def receive: Receive = {
    case msg @ AddMoneyToBankAccount(bankId:Int, money: Int) =>
      sender() ! ReplyFromBank(s"Added money to Bank Account with id $bankId")
    case msg @ GetMoneyFromBank(bankId: Int, money: Int) =>
      sender() ! ReplyFromBank(s"Getting money from Bank Account with id $bankId")
    case msg @ GetBankInfo(info:String)=>
      sender() ! ReplyFromBank(s"The amount of money in Bank Account with id $money")
  }
}