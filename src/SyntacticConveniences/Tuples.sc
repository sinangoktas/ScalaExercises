import com.atomicscala.AtomicTest._
/*
We saw earlier that case classes are useful to aggregate information. However,
sometimes you want to aggregate information without having to define a complete case class for it.
In such a case you can use tuples.
 */

def pair(i: Integer, s: String): (Int, String) = (i, s)

pair(42, "foo") is (42, "foo")

val is: (Int, String) = (42, "foo")

is match {
  case (i, s) =>
    i is 42
    s is "foo"
}
// Or,

val (i, s) = is
i is 42
s is "foo"

// Or,

is._1 is 42
is._2 is "foo"

