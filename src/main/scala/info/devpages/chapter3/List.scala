package info.devpages.chapter3

import scala.annotation.tailrec

/**
  * Declares 'List' data type. Sealed - all implementations must be declared in the same file.
  *
  * @tparam A
  */
sealed trait List[+A]

/**
  * 'Nil' data constructors  of empty [[List]]
  */
case object Nil extends List[Nothing]

/**
  * 'Cons' (traditionally short for construct) data constructors  of [[List]].
  *
  * @param head initial element
  * @param tail remaining element , possible empty
  */
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  /**
    * Sums all elements for specified List of Integers
    *
    * @param xs [[List]] which elements should be summed
    * @return the sum of all elements of the List
    */
  def sum(xs: List[Int]): Int = xs match {
    case Nil => 0
    case Cons(x, xy) => x + sum(xy)
  }

  /**
    * Multiplies all elements of the specified List of Doubles
    *
    * @param ds [[List]] of Doubles which elements should be multiplied
    * @return 1.0 if specified List is empty, otherwise result of multiplication for all elements
    */
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  /**
    * Variadic function of a `List`, meaning it accepts zero or more arguments of type `A`
    * It simplifies the instances construction of the data type (`list literals`) like List(1, 2, 3)
    *
    * @param as
    * @tparam A
    * @return
    */
  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  /**
    * Function which returns all elements of the List except the first element
    *
    * @param xs provided [[List]] for which tail of elements should be returned
    * @return rest elements of the List except the first
    */
  def tail[A](xs: List[A]): List[A] = xs match {
    case Nil => Nil
    case Cons(_, xs1) => xs1
  }

  /**
    * Replaces the Head (first element) for provided List by specified new head
    *
    * @param xs      List which head should be replaced
    * @param newHead to be replaced by
    * @return list with replaced head element
    */
  def setHead[A](xs: List[A], newHead: A): List[A] = xs match {
    case Nil => Cons(newHead, Nil)
    case Cons(_, l) => Cons(newHead, l)
  }

  /**
    * Drops first n element into provided List
    *
    * @param xs [[List]] which n elements should be removed
    * @param n  the amount of first elements to be removed
    * @return a new [[List]] with elements which were not removed
    */
  def drop[A](xs: List[A], n: Int): List[A] = {

    @tailrec
    def go(l: List[A], acc: Int): List[A] = {
      if (acc < n) go(tail(l), acc + 1)
      else tail(l)
    }

    if (n < 0) xs else go(xs, 1)
  }

  /**
    * Removes elements from the provided [[List]] until elements satisfies provided predicate condition
    *
    * @param as which elements should be removed
    * @param f  predicate according to which elements should be removed
    * @return a new [[List]] with remained elements which didn't satisfy predicate condition
    */
  def dropWhile[A](as: List[A])(f: A => Boolean): List[A] = as match {
    //    old implementation without partial function call
    //    case Cons(x, xs) => if (f(x)) dropWhile(xs, f) else as
    case Cons(x, xs) if f(x) => dropWhile(xs)(f)
    case _ => as
  }

  /**
    * Adds all the elements of second list to the end of first List. It only copies values until the first list is
    * exhausted.
    *
    * @param xs [[List]] to which elements elements from second list should be added
    * @param xy [[List]] which elements should be copied to the first list
    * @return resulting List with added to the end elements of the second List
    *
    */
  def append[A](xs: List[A], xy: List[A]): List[A] = xs match {
    case Nil => xy
    case Cons(a, b) => Cons(a, append(b, xy))
  }

  /**
    * returns a List consisting of all but the last element of a List.
    * So, given `List(1,2,3,4)`, `init` will return `List(1,2,3)`.
    *
    * @param xs List for which last element should be dropped
    * @return a new List without last element
    */
  def init[A](xs: List[A]): List[A] = xs match {
    case Nil => xs
    case Cons(_, Nil) => Nil // drop last element
    case Cons(x, xy) => Cons(x, init(xy))
  }

  /**
    *
    */
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

  /**
    * Implementation of `sum` function to use `foldRight` function.
    * expression `(x, y) => x + y` can be replaced by `_ + _`
    *
    * @param ns
    * @return
    */
  def sum2(ns: List[Int]): Int = foldRight(ns, 0)((x, y) => x + y)

  def product2(ns: List[Double]): Double = foldRight(ns, 1.0)((x, y) => x * y)

  def inc: Int => Int = x => x + 1

  def length[A](ns: List[A]): Int = foldRight(ns, 0)((_, y) => y + 1)

  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(head, tail) => foldLeft(tail, f(z, head))(f)
  }

  @tailrec
  def foldLeft2[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => foldLeft2(xs, z)(f)
  }

  def sum3(ns: List[Double]): Double = foldLeft(ns, 0.0)((x, y) => x + y)

  def product3(ns: List[Double]): Double = foldLeft(ns, 1.0)((x, y) => x * y)

  def reverse[A](xs: List[A]): List[A] = xs match {
    case Nil => xs
    case Cons(x, Nil) => println(xs); Cons(x, Nil)
    case Cons(x, xy) =>  append(reverse(xy), List(x))
  }

}