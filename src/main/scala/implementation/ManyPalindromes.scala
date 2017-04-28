package implementation

object ManyPalindromes extends App {

  def isPalindrome(s: String): Boolean = {
    s.reverse == s
  }

  val s = "barbarabar"
  val combinations = for (
    i <- 1 to s.size;
    j <- 0 to s.size-1-i
  ) yield s.substring(j,j+i)

  val results = combinations.map(s => (s, isPalindrome(s)))
  results.foreach(r => if (r._2) println(r._1))

}
