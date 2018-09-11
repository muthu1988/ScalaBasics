abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[CatAnimal] {
  def print(cat: CatAnimal): Unit =
    println("The cat's name is: " + cat.name)
}