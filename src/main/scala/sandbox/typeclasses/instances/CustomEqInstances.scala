package sandbox.typeclasses.instances

import java.time.{LocalDateTime, ZoneId}

import cats.Eq
import cats.instances.int._
import cats.instances.long._
import cats.instances.string._
import cats.syntax.eq._
import sandbox.model.Cat

object CustomEqInstances {

  implicit val dateEq: Eq[LocalDateTime] =
    Eq.instance[LocalDateTime] { (date1, date2) =>
      val date1seconds: Long = date1.atZone(ZoneId.systemDefault).toInstant.toEpochMilli
      val date2seconds: Long = date2.atZone(ZoneId.systemDefault).toInstant.toEpochMilli
      println("date1Long: " + date1seconds + " date2Long " + date2seconds)
      date1seconds === date2seconds
    }

  implicit val catEq: Eq[Cat] =
    Eq.instance[Cat] { (cat1, cat2) =>
      (cat1.name === cat2.name) &&
      (cat1.age === cat2.age) &&
      (cat1.color === cat2.color)
    }

}
