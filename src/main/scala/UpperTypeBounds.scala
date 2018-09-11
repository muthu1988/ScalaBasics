abstract class Drinks {
  def name: String
}

abstract class CoolDrinks extends Drinks {}

class Coke extends CoolDrinks {
  override def name: String = "Coke"
}

class Fanta extends CoolDrinks {
  override def name: String = "Fanta"
}

class Tea extends Drinks {
  override def name: String = "Tea"
}

class CoolDrinksContainer[C <: CoolDrinks](c: C) {
  def coolDrink: C = c
}