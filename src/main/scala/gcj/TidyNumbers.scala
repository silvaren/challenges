package gcj

import java.util.Scanner

import scala.annotation.tailrec

object TidyNumbers extends App {

  @tailrec
  def tidy(nString: String, tidyNumber: String): String = {
    val current = nString.reverse.head
    nString.reverse.toList.tail match {
      case Nil => current + tidyNumber
      case head :: tail if (head.toString.toInt <= current.toString.toInt) =>
        tidy(nString.take(nString.size - 1), current + tidyNumber)
      case head :: tail => {
        val newTidy = tidyNumber.map(_ => '9')
        val newHead = head.toString.toInt - 1
        tidy(nString.take(nString.size - 2) + newHead, '9' + newTidy)
      }
    }
  }

  val sc = new Scanner(System.in)
  val t = sc.nextInt()
  sc.nextLine()
  val ns = for (_ <- 1 to t) yield sc.nextLong()
  val tidys = ns.map(n => tidy(n.toString,"")).map(_.toLong)
  tidys.zipWithIndex.foreach(r => println(s"Case #${r._2+1}: ${r._1}"))
}
