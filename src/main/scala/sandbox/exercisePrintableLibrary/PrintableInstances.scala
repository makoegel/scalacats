package sandbox.exercisePrintableLibrary

import sandbox.model.Cat

object PrintableInstances {
  //Printable for String and Int


  implicit val stringPrintable:  Printable[String] =
    new Printable[String] {
      def format(value: String): String = value
    }

  implicit val numberPrintable:  Printable[Int] =
    new Printable[Int] {
      def format(value: Int): String = value.toString
    }

  implicit val catPrintable: Printable[Cat] =
    new Printable[Cat]{
      def format(cat: Cat) : String ={
       // s"${cat.name} is a ${cat.age} year-old ${cat.color} cat."
       // better type safe solution:
       val name = Printable.format(cat.name)
       val age = Printable.format(cat.age)
       val color = Printable.format(cat.color)
        s"$name is a $age year-old $color cat."

      }
    }

}
