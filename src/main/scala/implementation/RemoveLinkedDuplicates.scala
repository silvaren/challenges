package implementation

object RemoveLinkedDuplicates extends App {

  class Node (var data: Int = 0, var next: Option[Node] = None) {
    override def toString: String = s"${data} $next"
  }

  def removeDuplicates(clean: Node, list: Node, current: Node): Unit = {
    var v = list
    var isRepeated = false
    while (v ne current) {
      if (v.data == current.data)
        isRepeated = true
      v = v.next.get
    }
    var newClean = clean
    if (!isRepeated) {
      clean.next = Option(current)
      newClean = current
    }
    if (current.next.isDefined)
      removeDuplicates(newClean, list, current.next.get)
  }

  var test =
    new Node(1,Option(
      new Node(2,Option(
        new Node(3,Option(
          new Node(2,Option(
            new Node(1,Option(
              new Node(4,None)))))))))))

  removeDuplicates(test, test, test.next.get)
  println(test)

}
