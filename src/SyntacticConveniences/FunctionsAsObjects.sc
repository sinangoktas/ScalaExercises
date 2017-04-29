// In fact function values are treated as objects in Scala

// The function type A => B is just an abbreviation for the class scala.Function1[A, B], which is defined as follows

package scala
trait Function1[A, B] {
  def apply(x: A): B
}

/* So functions are objects with apply methods
There are also traits Function2, Function3, ... for functions which take more parameters
 */

// Expansion of Function Values
(x: Int) => x * x // anonymous function

// is expanded to
}
class AnonFun extends Function1[Int, Int] {
  def apply(x: Int) = x * x
}
new AnonFun
}

// or using anonymous class syntax

new Function1[Int, Int] {
  def apply(x: Int) = x * x
}

// Expansion of function calls
/*
A function call, such as f(a, b),
where f is a value of some class type, is expanded to
 */

f.apply(a, b)

val f = (x: Int) => x * x
// OO translation of above would be

val f = new Function1[Int, Int] {
  def appl(x: Int) = x * x
}
f.apply(7)

