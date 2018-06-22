package sandbox.exerciseMonoid

import cats.Monoid
import cats.instances.string._
import cats.instances.int._
import cats.instances.option._
import cats.instances.map._
import cats.instances.tuple._
import cats.syntax.semigroup._

object RealMonoidExample {

  def execute(): Unit = {

    println("--- Execute Realmonoidexample: ---")

// import cats.instances.string._
    val resString = "Scala" |+| " with " |+| "Cats"
    println("Scala\" |+| \" with \" |+| \"Cats :" + resString)

    // import cats.instances.int._
    // import cats.instances.option._
    val resOption = Option(1) |+| Option(2)
    println("Option(1) |+| Option(2) :" + resOption)

    // import cats.instances.map._
    val map1 = Map("a" -> 2, "b" -> 3)
    val map2 = Map("b" -> 100, "c" -> 3)

    val resMap = map1 |+| map2
    println("map1 |+| map2 : " + resMap)

    //import cats.instances.tuple._

    val tuple1 = ("Hello ", 123)
    val tuple2 = ("World", 321)
    val resTuple = tuple1 |+| tuple2

    println("tuple1 |+| tuple2 " + resTuple)

    println("addStrings :" + addAll(List("Test ", "Test ", "Test ", "Test")))
    println("addMap :" + addAll(List(Map("Child" -> 8), Map("Child" -> 6), Map("Adult" -> 40), Map("Adult" -> 45))))
    println("addTuple :" + addAll(List(tuple1, tuple2)))

  }

  //generic Version for all Types
  def addAll[A](values: List[A])(implicit monoid: Monoid[A]): A =
    values.foldRight(monoid.empty)(_ |+| _)
}
