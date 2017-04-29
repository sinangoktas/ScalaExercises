import com.atomicscala.AtomicTest._

Range(1, 10, 2)
case class Range(start: Int, end: Int, step: Int)
Range(start = 1, end = 10, step = 2)

case class Range2(start: Int, end: Int, step: Int = 2)
val xs = Range2(start = 1, end = 10)
xs.step is 2

// Repeated Parameters
def average(x: Int, xs: Int*) : Double =
  (x :: xs.to[List]).sum.toDouble / (xs.size + 1)

average(1) is 1.0
average(1, 2) is 1.5
average(1,2,6) is 3



// Type aliases

/*
In the same way as you can give meaningful names to expressions,
you can give meaningful names to type expressions
 */


type Result = Either[String, (Int, Int)]
def divide(dividend: Int, divisor: Int) : Result =
  if(divisor == 0) Left("Division by Zero")
  else Right(dividend / divisor, dividend % divisor)

divide(6, 4) is Right(1, 2)
divide(2, 0) is Left("Division by Zero")
divide(8, 4) is Right(2, 0)



