package ooptutorial

object Generics extends App{

    class TestList[A] { // class is parametrized with type A - A denotes generic type
        
    }
    val listOfIntegers = new TestList[Int]
    val listOfStrings = new TestList[String]
    
    //We can have also classes with two parameters:
    class MyMap[Key, Value]

    //Generic methods
    object TestList {
        def empty[A]: TestList[A] = ???
    }

    val emptyListOfIntegers = TestList.empty[Int]

    // variance problem
    class Animal
    class Cat extends Animal
    class Dog extends Animal

    // 1. yes, List[Cat] extends List[Animal] - COVARIANCE
    class CovariantList[+A]
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat]
    // anmialList.add(new Dog) ??? HARD QUESTION

    // 2. no, List[Cat] and List[Animal] are two separate things - INVARIANCE
    class InvariantList[A]
    // val invatiantList: InvariantList[Animal] = new InvariantList[Cat] <- this won't work

    // 3. HELL, NO - Contravariance
    class ContraVariantList[-A]
    val contraVatiantList: ContraVariantList[Cat] = new ContraVariantList[Animal]

    //usage:
    class Trainer[-A]
    val trainer: Trainer[Cat] = new Trainer[Animal]

    //bounded types - they allow to use generic classes only for certain types that are either a subclass
    //of a different type or a superclass of a different type
    class Cage[A <: Animal](animal: A)
    //class Cage only accepts type parameters A which are subtypes of animal

    val cage = new Cage(new Dog)
    //This is acceptable, because Dog is a subclass of animal

    // >: means that generics accepts only supertypy

    //bounded types solve a variance problem
    class CovariantBoundedList[+A] {
        def add[B >: A](element: B): CovariantBoundedList[B] = ???
        // if to a list of A I put in a B, which is a super type of A, then this list will turn into 
        // my list of B, not into my list of A
    }
    val animalCovariantList: CovariantBoundedList[Animal] = new CovariantBoundedList[Cat]
    // if we do animalCovariantList(new Dog) - we return a list of Animal, not a list of Cat 

}
  
