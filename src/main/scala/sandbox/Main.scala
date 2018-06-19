package sandbox

import cats.implicits._
import sandbox.model.Person
import sandbox.typeclass.Json
import sandbox.typeclass.JsonWriterInstances._

object Main extends App {
  println("Hello " |+| "Cats!")
  println(Json.toJson(Person("Example", "Example@github.de")))
  println(Json.toJson("Example"))
}
