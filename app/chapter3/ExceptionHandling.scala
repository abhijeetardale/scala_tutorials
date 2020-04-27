package chapter3

import scala.util.{Failure, Success, Try}

object ExceptionHandling extends App {

  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  toInt("10") match {
    case Some(i) => println(i)
    case None => println("That didn't work.")
  }


  toInt("No") match {
    case Some(i) => println(i)
    case None => println("That didn't work.")
  }

  val y = for {
    a <- toInt("1")
    b <- toInt("2")
    c <- toInt("3")
  } yield a + b + c
  println(y)


  def toInt1(s: String): Try[Int] = Try(Integer.parseInt(s.trim))

  println(toInt1("1"))
  println(toInt1("x"))

  toInt1("10") match {
    case Success(i) => println(i)
    case Failure(s) => println(s"Failed. Reason: $s")
  }

  toInt1("No") match {
    case Success(i) => println(i)
    case Failure(s) => println(s"Failed. Reason: $s")
  }

  val x = for {
    a <- toInt("1")
    b <- toInt("2")
    c <- toInt("3")
  } yield a + b + c
  println(x)

  val z = for {
    a <- toInt("1")
    b <- toInt("x")
    c <- toInt("3")
  } yield a + b + c
  println(z)
}
