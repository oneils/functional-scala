# Referential transparency (RT)
The expression is `referentially transparent` if the expression can be replaced by its result without changing  the
meaning of the program. 

The function is `pure` if calling it with `RT` arguments is also RT.

## Referential transparency and purity
An expression `e` is `referentially transparent` if, for all programs `p`, all occurrences of `e`
in `p` can be replaced by the result of evaluating `e` without affecting the meaning of `p`.
A function `f` is pure if the expression `f(x)` is referentially transparent (`RT`) for all referentially transparent `x`

## Substitution model
`Substitution Model` - everything the function does is represented by the `value` that it returns, according to the type 
of the function.