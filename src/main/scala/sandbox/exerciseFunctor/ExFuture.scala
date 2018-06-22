package sandbox.exerciseFunctor

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object ExFuture extends App {

  val future: Future[String] =
    Future(123)
      .map(n => n + 1)
      .map(n => n * 2)
      .map(n => n + "!")

  val result = Await.result(future, 1.second)

  println("Result Future :" + result)

}
