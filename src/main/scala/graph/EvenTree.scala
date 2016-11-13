package graph

import scala.collection.immutable.IndexedSeq

object EvenTree {

  def neighbors(vertex: Int, edges: IndexedSeq[(Int, Int)]): IndexedSeq[Int] =
    edges.collect{case (a,b) if (a == vertex || b == vertex) => if (a == vertex) b else a}

  def subtreeVertexCount(root: Int, edges: IndexedSeq[(Int, Int)], visited: List[Int]): Int = {
    if (visited.contains(root)) 0
    else {
      val rootNeighbors = neighbors(root, edges)
      1 + rootNeighbors.foldLeft(0)((acc, v) => acc + subtreeVertexCount(v, edges, root :: visited))
    }
  }

  def subtreeCounts(root: Int, edges: IndexedSeq[(Int, Int)], visited: List[Int]): List[(Int, Int)] = {
    if (visited.contains(root)) List()
    else {
      val rootNeighbors = neighbors(root, edges)
      (root, subtreeVertexCount(root, edges, visited)) ::
        rootNeighbors.foldLeft(List[(Int, Int)]())((acc, v) => acc ::: subtreeCounts(v, edges, root :: visited))
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val edges = for (i <- 0 until m) yield (sc.nextInt(),sc.nextInt())

    val allSubtreeCounts = subtreeCounts(1, edges, List())
    println(allSubtreeCounts.count{case (v,c) => c % 2 == 0} - 1)
  }

}
