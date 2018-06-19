package sandbox.meetCats
import java.time.LocalDateTime

import cats.Eq
import cats.instances.int._
import cats.instances.option._
import cats.syntax.eq._
import cats.syntax.option._
import CustomEqInstances._

object CatsEqExample {

  def execute(): Unit = {
    println("Execute CatsEqExample: ")

    val eqInt = Eq[Int]
    val int1 = 123
    val int2 = 234
    println(s"Ints ($int1, $int1) equivalent: " + eqInt.eqv(int1, int1))
    println(s"Ints ($int1, $int2) equivalent: " + eqInt.eqv(int1, int2))
    println(s"Ints ($int1, $int1) equivalent with Syntax eq: " + (int1 === int1))
    println(s"Ints ($int1, $int2) equivalent with Syntax  not eq: " + (int1 =!= int2))

    //argument with type
    val res = (Some(1): Option[Int]) === (None: Option[Int])
    println("argument with type: (Some(1): Option[Int]) === (None: Option[Int]) " + res)

    // import cats.instances.option._
    val resNicer = Option(1) === Option.empty[Int]
    println("cats.instances.option: Option(1) === Option.empty[Int " + resNicer)

    // import cats.syntax.option._
    val syntaxOptionEqual = 1.some === none[Int]
    println("cats.syntax.option equal: 1.some === none[Int] " + syntaxOptionEqual)

    val syntaxOptionNotEqual = 1.some =!= none[Int]
    println("cats.syntax.option not equal: 1.some =!= none[Int] " + syntaxOptionNotEqual)

    val date1 = LocalDateTime.now.minusHours(1)
    println("erste Zeit: " + date1)
    val date2 = LocalDateTime.now()
    println("zweite Zeit: " + date2)

    val isTimeEqual = date1 === date1
    val isTimeDifferent = date1 =!= date2

    println("isTimeEqual: " + isTimeEqual)
    println("isTimeDifferent: " + isTimeDifferent)

  }
}
