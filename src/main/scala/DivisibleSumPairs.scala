object DivisibleSumPairs {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val as = for (x <- 0 until n) yield sc.nextInt()

    val pairs = for(i <- 0 until n-1; j <- i+1 until n) yield (as(i), as(j))
    print(pairs.count{ case (ai,aj) => (ai + aj) % k  == 0})
  }

}
