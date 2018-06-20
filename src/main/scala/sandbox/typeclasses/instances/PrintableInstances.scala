package sandbox.typeclasses.instances

import java.time.LocalDate

import sandbox.model.Cat
import sandbox.typeclasses.Printable

object PrintableInstances {
  //Printable for String and Int

  implicit val stringPrintable: Printable[String] =
    new Printable[String] {
      def format(value: String): String = value
    }

  implicit val numberPrintable: Printable[Int] =
    new Printable[Int] {
      def format(value: Int): String = value.toString
    }

  implicit val catPrintable: Printable[Cat] =
    new Printable[Cat] {

      def format(cat: Cat): String = {
        // s"${cat.name} is a ${cat.age} year-old ${cat.color} cat."
        // better type safe solution:
        val name = Printable.format(cat.name)
        val age = Printable.format(cat.age)
        val color = Printable.format(cat.color)
        s"$name is a $age year-old $color cat."

      }
    }

  implicit val datePrintable: Printable[LocalDate] =
    new Printable[LocalDate] {

      def format(date: LocalDate): String = {
        val day = Printable.format(date.getDayOfMonth)
        val month = Printable.format(date.getMonthValue)
        val year = Printable.format(date.getYear)
        s"$day.$month.$year"
      }
    }

}
