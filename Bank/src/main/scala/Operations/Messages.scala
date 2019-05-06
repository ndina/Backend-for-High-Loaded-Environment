package Operations


case class CreateBankAccount(id: Int, name: String, money: Int )
case class UpdateBankAccount(id: Int, name: String)
case class GetBankAccount(id: Int)
case class DeleteBankAccount(id: Int)
case class AddMoneyToBankAccount(bankId: Int, money: Int)
case class GetMoneyFromBank(bankId: Int, money: Int)
case class GetBankInfo(info:String)
case class ReplyFromBank(info: String)