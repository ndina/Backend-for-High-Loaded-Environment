import lab.IntList

// Linked List
sealed trait IntList{
  def length(l: Int = 0): Int = this match{ // this because it is in the base trait
    case _root_.End => l
    case Node(head, tail) => tail.length(l + 1)
  }
}
case object End extends Int
case class Node(head: Int, tail: IntList) extends Int

val intList = {
  lab.Node(1, lab.Node(2, lab.Node(3, lab.Node(4, _root_.End))))
}

assert(intList.length == 4)
assert(intList.tail.length == 3)
assert(_root_.End.length == 0)
-------------------------------------------------------------------------------------
//def length(l: Int = 0): Int = this match {
//  case GenericEnd() => l
//  case GenericNode(head, tail) => tail.length(l + 1)
//}

//
//sealed trait lab.IntList{
//  def product: lab.IntList= this match{
//    case lab.End => lab.End
//    case lab.Node(head, tail) => lab.Node(head *4, tail.product)
//
//  }
//}
//  case object lab.End extends lab.IntList
//  case class lab.Node(head: Int, tail: lab.IntList) extends lab.IntList
//

//---------------------------------------------------------------------------------------
//
//
//sealed trait lab.IntList{
//  def double: lab.IntList = this match {
//    case lab.End => lab.End
//    case lab.Node(head, tail) => lab.Node(head * 2, tail.double)
//
//  }
//}
//  case object lab.End extends lab.IntList
//  case class lab.Node(head: Int, tail: lab.IntList) extends lab.IntList
//

//---------------------------------------------------------------------------------------
//sealed trait lab.IntList{
//def map(f: Int => Int) :lab.IntList = this match{
//  case lab.End => lab.End
//  case lab.Node(head, tail) => f(x => x *  3)
//}
//}
//  case object lab.End extends lab.IntList
//  case class lab.Node(head: Int, tail: lab.IntList) extends lab.IntList






