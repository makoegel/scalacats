package sandbox.typeclasses.instances

import sandbox.typeclasses.Semigroup

object SemigroupInstances {

  //must be def, because of type parameter
  implicit def setIntersectionSemigroup[A]: Semigroup[Set[A]] =
    new Semigroup[Set[A]] {
      println("setIntersectSemigroup")
      override def combine(a: Set[A], b: Set[A]): Set[A] = a.intersect(b)
    }
}
