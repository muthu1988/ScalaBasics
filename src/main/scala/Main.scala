// Define a main method using object
object Main extends App {
  println("Scala")

  // Constant
  val a = 1

  // Variable
  var b = 2

  // Block
  println({
    val c = a + b
    c
  })

  // Functions
  val square = (x: Int) => x * x
  println(square(2))
  val addFunction = (x: Int, y: Int) => x + y
  println(addFunction(2,3))

  // Methods
  def addMethod(x: Int, y: Int): Int = x + y
  println(addMethod(3,3))
  // Method mutiple parameter
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println(addThenMultiply(1, 2)(3)) // 9
  // Method no parameter
  def name: String = System.getProperty("user.name")
  println("Hello, " + name + "!")

  // Class
  val greeting = new Greetings("Hi ", " !")
  greeting.greet("Scala User")

  // Case class - immutable can be instantiated without new keyword
  val point = Point(1,1)
  val anotherPoint = Point(1,1)
  val yetAnotherPoint = Point(1,2)
  println(point == anotherPoint)
  println(point == yetAnotherPoint)

  // Object - Object will act as singleton of there own class
  val newId = IdGenerator.create()
  println(newId)
  val anotherId = IdGenerator.create()
  println(anotherId)

  // Traits
  val defaultGreet = new DefaultGreeter();
  println(defaultGreet.greet("muthu"))
  val customizedGreeter = new CustomizedGreeter("Hello ", " !")
  println(customizedGreeter.greet("muthu"))
}