package implementation

object BalancedTree extends App {

  class Node (var data: Int = 0, var children: List[Node] = List()) {
    override def toString: String = s"${data} $children"
  }

  def minMaxHeight(node: Node, level: Int): (Int,Int) = {
    if (node.children.isEmpty)
      (level, level)
    else {
      val minMaxes = node.children.map(n => minMaxHeight(n, level + 1))
      (minMaxes.minBy(_._1)._1,minMaxes.maxBy(_._2)._2)
    }
  }

  def checkBalanced(node: Node): Boolean = {
    val rootMinMax = minMaxHeight(node, 0)
    rootMinMax._2 - rootMinMax._1 < 2
  }

  var test =
    new Node(1, List(
      new Node(2, List(new Node(3, List(new Node(4, List()))))),
      new Node(5, List())
    ))

  println(test)
  println(checkBalanced(test))

  var balanced =
    new Node(1, List(
      new Node(2, List(new Node(3, List(new Node(4, List()))))),
      new Node(5, List(new Node(6, List())))
    ))
  println(balanced)
  println(checkBalanced(balanced))

}
