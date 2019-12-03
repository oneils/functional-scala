# About 

This package is for Chapter 4: `Handling errors without exceptions`.

All implementations and examples could be found under `main/scala/info.devpages/chapter4` folder.
Also there're tests for solved exercises which are here: `test/scala/indo.devpages/chapter4`

After completion of the chapter it will be clear how to use standard library versions of `Option` and `Either`.

Exceptions break referential transparency. Meaning of `RT` expressions  `does not depend on cotext` whereas the meaning of
`non RT` expressions `is context dependent` and requires more global reasoning.

The main exceptions benefit: `consolidation` and `centralization of error handling logic`.

```scala
def mean(xs: Seq[Double]): Double =
  if (xs.isEmpty)
    throw new ArithmeticException("xs is empty")
  else xs.sum / xs.length
```

`mean` is a partial function because it's not defined for some inputs.

### Usage sscenarios for Option's functions

`map` function can be used to transform the result inside an Option, if its exists.  We can think of it as proceeding with a computation on the
assumption that an error hasn’t occurred; it’s also a way of deferring the error handling to later code.
