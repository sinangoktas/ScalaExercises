package StructuringInformation
import com.atomicscala.AtomicTest._
/**
  * Created by cyn on 28/04/17.
  */
sealed trait Duration
case object Whole extends Duration
case object Half extends Duration
case object Quarter extends Duration

/*
It is generally a bad idea to work with a model that makes it possible to reach invalid states as in Note.scala
Note names can easily be set to an invalid note name. Note names are in fact consists of A,B,C,D,E,F,G only.
In our case, we want to restrict the possible durations to a set of fixed alternatives. Whole, Half and Quarter...
We can express the fact that durations are a fixed set of alternatives by using a sealed trait,
but in contrast to the Symbol.scala, alternatives are not case classes because they aggregate no information.
 */

object testDuration extends App {

  def fractionOfWhole(duration: Duration) : Double =
    duration match {
      case Whole => 1.0
      case Half => 0.5
      case Quarter => 0.25
    }

  fractionOfWhole(Whole) is 1.0
  fractionOfWhole(Half) is 0.5
}
