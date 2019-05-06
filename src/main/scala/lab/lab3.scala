package lab


// using tail recursion

sealed trait IntList{

  def length(l: Int = 0): Int = this match { // this because it is in the base trait
    case End => l
    case Node(head, tail) => tail.length(l + 1)
  }

  def product(p: Int = 1): Int = this match {
    case End => p
    case Node(head, tail) => tail.product(p * head)
  }

  def double: IntList = this match {
    case End => lab.End
    case Node(head, tail) => Node(head * 2, tail.double)
  }


  def map(f: Int => Int): IntList = this match {   //bonus part 1
    case End => lab.End
    case Node(head, tail) => Node(f(head), tail.map(f))
  }

}
case object End extends IntList
case class Node(head: Int, tail: lab.IntList) extends IntList


object lab3 extends App{

  val intList = Node(1, Node(2, Node(3, Node(4, End))))

  assert(intList.length() == 4)
  assert(intList.tail.length() == 3)
  assert(End.length() == 0)


  assert(intList.product() == 1 * 2 * 3 * 4)
  assert(intList.tail.product() == 2 * 3 * 4)
  assert(End.product() == 1)

  assert(intList.double == Node(1 * 2, Node(2 * 2, Node(3 * 2, Node(4 * 2, End)))))
  assert(intList.tail.double == Node(4, Node(6, Node(8, End))))
  assert(End.double == End)

  assert(intList.map(x => x * 3) == Node(1 * 3, Node(2 * 3, Node(3 * 3, Node(4 * 3, End)))))
  assert(intList.map(x => 5 - x) == Node(5 - 1, Node(5 - 2, Node(5 - 3, Node(5 - 4, End)))))

  println(intList.map(x => x * 3))

}


