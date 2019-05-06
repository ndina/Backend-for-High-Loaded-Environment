package lab4

case class Film( name: String,
                 yearOfRelease: Int,
                 imdbRating: Double)

case class Director( firstName: String,
                     lastName: String,
                     yearOfBirth: Int,
                     films: Seq[Film])

object laba extends App{

  val memento = new Film("Memento", 2000, 8.5)
  val darkKnight = new Film("Dark Knight", 2008, 9.0)
  val inception = new Film("Inception", 2010, 8.8)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9)
  val unforgiven = new Film("Unforgiven", 1992, 8.3)
  val granTorino = new Film("Gran Torino", 2008, 8.2)
  val invictus = new Film("Invictus", 2009, 7.4)
  val predator = new Film("Predator", 1987, 7.9)
  val dieHard = new Film("Die Hard", 1988, 8.3)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)
  val eastwood = new Director("Clint", "Eastwood", 1930,
    Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
  val mcTiernan = new Director("John", "McTiernan", 1951,
    Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
  val nolan = new Director("Christopher", "Nolan", 1970,
    Seq(memento, darkKnight, inception))
  val someGuy = new Director("Just", "Some Guy", 1990,
    Seq())
  val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

  //Task 1 -> Accept a parameter numberOfFilms of type Int — find all directors who have directed more than numberOfFilms

   val a = (numberOfFilms: Int) => directors.filter(d => d.films.size > numberOfFilms)
  println(a(2))

  //Task 2 -> Accept a parameter year of type Int — find a director who was born before that year
  val b = (year: Int) => directors.filter(d => d.yearOfBirth < year)
  println(b(2000))

  //Task 3 -> Accept two parameters, year and numberOfFilms , and return a list of directors who were born before year who have also directed more than than numberOfFilms.
  val c = (numberOfFilms: Int, year : Int) => directors.filter(d => d.films.size > numberOfFilms && d.yearOfBirth < year)
  println(c(2, 2000))

  //Task 4 -> Accept a parameter ascending of type Boolean that defaults to true. Sort the directors by age in the specified order.
  val d = (ascending: Boolean) => ascending match{
    case true => directors.sortWith(_.yearOfBirth < _.yearOfBirth)
    case false => directors.sortWith(_.yearOfBirth > _.yearOfBirth)
  }
  println(d(true))

  //Task 5 -> Starting with the definition of nolan, create a list containing the names of the films directed by Christopher Nolan.

  val e = nolan.films.map(f => f.name)
  println(e)

  // Task 6 -> Starting with the definition of directors, create a list containing the names of all films by all directors.
  val f = directors.flatMap(d => d.films.map(f => f.name))
  println(f)

  // Task 7 -> Starting with mcTiernan, find the date of the earliest McTiernan film.
  //Tip: you can concisely find the minimum of two numbers a and b using math.min(a, b)

  val g = mcTiernan.films.map(f => f.yearOfRelease).min
  println(g)

  // Task 8 -> Starting with directors, find all films sorted by descending IMDB rating.
//  val h = (descending: Boolean) => descending match{
//    case true => directors.films.sortWith(_.imdbRating > _.imdbRating)
//  }
  val h = directors.flatMap(d => d.films).sortWith(_.imdbRating < _.imdbRating)
  println("H ")
  println(h)

  // Task 9 -> Starting with directors again, find the average score across all films.
  def i() : Double = {
    val films: Seq[Film] = directors.flatten(director => director.films)
    val sum: Double = films.foldLeft(0.0)((sum, film) => sum + film.imdbRating)
     sum / films.size
  }

  //Task 10 -> Starting with directors , print the following for every film: "Tonight only! FILM NAME by DIRECTOR!"


  val k = () => directors.foreach(d => d.films.foreach(f => println(s"Tonight only! ${f.name} by ${d.firstName}")))

  println(k)

  // Task 11 ->
  def l(): Option[Film] = {
    val res= directors.flatMap(d => d.films).sortWith((f1, f2) => (f1.yearOfRelease) < f2.yearOfRelease)
    res.headOption
  }

  println(l)
}