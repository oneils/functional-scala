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
  def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
    case None => None
    case Some(_) => ob
  }

  /**
    * Convert Some to None if the value doesn’t satisfy f .
    */
  def filter(f: A => Boolean): Option[A] = this match {
    case Some(a) if f(a) => Some(a)
    case _ => None
  }

  /**
    * Implementing filter by using flatmap
    */
  def filter1(f: A => Boolean): Option[A] = {
    flatMap(a => if (f(a)) Some(a) else None)
  }

  def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f

  /**
    * combines a list of Options into one Option containing
    * a list of all the Some values in the original list. If the original list contains None even
    * once, the result of the function should be None; otherwise the result should be Some
    * with a list of all the values
    *
    */
  def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
    case Nil => None
    case h :: t => h flatMap (hh => sequence(t) map (hh :: _))
  }
}

case class Some[A](get: A) extends Option[A]

case object None extends Option[Nothing]
