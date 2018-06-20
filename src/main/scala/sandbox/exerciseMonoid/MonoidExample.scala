package sandbox.exerciseMonoid

import sandbox.typeclasses.Monoid
import sandbox.typeclasses.instances.MonoidInstances._

object MonoidExample {

  def execute(): Unit = {
    println("--- Execute Monoid: ---")

    val intSetMonoid = Monoid[Set[Int]]

    println("Combine Set Monoid with union: " + intSetMonoid.combine(Set(1, 2), Set(2, 3)))
    println("Combine Set Monoid with union: " + intSetMonoid.combine(Set(1, 2), Set.empty))
    println("Empty Set Monoid: " + intSetMonoid.empty)

    //val booleanMonoid = Monoid[Boolean]
    // ambiguos implicit values -> booleanAndMonoid - booleanOrMonoid
    //println("Combine Boolean Monoid: " + booleanMonoid.combine(true, true))

  }
}
