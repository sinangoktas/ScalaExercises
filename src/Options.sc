import com.atomicscala.AtomicTest._

val someValue: Option[String] = Some("I am wrapped in something")
someValue is Some("I am wrapped in something")

val emptyValue: Option[String] = None
emptyValue is None

/*
Scala does not have null values. It provides its own
type for representing optional values,
values that maybe present or not. Option[A]
 */

/*
Option[A] is a container for an optional value of type A.
If the value of type A is present, the Option[A] is an instance of Some[A], containing the present value of type A. If the value is absent, the Option[A] is the object None
 */

// Let's write a function that may or not give us a string, thus returning Option[String]

def maybeItWillReturnSomething(flag : Boolean) : Option[String] = {
  if(flag) Some("Found value") else None
}

val value1 = maybeItWillReturnSomething(true)
val value2 = maybeItWillReturnSomething(false)

value1 is Some("Found value")
value2 is None

value1.isEmpty is false
value2.isEmpty is true

// Options can also be used with pattern matching

val aValue: Option[Double] = Some(20.0)
val v = aValue match {
  case Some(v) ⇒ v
  case None ⇒ 0.0
}
v is 20.0
val noValue: Option[Double] = None
val v1 = noValue match {
  case Some(v) ⇒ v
  case None ⇒ 0.0
}
v1 is 0.0

// An option could be looked at as a collection

val number: Option[Int] = Some(3)
val noNumber: Option[Int] = None
val result1 = number.map(_ * 1.5)
val result2 = noNumber.map(_ * 1.5)
result1 is Some(4.5)
result2 is None

/*
Another operation is fold. This operation will extract the value from the option,
or provide a default if the value is None
 */

val r1 = number.fold(0)(_ * 3)
r1 is 9

val r2 = noNumber.fold(0)(_ * 3)
r2 is 0




