package chapter3

import models.Donut

object PatternMatching {

  val donutType = "Glazed Donut"
  donutType match {
    case "Glazed Donut" => println("Very tasty")
    case "Plain Donut"  => println("Tasty")
  }



  val tasteLevel = donutType match {
    case "Glazed Donut" => "Very tasty"
    case "Plain Donut"  => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel")



  val tasteLevel2 = donutType match {
    case "Glazed Donut" => "Very tasty"
    case "Plain Donut"  => "Tasty"
    case _              => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel2")



  val tasteLevel3 = donutType match {
    case "Glazed Donut" | "Strawberry Donut" => "Very tasty"
    case "Plain Donut" => "Tasty"
    case _  => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel3")



  val tasteLevel4 = donutType match {
    case donut if donut.contains("Glazed") || donut.contains("Strawberry") => "Very tasty"
    case "Plain Donut"  => "Tasty"
    case _  => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel4")


  val priceOfDonut: Any = 2.50

  val priceType = priceOfDonut match {
    case price: Int     => "Int"
    case price: Double  => "Double"
    case price: Float   => "Float"
    case price: String  => "String"
    case price: Boolean => "Boolean"
    case price: Char    => "Char"
    case price: Long    => "Long"
  }
  println(s"Donut price type = $priceType")

  val favoriteDonut: Donut = Donut("Glazed Donut", "Very Tasty")

  favoriteDonut match {
    case Donut("Glazed Donut",_) => println("Very tasty")
    case Donut("Plain Donut",_)  => println("Tasty")
    case _  => println("Not Valid")
  }

  favoriteDonut match {
    case Donut(_,"Very tasty") => println("Glazed Donut")
    case Donut(_,"Tasty")  => println("Plain Donut")
    case _  => println("Not Valid")
  }

  favoriteDonut match {
    case Donut("Glazed Donut","Very tasty") => println(favoriteDonut.name)
    case Donut(_,_)  => println("Plain Donut")
  }
}
