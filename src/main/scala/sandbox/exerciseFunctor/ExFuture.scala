package sandbox.exerciseFunctor

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.Random

//object ExFuture extends App {
object ExFuture {

  def mapFuture(): Unit = {
    val future: Future[String] =
      Future(123)
        .map(n => n + 1)
        .map(n => n * 2)
        .map(n => n + "!")

    val result = Await.result(future, 1.second)

    println("Result Future :" + result)
  }

  def randomFuture(): Unit = {
    val future1 = {
      val r = new Random(0L)
      val x = Future(r.nextInt)

      for {
        a <- x
        b <- x
      } yield (a, b)
    }

    val future2 = {
      val r = new Random(0L)

      for {
        a <- Future(r.nextInt)
        b <- Future(r.nextInt) // new Call for Future : side-effect, not referentially transparent
      } yield (a, b)
    }

    println("result1: " + Await.result(future1, 1.second))
    println("result2: " + Await.result(future2, 1.second))
  }

  mapFuture()
  randomFuture()

}
