import akka.actor.{ActorRef, ActorSystem}
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.directives.PathDirectives.path
import akka.pattern.ask
import akka.stream.ActorMaterializer
import akka.util.Timeout
import Operations._
import org.slf4j.LoggerFactory
import actors._
import scala.concurrent.duration._

object Boot extends App with JsonSupport{
  val log = LoggerFactory.getLogger("Boot")
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(30.seconds)

  val banks = scala.collection.mutable.Map[Int, ActorRef]()
  val bankService = system.actorOf(BankService.props(10101001))
  val bank = system.actorOf(BankAccount.props(banks, bankService))

  val route ={
    pathPrefix("bank") {
      (path("create") & post) {
        entity(as[CreateBankAccount]) {createBankAccount =>
          complete{
            (bank ? createBankAccount).mapTo[ReplyFromBank]
          }
        }
      } ~ (path("update") & put){
        entity(as[UpdateBankAccount]) {updateBankAccount =>
          complete{
            (bank ? updateBankAccount).mapTo[ReplyFromBank]
          }
      }
    } ~ (path("get") & get ){
        entity(as[GetBankAccount]) {getBankAccount =>
          complete{
            (bank ? GetBankAccount).mapTo[ReplyFromBank]
          }
        }
      } ~ (path("delete") & delete) {
        entity(as[DeleteBankAccount]){deleteBankAccount =>
          complete{
            (bank ? DeleteBankAccount).mapTo[ReplyFromBank]
          }
        }
      } ~ (path("addmoney") & put){

        entity(as[AddMoneyToBankAccount]){addMoneyToBankAccount =>
          complete{
            (bank ? AddMoneyToBankAccount).mapTo[ReplyFromBank]
          }
        }
      } ~ (path("getmoney") & put){
        entity(as[GetMoneyFromBank]){getMoneyFromBank =>
          complete{
            (bank ? GetBankAccount).mapTo[ReplyFromBank]
          }
        }
      } ~ (path("bankinfo") & get) {
        entity(as[GetBankInfo]){ getBankInfo =>
          complete{
            (bank ? getBankInfo).mapTo[ReplyFromBank]
          }
        }
      }
    }
  }


  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
  log.info("Listening on port 8080...")




}