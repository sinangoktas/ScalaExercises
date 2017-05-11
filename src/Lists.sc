import com.atomicscala.AtomicTest._

val a = List(1, 2, 3)
val b = List(1, 2, 3)

// eq tests identity (same object)

a eq b is false

// == tests equality (same content)

a == b is true

// Nil lists are identical, even of different types

val a2: List[String] = Nil
val b2: List[Int] = Nil


a2 == b2 is true
a2 eq b2 is true

b2 == Nil is true
b2 eq Nil is true

a2 == Nil is true
a2 eq Nil is true

// Lists can be accessed via head, headOption and tail. Accessing a list via head is unsafe and
// may result in a IndexOutOfBoundsException

a.headOption is Some(1)
a.tail is List(2, 3)

// Lists can be accessed by position

a(0) is 1
a(2) is 3

// Lists are immutable

val c = a.filterNot(v => v == 2) // remove where value is 2

a is List(1, 2, 3)
c is List(1, 3)

// Lists have many useful utility methods

a.length is 3

a.reverse is List(3, 2, 1)

a.map {
  v => v * 2
} is List(2, 4, 6)

a.filter {
  v => v % 3 == 0
} is List(3)

// Functions over lists can use _ as shorthand

a.map(_ * 3) is List(3, 6, 9)

a.filter(_ % 2 != 0) is List(1, 3)

// Lists can be reduced with a mathematical operation

a.reduceLeft(_ + _) is 6
a.reduceLeft(_ * _) is 6

// foldLeft is like reduce, but with an explicit starting value

a.foldLeft(2)(_ + _) is 8
a.foldLeft(4)(_ * _) is 24

// You can create a list from a range

val a3 = (1 to 5).toList
a3 is List(1, 2, 3, 4, 5)

// Lists reuse their tails

val x = Nil
val y = 3 :: x
val z = 2 :: y
val j = 1 :: z

j is List(1, 2, 3)
j.tail is List(2, 3)
z.tail is List(3)
y.tail is Nil












