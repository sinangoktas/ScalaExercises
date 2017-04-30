import com.atomicscala.AtomicTest._

class BankAccount {

  private var balance = 0

  def deposit(amount: Int): Unit = {
    if (amount > 0) balance = balance + amount
  }

  def withdraw(amount: Int): Int =
    if (0 < amount && amount <= balance) {
      balance = balance - amount
      balance
    } else throw new Error("insufficient funds")
}

case class Note(name: String, duration: String, octave: Int)

val aliceAccount = new BankAccount
val bobAccount = new BankAccount

aliceAccount == bobAccount is false

val c3 = Note("C", "Quarter", 3)
val cThree = Note("C", "Quarter", 3)

c3 == cThree is true

/*
In the above example, the same definitions of bank accounts lead to different values,
whereas the same definitions of notes lead to equal values.
 */

/*
the value of BankAccount can change over time
whereas the value of a Note is immutable.
 */

/*
In Scala, by default, comparing objects will compare their identity,
but in the case of case class instances, the equality is redefined to compare the values of the aggregated information
 */

/*
It turns out that case classes are just a special case of classes,
whose purpose is to aggregate several values into a single value
 */

/*
When we define a case class,
the Scala compiler defines a class enhanced with some more methods and a companion object.
 */

