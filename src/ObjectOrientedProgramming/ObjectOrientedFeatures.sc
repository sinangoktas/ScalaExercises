import com.atomicscala.AtomicTest._

import scala.math._

// RATIONAL ADDITION
/*
def addRationalNumerator(n1: Int, d1: Int, n2: Int, d2: Int): Int
def addRationalDenominator(n1: Int, d1: Int, n2: Int, d2: Int): Int
It would be difficult to manage all these numerators and denominators!
A better choice is to combine the numerator and denominator of a rational number in a data structure
 */

// CLASSES

class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y
}

// a new type rational and a constructor {} to create elements of this type

/*
Scala keeps the names of types and values in different namespaces.
So there's no conflict between the two definitions of Rational
 */

// OBJECTS

/*We call the elements of a class type objects
We create an object by prefixing an application of the constructor of the class with the operator new
 */

new Rational(1, 2)

// MEMBERS OF AN OBJECT

val x = new Rational(1, 2)
x.numer is 1
x.denom is 2

// IMPLEMENTING RATIONAL ARITHMETIC

def addRational(r: Rational, s: Rational): Rational =
  new Rational ( r.numer * s.denom + s.numer * r.denom,
    r.denom * s.denom)
def makeString(r: Rational) =
  r.numer + "/" + r.denom

makeString(addRational(new Rational(1, 2), new Rational(2, 3)))


// METHODS

class Rasionel(x: Int, y: Int) {
  // We can set a precondition by calling the require function
  require(y > 0, "denominator must be positive")
  def numer = x
  def denom = y
  require(y > 0, "denominator must be positive")

  def add(r: Rasionel) =
    new Rasionel(numer * r.denom + r.numer * denom, denom * r.denom)
  override def toString = numer + "/" + denom
}

val a = new Rasionel(1, 3)
val b = new Rasionel(5, 7)
a.add(b) is "22/21"

// ASSERTION
/*
 Assert also takes a condition and
  an optional message string as parameters
  */

val p = sqrt(9)
assert(p >= 0, "optional text goes here")


// CONSTRUCTORS
/*
In Scala, a class implicitly introduces a constructor.
This one is called the primary constructor of the class
Takes the parameters of the class and executes all statements in the class body
 */
/*
Scala also allows the declaration of auxiliary constructors.
These are methods named this.
 */

// primary constructor
class Pizza (var crustSize: Int, var crustType: String) {

  // one-arg auxiliary constructor
  def this(crustSize: Int) {
    this(crustSize, "Thin")
  }

  // one-arg auxiliary constructor
  def this(crustType: String) {
    this(12)
  }

  // zero-arg auxiliary constructor
  def this() {
    this("Thin")
  }
  override def toString = s"A $crustSize inch pizza with a $crustType crust"
}

// same pizzas created as below
// each auxiliary constructor calls the previous aux constructor

val p1 = new Pizza(12, "Thin")
val p2 = new Pizza(12)
val p3 = new Pizza("Thin")
val p4 = new Pizza

// ABSTRACT CLASSES

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}

/*Abstract classes can contain members which are missing an implementation
Consequently, no instances of an abstract class can be created with the operator new
 */

// CLASS EXTENSIONS

/*
Let's consider implementing sets as binary trees
There are two types of possible trees:
a tree for the empty set, and a tree consisting of an integer and two sub-trees
 */

class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
}

/*
If no superclass is given, the standard class Object in the Java package java.lang is assumed.
The direct or indirect superclasses of a class C are called base classes of C.
So, the base classes of NonEmpty are IntSet and Object
 */


// OBJECT DEFINITIONS

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
}

/*
This defines a singleton object named Empty.
No other Empty instances can be (or need to be) created.
Singleton objects are values, so Empty evaluates to itself.
 */

// Implementation and Overriding

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3
}

// It is also possible to redefine an existing, non-abstract definition in a subclass by using override

// TRAITS

/*In Scala, a class can only have one superclass.
But what if a class has several natural supertypes to which it conforms or from which it wants to inherit code?
Here, you could use traits.
A trait is declared like an abstract class, just with trait instead of abstract class.
*/
trait Planar {
  def height: Int
  def width: Int
  def surface = height * width
}

class Square extends Shape with Planar with Movable   ....


