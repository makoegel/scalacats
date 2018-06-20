package sandbox.exerciseMonoid

import sandbox.typeclasses.Semigroup
import sandbox.typeclasses.instances.SemigroupInstances._

object SemigroupExample {

  def execute(): Unit = {
    println("--- Execute Monoid: ---")

    val intSetSemigroup: Semigroup[Set[Int]] = Semigroup[Set[Int]]
    println("Combine Set Semigroup with intersect: " + intSetSemigroup.combine(Set(1, 2, 3), Set(2, 3, 4, 5)))
  }
}
