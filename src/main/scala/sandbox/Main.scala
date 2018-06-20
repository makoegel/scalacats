package sandbox

import cats.implicits._
import sandbox.exerciseJsonWriter.JsonWriterExample
import sandbox.exerciseMeetCats.{CatsEqExample, CatsShowExample}
import sandbox.exercisePrintableLibrary.PrintableExample

object Main extends App {
  println("Hello " |+| "Cats!")

  JsonWriterExample.execute

  PrintableExample.execute

  CatsEqExample.execute
  CatsShowExample.execute

}
