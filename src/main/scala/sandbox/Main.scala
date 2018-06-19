package sandbox

import cats.implicits._
import sandbox.meetCats.CatsEqExample
//import sandbox.exercisePrintableLibrary.ExecutePrintable
//import sandbox.meetCats.CatsShowExample
//import sandbox.typeclass.ExecuteJsonWriter

object Main extends App {
  println("Hello " |+| "Cats!")

  // ExecuteJsonWriter.execute

  // ExecutePrintable.execute

  // CatsShowExample.execute()
  CatsEqExample.execute()
}
