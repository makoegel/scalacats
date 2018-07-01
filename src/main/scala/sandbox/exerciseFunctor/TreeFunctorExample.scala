package sandbox.exerciseFunctor

import sandbox.model.Tree
import cats.syntax.functor._
import sandbox.typeclasses.instances.CustomFunctorInstances._

object TreeFunctorExample {

  def execute(): Unit = {
    println("--- Execute TreeFunctorexample: ---")

    println(Tree.leaf(100).map(_ * 2))
    println(Tree.branch(Tree.leaf(20), Tree.leaf(20)).map(_ * 2))
  }
}
