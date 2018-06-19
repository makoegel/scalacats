package sandbox.typeclass

import sandbox.model.Person
import sandbox.typeclass.JsonWriterInstances._
import sandbox.typeclass.JsonSyntax._

object ExecuteJsonWriter {

  def execute() : Unit = {
    println("Execute JsonWriter: ")
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
  }

}
