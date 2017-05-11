package LexicalScopes
import com.atomicscala.AtomicTest._

/**
  * The definitions inside a block are only visible from within the block
  *
  */
object Exercise_1 extends App {
  val x = 0
  def f(y: Int) = y + 1
  val result = {
    val x = f(3)
    x * x
  } + x

  result is 16


}
