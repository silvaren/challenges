package functional

object FilterArray {

  def f(delim:Int,arr:List[Int]):List[Int] = arr.foldLeft(List[Int]())((acc, x) => if (x < delim) acc :+ x else acc)

}
