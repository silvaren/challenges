package functional

object ReverseAList {

  def f(arr:List[Int]):List[Int] = arr match {
    case head :: tail => f(tail) :+ head
    case _ => List()
  }

}
