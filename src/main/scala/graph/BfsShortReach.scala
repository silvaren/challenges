package graph

object BfsShortReach {

  val LENGTH = 6

  def bfs(adj: Array[Array[Int]], queue: Seq[(Int,Int)], shortReach: Seq[Int]): Seq[Int] = {
    if (queue.isEmpty) shortReach
    else {
      val node = queue.head
      val newShortReach = shortReach.updated(node._1-1, node._2)
      val queueAddend = for (i <- 0 until adj.length if adj(node._1-1)(i) > 0)
        yield (i + 1, node._2 + adj(node._1-1)(i))
      val newQueue = queue.tail ++ queueAddend
      bfs(adj, newQueue, newShortReach)
    }
  }

  def bfsProxy(adj: Array[Array[Int]], s: Int): Unit ={
    val n = adj.length
    val shortReach = bfs(adj, Seq((s,0)), Seq.fill(n)(-1))
    val shortReachNoStartNode = shortReach.take(s - 1) ++ shortReach.drop(s)
    shortReachNoStartNode.foreach(l => print(l + " "))
    println()
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val q = sc.nextInt()
    val qs = for (i <- 0 until q) yield {
      val n = sc.nextInt()
      val m = sc.nextInt()
      val es = for (j <- 0 until m) yield (sc.nextInt(), sc.nextInt())
      val s = sc.nextInt()

      val adj = Array.ofDim[Int](n,n)
      es.foreach{ case (v1: Int,v2: Int) => adj(v1-1)(v2-1) = LENGTH}
      (adj, s)
    }
    qs.foreach(q => bfsProxy(adj = q._1, s = q._2))
  }

}
