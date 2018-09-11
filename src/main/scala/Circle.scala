import scala.math._

object Circle {
  def calculateArea(radius: Double) : Double = Pi * pow(radius, 2)
}

class Circle(radius: Double){
  import Circle.calculateArea
  def area = calculateArea(radius)
}