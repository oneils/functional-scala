package info.devpages.chapter2

import info.devpages.chapter2.Chapter2._
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Aliaksei Bahdanau.
  */
class Chapter2Spec extends FlatSpec with Matchers {

  "A fib" should "return 0 for n=0 input" in {
    fib(0) should be(0)
  }

  it should "return 1 for n=1 input" in {
    fib(1) should be(1)
  }

  it should "return 1 for n=2 input" in {
    fib(2) should be(1)
  }

  it should "retun 2 for n=3 input" in {
    fib(3) should be(2)
  }

  it should "return 5 for n=5 input" in {
    fib(5) should be(5)
  }

  it should "return 144 for n=12" in {
    fib(12) should be(144)
  }

  it should "return 6765 for n=20" in {
    fib(20) should be(6765)
  }

  it should "return 0 for negative input" in {
    fib(-12334343) should be(0)
  }

  "A findFirst" should "return -1 for empty list" in {
    findFirst(Array(), (x: String) => x == "a") should be(-1)
  }

  it should "return 0 for array of with single element" in {
    findFirst(Array("a"), (x: String) => x == "a") should be(0)
  }

  it should "return 2 for hello input" in {
    findFirst(Array("H", "e", "l", "l", "o"), (x: String) => x == "l") should be(2)
  }

  "A isSorted" should "return true for array of a single element" in {
    isSorted(Array(0), (x: Int, y: Int) => x < y) should be(true)
  }

  it should "return true for a sorted ASC array of 2 elements" in {
    isSorted(Array(0, 1), (x: Int, y: Int) => x < y) should be(true)
  }

  it should "return true for a sorted array of 3 elements" in {
    isSorted(Array(0, 1, 2), (x: Int, y: Int) => x < y) should be(true)
  }

  it should "return false for not sorted array of 2 elements" in {
    isSorted(Array(2, 0), (x: Int, y: Int) => x < y) should be(false)
  }

  it should "return false for not sorted array of 3 elements" in {
    isSorted(Array(0, 2, 1), (x: Int, y: Int) => x < y) should be(false)
  }

  it should "return true for array sorted DESC" in {
    isSorted(Array(3, 2, 1, 0), (x: Int, y: Int) => x > y) should be(true)
  }

  it should "return false for not sorted DESC array" in {
    isSorted(Array(3, 1, 2, 0), (x: Int, y: Int) => x > y) should be(false)
  }

}
