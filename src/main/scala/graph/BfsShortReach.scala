package graph

object BfsShortReach {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val q = sc.nextInt()
    val qs = for (i <- 0 until q) yield {
      val n = sc.nextInt()
      val m = sc.nextInt()

      val es = for (j <- 0 until m) yield (sc.nextInt(), sc.nextInt())

      val s = sc.nextInt()

      (n,es,s)
    }
  }

}
