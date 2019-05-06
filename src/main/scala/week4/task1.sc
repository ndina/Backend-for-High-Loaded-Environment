import java.awt.Rectangle

sealed trait Shape{
  def sides: Int
  def perimeter():Double
  def area(): Double
}

// make Shape a sealed trait. Then write a singleton object called Draw with an apply method that takes a Shape as
// an argument and returns a description of it on the console
object Draw {
  def apply(sh: Shape) = sh match {
    case Rectangle(w, h) => s"A rectangle of width ${w} and height ${h}"
    case Circle(rad) => s"A circle of radius ${rad}"
    case Square(a) => s"A square of side ${a}"
  }
}
sealed trait Rectangular extends Shape {
//  def area(w: A, h: A): Doubletyp
  def w: Double
  def h: Double
  val sides = 4

  override def perimeter(): Double = 2 * (w + h)

  override def area(): Double = w * h

}


case class Circle(rad: Double) extends Shape{
  override def area(): Double = math.Pi * rad * rad

  override def perimeter(): Double = 2 * math.Pi * rad

  override def sides: Int = 1

}

case class Rectangle(val w: Double, val h: Double) extends Rectangular // if we don't write case {case Rectangle in Draw will not work}
//{
//  override def area(): Double = w * h
//
////  override def perimeter(): Double = 2 * (w + h)
////
////  override def sides: Int = 4

//}

case class Square(a: Double) extends Rectangular {
  val w = a
  val h = a
}
//{
//  override def area(): Double = a * a
//
//  override def perimeter(): Double = 4 * a
//
//  override def sides: Int = 4
//
//}




