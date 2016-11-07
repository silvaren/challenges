package implementation

object AppleAndOrange {

  def main(args: Array[String]){
    val sc = new java.util.Scanner (System.in)
    val s = sc.nextInt()
    val t = sc.nextInt()
    val a = sc.nextInt()
    val b = sc.nextInt()
    val m = sc.nextInt()
    val n = sc.nextInt()
    val appleDs = for (x <- 0 until m) yield sc.nextInt()
    val orangeDs = for (x <- 0 until n) yield sc.nextInt()

    println(appleDs.count(x => a + x >= s && a + x <= t))
    println(orangeDs.count(x => b + x >= s && b + x <= t))
  }

}
