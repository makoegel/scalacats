package sandbox.typeclasses.instances

import sandbox.typeclasses.Monoid

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
      override def combine(a: Set[A], b: Set[A]): Set[A] = a.union(b)
      override def empty: Set[A] = Set.empty[A]
    }

}
