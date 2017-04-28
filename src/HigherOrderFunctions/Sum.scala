package HigherOrderFunctions
import com.atomicscala.AtomicTest._

/**
Functional languages treat functions as first-class values.
This means that, like any other value, a function can be passed as a parameter and returned as a result.
This provides a flexible way to compose programs.
Functions that take other functions as parameters or that return functions as results are called higher order functions.
  */
object Sum extends App {

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(x: Int, acc: Int): Int = {
      if (x > b) acc
      else loop(x + 1, acc + f(x))
    }
    loop(a, 0)
  }
  sum(x => x, 1, 10) is 55

  // tail recursive
  // sum() takes an anonymous function f(takes an int as argument and returns the same int),
  // and a:Int and b: Int as arguments
  // a = 1, b = 10 then
  // loop(a, 0) > x = a = 1, acc = 0
  // 1+2+3+ ......... + 10 = 55




}


