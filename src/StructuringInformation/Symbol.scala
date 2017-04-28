package StructuringInformation
import com.atomicscala.AtomicTest._
/**
  * musical symbols can be either notes or rests
  */

// A sealed trait definition introduces a new type (here, Symbol), but no constructor for it
// Constructors are defined by alternatives that extend the sealed trait
/*
Data types defined with sealed trait and case classes are called algebraic data types.
An algebraic data type definition can be thought of as a set of possible values.
Algebraic data types are a powerful way to structure information
 */

/*
If a concept of your program’s domain can be formulated in terms of an is relationship,
you will express it with a sealed trait. A symbol is either a note or a rest
On the other hand, if a concept of your program’s domain can be formulated in terms of an has relationship,
you will express it with a case class. A note has a name, a duration and an octave number
 */

sealed trait Symbol
case class someNote(name: String, duration: String, octave: Int) extends Symbol
case class Rest(duration: String) extends Symbol


  object demo extends App {

    val symbol1: Symbol = someNote("C", "Quarter", 3)
    val symbol2: Symbol = Rest("Whole")

    symbol1 is someNote("C", "Quarter", 3)

    def symbolDuration(symbol: Symbol): String =
      symbol match {
        case someNote(name, duration, octave) => duration
        case Rest(duration) => duration
      }

    symbolDuration(symbol1) is "Quarter"
    symbolDuration(symbol2) is "Whole"

  }




