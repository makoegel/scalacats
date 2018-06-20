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
}
