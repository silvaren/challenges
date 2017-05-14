package implementation

object Bst extends App {

  class Node (var data: Int = 0, var left: Option[Node] = None, var right: Option[Node] = None) {
    override def toString: String = s"${data} left: $left | right: $right"
  }

  def bst(node: Node, e: Int): Option[Node] = {
    if (node.data == e) Some(node)
    else if (node.data < e && node.right.isDefined) bst(node.right.get, e)
    else if (node.data > e && node.left.isDefined) bst(node.left.get, e)
    else None
  }

  var test = new Node(5,
    Some(new Node(3, Some(new Node(1, None, None)), Some(new Node(4, None, None)))),
    Some(new Node(7, Some(new Node(6, None, None)), Some(new Node(8,None, None)))))

  println(bst(test, 2))
}
