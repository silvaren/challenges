package gcj

import java.util.Scanner

import scala.annotation.tailrec

object OversizedPancakeFlipper extends App {

  def flip(pancakes: String, k: Int) = {
    val flippedPancakes = pancakes.take(k).map(c => if (c == '-') '+' else '-')
    flippedPancakes ++ pancakes.drop(k)
  }

  @tailrec
  def traverse(pancakes: String, k: Int, flips: Int): Int = {
    val unhappyPart = pancakes.dropWhile(_ == '+')
    unhappyPart.size match {
      case 0 => flips
      case x if x < k => -1
      case x if x == k && unhappyPart.forall(_ == '-') => traverse(unhappyPart.drop(k),k,flips+1)
      case _ => traverse(flip(unhappyPart, k),k,flips+1)
    }
  }

  val sc = new Scanner(System.in)
  val t = sc.nextInt()
  sc.nextLine()
  val lines = for (_ <- 1 to t) yield sc.nextLine()
  def charIsPancake = (c: Char) => c == '-' || c == '+'
  val tests = lines.map(s => (s.takeWhile(charIsPancake),s.dropWhile(charIsPancake).tail.toInt))
  val results = tests.map(test => traverse(test._1, test._2,0))
  val stringResults = results.map(flips => if (flips < 0) "IMPOSSIBLE" else flips.toString)
  stringResults.zipWithIndex.foreach(r => println(s"Case #${r._2+1}: ${r._1}"))
}
