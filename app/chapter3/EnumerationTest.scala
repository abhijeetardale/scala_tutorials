package chapter3

object EnumerationTest extends App {

  object Donut extends Enumeration {
    type Donut = Value

    val Glazed      = Value("Glazed")
    val Strawberry  = Value("Strawberry")
    val Plain       = Value("Plain")
    val Vanilla     = Value("Vanilla")
  }

  println(s"Vanilla Donut string value = ${Donut.Vanilla}")
  println(s"Vanilla Donut's id = ${Donut.Vanilla.id}")
  println(s"Donut types = ${Donut.values}")

  Donut.values.foreach {
    case d if d == Donut.Strawberry || d == Donut.Glazed => println(s"Found favourite donut = $d")
    case _ => None
  }

  object DonutTaste extends Enumeration{
    type DonutTaste = Value

    val Tasty       = Value(0, "Tasty")
    val VeryTasty   = Value(1, "Very Tasty")
    val Ok          = Value(-1, "Ok")
  }

  println(s"Donut taste values = ${DonutTaste.values}")
  println(s"Donut taste of OK id = ${DonutTaste.Ok.id}")

}
