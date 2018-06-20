package sandbox.exerciseMonoid

import cats.instances.int._
import cats.instances.string._
import cats.kernel.Monoid
import cats.syntax.semigroup._

object RealSemigroupExample {

  def execute(): Unit = {
    val str = "Hello " |+| "Marion"
    println(str)

    val list = List(1, 2, 3, 4)
    println("AddItemsWithFoldFunktion: " + addWithFold(list))
    println("AddItemsWithFoldAndMonoid: " + addWithMonoid(list))
  }

  def addWithFold(items: List[Int]): Int =
    //with fold
    //items.fold[Int](0)((x, y) => (x + y))
    //items.foldLeft(0)(_ + _)
    items.sum

  def addWithMonoid(items: List[Int]): Int =
    items.foldLeft(Monoid[Int].empty)(_ |+| _)

}
