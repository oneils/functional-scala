def mean(xs: Seq[Double]): Double =
  if (xs.isEmpty)
    throw new ArithmeticException("xs is empty")
  else xs.sum / xs.length