package info.devpages.chapter4

/**
  * @author Aliaksei Bahdanau
  */
sealed trait Option[+A] {

  /**
    * Apply f if the Option is not None .
    */
  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(a) => Some(f(a))
  }

  /**
    * Apply f , which may fail, to the Option if not None .
    */
  def flatMap[B](f: A => Option[B]): Option[B] = {
    map(f) getOrElse None
  }

  def flatMap1[B](f: A => Option[B]): Option[B] = this match{
    case None => None
    case Some(a) => f(a)
  }

  /**
    * The B >: A says that the B type parameter must be a supertype of A .
    */
  def getOrElse[B >: A](default: => B): B = this match {
    case None => default
    case Some(a) => a
  }

  /**
    * Don’t evaluate ob unless needed.
    */
  def orElse[B >: A](ob: => Option[B]): Option[B] = ???

  /**
    * Convert Some to None if the value doesn’t satisfy f .
    */
  def filter(f: A => Boolean): Option[A] = ???

}

case class Some[A](get: A) extends Option[A]

case object None extends Option[Nothing]
