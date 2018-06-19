package sandbox.meetCats

import java.time.{LocalDateTime, ZoneId}

import cats.Eq
import cats.instances.long._
import cats.syntax.eq._

object CustomEqInstances {

  implicit val dateEq: Eq[LocalDateTime] =
    Eq.instance[LocalDateTime] { (date1, date2) =>
      val date1seconds: Long = date1.atZone(ZoneId.systemDefault).toInstant().toEpochMilli
      val date2seconds: Long = date2.atZone(ZoneId.systemDefault).toInstant().toEpochMilli
      println("date1Long: " + date1seconds + " date2Long " + date2seconds)
      date1seconds === date2seconds
    }

}
