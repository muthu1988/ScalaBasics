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

  //High Order Functions
  var numbers = Seq(1,2,3)
  var newnumbers = numbers.map(_ * 2)
  println(newnumbers)

  val salaries: List[Double] = List(1,2,3)
  val smallPromo = SalaryRiser.smallPromotion(salaries)
  println("small promo: " + smallPromo)
  val bigPromo = SalaryRiser.bigPromotion(salaries)
  println("big promo: " + bigPromo)
  val hugePromo = SalaryRiser.hugePromotion(salaries)
  println("huge promo: " + hugePromo)

  // Pattern Matching
  val patternVal = 2
  patternVal match {
    case 1 => println("one")
    case 2 => println("two")
    case _ => println("others")
  }

  // Pattern matching with guard
  def showNotifiction( notification: Notification) : String = {
    val listOfSenders :  Seq[String] = Seq("muthu")
    notification match {
      case Email(sender, title, _) if listOfSenders.contains(sender) => s"Email from $sender"
      case SMS(caller, _) => s"SMS from $caller"
      case VoiceRecording(contactName, link) => s"Voice Mail from $contactName"
      case other => s"Other : $other"
    }
  }

  println(showNotifiction(Email("muthu", "", "")))
  println(showNotifiction(Email("muthus", "", "")))

  def matchingOnlyOnType(notification: Notification) : String = {
    notification match {
      case e : Email => e.sender
      case v : VoiceRecording => v.contactName
      case s : SMS => s.caller
    }
  }
  println(matchingOnlyOnType(SMS("caller","")))

  // Object with Companion Class
  val c = new Circle(2)
  println(c.area)

  // Regular Expression( .r)
  import scala.util.matching.Regex
  val numberPattern: Regex = "[0-9]".r

  numberPattern.findFirstMatchIn("awesomepassword") match {
    case Some(_) => println("Password OK")
    case None => println("Password must contain a number")
  }

  //Extractor Object
  import CustomerID._
  val customer1ID = CustomerID("Sukyoung")  // Sukyoung--23098234908
  customer1ID match {
    case CustomerID(name) => println(name)  // prints Sukyoung
    case _ => println("Could not extract a CustomerID")
  }

  // For Comprehension
  case class User(name: String, age: Int)

  val userBase = List(User("muthu", 29), User("adaikalam", 60), User("ranji", 25))
  val twenties = for( user <- userBase if(user.age > 19 && user.age <30)) yield user.name
  twenties.foreach(name => println(name))

  def foo(n: Int, v: Int) =
    for(i <- 0 until n; j <- i until n if i + j == v) yield (i, j)

  foo(10, 10) foreach {
    case (i ,j) => println(s"$i , $j")
  }

  // Generic Class
  val genericClass = new Stack[Int]()
  genericClass.push(1)
  genericClass.push(2)
  println(genericClass.pop())
  println(genericClass.pop())

  //Covariance
  val cats: List[DogAnimal] = List(DogAnimal("Whiskers"), DogAnimal("Tom"))
  val dogs: List[CatAnimal] = List(CatAnimal("Fido"), CatAnimal("Rex"))

  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  printAnimalNames(cats)
  printAnimalNames(dogs)

  //Contravariance
  val myCat: CatAnimal = CatAnimal("Boots")

  def printMyCat(printer: Printer[CatAnimal]): Unit = {
    printer.print(myCat)
  }

  val catPrinter: Printer[CatAnimal] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter

  printMyCat(catPrinter)
  printMyCat(animalPrinter)

  // Invariance - Neither Covariance or Contravariance

  // UPPER TYPE BOUNDS
  val cokeContainer = new CoolDrinksContainer[Coke](new Coke)
  val fantaContainer = new CoolDrinksContainer[Fanta](new Fanta)
  // Below wont compile - [Tea] do not conform to class CoolDrinksContainer's type parameter bounds [C <: CoolDrinks]
  // val teaContainer = new CoolDrinksContainer[Tea](new Tea)

  // Lower Type Bounds

  // Inner Classes

  // Abstract types

  // Compound Types

  // Self Type

  // Implicit Parameters

  // Implicit Conversion

  // Polymorphic methods

  // Type Inference

  // Operators

  // By Name Parameters

  // Annotations

  // Default Parameter Values

  // Names Arguments

  // Packages & Imports
}