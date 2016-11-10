package graph

import scala.collection.immutable.IndexedSeq

object EvenTree {

  def connectedVertices(seedVertex: Int, edges: IndexedSeq[(Int, Int)], visited: Set[Int]): Set[Int] = {
    println("visited: " + visited)
    if (visited.contains(seedVertex)) visited
    else {
      val connected = edges.collect{
        case (x,y) if (x == seedVertex) => y
        case (x,y) if (y == seedVertex) => x
      }
      connected.foldLeft(Set[Int]())((acc, vertex) => acc ++ connectedVertices(vertex, edges, visited + seedVertex ++ acc))
    }
  }

  def isEvenForest(vertices: IndexedSeq[Int], edges: IndexedSeq[(Int, Int)]): Boolean = {
    println("isEven vertices:" + vertices)
    vertices match {
      case IndexedSeq() => true
      case x +: IndexedSeq() => false
      case x +: rest => {
        val connected = connectedVertices(x, edges, Set())
        if (connected.size % 2 > 0) false
        else isEvenForest(vertices.diff(connected.toIndexedSeq), edges)
      }
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val edges = for (i <- 0 until m) yield (sc.nextInt(),sc.nextInt())

    val vertices = for (i <- 1 to n) yield i
    println("edges: " + edges)
    println(isEvenForest(vertices, edges.diff(IndexedSeq((3,1),(6,1)))))
  }

}
