## Defining functional data structure

Additing arameter `[+A]` after sealed trait List and then using that `A` parameter inside of `Cons` data constructor declares the `List` 
 data type to be `polymorphic` in the type of elements.
 
 `+` indicates that the type parameters `A` is `covariant` or `positive` parameter of `List`.
 This means that, for instance, `List[Dog]` is considered a subtype of List[Animal],
 assuming `Dog` is a subtype of `Animal`.
 it allows to declare such data types:
 
 ```scala
val ex1: List[Double] = Nil
val ex2: List[Int] = Cons(1, Nil)
val ex3: List[String] = Cons("a", Cons("b", Nil))
```

More generally about covariance:
For all types `X` and `Y`, if `X` is a subtype of `Y`, then `List[X]` is a subtype of `List[Y]`
But notice now that Nil extends `List[Nothing]`. `Nothing` is a subtype of all types,
which means that in conjunction with the variance annotation, `Nil` can be considered
a `List[Int]`, a `List[Double]`, and so on, exactly as we want.

### Variadic function
`apply` is a Variadic function in `List`, meaning it acceppts zero or more arguments of type `A`
In other words it mean we can construct instances of the data type (`list literals`) like:

```scla
List(1, 2, 3, 4)
List("aaa", "bbbb")
```

`Variadic` functions - are syntetic sugar for creating and passing a `Seq` of elements explicitly.
Inside `apply`, the argument `as` will be bound to a `Seq[A]` which has the functions `head` (returns the first element) and `tail` (returns all
elements but the first). The special `_*` type annotation allows us to pass a `Seq` to a variadic method.

### Data sharing in functional data structures
When we add an element `a` to the front of an existing list `xs`, we return a new list (`Cons("s", xs)`).
 Since lists are immutable, we don't need to actuallu copy `xa`, we can just reuse it - `DATA SHARING`
 
Functional data structures are `persistent` - existing references are never changed be operations on the data structure.


For `curried` functions see `Chapter 2`???