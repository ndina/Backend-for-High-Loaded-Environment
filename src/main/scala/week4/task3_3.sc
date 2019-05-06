
//// Linked List
//sealed trait lab.IntList{
// def length: Int = this match{ // this because it is in the base trait
// case lab.End => 0
// case lab.Node(head, tail) => tail.length
// }
//}
//case object lab.End extends lab.IntList
//case class lab.Node(head: Int, tail: lab.IntList) extends lab.IntList
//
//val intList = {
// lab.Node(1, lab.Node(2, lab.Node(3, lab.Node(4, lab.End))))
//}
//
////assert(intList.length == 4)
////assert(intList.tail.length == 3)
////assert(lab.End.length == 0)
//-------------------------------------------------------------------------------------


//
//sealed trait lab.IntList{
// def product: lab.IntList= this match{
// case lab.End => lab.End
// case lab.Node(head, tail) => lab.Node(head *4, tail.product)
//
// }
//}
// case object lab.End extends lab.IntList
// case class lab.Node(head: Int, tail: lab.IntList) extends lab.IntList
//

//---------------------------------------------------------------------------------------


sealed trait IntList{
  def double: lab.IntList = this match {
    case lab.End => lab.End
    case Node(head, tail) => lab.Node(head * 2, tail.double)

  }
}
case object End extends lab.IntList
case class Node(head: Int, tail: lab.IntList) extends lab.IntList


//---------------------------------------------------------------------------------------
//sealed trait lab.IntList{
//def map(f: Int => Int) :lab.IntList = this match{
// case lab.End => lab.End
// case lab.Node(head, tail) => f(x => x * 3)
//}
//}
// case object lab.End extends lab.IntList
// case class lab.Node(head: Int, tail: lab.IntList) extends lab.IntList


//// Linked List
//sealed trait lab.IntList{
//
//  def length(l: Int = 0): Int = this match {
//    case lab.End => l
//    case lab.Node(_, tail) => tail.length(l + 1)
//  }
//
//  def product(p: Int = 1): Int = this match {
//    case lab.End => p
//    case lab.Node(head, tail) => tail.product(p * head)
//  }
//
//  def double: lab.IntList = this match {
//    case lab.End => lab.End
//    case lab.Node(head, tail) => lab.Node(head * 2, tail.double)
//  }
//
//  //BONUS PART
//  def map(f: Int => Int): lab.IntList = this match {
//    case lab.End => lab.End
//    case lab.Node(head, tail) => lab.Node(f(head), tail.map(f))
//  }
//
//}
//case object lab.End extends lab.IntList
//case class lab.Node(head: Int, tail: lab.IntList) extends lab.IntList