package sandbox.exerciseMonoid

import cats.instances.int._
import cats.instances.string._
import cats.instances.option._
import cats.kernel.Monoid
import cats.syntax.semigroup._
import sandbox.model.Order
import sandbox.typeclasses.instances.MonoidInstances._

object RealSemigroupExample {

  def execute(): Unit = {
    val str = "Hello " |+| "Marion"
    println(str)

    val list = List(1, 2, 3, 4)
    println("AddItemsWithFoldFunktion: " + addWithFold(list))
    println("AddItemsWithFoldAndMonoid: " + addWithMonoid(list))

    val listOption = List(Some(2), Some(3), None, Some(6))
    println("AddItemsWithOptionInt: " + addWithGenericMonoid(list))
    println("AddItemsWithOptionInt: " + addWithGenericMonoid(listOption))
    println("AddItemsWithOptionIntEleganter: " + addWithGenericMonoidEleganter(listOption))

    val listOrders = List(Order(1.5, 2.5), Order(1.5, 2.5), Order(3.0, 3.0))
    println("addOrders: " + addWithGenericMonoid(listOrders))
  }

  def addWithFold(items: List[Int]): Int =
    //with fold
    //items.fold[Int](0)((x, y) => (x + y))
    //items.foldLeft(0)(_ + _)
    items.sum

  def addWithMonoid(items: List[Int]): Int =
    items.foldLeft(Monoid[Int].empty)(_ |+| _)

  def addWithGenericMonoid[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.foldLeft(monoid.empty)(_ |+| _)

  def addWithGenericMonoidEleganter[A: Monoid](items: List[A]): A =
    items.foldLeft(Monoid[A].empty)(_ |+| _)

}
