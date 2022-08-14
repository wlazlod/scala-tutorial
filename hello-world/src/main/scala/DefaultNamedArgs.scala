object DefaultNamedArgs extends App {
  
    def trFact(n: Int, acc: Int): Int = 
        if (n<= 1) acc 
        else trFact(n-1, n*acc)

    def betterTrFact(n: Int, acc: Int = 1): Int =
        if (n<= 1) acc 
        else betterTrFact(n-1, n*acc)

    //default value helps to store accumulators
    
    println(betterTrFact(10))

    def printThreeValues(a: Int = 1, b: Int = 2, c: Int =3): Unit = 
        println(s"$a $b $c")
    
    printThreeValues()
    /*
        If we want to change just 3rd argument we have 2 options:
            1. Pass in every leading argument
            2. Name the arguments
    */
    printThreeValues(c = 5)

}
