object SockMerchant {

  def findMatch(head: Int, tail: Seq[Int]): Option[Int] = {
    tail.find( x => head == x) match {
      case None => None
      case Some(x) => Some(tail.indexOf(x))
    }
  }

  def countPairs(socks: Seq[Int]): Int = {
    socks match {
      case Seq() => 0
      case head +: Seq() => 0
      case head +: tail => {
        findMatch(head, tail) match {
          case None => countPairs(tail)
          case Some(x) => 1 + countPairs(tail.diff(Seq(tail(x))))
        }
      }
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val cs = for (i <- 0 until n) yield sc.nextInt()

    println(countPairs(cs))
  }

}
