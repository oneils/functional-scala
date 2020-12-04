package info.devpages.chapter2

/**
  * @author Aliaksei Bahdanau.
  */
object Chapter2 {

  def factorial(n: Int): Int = {
    @scala.annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, n * acc)
    }

    go(n, 1)
  }

  def abs(n: Int) = if (n < 0) -n else n

  private def fromatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(x: Int) = {
    val msg = "The factorial of %d is %d"
    msg.format(x, factorial(x))
  }

  def formatResult(name: String, n: Int, f: Int => Int): String = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }


  def fib(n: Int): Int = {
    if (n <= 0) 0
    else if (n == 1) 1
    else fib(n - 1) + fib(n - 2)
  }

  // Monomorphic or polymorphic functions

  /**
    * returns the first index in an array where the key occurs, or -1 if it’s not found
    *
    * @param ss
    */
  def findFirst[A](ss: Array[A], p: A => Boolean): Int = {
    def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if (p(ss(n))) n
      else loop(n + 1)
    }

    loop(0)
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def go(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if (!ordered(as(n), as(n + 1))) false
      else go(n + 1)
    }

    go(0)
  }

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = {
    b => f(a, b)
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
    a => b => f(a, b) // f(a, b) - returns C
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    (a, b) => f(a)(b)
  }

  /**
    * Composes two functions.
    */
  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    a => f(g(a))
  }
}
