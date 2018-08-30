import scala.collection.mutable.ArrayBuffer

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
  defaultGreet.greet("muthu")
  val customizedGreeter = new CustomizedGreeter("Hello ", " !")
  customizedGreeter.greet("muthu")

  //Type
  val list: List[Any] = List(
    "a string",
    732,  // an integer
    'c',  // a character
    true, // a boolean value
    () => "an anonymous function returning a string"
  )
  list.foreach(element => println(element))

  val x: Long = 987654321
  val y: Float = x  // 9.8765434E8 (note that some precision is lost in this case)
  val face: Char = 'b'
  val number: Int = face  // 9786

  // Class
  val defaultPoint = new Point
  println(defaultPoint)
  val xpoint = new Point(1)
  println(xpoint)
  val ypoint = new Point(y=1)
  println(ypoint)

  val coordinates = new Coordinates
  coordinates.x = 100
  coordinates.y = 101

  // Trait
  var iter = new Iterator(4)
  println(iter.next())
  println(iter.next())
  println(iter.next())
  println(iter.next())
  println(iter.next())

  class Dog(val name: String) extends PetTrait
  class Cat(val name: String) extends PetTrait

  val dog = new Dog("bow")
  val cat = new Cat("meow")

  val animals = ArrayBuffer.empty[PetTrait]
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name))

  // Class composition with mixins
  class RichStringIter extends StringIterator("scala") with RichStringIterator
  var richStringIter = new RichStringIter
  richStringIter foreach println

}