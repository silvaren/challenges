package functional

object EvalEx {

  def factorial(x: Int): Int = x match {
    case 0 => 1
    case 1 => 1
    case y: Int => y * factorial(y - 1)
  }

  def evalX(x: Double): Double = {
    1.0 + (1 to 9).foldLeft(0.0)((acc, y) => acc + (Math.pow(x,y.toDouble)/factorial(y).toDouble))
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val xs = for (i <- 1 to n) yield sc.nextDouble()
    xs.map(evalX(_)).foreach(println(_))
  }

}
