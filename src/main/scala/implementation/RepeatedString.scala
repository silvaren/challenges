package implementation

object RepeatedString {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val s = sc.next()
    val n = sc.nextLong()

    val fullAs = (n / s.size) * s.toList.count( c => c == 'a')
    val remainderAs =  s.substring(0, (n % s.size).toInt).toList.count( c => c == 'a')
    println(fullAs + remainderAs)
  }

}
