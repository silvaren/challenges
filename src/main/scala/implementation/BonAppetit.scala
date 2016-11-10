package implementation

object BonAppetit {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val cs = for (i <- 0 until n) yield sc.nextInt()
    val bCharged = sc.nextInt()

    val fairCharge = (cs.reduce(_ + _) - cs(k))/2
    if (fairCharge == bCharged) println("Bon Appetit")
    else println(bCharged - fairCharge)
  }

}
