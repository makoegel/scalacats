package sandbox.typeclasses.instances

import cats.Monoid
import sandbox.model.Order

object MonoidInstances {

  implicit val booleanAndMonoid: Monoid[Boolean] = {
    new Monoid[Boolean] {
      override def combine(a: Boolean, b: Boolean): Boolean = a && b
      override def empty = true
    }
  }

  implicit val booleanOrMonoid: Monoid[Boolean] = {
    new Monoid[Boolean] {
      override def combine(a: Boolean, b: Boolean): Boolean = a || b
      override def empty = false
    }
  }

  implicit val booleanEitherMonoid: Monoid[Boolean] = {
    new Monoid[Boolean] {
      override def combine(a: Boolean, b: Boolean): Boolean = (a || !b) || (!a || b)
      override def empty: Boolean = false
    }
  }

  implicit val booleanXorMonoid: Monoid[Boolean] = {
    new Monoid[Boolean] {
      override def combine(a: Boolean, b: Boolean): Boolean = (!a || b) && (a || !b)
      override def empty: Boolean = true
    }
  }

  //must be def, because of type parameter
  implicit def setUnionMonoid[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      println("setUnionMonoid")
      override def combine(a: Set[A], b: Set[A]): Set[A] = a.union(b)
      override def empty: Set[A] = Set.empty[A]
    }

  implicit val intMonoid: Monoid[Int] = {
    new Monoid[Int] {
      override def combine(a: Int, b: Int): Int = a + b
      override def empty: Int = 0
    }
  }

  implicit val orderMonoid: Monoid[Order] = {
    new Monoid[Order] {
      def combine(o1: Order, o2: Order) =
        Order(
          o1.totalCost + o2.totalCost,
          o1.quantity + o2.quantity
        )
      def empty = Order(0, 0)
    }
  }

}
