package sandbox.typeclasses.syntax

import sandbox.typeclasses.{Json, JsonWriter}

// Interface Syntax
object JsonSyntax {

  implicit class JsonWriterOps[A](value: A) {

    def toJson(implicit w: JsonWriter[A]): Json =
      w.write(value)
  }

}
