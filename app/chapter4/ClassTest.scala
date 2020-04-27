package chapter4

object ClassTest extends App{

  class Donut(val name: String, tasteLevel: String){

    override def toString: String = s"$name, $tasteLevel)"
  }

  object Donut {
    def apply(name: String, tasteLevel: String): Donut = {
      new Donut(name, tasteLevel)
    }

    def unapply(d: Donut): String = s"after unapply ${d.name}"
  }



  val favoriteDonut = Donut("Glazed Donut", "Very Tasty")

  println(favoriteDonut.name)
  //println(favoriteDonut.tasteLevel)
  println(favoriteDonut)

  val favoriteDonut1 = Donut.apply("Glazed Donut", "Very Tasty")

  println(favoriteDonut1.name)
//println(favoriteDonut1.tasteLevel)
  println(favoriteDonut1)

  println(Donut.unapply(favoriteDonut1))

  object Logger {
    def info(message: String): Unit = println(s"INFO: $message")
  }

  println(Logger.info("Test Logger"))

  import Logger._
  println(info("Test Logger with imports"))

}
