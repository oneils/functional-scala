package info.devpages.chapter4

//hide std library `Option` and `Either`, since we are writing our own in this chapter

import scala.{Option => _, Either => _, _}

trait Option[+A] {

  /**
    * Apply f if the Option is not None
    *
    * @param f function to be applied
    * @tparam B
    * @return
    */
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(x) => Some(f(x))
  }

  /**
    * Apply f, which may fail, to the Option if not None
    *
    * @param f function to be applied
    * @tparam B
    * @return
    */
  def flatMap[B](f: A => Option[B]): Option[B] = this match {
    case Some(x) => f(x)
    case None => None
  }

  // B >: A mean that B is a supertype of A.
  // default :=> B indicates that argument of type B and it won't be evaluated until it's needed by the function.
  def getOrElse[B >: A](default: => B): B = this match {
    case None => default
    case Some(x) => x
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
    case None => ob
    case Some(x) => Some(x)
  }

  def filter(f: A => Boolean): Option[A] = this match {
    case Some(x) if f(x) => this
    case _ => None
  }
}


case class Some[A](get: A) extends Option[A]

case object None extends Option[Nothing]



object Option {
  // Exaample of implementation of total function for mean: it take each value of input type to exactly one value of output type
  def mean (xs: Seq[Double] ): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)
}


