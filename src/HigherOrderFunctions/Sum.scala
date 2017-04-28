package HigherOrderFunctions
import com.atomicscala.AtomicTest._

/**
  * Created by cyn on 29/04/17.
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


