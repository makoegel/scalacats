package sandbox

import cats.implicits._
import sandbox.exercisePrintableLibrary.Printable
import sandbox.model.{Cat, Person}
import sandbox.typeclass.{Json, JsonWriter}
import sandbox.typeclass.JsonWriterInstances._
import sandbox.exercisePrintableLibrary.PrintableInstances._
import sandbox.typeclass.JsonSyntax._

object Main extends App {
  println("Hello " |+| "Cats!")

  // JsonWriterInstances implicit vals
  println(Json.toJson(Person("Example", "Example@github.de")))
  println(Json.toJson("Example"))

  // JsonSyntax
  println(Person("Test", "Test@test.de").toJson)

  // Implicitly Method is from Scala Standard library.
  // Good for testing, if compiler can find an instance of type class.
  println(implicitly[JsonWriter[String]])

  //implicit def
  println(Json.toJson(Option("Some String")))
  println(Json.toJson(Option(123)))

  //print cat (exercisePrintableLibrary)
  val cat = Cat("Kater Mau", 8, "black")
  Printable.print(cat)


}
