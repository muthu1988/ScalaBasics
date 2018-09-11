abstract class Animal {
  def name: String
}
case class CatAnimal(name: String) extends Animal
case class DogAnimal(name: String) extends Animal
