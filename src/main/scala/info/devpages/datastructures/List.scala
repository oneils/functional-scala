package info.devpages.datastructures

/**
  * Declares 'List' data type. Sealed - all implementations must be declared in the same file.
  *
  * @tparam A
  */
sealed trait List[+A]

/**
  * 'Nil' data constructors  of [[List]]
  */
case object Nil extends List[Nothing]

/**
  * 'Cons' (traditionally short for construct) data constructors  of [[List]].
  *
  * @param head initial element
  * @param tail remaining element , possible empty
  * @tparam A
  */
case class Cons[+A](head: A, tail: List[A]) extends List[A]

/**
  * @author Aliaksei Bahdanau.
  */
object List {

  def drop[A](list: List[A], numberOfElementsToRemove: Int): List[A] =
    if (numberOfElementsToRemove <= 0) list
    else list match {
      case Nil => list
      case Cons(_, xs) => drop(xs, numberOfElementsToRemove - 1)
    }

  def dropWhile[A](list: List[A])(f: A => Boolean): List[A] = list match {
    case Nil => list
    case Cons(x, tail) if f(x) => dropWhile(tail)(f)
    case _ => list
  }

  /**
    * Uses pattern matching to add up a list of integers.
    *
    * @param ints
    * @return
    */
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(x, xs) => x * product(xs)
  }

  /**
    * Removes the first element
    */
  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def setHead[A](list: List[A], h: A): List[A] = list match {
    case Nil => List(h)
    case Cons(_, xs) => Cons(h, xs)
    case _ => list
  }


  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  def sum2(list: List[Int]): Int = foldRight(list, 0)((x, y) => x + y)

  def product2(list: List[Double]): Double = foldRight(list, 1.0)((x, y) => x * y)

  def length[A](list: List[A]): Int = foldRight(list, 0)((_, acc) => acc + 1)

  def transform(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case Cons(x, Nil) => Cons(x + 1, Nil)
    case Cons(x, xs) => Cons(x + 1, transform(xs))
  }

  def double2String(list: List[Double]): List[String] = list match {
    case Nil => Nil
    case Cons(x, Nil) => Cons(x.toString, Nil)
    case Cons(x, xs) => Cons(x.toString, double2String(xs))
  }

  /**
    * Variadic function
    *
    * @param as
    * @tparam A
    * @return
    */
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}
