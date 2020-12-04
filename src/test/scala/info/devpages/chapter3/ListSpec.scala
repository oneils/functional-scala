package info.devpages.chapter3

import info.devpages.chapter3.List._
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Aliaksei Bahdanau.
  */
class ListSpec extends FlatSpec with Matchers {

  "A tail" should "return Nil for empty list" in {
    tail(Nil) should be(Nil)
  }

  it should "remove first element" in {
    tail(List(1, 2, 3)) should be(List(2, 3))
  }

  it should "remove first String element" in {
    tail(List("a", "b", "c")) should be(List("b", "c"))
  }

  "A setHead" should "return list of specified head for empty list" in {
    setHead(Nil, 1) should be(List(1))
  }

  it should "replace the head in non-empty list" in {
    setHead(List(2, 3), 1) should be(List(1, 3))
  }

  it should "replace the head of single element list" in {
    setHead(List(1), 2) should be(List(2))
  }

  "A drop" should "return Nil for empty list" in {
    drop(List(), 2) should be(Nil)
  }

  it should "remove a single element from single element and return empty list" in {
    drop(List(1), 1) should be(Nil)
  }

  it should "remove all elements from list" in {
    drop(List(1, 2, 3, 4), 4) should be(Nil)
  }

  it should "remove specified amount of elements and return list with single element" in {
    drop(List(1, 2, 3, 4), 3) should be(List(4))
  }

  it should "return initial list if n <= 0" in {
    drop(List(1, 3, 4), -4) should be(List(1, 3, 4))
  }

  "A dropWhile" should "return Nil for empty list" in {
    val result = dropWhile(List())(_ => true)
    result should be(Nil)
  }

  it should "delete 1 element from the list" in {
    val result = dropWhile(List(1, 2, 3))(x => x < 2)
    result should be(List(2, 3))
  }

  it should "leave list with single element" in {
    val result = dropWhile(List(1, 2, 3, 4))(x => x < 4)
    result should be(List(4))
  }

  it should "return initial list if predicate condition not satisfied" in {
    val result = dropWhile(List(1, 2, 3, 4))(x => x > 10)
    result should be(List(1, 2, 3, 4))
  }

  "Append" should "return second list if the first list in empty" in {
    append(Nil, List(1, 2, 3)) should be(List(1, 2, 3))
  }

  it should "appends first List to the end of the another List" in {
    append(List(1, 2, 3), List(4, 5, 6)) should be(List(1, 2, 3, 4, 5, 6))
  }

  "Init" should "return empty List for provided empty List" in {
    init(Nil) should be(Nil)
  }

  it should "return empty list for list of a single element" in {
    init(List(1)) should be(Nil)
  }

  it should "return List with single element for provided List of 2 elements" in {
    init(List(1, 2)) should be(List(1))
  }

  it should "return a list without last element in reversed order" in {
    init(List(1, 2, 3, 4)) should be(List(1, 2, 3))
  }

  "Length" should "return 0 for empty list" in {
    List.length(Nil) should be (0)
  }

  it should "return 1 for list with single element" in {
    List.length(List("ab")) should be(1)
  }

  it should "return 3 for list with 3 elements" in {
    List.length(List(10, 2, 3, 40)) should be(4)
  }

  "reverse" should "return Nil for empty list" in {
    List.reverse(Nil) should be (Nil)
  }

  it should "reverse List of 1 elements" in {
    List.reverse(List(1)) should be (List(1))
  }

  it should "reverse List of 2 elements" in {
    List.reverse(List(1, 2)) should be (List(2, 1))
  }

  it should "reverse List " in {
    List.reverse(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) should be (List(10, 9, 8, 7, 6, 5, 4, 3, 2, 1))
  }

  //
  //  "A transform" should "return Nil empty list" in {
  //    List.transform(List()) should be (Nil)
  //  }
  //
  //  it should "return a list of a element incremented by 1" in {
  //    List.transform(List(1)) should be (List(2))
  //  }
  //
  //  it should "return a list of 2 elements incremented by 1" in {
  //    List.transform(List(1, 2)) should be (List(2, 3))
  //  }
  //
  //  it should "return a list of 3 elements incremented by 1" in {
  //    List.transform(List(0, 1, 2)) should be (List(1, 2, 3))
  //  }
  //
  //  "A double2String" should "return Nil for empty list" in {
  //    List.double2String(List()) should be (Nil)
  //  }
  //
  //  it should "transform a list of 1 number to a list with 1 string" in {
  //    List.double2String(List(10.0)) should be (List("10.0"))
  //  }
  //
  //  it should "transform a list of doubles to the list of strings" in {
  //    List.double2String(List(0.0, 14.0, 3.0)) should be (List("0.0", "14.0", "3.0"))
  //  }
}
