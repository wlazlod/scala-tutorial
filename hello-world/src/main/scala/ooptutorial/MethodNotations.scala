package ooptutorial
import scala.language.postfixOps
object MethodNotations extends App{
  
    class Person(val name: String, favouriteMovie: String){
        def likes(movie: String): Boolean = movie == favouriteMovie
        def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
        def unary_! : String = s"$name, what the heck!"
        def isAlive: Boolean = true // do not receive parameters
        def apply(): String = s"Hi, my name is $name and I like $favouriteMovie" // 
    }

    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))

    println(mary likes "Inception") //Another syntax of using a method
    //that's called infix notation (or operator notation) - it's an example of syntactic sugar)
    //it works only with methods with single parameter

    val tom = new Person("Tom", "XXX")
    println(mary hangOutWith tom)

    //other operator are also defined like that
    println(1 + 2)
    println(1.+(2))
    //ALL OPERATORS ARE METHODS!!!!

    //unary operators are also methods!
    //unary operators have unary_ prefix

    val x = -1
    val y = 1.unary_-

    // unary_ prefix works only with - + ~ ! operators
    println(!mary)

    // postfix notation:
    println(mary.isAlive)
    println(mary isAlive)

    // apply - special method, which allows to use object like a function
    println(mary.apply())
    println(mary)
}
