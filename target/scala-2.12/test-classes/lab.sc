

//why do we need abstraction? - they can contain members which are missing an implementation // when we need some common method
//how traits in Scala are used? - java's interface(almost), classes and objects can extend traits but traits cannot be instantiated and have no parameters and when we let a class to have several supertypes(for ex class Square extends Shape with Planar with Movable)
//hides all but the relevant data about an object in order to reduce complexity and increase efficiency.

trait Animal {
  // Is this abstract or concrete (implemented) member?
  // abstract because method is no complete
  def name: String // abstract

  // Is this abstract or concrete (implemented) member?
  // abstract because method is no complete
  def makeSound(): String // abstract
}

trait Walks {


  this: Animal => //it makes members of Animal available to Walks


  def walk: String = s"$name is walking" // implemented member & name is available because of code line above

}

//Can Dog only extend from 'Walks'? - No, class also should extend Animal

case class Dog(_name: String, makesound: String = "Whoaaa") extends Animal with Walks{
  override def name: String = _name

  override def makeSound(): String = makesound
}

// Implement Cat class so it passes tests

case class Cat(name: String) extends Animal with Walks{
  override def walk: String = s"$name is walking"

  override def makeSound(): String = "miyaau"
}


object part_1 extends App{



  val dog1 = Dog("Ceasar")
  val dog2 = Dog("Laika")

  assert(dog1.name == "Ceasar")
  assert(dog2.name == "Laika")

  assert(dog1.makeSound() == "Whooof") // asserts are there to help us catch bugs
  assert(dog2.makeSound() == "Whooof")

  assert(dog1.walk == "Ceasar is walking")
  assert(dog2.walk == "Laika is walking")

  val cat1 = Cat("Tosha")
  val cat2 = Cat("Chocolate")

  assert(cat1.name == "Tosha")
  assert(cat2.name == "Chocolate")

  assert(cat1.makeSound() == "Miiyaaau")
  assert(cat2.makeSound() == "Miiyaaau")

  assert(cat1.walk == "Tosha is walking")
  assert(cat2.walk == "Chocolate is walking")

}