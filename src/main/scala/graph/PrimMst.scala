package graph

import scala.annotation.tailrec

object PrimMst {

  case class Edge(x: Int, y: Int, length: Int)
  case class Tree(nodes: Set[Int], edges: Set[Edge])

  @tailrec
  def primMst(tree: Tree, graph: Set[Edge], n: Int): Tree = {
    if (tree.nodes.size == n) tree
    else {
      val nextEdges = graph.filter(e =>
        tree.nodes.contains(e.x) && !tree.nodes.contains(e.y) ||
          tree.nodes.contains(e.y) && !tree.nodes.contains(e.x))
      val smallestEdge = nextEdges.minBy(_.length)
      val newNode = if (tree.nodes.contains(smallestEdge.x)) smallestEdge.y else smallestEdge.x
      primMst(Tree(tree.nodes + newNode, tree.edges + smallestEdge), graph, n)
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val ms = for (i <- 0 until m) yield {
      val x = sc.nextInt()
      val y = sc.nextInt()
      val r = sc.nextInt()

      Edge(x,y,r)
    }
    val s = sc.nextInt()

    ms.foreach(println(_))
    println(s)
    val mst = primMst(Tree(Set(s),Set()), ms.toSet, n)
    println(mst)
  }

}
