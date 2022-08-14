package ooptutorial

object InheritanceAndTraits extends App{
  
    //Cat is a subclass of Animal
    //Animal is a superclass of Cat
    //Subclass inherits only non-private elements of superclass
    //Protected methods can be used only within a

    class Animal{
        val creatureType = "wild"
        def eat = println("NOM NOM NOM")
        private def poop = println("PRRRRT")
        protected def pee = println("WHOOSH") //Protected methods can be used only within a class and subclasses
    }

    class Cat extends Animal{ 
        def meow = println("MEOW")
        def markTeritory = {
            println("Lifts a leg")
            pee // can use a method from
        }
    }

    val cat = new Cat
    cat.eat
    //cat.poop won't work
    cat.markTeritory

    //for class with parameters we have to ensure that we extend a constructor with right parameters - that could be created
    class Person(name: String, age: Int)
    class Adult(name: String, age: Int, idCard:String) extends Person(name, age)


    //if we want to override a method from superclass we can do so, with `override`

    class Dog extends Animal{
        override def eat: Unit = println("CRUNCH CRUNCH")
        override val creatureType: String = "domestic" //override could be also used in the constructor
        // class Dog(override val creatureType: String) extends Animal is also valid
    }

    val dog = new Dog
    dog.eat

    // We can do a type substitution - broad polymorphism
    val unknownAnimal: Animal = new Dog
    unknownAnimal.eat // although it is of Animal type it would use Dog implementation
    //method call would always go to the most overridden version whenever possible

    //There is a distinction between overRIDING and overLOADING (supplying multiple methods with different 
    //signatures) but with the same name in the same class

    // super
    // super is used when we want to reference a method or a field from parent class

    class Cow extends Animal{
        override def eat: Unit = {
            super.eat 
            println("CRUNCH CRUNCH")
        }
        override val creatureType: String = "domestic" //override could be also used in the constructor
        // class Dog(override val creatureType: String) extends Animal is also valid
    }
    val cow = new Cow
    cow.eat


    // there are ways to prevent overrides
    // 1. using "final". It prevent derived classes from overriding the original method
    // 2. final can be used on the class itself - it prevents entire class from extending
    //      numerical classes in Scala are final for example
    // 3. seal the class - we can extend classes in THIS FILE, but prevents extension in other classes



}
