package graph

object PrimMst {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val ms = for (i <- 0 until m) yield {
      val x = sc.nextInt()
      val y = sc.nextInt()
      val r = sc.nextInt()

      (x,y,r)
    }
    val s = sc.nextInt()

    ms.foreach(println(_))
    println(s)
  }

}
