package functional

object SumOfOddElements {

  def f(arr:List[Int]):Int = arr.reduce((acc, x) => if (x % 2 != 0) acc + x else acc)

}
