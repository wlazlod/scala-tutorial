
object Main extends App {

  // Syntax: def nameOfTefunction(parameter1: Type , ....): TypeReturned = 
  // Single expression
  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("String", 3))

  // Expression can be a block of code
  def anotherFunction(a: Int, b: Int): Int = {
    val c = a % b
    c * a + b
  }

  def aParameterlessFunction(): Int = 2137 // Functions can be parameterless

  println(aParameterlessFunction())
  println(aParameterlessFunction) // parameterless functions can be called with just their name(!)

  // We do not use loops and instead use recursion!!!
  def aRepeatedFunction(aString: String, n: Int) : String = {
    if (n==1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  
  // println(aRepeatedFunction("DUPA", 3)) 

  // Returned types don't have to be specified, but it is a bad practice and it won't work for recursive funcion
  def aFunction2(a: String, b: Int) =
    a + " " + b
  
  // We can use Unit as returned Type. It is useful for side effects - fe. printing
  def yetAnotherFunction(a: Int, b: Int): Unit = println(a+b)

  yetAnotherFunction(1, 2)

  // We can define functions inside the block of code, fe:
  def aBigFunction(n: Int): Int = {
    def aSmallerFuction(a: Int, b: Int): Int = a + b

    aSmallerFuction(n, n-1)
  }
  println(aBigFunction(3)) 

  //For formatting strings we can use s"Hello, $name", where name is a val/var
  def greetingFunction(name: String, age: Int): String = s"Hi, my name is $name and I am $age years old"
  
  println(greetingFunction("Daniel", 30))
  //println(aBigFunction(5)) 

  def factorialFunction(n: Int): Int = {
    if (n<=1) 1
    else n * factorialFunction(n - 1)
  }

  println(factorialFunction(5))

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else  fibonacci(n-1) + fibonacci(n-2)
  }

  println(fibonacci(6))
}