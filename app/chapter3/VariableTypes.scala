package chapter3

object VariableTypes extends App {

  val donutsToBuy: Int = 5
  //    donutsToBuy = 10 // you will get compile error because donutToBuy is immutable

  var favoriteDonut: String = "Glazed Donut"
  favoriteDonut = "Vanilla Donut"

  lazy val donutService = "initialize some donut service"

  val donutsBought: Int = 5

  val bigNumberOfDonuts: Long = 100000000L

  val smallNumberOfDonuts: Short = 1

  val priceOfDonut: Double = 2.50

  val donutPrice: Float = 2.50f

  val donutStoreName: String = "Donut Store"

  val donutByte: Byte = "A".toByte

  val donutFirstLetter: Char = 'D'

  val nothing: Unit = ()

  var leastFavoriteDonut: String = _

  leastFavoriteDonut = "Plain Donut"

  val numberOfDonuts: Short = 1

  val minimumDonutsToBuy: Int = numberOfDonuts

  val minimumDonutsToSell: String = numberOfDonuts.toString()
}
