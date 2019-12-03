//hide std library `Option` and `Either`, since we are writing our own in this chapter

import scala.{Either => _, Option => _, _}
import info.devpages.chapter4.Option
import info.devpages.chapter4.Some
import info.devpages.chapter4.None

def mean(xs: Seq[Double]): Double =
  if (xs.isEmpty)
    throw new ArithmeticException("xs is empty")
  else xs.sum / xs.length


// `map` function can be used to transform the result inside an Option, if its exists.  We can think of it as proceeding with a computation on the
//assumption that an error hasn’t occurred; it’s also a way of deferring the error handling to later code.

case class Employee(name: String, department: String)

def lookupByName(name: String): Option[Employee] = Some(Employee("df", "sdf"))

val joeDepartment: Option[String] = lookupByName("Joe").map(_.department)



//val absO: Option[Double] => Option[Double] = Some(5).lift(math.abs)


def lift[A, B](f: A => B): Option[A] => Option[B] = _.map(f)

def map22[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
  a.flatMap(aa =>
    b.map(bb =>
      f(aa, bb)))

def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
  for {
    aa <- a
    bb <- b
  } yield f(aa, bb)

val abs0: Option[Int] => Option[Int] = lift(Math.abs)

def insuranceRateQuote(age: Int, numberOfSpeedingTickets: Int): Double = age * numberOfSpeedingTickets

def parseInsuranceRateQuote(age: String, numberOfSpeedingTickets: String): Option[Double] = {
  val optAge: Option[Int] = Try(age.toInt)
  val optTickets: Option[Int] = Try(numberOfSpeedingTickets.toInt)

  map2(optAge, optTickets)(insuranceRateQuote)
}

def Try[A](a: => A): Option[A] = {
  try Some(a)
  catch {
    case e: Exception => None
  }
}


def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
  case Nil => Some(Nil)
  case h :: t => h.flatMap(hh =>
    sequence(t)
      .map(hh :: _))
}

def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] =
  a match {
    case Nil => Some(Nil)
    case h :: t => map2(f(h), traverse(t)(f))(_ :: _)
  }
