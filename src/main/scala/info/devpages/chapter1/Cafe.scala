package info.devpages.chapter1

/**
  * Exmaple of functional approach for implementing Cafe.
  *
  * @author Aliaksei Bahdanau.
  */
class Cafe {

  def buyCoffee(cc: CreaditCard): (Coffee, Charge) = {
    val cup = new Coffee()

    (cup, Charge(cc, cup.price))
  }

  def buyCoffees(cc: CreaditCard, n: Int): (List[Coffee], Charge) = {
    val purchases = List.fill(n)(buyCoffee(cc))
    val (coffees, charges) = purchases.unzip
    (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
  }

  /**
    * Takes a list of charges, groups them by the credit card used, and then combines them into a single charge per card.
    *
    * @param charges a [[List]] of [[Charge]]s
    * @return [[Charge]]s grouped by Credit card.
    */
  def coalesce(charges: List[Charge]): List[Charge] = {
    charges.groupBy(_.cc).values.map(_.reduce(_ combine _)).toList
  }

}

case class Charge(cc: CreaditCard, amount: Double) {
  def combine(other: Charge): Charge = {
    if (cc == other.cc) Charge(cc, amount + other.amount)
    else throw new Exception("Can't combine chrages to different cards")
  }
}

// Classes below doesn't require the implementation.

class CreaditCard {
  def charge(price: Double): Coffee = ???
}

class Coffee {
  val price: Double = ???
}

class Payments {
  def charge(cc: CreaditCard, price: Double) = ???
}