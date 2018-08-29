// Scala class with constructors and a method
class Greetings(prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}