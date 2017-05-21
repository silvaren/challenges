package implementation

object RotatedBst extends App {

  def rotatedBst(arr: IndexedSeq[Int], e: Int, offset: Int, l: Int, h: Int): Int = {
    val size = arr.size
    val middle = l + (h - l)/2
    if (arr((middle + offset) % size) == e) (middle + offset) % size
    else if (h - l < 1) -1
    else if (arr((middle + offset)) < e) rotatedBst(arr, e, offset, middle+1, h)
    else rotatedBst(arr, e, offset, 0, middle-1)
  }

  def findElement(rotatedSorted: IndexedSeq[Int], element: Int): Int = {
    var i = 0
    while (rotatedSorted(i) < rotatedSorted(i+1 % rotatedSorted.size)) i = i + 1
    val offset = i + 1
    println(i)

    rotatedBst(rotatedSorted, element, offset, 0, rotatedSorted.size-1)
  }

  val rotatedSorted = IndexedSeq(50,60,70,80,10,20,30,40)

  println(findElement(rotatedSorted, 30))

}
