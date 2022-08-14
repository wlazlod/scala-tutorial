package ooptutorial

object GenericsExercise extends App{
   
   abstract class MyList[+A] {

        def head: A
        def tail: MyList[A]
        def isEmpty: Boolean
        def add[B >: A](element: B): MyList[B]
        def printElements: String 
        //polymorphic call
        override def toString(): String = f"[ $printElements ]" // thanks to that we dont fave to implement 
    }


    class Cons[+A](h: A, t:MyList[A]) extends MyList[A]{
        def head: A = h
        def tail: MyList[A] = t
        def isEmpty: Boolean = false
        def add[B >: A](element: B): MyList[B] = new Cons(element, this)
        def printElements: String = {
            if (t.isEmpty) f"$h"
            else f"$h ${t.printElements}"
        }

    }


    object EmptyList extends MyList[Nothing] {
        def head: Nothing = throw new NoSuchElementException //  that means Nothing
        def tail: MyList[Nothing] = throw new NoSuchElementException
        def isEmpty: Boolean = true
        def add[B >: Nothing](element: B): MyList[B] = new Cons(element, EmptyList)
        def printElements: String = ""
    }

    val list = new Cons(1, EmptyList)
    val list2 = new Cons(3, new Cons(2, list))
    println(list2)
}
