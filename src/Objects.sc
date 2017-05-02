import com.atomicscala.AtomicTest._

/*
An object is a singleton. One object, that's it. This object is a replacement of static in Java,
and is called upon much in the same way
 */

object Greeting {
  def english = "Hi"

  def espanol = "Hola"

}

Greeting.english is "Hi"
Greeting.espanol is "Hola"

val x = Greeting
x.espanol is "Hola"

val y = x
y.english is "Hi"

val z = Greeting

// Here is the proof that an object is a singleton

x eq y is true
x eq z is true

// eq checks for reference. They are all pointing the same object

/*
An object that has the same name as a class is called a companion object of the class,
and it is often used to contain factory methods for the class that it complements:
 */


