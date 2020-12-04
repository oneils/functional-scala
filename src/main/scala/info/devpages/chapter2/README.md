# Introduction to Scala

```scala
    def abs(n: Int): Int =
      if (n < 0) -n
    else n
```

`left-hand side` or `signature` is a declaration of the function, e.g. `def abs(n: Int): Int`
`right-hand side` or `definition` is the code that comes after the equals sign, e.g. `if (n < 0) -n
                                                                                          else n`
# Higher-order functions: passing functions to functions
`higher-order function (HOF)` - function that accepts other functions as arguments.

# Polymorphic functions: abstracting over types
`monomorphic` function - function which operates on only 1 type of data.
`(parametric) polymorphic function` - function which operates on `any` type of data.
`parametric polymorphism` is not related to subtyping or inheritance relations.

`generic` function is a function which is abstracted over the type of the parameter(-s).

`partially applied function` is an expression in which you don't supply all of the arguments needed by the function. 
You supply only some or none of the required arguments.
