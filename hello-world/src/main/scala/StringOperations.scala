object StringOperations extends App{
  
    val str: String = "Hello, I am learning Scala"

    println(str.charAt(2))
    println(str.substring(7, 11))
    println(str.split(" ").toList)
    println(str.startsWith("Hello"))
    println(str.replace(" ", "-"))
    println(str.toLowerCase())
    println(str.length())

    //Functions only in Scala
    val aNumberString = "34"
    val aNumber: Int = aNumberString.toInt

    println('a' +: aNumberString :+ 'z')
    println(str.reverse)
    println(str.take(2))

    //String interpolators
    // s - interpolator
    val name = "David"
    val age = 12
    val greeting = s"Hello, my name is $name and I am $age years old"
    //it could evaluate blocks
    val anotherGreeting = s"Next year I will be ${age + 1} years old"

    println(greeting)
    println(anotherGreeting)    

    // f - interpolator 
    // acts similarly as s-interpolator, but can also receive printf like format's
    var speed: Float = 1.2f
    val myth = f"$name can eat $speed%2.2f donughts"
    //%3.2f is a format: 3 characters total (min.), 2 decimals precision, float
    println(myth)

    //f interpolators can also check for type correctness in the values that they expand

    // raw interpolator - works similarly to f-interpolator, but not escapes characters, prints them literally
    val rawMyth = raw"$name inserted a \n but nothing happened"
    println(rawMyth)

    def factorial(n: Int, accumulator: Int = 1): Int = {
        if(n<=1) accumulator
        else factorial(n-1, accumulator * n)
    }
    println(factorial(10))
}
