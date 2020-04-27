package chapter3

object OptionTest extends App{

  val glazedDonutTaste: Option[String] = Some("Very Tasty")
  println(s"Glazed Donut taste = ${glazedDonutTaste.get}")

  val chocolateDonut: Option[String] = None
  println(s"Chocolate Donut name = ${chocolateDonut.getOrElse("Chocolate Donut")}")

  val glazedDonutName: Option[String] = Some("Glazed Donut")
  glazedDonutName match {
    case Some(name) => println(s"Received donut name = $name")
    case None       => println(s"No donut name was found!")
  }

  glazedDonutTaste.map(taste => println(s"glazedDonutTaste = $taste"))
  glazedDonutName.foreach(name => println(s"glazedDonutName = $name"))
  glazedDonutName.fold(println(s"No Donut"))(name => println(s"glazedDonutName = $name"))

  if(chocolateDonut.isEmpty) println(s"No Donut") else println(s"$chocolateDonut")
  if(glazedDonutName.isDefined) println(s"$glazedDonutName") else println(s"No Donut")

}
