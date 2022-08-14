package ooptutorial

object AnonymousClasses extends App {
  
    abstract class Animal {
        def eat: Unit
    }

    val funnyAnimal: Animal = new Animal {
        override def eat: Unit = println("MWAHAHAHAHA")
    }
    // We didn't instatiated an abstract class. We instatiated a real class
    // It is called an anonymous class

    funnyAnimal.eat
    println(funnyAnimal.getClass())
    // class ooptutorial.AnonymousClasses$$anon$1

    // It is the same as:
    /*
    class AnonymousClasses$$anon$1 extends Animal {
        override def eat: Unit = println("MWAHAHAHAHA")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1 
    */

    // We can do so even for not generic classes:
    class Person (name: String) {
        def sayHi: Unit = println(s"Hi, it's $name")
    }

    val jim = new Person("Jim") { // for classes with constructors with parameters, we must pass the parameter before overriding
        override def sayHi: Unit = println("Fuck you, Jim!")
    }

    jim.sayHi
}
