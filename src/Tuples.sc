import java.util.Date

import com.atomicscala.AtomicTest._

val t = (1, "hello", Console)

// Which is syntactic sugar(short cut) for the following

val t2 = Tuple3(1, "hello", Console)

/*
Scala tuple combines a fixed number of items together so that they can be passed around as a whole
 Unlike an array or list, a tuple can hold objects with different types but they are also immutable
 */

val tuple = ("apple", "dog")
val animal = tuple._2
val fruit = tuple._1

animal is "dog"
fruit is "apple"

// Tuples may be of mixed types

val tuple5 = ("a", 1, 2.2, new Date(), "five")

tuple5._2 is 1
tuple5._5 is "five"

/*
You can assign multiple variables at once using tuples
 */

val student = ("Cyn Goktas", 38, 3.5)
val(name, age, gpa) = student

name is "Cyn Goktas"
age is 38


/*
The swap method can be used to swap the elements of a Tuple2
 */

val tupl = ("apple", 3).swap
tupl._1 is 3



