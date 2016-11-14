package dynamicprogramming

object ModifiedFibonacci {

  def memoize[I, O](f: I => O): collection.Map[I, O] = new scala.collection.mutable.HashMap[I, O]() {
    override def apply(key: I) = getOrElseUpdate(key, f(key))
  }

  lazy val fibonacci: ((Int, Int, Int)) => BigInt = memoize[((Int, Int, Int)),BigInt](
    x => x match {
      case (t1,t2,n) if (n == 1) => t1
      case (t1,t2,n) if (n == 2) => t2
      case (t1,t2,n) => fibonacci(t1,t2, n-2) + fibonacci(t1,t2, n-1) * fibonacci(t1,t2, n-1)
    }
  )

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in)
    val t1 = sc.nextInt()
    val t2 = sc.nextInt()
    val n = sc.nextInt()

    println(fibonacci(t1, t2, n))
  }

}
