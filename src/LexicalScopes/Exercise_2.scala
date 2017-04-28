package LexicalScopes
import com.atomicscala.AtomicTest._
/**
  * Created by cyn on 28/04/17.
  */
object Exercise_2 extends App {

  object Foo {
    val x = 1
  }
  object Bar {
    val x = 2
  }
  object Baz {
    import Bar.x
    val y = x + Foo.x
  }

  Baz.y is 3



}
