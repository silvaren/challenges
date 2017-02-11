package functional

object ListReplication {

  def f(num:Int,arr:List[Int]):List[Int] = arr.flatMap(x => (1 to num).map(_ => x).toList)

}
