package functional

object FilterPositionsInAList {

  def f(arr:List[Int]):List[Int] = arr match {
    case odd :: even :: tail => even :: f(tail)
    case _ => List()
  }

}
