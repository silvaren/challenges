object StrangeAdvertising {

  def likes(n: Int): Int = {
    if (n == 1) 2
    else Math.floor((likes(n - 1) * 3) / 2).toInt
  }

  def likeSum(n: Int): Int = {
    if (n == 1) 2
    else likeSum(n - 1) + likes(n)
  }

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()

    print(likeSum(n))
  }

}
