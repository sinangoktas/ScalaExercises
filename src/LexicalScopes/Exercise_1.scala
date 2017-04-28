package LexicalScopes

/**
  * Created by cyn on 28/04/17.
  */
object Exercise_1 extends App {
  val x = 0
  def f(y: Int) = y + 1
  val result = {
    val x = f(3)
    x * x
  } + x

  println(result)

}
