package sandbox

import cats.implicits._
import sandbox.exerciseFunctor.{RealFunctorExample, TreeFunctorExample}
import sandbox.exerciseMonoid.{RealMonoidExample, RealSemigroupExample, SemigroupExample}
/*import sandbox.exerciseJsonWriter.JsonWriterExample
import sandbox.exerciseMeetCats.{CatsEqExample, CatsShowExample}
import sandbox.exercisePrintableLibrary.PrintableExample*/
import sandbox.exerciseMonoid.MonoidExample

object Main extends App {
  println("Hello " |+| "Cats!")

  /*  JsonWriterExample.execute

  PrintableExample.execute

  CatsEqExample.execute
  CatsShowExample.execute*/

  MonoidExample.execute()
  SemigroupExample.execute()
  RealSemigroupExample.execute()
  RealMonoidExample.execute()

  RealFunctorExample.execute()
  TreeFunctorExample.execute()

}
