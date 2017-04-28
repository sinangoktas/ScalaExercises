package StructuringInformation
import com.atomicscala.AtomicTest._
/**
  * Created by cyn on 28/04/17.
  */
case class Note(name: String, duration: String, octave: Int)

// This definition introduces a new type, Note
// You can create values of this type by calling its constructor

object testNote extends App {

  val c3 = Note("C", "Quarter", 3)
  c3.duration is "Quarter"
  c3.name is "C"
  c3.octave is 3

  // comparing case class instances compare their values

  val otherC3 = Note("C", "Quarter", 3) // different object to c3
  c3 == otherC3 is true // value equality
  c3 equals otherC3 is true // value equality
  c3 eq otherC3 is false // reference equality
  c3 ne otherC3 is true  // reference equality








}