package implementation

import scala.annotation.tailrec

object Solution {

  def twoPowerDivision(n: Int, powerOfTwoExponent: Int) = {
    val powerOfTwo = Math.pow(2, powerOfTwoExponent)
    (n / powerOfTwo.toInt, (n % powerOfTwo).toInt)
  }

  @tailrec
  def binarySequence(n: Int, powerOfTwoExponent: Int, binary: Seq[Int]): Seq[Int] = {
    if (powerOfTwoExponent < 0) binary
    else {
      val divResult = twoPowerDivision(n, powerOfTwoExponent)
      if (divResult._1 > 0) binarySequence(divResult._2.toInt, powerOfTwoExponent - 1, binary :+ 1)
      else binarySequence(divResult._2.toInt, powerOfTwoExponent - 1, binary :+ 0)
    }
  }

  def maxBinaryGap(binary: Seq[Int], currentGapSize: Int, gapSizes: Seq[Int]): Seq[Int] = {
    binary match {
      case Seq() => gapSizes
      case head :: tail if (head == 1 && currentGapSize > 0) => maxBinaryGap(tail, 0, gapSizes :+ currentGapSize)
      case head :: tail if (head == 1 && currentGapSize <= 0) => maxBinaryGap(tail, 0, gapSizes)
      case head :: tail if (head == 0) => maxBinaryGap(tail, currentGapSize + 1, gapSizes)
    }
  }

  def solution(n: Int): Int = {
    val binary = binarySequence(n, 30, Seq())
    val firstOne = binary.indexOf(1)
    val cutBinary = binary.drop(firstOne)
    val gaps = maxBinaryGap(cutBinary, 0, Seq())
    gaps.max
  }

  def main(args: Array[String]): Unit = {
    val n = 5000
    val binary = binarySequence(n, 30, Seq())
    val maxGap = solution(n)
    println(binary)
    println(maxGap)
  }

}
