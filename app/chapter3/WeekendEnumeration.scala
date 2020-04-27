package chapter3

object WeekendEnumeration extends App{

  object Weekday extends Enumeration {
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }

  println(Weekday.withName("Monday"))
  //println(Weekday.withName("Mondai"))

  object Weekday1 extends Enumeration {
    val Monday = Value("Mo.")
    val Tuesday = Value("Tu.")
    val Wednesday = Value("We.")
    val Thursday = Value("Th.")
    val Friday = Value("Fr.")
    val Saturday = Value("Sa.")
    val Sunday = Value("Su.")
  }
  println(Weekday1.Monday.toString)
  println(Weekday1.values)

  object Weekday2 extends Enumeration {
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }
  println(Weekday2.values.toList.sorted)


  object Weekday4 extends Enumeration {
    val Monday = Value(1)
    val Tuesday = Value(2)
    val Wednesday = Value(3)
    val Thursday = Value(4)
    val Friday = Value(5)
    val Saturday = Value(6)
    val Sunday = Value(0)
  }

  println(Weekday4.values.toList.sorted)

  def test(enum: Weekday.Value) = {
    println(s"enum: $enum")
  }
  test(Weekday.Monday)

  def nonExhaustive(weekday: Weekday.Value): Unit = {
    weekday match {
      case Weekday.Monday => println("I hate Mondays")
      case Weekday.Sunday => println("The weekend is already over? :( ")
    }
  }
  nonExhaustive(Weekday.Sunday)

  sealed trait Weekday

  case object Monday extends Weekday
  case object Tuesday extends Weekday
  case object Wednesday extends Weekday
  case object Thursday extends Weekday
  case object Friday extends Weekday
  case object Saturday extends Weekday
  case object Sunday extends Weekday

//  def test(weekday: Weekday) = {
//    weekday match {
//      case Monday => println("I hate Mondays")
//      case Sunday => println("The weekend is already over? :( ")
//    }
//  }

  sealed abstract class Weekday1( val name: String,
                                 val abbreviation: String,
                                 val isWorkDay: Boolean)

  case object Monday1 extends Weekday1("Monday", "Mo.", true)
  case object Tuesday1 extends Weekday1("Tuesday", "Tu.", true)
  case object Wednesday1 extends Weekday1("Wednesday", "We.", true)
  case object Thursday1 extends Weekday1("Thursday", "Th.", true)
  case object Friday1 extends Weekday1("Friday", "Fr.", true)
  case object Saturday1 extends Weekday1("Saturday", "Sa.", false)
  case object Sunday1 extends Weekday1("Sunday", "Su.", false)

  sealed abstract class Weekday2( val name: String,
                                 val abbreviation: String,
                                 val isWeekDay: Boolean,
                                 val order: Int) extends Ordered[Weekday2] {

    def compare(that: Weekday2) = this.order - that.order
  }

  case object Monday2 extends Weekday2("Monday", "Mo.", true, 2)
  case object Tuesday2 extends Weekday2("Tuesday", "Tu.", true, 3)
  case object Wednesday2 extends Weekday2("Wednesday", "We.", true, 4)
  case object Thursday2 extends Weekday2("Thursday", "Th.", true, 5)
  case object Friday2 extends Weekday2("Friday", "Fr.", true, 6)
  case object Saturday2 extends Weekday2("Saturday", "Sa.", false, 7)
  case object Sunday2 extends Weekday2("Sunday", "Su.", false, 1)

}
