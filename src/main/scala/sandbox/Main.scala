package sandbox

import cats.implicits._
import sandbox.exercisePrintableLibrary.ExecutePrintable
import sandbox.typeclass.ExecuteJsonWriter


object Main extends App {
  println("Hello " |+| "Cats!")

  ExecuteJsonWriter.execute

  ExecutePrintable.execute
}
