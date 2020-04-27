package chapter4

trait Show[A] {
  def show(a: A): String
}

object Show{

  def apply[A](implicit sh: Show[A]): Show[A] = sh

  def show0[A](a: A)(implicit sh: Show[A]) = sh.show(a)

  def instance[A](func: A => String): Show[A] =
    new Show[A] {
      def show(a: A): String = func(a)
    }

//  implicit val intCanShow: Show[Int] =
//    new Show[Int] {
//      def show(int: Int): String = s"int $int"
//    }
//
//  implicit val stringCanShow: Show[String] =
//    new Show[String]{
//      def show(str: String): String = s"string $str"
//    }

  implicit val intCanShow: Show[Int] =  int => s"int $int"

  implicit val stringCanShow: Show[String] = str => s"string $str"
}

object TypeHierarchy extends App {
 import Show._
  val favoriteDonut: Any = "Glazed Donut"
  println(s"favoriteDonut of type Any = $favoriteDonut")

  val donutName: AnyRef = "Glazed Donut"
  println(s"donutName of type AnyRef = $donutName")

  val donutPrice: AnyVal = 2.50
  println(s"donutPrice of type AnyVal = $donutPrice")

  println(intCanShow.show(10))

  println(show0(20))

//  implicit val intCanShow1: Show[Int] =
//    new Show[Int] {
//      def show(int: Int): String = s"int $int"
//    }
//
//  println(intCanShow1.show(20))

  def show1[A](a: A)(implicit sh: Show[A]) = sh.show(a)
  println(show1(10))

  def show2[A: Show](a: A) = implicitly[Show[A]].show(a)
  println(show2(20))

  def show3[A: Show](a: A) = Show.apply[A].show(a)
  println(show3(30))

  def show4[A: Show](a: A) = Show[A].show(a)
  println(show4(40))

  implicit class ShowOps[A: Show](a: A) {
    def show5 = Show[A].show(a)
  }
  println(50.show5)

  implicit class ShowOps1[A](val a: A) extends AnyVal {
    def show6(implicit sh: Show[A]) = sh.show(a)
  }
  println(60.show6)

  println(stringCanShow.show("Hello"))

}
