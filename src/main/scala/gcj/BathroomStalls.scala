package gcj

import java.util.Scanner

import scala.annotation.tailrec
import scala.collection.mutable

object BathroomStalls extends App {

  def getMinMax(biggestEmpty: Long): (Long, Long) = {
    val remaining = biggestEmpty - 1
    val min = remaining / 2
    val max = min + remaining % 2
    (min,max)
  }

  @tailrec
  def stalls(empties: Seq[Long], k: Long): (Long, Long)= {
    val biggestEmpty = empties.max
    val minMax = getMinMax(biggestEmpty)
    if (k == 1)
      minMax
    else {
      val removedCount = empties.count(_ == biggestEmpty)
      val newEmpties = empties.flatMap(e => if (e == biggestEmpty) Seq(minMax._1,minMax._2) else Seq(e))
      if (k-removedCount < 1)
        (minMax._1,minMax._2)
      else
        stalls(newEmpties, k-removedCount)
    }
  }

  val sc = new Scanner(System.in)
  val t = sc.nextInt()
  sc.nextLine()
  val nks = for (_ <- 1 to t) yield (sc.nextLong(),sc.nextLong())
  val results = nks.map(nk => stalls(Seq(nk._1),nk._2))
  results.zipWithIndex.foreach(r => println(s"Case #${r._2+1}: ${r._1._2} ${r._1._1}"))
}
