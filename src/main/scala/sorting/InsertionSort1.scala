package sorting

object InsertionSort1 {

  def printArray(as: Seq[Int]): Unit = {
    as.foreach(x => print(x + " "))
    println()
  }

  def insertSort(as: Seq[Int], unsorted: Int, index: Int): Unit = {
    if (index < 0) printArray(as.updated(0, unsorted))
    if (as(index) > unsorted) {
      val shifted = as.updated(index+1, as(index))
      printArray(shifted)
      insertSort(as.updated(index+1, as(index)), unsorted, index - 1)
    } else
      printArray(as.updated(index+1, unsorted))
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val as = for (x <- 0 until n) yield sc.nextInt()

    insertSort(as, as(n-1), n-2)
  }

}
