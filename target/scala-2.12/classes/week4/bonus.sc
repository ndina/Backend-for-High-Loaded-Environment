
// Linked List
sealed trait IntList
case object End extends lab.IntList
case class Node(head: Int, tail: lab.IntList) extends lab.IntList