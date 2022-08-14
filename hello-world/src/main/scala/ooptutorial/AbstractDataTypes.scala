package ooptutorial

object AbstractDataTypes extends App{
  

    // abstract
    abstract class Animal {
        val creatureType: String
        def eat: Unit
    }
    // abstract classes cannot be instantiated
    // they are made to be extended later

    class Dog extends Animal{
        override val creatureType: String = "Canine"
        override def eat: Unit = println("CRUNCH CRUNCH")
    }
    // override isn't necessary for extending animal
    class Cat extends Animal{
        val creatureType: String = "Felis"
        def eat: Unit = println("CHONK CHONK")
    }

    //Traits
    trait Carnivore{
        def eat(animal: Animal): Unit 
        // method is absract by default
    }
    //Unlike abstract classes, they can be inherited along classes

    class Crocodile extends Animal with Carnivore {
        val creatureType: String = "Croc"
        def eat: Unit = println("NOM NOM NOM")
        def eat(animal: Animal): Unit = println(f"Before that $creatureType eats your ${animal.creatureType} give that $creatureType a banana")
    }

    val croc = new Crocodile
    val dog = new Dog
    croc.eat(dog)

    //Abstract classess and traits can have both abstract and non abstract values and methods
    trait CarnivoreAgain{
        def eat(animal1: Animal, animal2: Animal): Unit 
        // method is absract by default
        val preferredMeal: String = "Fresh meat"
    }

    //Difference between abstract classes and traits are 
    //1. traits cannot have constructor parameters
    //2. we can extend only one class (abstract or not), but have multiple traits
    //3. traits describe a type of behaviour, abstract class is a type of thing


    //Scala Type Hierarchy
    //scala.Any - mother of all Types
    //  scala.AnyRef - which is mapped to java's object type. All classess we will use will derive from AnyRef, unless we explicitly say to extent some other class
    //      String, List, Set .... all derive from AnyRef. If we will create a clas it will by default derive from AnyRef
    //          scala.Null - derive from all of scala objects. It's only reference is the Null reference. Thanks to that we can replace any type of object with Null.
    //  scala.AnyVal - contain al the primitive types (Int, Unit, Boolean, Float,...)
    //              scala.Nothing derives from all of them - it can replace everything. It means no instance at all


    abstract class MyList {

        def head: Int
        def tail: MyList
        def isEmpty: Boolean
        def add(element: Int): MyList 
        def printElements: String 
        //polymorphic call
        override def toString(): String = f"[ $printElements ]" // thanks to that we dont fave to implement 
    }

    object EmptyList extends MyList {
        def head: Int = throw new NoSuchElementException //  that means Nothing
        def tail: MyList = throw new NoSuchElementException
        def isEmpty: Boolean = true
        def add(element: Int): MyList = new ConsList(element, EmptyList)
        def printElements: String = ""
    }

    //  '???'' means Nothing

    class ConsList(h: Int, t: MyList) extends MyList {
        def head: Int = h 
        def tail: MyList = t
        def isEmpty: Boolean = false
        def add(element: Int): MyList = new ConsList(element, this)
        def printElements: String = {
            if (t.isEmpty) f"$h"
            else f"$h ${t.printElements}"
        }
    }

    val list = new ConsList(1, EmptyList)
    val list2 = new ConsList(3, new ConsList(2, list))
    println(list2)
}
