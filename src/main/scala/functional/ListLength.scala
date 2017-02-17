package functional

object ListLength {

  def f(arr:List[Int]):Int = arr.reduce((acc, x) => acc + 1)

}
