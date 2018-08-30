// Class with Getters and Setters
class Coordinates {

  private var _x = 0
  private var _y = 0
  private val bound = 100

  // getters
  def x = _x
  def y = _y

  // setters
  def x_= (newValue: Int) : Unit = {
    if(newValue > 100) _x = newValue else println("Out of bound")
  }

  def y_= (newValue: Int) : Unit = {
    if(newValue > 100) _y = newValue else println("Out of bound")
  }

}
