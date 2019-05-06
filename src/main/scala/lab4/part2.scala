object part2 extends App{

  def calculator(operand1: String, operator: String, operand2: String):Unit = {


    val a1: Option[Int] = if(operand1 matches "\\d+") Some(operand1.toInt) else None
    val a2: Option[Int] = if(operand2 matches "\\d+") Some(operand2.toInt) else None

    def divide(operand1: Option[Int], operand2: Option[Int]): Option[Int] =  {
      operand2 match {
        case Some(0) => return None
      }
      for {
        value1 <- operand1
        value2 <- operand2
      } yield value1 / value2
    }


    val operation= a1 match {
      case Some(a) =>{
        a2 match {
          case Some(b) => {
            operator match {
              case "+" => Some(a + b)
              case "-" => Some(a - b)
              case "*" => Some(a * b)
              case "/" => divide(a1, a2)
            }
          }
          case None => println("There is no way to convert")
        }
      }
      case None =>  None
    }


    operation match {
      case Some(r) => println(r)
      case None => println("Error!")
    }
  }

  calculator("12", "/", "0")
}