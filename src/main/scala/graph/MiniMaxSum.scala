package graph

object MiniMaxSum {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    val integers = for (i <- 0 until 5) yield sc.nextInt()

    val sortedLongs = integers.sorted.map(_.toLong)
    val minSum = sortedLongs.take(4).reduce(_ + _)
    val maxSum = sortedLongs.drop(1).reduce(_ + _)
    println(s"${minSum} ${maxSum}")
  }
}