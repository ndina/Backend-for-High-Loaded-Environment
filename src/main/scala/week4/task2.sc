//A calculation may succeed (with an Int result) or fail (with a String message). Implement this.
sealed trait Calculator
case class Success(ret: Int) extends Calculator
case class Fail(ret: String) extends Calculator



//Bottled water has a size (an Int), a source (which is a well, spring, or tap), and a Boolean carbonated. Implement this in Scala.
sealed trait Bottle
case class Size(sz: Int) extends Bottle
sealed trait Source
case object Well extends Source
case object Spring extends Source
case object Tap extends Source
case class Carbonated(car: Boolean) extends Bottle

