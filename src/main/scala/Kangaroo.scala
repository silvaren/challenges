object Kangaroo {

  object Solution {

    def main(args: Array[String]) {
      val sc = new java.util.Scanner (System.in);
      var x1 = sc.nextInt();
      var v1 = sc.nextInt();
      var x2 = sc.nextInt();
      var v2 = sc.nextInt();

      if (v1 <= v2) println("NO")
      else println(if ((x2 - x1) % (v1 - v2) == 0) "YES" else "NO")
    }
  }

}
