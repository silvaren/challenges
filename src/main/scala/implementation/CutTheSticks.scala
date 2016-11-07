package implementation

object CutTheSticks {

  def cutSticks(as: Seq[Int]): Seq[Int] =
    as.collect{ case x if x > as.min => x - as.min }

  def cutUntilNone(as: Seq[Int]): Unit = {
    if (!as.isEmpty) {
      println(as.size)
      cutUntilNone(cutSticks(as))
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val as = for (i <- 0 until n) yield sc.nextInt()

    cutUntilNone(as)
  }

}
