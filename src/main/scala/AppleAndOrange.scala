object AppleAndOrange {

  def main(args: Array[String]){
    val sc = new java.util.Scanner (System.in);
    var s = sc.nextInt();
    var t = sc.nextInt();
    var a = sc.nextInt();
    var b = sc.nextInt();
    var m = sc.nextInt();
    var n = sc.nextInt();
    val appleDs = for (x <- 0 until m) yield sc.nextInt()
    val orangeDs = for (x <- 0 until n) yield sc.nextInt()
    println(appleDs.count(x => a + x >= s && a + x <= t))
    println(orangeDs.count(x => b + x >= s && b + x <= t))
  }

}
