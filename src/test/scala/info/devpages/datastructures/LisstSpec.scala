package info.devpages.datastructures

import info.devpages.datastructures.List._
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Aliaksei Bahdanau.
  */
class LisstSpec extends FlatSpec with Matchers {

  "A tail" should "return Nil for empty list" in {
    tail(Nil) should be(Nil)
  }

  it should "remove first element" in {
    tail(List(1, 2, 3)) should be(List(2, 3))
  }

  "A setHead" should "return list of specified head for empty list" in {
    setHead(List(), 1) should be(List(1))
  }

  it should "replace the head of single element list" in {
    setHead(List(1), 2) should be(List(2))
  }

  it should "replace the head of list of three elements" in {
    setHead(List(1, 2, 3), 4) should be(List(4, 2, 3))
  }

  "A drop" should "return Nil for empty list" in {
    drop(List(), 2) should be(Nil)
  }

  it should "return a list for numberOfElementsToRemove <= 0" in {
    val list = List(1, 2, 3)

    drop(list, -1) should be(list)
  }

  it should "remove 3 elements from list of 3 elements" in {
    drop(List(1, 2, 3), 3) should be(Nil)
  }

  "A dropWhile" should "return Nil for empty list" in {
    val predicate = (x: Int) => x < 4
    val result = dropWhile(List())(predicate)

    result should be(Nil)
  }

  it should "delete 1 element from the list" in {
    //    val result = dropWhile(List(1, 2, 3), (x: Int) => x < 2) -- old way
    val result = dropWhile(List(1, 2, 3))(x => x < 2)

    result should be(List(2, 3))
  }

  "A product" should "return 1.0 for empty lst" in {
    List.product(List()) should be(1.0)
  }

  it should "return zero if list contains 0" in {
    List.product(List(1, 2, 0, 4, 5)) should be(0)
  }

  it should "return 6 for list" in {
    List.product(List(1, 2, 3)) should be(6)
  }

  "A length" should "return zero for empty list" in {
    List.length(List()) should be (0)
  }

  it should "return 2 for list with 2 elements" in {
    List.length(List(0, 1)) should be (2)
  }

  "A transform" should "return Nil empty list" in {
    List.transform(List()) should be (Nil)
  }

  it should "return a list of a element incremented by 1" in {
    List.transform(List(1)) should be (List(2))
  }

  it should "return a list of 2 elements incremented by 1" in {
    List.transform(List(1, 2)) should be (List(2, 3))
  }

  it should "return a list of 3 elements incremented by 1" in {
    List.transform(List(0, 1, 2)) should be (List(1, 2, 3))
  }

  "A double2String" should "return Nil for empty list" in {
    List.double2String(List()) should be (Nil)
  }

  it should "transform a list of 1 number to a list with 1 string" in {
    List.double2String(List(10.0)) should be (List("10.0"))
  }

  it should "transform a list of doubles to the list of strings" in {
    List.double2String(List(0.0, 14.0, 3.0)) should be (List("0.0", "14.0", "3.0"))
  }
}
