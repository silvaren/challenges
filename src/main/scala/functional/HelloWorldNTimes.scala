package functional

object HelloWorldNTimes {

  def f(n: Int) = (1 to n).foreach( _ => println("Hello World"))

}
