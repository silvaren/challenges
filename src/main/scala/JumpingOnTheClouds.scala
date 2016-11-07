object JumpingOnTheClouds {

  def countJumps(cs: IndexedSeq[Int]): Int = {
    cs match {
      case IndexedSeq() => 0
      case curr +: IndexedSeq() => 0
      case curr +: next +: IndexedSeq() => 1
      case curr +: next +: secNext +: rest if secNext == 0 => 1 + countJumps(cs.drop(2))
      case curr +: next +: secNext +: rest => 1 + countJumps(cs.drop(1))
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val cs = for (i <- 0 until n) yield sc.nextInt()

    println(countJumps(cs))
  }

}
