package HigherOrderFunctions
import com.atomicscala.AtomicTest._
/**
  * Created by cyn on 03/05/17.
  */

object Introduction extends App {

  /*
  Anonymous functions in source code are called function literals and at run time,
  function literals are instantiated into objects called function values
   */

  def lambda = (x: Int) => x + 1

  def result = lambda(5)

  result is 6

  /*
  A closure is a function which maintains a reference to one or more variables
  outside of the function scope (it "closes over" the variables)
  Scala will detect that you are using variables outside of scope and
  create an object instance to hold the shared variables
   */

  var incrementer = 1

  def closure = { x: Int => x + incrementer }

  val result1 = closure(10)
  result1 is 11

  /*
  We can take that closure and throw it into a method and it will still hold the environment
   */
  def summation(x: Int, y: Int => Int) = y(x)

  incrementer = 3
  val result2 = summation(10, closure)
  result2 is 13

  /*
  Function returning another function
   */

  def addWithoutSyntaxSugar(x: Int): Function1[Int, Int] = {
    new Function1[Int, Int]() {
      def apply(y: Int): Int = x + y
    }

  }

  addWithoutSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] is true
  addWithoutSyntaxSugar(2)(3) is 5
  def fiveAdder: Function1[Int, Int] = addWithoutSyntaxSugar(5)
  fiveAdder(5) is 10

  /*
  Function returning another function using an anonymous function
   */

  def addWithSyntaxSugar(x: Int) = (y: Int) => x + y
  addWithoutSyntaxSugar(1).isInstanceOf[Function1[Int, Int]] is true
  addWithoutSyntaxSugar(2)(3) is 5
  fiveAdder(5) is 10

  /*
  A map method applies the function to each element of a list
   */

  def makeUpper(xs: List[String]) = xs map {
    _.toUpperCase
  }

  def makeWhatEverYouLike(xs: List[String], sideEffect: String => String) =
    xs map sideEffect

  makeUpper(List("abc", "xyz", "123")) is List("ABC", "XYZ", "123")
  makeWhatEverYouLike(List("ABC", "XYZ", "123"), {x => x.toLowerCase}) is List("abc", "xyz", "123")

  // using it in line

  List("Scala", "Erlang", "Clojure") map {
    _.length
  } is List(5, 6, 7)

}
