package sandbox

import cats.implicits._
import sandbox.model.Person
import sandbox.typeclass.Json
import sandbox.typeclass.JsonWriterInstances._
import sandbox.typeclass.JsonSyntax._

object Main extends App {
  println("Hello " |+| "Cats!")

  // JsonWriterInstances
  println(Json.toJson(Person("Example", "Example@github.de")))
  println(Json.toJson("Example"))

  // JsonSyntax
  println(Person("Test", "Test@test.de").toJson)
}
