package graph

object BfsShortReach {

  val LENGTH = 6

  def bfs(adj: IndexedSeq[Seq[(Int,Int)]], queue: Seq[(Int,Int)], shortReach: IndexedSeq[Int]): Seq[Int] = {
    if (queue.isEmpty) shortReach
    else {
      val node = queue.head
      if (shortReach(node._1-1) > 0) bfs(adj, queue.tail, shortReach)
      else {
        val newShortReach = shortReach.updated(node._1 - 1, node._2)
        val queueAddend = adj(node._1 - 1).map { case (v, l) => (v, node._2 + l) }
        val newQueue = (queue.tail ++ queueAddend)
        bfs(adj, newQueue, newShortReach)
      }
    }
  }

  def bfsProxy(adj: IndexedSeq[Seq[(Int,Int)]], s: Int): Unit ={
    val n = adj.length
    val shortReach = bfs(adj, Seq((s,0)), IndexedSeq.fill(n)(-1))
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

      val adj = Array.fill[Seq[(Int, Int)]](n)(Seq[(Int,Int)]())
      es.foreach{ case (v1: Int,v2: Int) => {
          adj(v1 - 1) = (v2, LENGTH) +: adj(v1 - 1)
          adj(v2 - 1) = (v1, LENGTH) +: adj(v2 - 1)
        }
      }
      (adj, s)
    }
    qs.foreach(q => bfsProxy(adj = q._1, s = q._2))
  }

}
