package sandbox.typeclasses

trait Semigroup[A] {
  def combine(a: A, b: A): A
}

object Semigroup {

  def apply[A](implicit semigroup: Semigroup[A]): Semigroup[A] = semigroup
}
