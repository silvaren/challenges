package functional

object AreaUnderCurvesAndVolumeOfRevolvingCurve {

  // This function will be used while invoking "Summation" to compute
  // The area under the curve.
  def f(coefficients:List[Int],powers:List[Int],x:Double):Double =
  {
    coefficients.zip(powers).foldLeft(0.0)((acc, p) => acc + p._1.toDouble * (Math.pow(x,p._2)))
  }

  // This function will be used while invoking "Summation" to compute
  // The Volume of revolution of the curve around the X-Axis
  // The 'Area' referred to here is the area of the circle obtained
  // By rotating the point on the curve (x,f(x)) around the X-Axis
  def area(coefficients:List[Int],powers:List[Int],x:Double):Double =
  {
    //Fill Up this function body
    // To compute the area of the circle on revolving the point
    // (x,f(x)) around the X-Axis
    // For the given coefficients, powers and value of x
    Math.PI * Math.pow(f(coefficients, powers, x), 2)
  }

  // This is the part where the series is summed up
  // This function is invoked once with func = f to compute the area         // under the curve
  // Then it is invoked again with func = area to compute the volume
  // of revolution of the curve
  def summation(func:(List[Int],List[Int],Double)=>Double,
                upperLimit:Int,lowerLimit:Int,coefficients:List[Int],powers:List[Int]):Double =
  {
    (lowerLimit.toDouble until upperLimit.toDouble by 0.001).reduce(
      (acc: Double, x:Double) => acc + 0.001 * func(coefficients,powers,x + 0.0005))
  }

  def main(args: Array[String]): Unit = {
    val coefs = List(1, 2, 3, 4, 5, 6, 7, 8)
    val powers = List(-1, -2, -3, -4, 1, 2, 3, 4)
    val areaUnder = summation(f, 2, 1, coefs, powers)
    println(f"$areaUnder%.1f")
    val volume = (summation(area, 2, 1, coefs, powers))
    println(f"$volume%.1f")
  }

}
