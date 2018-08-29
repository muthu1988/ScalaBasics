trait GreeterTrait {
  def greet(name: String): Unit =
    println("Hi "+ name)
}
class DefaultGreeter extends GreeterTrait

class CustomizedGreeter(prefix: String, postfix: String) extends GreeterTrait {
  override def greet(name: String): Unit = println(prefix + name + postfix)
}