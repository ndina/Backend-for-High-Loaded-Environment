//why do we need abstraction? - they can contain members which are missing an implementation // when we need some common method
//how traits in Scala are used? - java's interface(almost), classes and objects can extend traits but traits cannot be instantiated and have no parameters and when we let a class to have several supertypes(for ex class Square extends Shape with Planar with Movable)


trait Animal {

  def name: String // abstract

  //   def makeSound(): String // abstract

}


trait Walks {

  this: Animal => // it makes members of Animal available to Walks

  def walk: String = s"$name is walking" // implemented member & name is available because of code line above

}

//Can Dog only extend from 'Walks'? - No, class also should extend Animal

case class Dog(name: String) extends Walks with Animal{
  override def walk: String = s"$name my walk"

}

case class Cat(name: String) extends Walks with Animal{
  override def walk: String = s"$name is walking"
}

object lab22 extends App{
  val dog1 = Dog("Caesar")
  val dog2 = Dog("Laika")

  assert(dog1.name == "Caesar") // asserts are there to hepl us catch bugs
  assert(dog2.name == "Laika")

  assert(dog1.walk == "Ceasar is walking")
  assert(dog2.walk == "Laika is walking")


  val cat1 = Cat("Tosha")
  val cat2 = Cat("Chocolate")

  assert(cat1.name == "Tosha")
  assert(cat2.name == "Chocolate")


  assert(cat1.walk == "Tosha is walking")
  assert(cat2.walk == "Chocolate is walking")

}