package sandbox.exerciseFunctor

import cats.instances.function._
import cats.syntax.functor._

object RealFunctorExample {

  def execute(): Unit = {
    println("--- Execute Functorexample: ---")

    val func1: Int => Double =
      (x: Int) => x.toDouble

    val func2: Double => Double =
      (y: Double) => y * 2

    println("Composition with map: " + func1.map(func2)(1))
    println("Composition with andThen: " + func1.andThen(func2)(1))
    println("Composition by hand: " + func2(func1(1)))
  }

}
