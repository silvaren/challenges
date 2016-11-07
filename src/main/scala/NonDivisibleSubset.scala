import scala.collection.immutable.IndexedSeq

object NonDivisibleSubset {

  def maxSubset(sortedKeys: List[Int], k: Int, maxNonDivSubset: List[Int], byRemainder: Map[Int,IndexedSeq[Int]]):
  List[Int] = {
    sortedKeys match {
      case List() => maxNonDivSubset
      case 0 :: tail => maxSubset(tail, k, maxNonDivSubset, byRemainder)
      case head :: tail => {
        if (maxNonDivSubset.exists(x => (x + head) % k == 0 || (((x + x) % k == 0) && byRemainder(x).size > 1))) {
          println("ignoring: " + head)
          maxSubset(tail, k, maxNonDivSubset, byRemainder)
        } else {
          println("adding: " + head)
          maxSubset(tail, k, head :: maxNonDivSubset, byRemainder)
        }
      }
    }
  }

  def countGroups(byRemainder: Map[Int, IndexedSeq[Int]], k: Int) = {}

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val as = for (i <- 0 until n) yield sc.nextInt()

    val byRemainder = as.groupBy( x => x % k)
    countGroups(byRemainder, k);
    val sortedKeys = byRemainder.keys.toList.sortWith((x,y) => byRemainder(x).size > byRemainder(y).size)
    sortedKeys.foreach( x => println((x,byRemainder(x).size)))
    val maxSubsetKeys = maxSubset(sortedKeys, k, List(), byRemainder)
    maxSubsetKeys.foreach( x => println((x,byRemainder(x).size)))
    val evenTerm = if (byRemainder.contains(0)) 1 else 0
    val halfTerm = if (k % 2 == 0 && byRemainder.contains(k/2)) 1 else 0
    println(maxSubsetKeys.foldLeft(0)((total,key) => total + byRemainder(key).size) + evenTerm + halfTerm)
  }

}
