package info.devpages.chapter4

import info.devpages.chapter3.List._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
  * @author Aliaksei Bahdanau.
  */
class OptionSpec extends AnyFlatSpec with Matchers {

  "A map" should "apply function for existing Option" in {
    Some("test").map(t => t.length) should be(Some(4))
  }

  it should "not apply function when the Option is None" in {
    val result: Option[String] = None
    result.map(t => t.length) should be(None)
  }


  "A flatMap" should "apply function for Option if not None" in {
    Some("test").flatMap(t => Some(t.length)) should be(Some(4))
  }

  it should "not apply function when the Option is None" in {
    val result: Option[String] = None
    result.flatMap(t => Some(t.length)) should be(None)
  }


  "A getOrElse" should "return given default value when Option is None" in {
    val result: Option[String] = None
    result.getOrElse("Expected result") should be("Expected result")
  }

  it should "return the result which inside Some case of the Option" in {
    Some("test").getOrElse("It's default value") should be("test")
  }

  "A orElse" should "return the second Option if first Option is not defined" in {
    val result: Option[String] = None
    result.orElse(Some("Expected result")) should be(Some("Expected result"))
  }

  it should "return the first Option if its present" in {
    Some("test").orElse(Some("It's default value")) should be(Some("test"))
  }

  "A filter" should "return Some if the value satisfy f" in {
    Some(4).filter( x => x == 4) should be(Some(4))
  }
}
