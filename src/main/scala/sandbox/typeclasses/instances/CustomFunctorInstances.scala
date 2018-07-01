package sandbox.typeclasses.instances

import cats.Functor
import sandbox.model.{Branch, Leaf, Tree}

object CustomFunctorInstances {

  implicit val treeFunctor: Functor[Tree] =
    new Functor[Tree] {
      override def map[A, B](tree: Tree[A])(func: A => B): Tree[B] =
        tree match {
          case Branch(left, right) => Branch(map(left)(func), map(right)(func))
          case Leaf(value)         => Leaf(func(value))
        }
    }

}
