package ooptutorial

object Objects extends App{

    // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
    // Equivalent of this are Objects
    // Objects do not receive parameters!
    //Scala object = SINGLETON INSTANCE
    object Person{ //type + its only instance
        val N_EYES = 2
        def canFly: Boolean = false
        
        // factory method
        def apply(mother: Person, father: Person): Person = new Person("Bobbie")
    }

    // We can have objects and classes of the same name to separate instance level functionality 
    // from "static"/"class" - level one
    class Person(val name: String){
        
    }
    //This type is called COMPANIONS

    println(Person.N_EYES)
    println(Person.canFly)

    //Scala object = SINGLETON INSTANCE

    val mary = new Person("Mary")
    val john = new Person("John")
    val bobbie = Person(mary, john) // with factory method we can create objects without using new

    //Scala Applications = Scala Objects with:
    //def main(args: Array[String]): Unit
    //It has to be done this way, because Scala applications are turned to JVM Applications,
    //whose entry points have to be public static void main with an array of string as a parameter
}
