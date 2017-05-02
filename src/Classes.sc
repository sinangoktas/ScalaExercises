import com.atomicscala.AtomicTest._

class Point(x: Int, y: Int) {
  override def toString = "(" + x + ", " + y + ")"
}

/*
Classes in Scala are static templates that can be instantiated into many objects at runtime
 */

/*
Classes in Scala are parameterized with constructor arguments. The code above defines two constructor arguments, x and y; they are both visible in the whole body of the class
 */


object Classes {
  def main(args: Array[String]): Unit = {
    val pt = new Point(1, 2)
    pt is (1, 2)
  }
}

/*
The program defines an executable application Classes in the form of a top-level singleton object with a main method. The main method creates a new Point and stores it in value pt
 */

class ClassWithValParameter(val name: String)
/*
Value parameters automotically creates an internal property
 */

val aClass = new ClassWithValParameter("Gandalf")
aClass.name is "Gandalf"

/*
An object that has the same name as a class is called a companion object of the class,
and it is often used to contain factory methods for the class that it complements:
 */

class Movie(val name: String, val year: Short)

object Movie {

  def academyAwardBestMoviesForYear(x: Short) = {
    /*This is a match statement,
    more powerful than a Java switch statement */
    x match {
      case 1930 => Some(new Movie("All Quiet On the Western Front", 1930))
      case 1931 => Some(new Movie("Cimarron", 1931))
      case 1932 ⇒ Some(new Movie("Grand Hotel", 1932))
      case _ => None
    }
  }

}

Movie.academyAwardBestMoviesForYear(1932).get.name is "Grand Hotel"
Movie.academyAwardBestMoviesForYear(1933) is None


/*
A companion object can also see private values and
variables of the corresponding classes' instantiated objects
 */

class Person(val name: String, private val superHeroName: String)
object Person {
  def showMeInnerSecret(x: Person) = x.superHeroName
}

val clark = new Person("Clark Kent", "Superman")
Person.showMeInnerSecret(clark) is "Superman"