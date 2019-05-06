package Operations

import spray.json.RootJsonFormat
import spray.json.DefaultJsonProtocol._

trait JsonSupport {
  implicit val replyFromBankFormat: RootJsonFormat[ReplyFromBank] = jsonFormat1(ReplyFromBank)
  implicit val createBankAccountFormat: RootJsonFormat[CreateBankAccount] = jsonFormat3(CreateBankAccount)
  implicit val updateBankAccountFormat: RootJsonFormat[UpdateBankAccount] = jsonFormat2(UpdateBankAccount)
  implicit val getBankAccountFormat: RootJsonFormat[GetBankAccount] = jsonFormat1(GetBankAccount)
  implicit val deleteBankAccountFormat: RootJsonFormat[DeleteBankAccount] = jsonFormat1(DeleteBankAccount)
  implicit val addMoneyToBankAccountFormat: RootJsonFormat[AddMoneyToBankAccount] = jsonFormat2(AddMoneyToBankAccount)
  implicit val getMoneyFromBankFormat: RootJsonFormat[GetMoneyFromBank] = jsonFormat2(GetMoneyFromBank)
  implicit val getBankInfoFormat: RootJsonFormat[GetBankInfo] = jsonFormat1(GetBankInfo)
}
