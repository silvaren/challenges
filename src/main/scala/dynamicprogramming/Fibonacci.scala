package dynamicprogramming

object Fibonacci {

  def memoize[I, O](f: I => O): collection.Map[I, O] = new scala.collection.mutable.HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }

  lazy val fibonacci: Int => BigInt = memoize {
    case 0 => 0
    case 1 => 1
    case n => {
      fibonacci(n - 1) + fibonacci(n - 2)
    }
  }

  def main(args: Array[String]): Unit = {
    println(fibonacci(10))
  }

}
