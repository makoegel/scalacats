package sandbox.exercisePrintableLibrary

import java.time.LocalDate
import sandbox.exercisePrintableLibrary.PrintableInstances._
import sandbox.exercisePrintableLibrary.PrintableSyntax._
import sandbox.model.Cat

object ExecutePrintable {
  def execute (): Unit = {

    println("Execute Printable: ")
    //print cat (exercisePrintableLibrary)
    val cat = Cat("Kater Mau", 8, "black")
    Printable.print(cat)

    //extension Method for Case Class Cat
    println(cat.format)
    cat.print

    //extension Method for Date
    LocalDate.now().print
  }
}
