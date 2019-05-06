package week4

object Boot {
  def main(args: Array[String]): Unit ={
    println(5 + 5);


    // case class can take arguments so each instance of that class can be different based on the values of its arguments;
    sealed trait Traffic;
    case object Red extends Traffic; // doesn't take arguments, so there might be only one instance of class
    case object Green extends Traffic;
    case object Yellow extends Traffic;


     //Functions which call themselves as their last action are called tail-recursive.

    def sumRecursive(n: Int) : Int = n match {
      case 0 => 0
      case k: Int => k + sumRecursive(k-1)

    }

    println(s"Sum is ${sumRecursive(5)}")

    def tailRecursive(n: Int, acc: Int): Int = n match {
      case 0 => acc
      case k:Int => acc + tailRecursive((k - 1), (acc + k))
    }

    println(s"Sum of tail recursive is ${tailRecursive(5, 0)}") // ???

    val seq: Seq[Int] = Seq(1,2,3,4,5,6,7,8,9)

    seq.foreach(number => print(" " + number))
    seq.foreach(println(_))

    val cube = seq.map(number => number * number * number)

    cube.map(println)

    








  }

}
