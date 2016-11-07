package implementation

object AngryProfessor {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val t = sc.nextInt()

    val tests = for (i <- 0 until t) yield {
      val n = sc.nextInt()
      val k = sc.nextInt()
      val as = for (j <- 0 until n) yield sc.nextInt()
      (n, k, as)
    }

    tests.foreach{
      case (n, k, as) => {
        println(if (as.count(x => x <= 0) < k) "YES" else "NO")
      }
    }

  }

}
