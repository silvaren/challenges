package implementation

import scala.collection.immutable.IndexedSeq

object NonDivisibleSubset {

  def countGroups(keys: List[Int], k: Int, byRemainder: Map[Int,IndexedSeq[Int]], acc: Int): Int = {
    keys match {
      case 0 :: tail => countGroups(tail, k, byRemainder, acc)
      case List() => acc
      case head :: tail if (k % 2 == 0 && head == k / 2) => countGroups(tail, k, byRemainder, acc)
      case head :: tail => {
        if (!byRemainder.contains(k-head) || byRemainder(head).size > byRemainder(k-head).size) {
          val updated = if (tail.contains(k-head)) tail.diff(List(head,k-head)) else tail.diff(List(head))
          countGroups(updated, k, byRemainder, acc + byRemainder(head).size)
        } else {
          countGroups(keys.diff(List(k - head, head)), k, byRemainder, acc + byRemainder(k - head).size)
        }
      }
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val as = for (i <- 0 until n) yield sc.nextInt()
    val byRemainder = as.groupBy( x => x % k )
    val evenTerm = if (byRemainder.contains(0)) 1 else 0
    val halfTerm = if (k % 2 == 0 && byRemainder.contains(k/2)) 1 else 0
    val sortedKeys: List[Int] = byRemainder.keys.toList.sortWith((x, y) => byRemainder(x).size > byRemainder(y).size)
    println(countGroups(sortedKeys, k, byRemainder, 0) + evenTerm + halfTerm);
  }

}
