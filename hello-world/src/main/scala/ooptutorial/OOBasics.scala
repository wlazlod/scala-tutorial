package ooptutorial

object OOBasics extends App{
  
    val man = new Man("Daniel", 29)
    println(man)
    val person = new Person("John", 26)
    println(person.name)
    person.greet("Agata")
    person.greet()
    person.printName()

}

class Man(name: String, age: Int) // constructor
// age and name are class parameters but not class members!
// to convert parameters to members we have to add val

class Person(val name: String, val age: Int)
{
    val x: Int = 2 // val are fields
    println("PERSON")  // at every instantiation of the class the whole block of code is evaluated


    //method
    def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
    // this - access class parameter/field 
    // used mostly when class and method parameters have the same name
    def printName(): Unit = println(s"My name is $name")
    // when there is no ambigiuity we can ommit this.

    //overloading is allowed in Scala
    def greet(): Unit = println(s"$name says: Hi!")

    //multiple constructors - with this
    def this(name: String) = this(name, 0) // auxuliary constractor has to be a constructor and nothing else
    // because of that they can be ommited by simply having default value of a parameter
}


class Writer(val firstName: String, val surname: String, val year: Int)
{
    def fullName = s"$firstName $surname"
}
class Novel(val name: String, val year: Int, val author: Writer)
{
    def authorAge(): Int = this.year - author.year
    def isWrittenBy(author: Writer): Boolean = {
        ((this.author.firstName == author.firstName) && (this.author.surname == author.surname) && (this.author.year == author.year))
    }
    def copyNovel(year: Int): Novel = new Novel(this.name, year, this.author)
}

class Counter(val curVal: Int = 1)
{
    def currentCount: Int = curVal
    def decrement: Counter = new Counter(curVal - 1) // immutability. Instances are fixed. They cannot be changed during it's lifetime
    def increment: Counter = new Counter(curVal + 1)

    def increment(n: Int): Counter = {
        if (n<=0) this
        else increment.increment(n-1)
    }

    def decrement(n: Int): Counter = {
        if (n<=0) this
        else decrement.decrement(n-1)
    }

}
