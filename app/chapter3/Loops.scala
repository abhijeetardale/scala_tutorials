package chapter3

object Loops extends App{

  // IF Else
  val numberOfPeople = 20
  val donutsPerPerson = 2

  if(numberOfPeople > 10)
    println(s"Number of donuts to buy = ${numberOfPeople * donutsPerPerson}")

  val defaultDonutsToBuy = 8

  if(numberOfPeople > 10)
    println(s"Number of donuts to buy = ${numberOfPeople * donutsPerPerson}")
  else
    println(s"Number of donuts to buy = $defaultDonutsToBuy")


  if(numberOfPeople > 10) {
    println(s"Number of donuts to buy = ${numberOfPeople * donutsPerPerson}")
  } else if (numberOfPeople == 0) {
    println("Number of people is zero.")
    println("No need to buy donuts.")
  } else {
    println(s"Number of donuts to buy = $defaultDonutsToBuy")
  }


  val numberOfDonutsToBuy = if(numberOfPeople > 10) numberOfPeople * donutsPerPerson else defaultDonutsToBuy
  println(s"Number of donuts to buy = $numberOfDonutsToBuy")


  //RANGE

  val from1To5 = 1 to 5
  println(s"Range from 1 to 5 inclusive = $from1To5")

  val from1Until5 = 1 until 5
  println(s"Range from 1 until 5 where 5 is excluded = $from1Until5")

  val from0To10By2 = 0 to 10 by 2
  println(s"Range from 0 to 10 with multiples of 2 = $from0To10By2")

  val alphabetRangeFromAToZ = 'a' to 'z'
  println(s"Range of alphabets from a to z = $alphabetRangeFromAToZ")

  val alphabetRangeFromAToZBy2 = 'a' to 'z' by 2
  println(s"Range of every other alphabet = $alphabetRangeFromAToZBy2")

  val listFrom1To5 = (1 to 5).toList
  println(s"Range to list = ${listFrom1To5.mkString(" ")}")

  val setFrom1To5 = (1 to 5).toSet
  println(s"Range to set = ${setFrom1To5.mkString(" ")}")

  val sequenceFrom1To5 = (1 to 5).toSeq
  println(s"Range to sequence = ${sequenceFrom1To5.mkString(" ")}")

  val arrayFrom1To5 = (1 to 5).toArray
  println(s"Range to array = `${arrayFrom1To5.mkString(" ")}")

  arrayFrom1To5.foreach(print(_))


  // FOR Loop

  for(numberOfDonuts <- 1 to 5){
    println(s"Number of donuts to buy = $numberOfDonuts")
  }

  for(numberOfDonuts <- 1 until 5){
    println(s"Number of donuts to buy = $numberOfDonuts")
  }

  val donutIngredients = List("flour", "sugar", "egg yolks", "syrup", "flavouring")
  for(ingredient <- donutIngredients if ingredient == "sugar"){
    println(s"Found sweetening ingredient = $ingredient")
  }
  val sweeteningIngredients = for {
    ingredient <- donutIngredients
    if ingredient == "sugar" || ingredient == "syrup"
  } yield ingredient
  println(s"Sweetening ingredients = $sweeteningIngredients")



  val twoDimensionalArray = Array.ofDim[String](2,2)
  twoDimensionalArray(0)(0) = "flour"
  twoDimensionalArray(0)(1) = "sugar"
  twoDimensionalArray(1)(0) = "egg"
  twoDimensionalArray(1)(1) = "syrup"

  for { x <- 0 until 2
        y <- 0 until 2
  } println(s"Donut ingredient at index ${(x,y)} = ${twoDimensionalArray(x)(y)}")


  //While Loop

  var numberOfDonutsToBake = 10
  while (numberOfDonutsToBake > 0) {
    println(s"Remaining donuts to be baked = $numberOfDonutsToBake")
    numberOfDonutsToBake -= 1
  }


  //do while

  var numberOfDonutsBaked = 0
  do {
    numberOfDonutsBaked += 1
    println(s"Number of donuts baked = $numberOfDonutsBaked")
  } while (numberOfDonutsBaked < 5)


}
