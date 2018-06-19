package sandbox.exercisePrintableLibrary

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

}
