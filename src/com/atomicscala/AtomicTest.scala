package com.atomicscala
import java.io.FileWriter

import language.implicitConversions

/**
  * Created by cyn on 28/04/17.
  */
class AtomicTest[T](val target: T) {

  val errorLog = "_AtomicTestErrors.txt"
  def tst[E](expected: E)(test: => Boolean) {
    println(target)
    if (test == false) {
      val msg = "[Error] expected:\n" +
        expected
      println(msg)
      val el = new FileWriter(errorLog, true)
      el.write(target + msg + "\n")
      el.close()
    }
  }
  def str = // Safely convert to a String
    Option(target).getOrElse("").toString
  def is(expected: String) = tst(expected) {
    expected.replaceAll("\r\n", "\n") == str
  }
  def is[E](expected: E) = tst(expected) {
    expected == target
  }
  def beginsWith(exp: String) = tst(exp) {
    str.startsWith(
      exp.replaceAll("\r\n", "\n"))
  }
}

object AtomicTest {
  implicit def any2Atomic[T](target: T) =
    new AtomicTest(target)

}
