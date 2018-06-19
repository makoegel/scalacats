package sandbox.meetCats
import java.time.LocalDateTime

import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.syntax.show._
import CustomShowInstances._
import sandbox.model.Cat

object CatsShowExample {

  def execute(): Unit = {
    println("CatsShowExample")

    val showInt = Show.apply[Int]
    val showString = Show.apply[String]

    val intAsString: String = showInt.show((123))
    val stringAsString: String = showString.show("abc")

    println("Int as String: " + intAsString)
    println("String as String: " + stringAsString)
    println("Syntax show for Int: " + 123.show)
    println("Syntax show for String: " + "abc".show)
    println("Date: " + LocalDateTime.now.show)

    println("Cat with Show: " + Cat("Moritz", 9, "grey").show)
  }
}
