object CallMeByYourName extends App{
  
    def calledByValue(x: Long): Unit = {
        println("by value: " + x)
        println("by value: " + x)
    }
    //it takes Long, because time functions in JVM return longs

    def calledByName(x: => Long): Unit = {
        println("by name: " + x)
        println("by name: " + x)
    }
    // when we do => that mean that parameter would be called by name
    // when called by value - we pass value - object/function is computed before the function evaluates 
    // when called by name - expression is passed as it is - it is evaluated every time
    // It is extremely useful in lazy streams and in things that might fail


    calledByValue(System.nanoTime())
    calledByName(System.nanoTime())
}
