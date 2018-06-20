package sandbox.typeclasses.instances

import java.time.LocalDateTime

import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.syntax.show._
import sandbox.model.Cat

object CustomShowInstances {

  implicit val dateShow: Show[LocalDateTime] =
    /*  new Show[LocalDateTime] {

      def show(date: LocalDateTime): String =
        s"${date.getSecond} seconds since the epoch."
    }*/
    // simplified with Object Show:
    Show.show(date => s"${date.getNano} ms since the epoch.")

  implicit val catShow: Show[Cat] =
    Show.show[Cat] { cat =>
      val name = cat.name.show
      val age = cat.age.show
      val color = cat.color.show
      s"$name is a $age year-old $color cat"
    }
}
