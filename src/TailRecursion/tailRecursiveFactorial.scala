package TailRecursion
import annotation.tailrec
import com.atomicscala.AtomicTest._

/**
  * Created by cyn on 28/04/17.
  */
object tailRecursiveFactorial extends App {

  def factorial(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if (x ==0) result
      else iter(x - 1 , result * x)

    iter(n, 1)
  }

  factorial(3) is 6
  factorial(4) is 24

}
