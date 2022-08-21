import scala.annotation.tailrec

object Recursion extends App{
        def factorialFunction(n:Int):Int={
        if(n<=1)1
        else{
        println(s"Computing factorial of $n")
        val result=n*factorialFunction(n-1)
        println(s"Computed factorial of $n")
        result
        }
        }

        factorialFunction(5)
        // If we run factorialFunction(5000) we get stack overflow error - recursive depth is too big and JVM
        // runs out of memory

        def anotherFactorial(n:Int)={
                @tailrec //This tells compiller that this function is supposed to be tail recursion
                def factorialHelper(x:Int,accumulator:Int):Int=
                        if(n<=1)accumulator
                        else factorialHelper(x-1,x*accumulator) // TAIL RECURSION - previous result is overwritten by the new
                        // key is to use recursive call as the last expression on each codepath where it occurs

                factorialHelper(n,1)
                }

                //WHEN WE NEED LOOP USE TAIL RECURSION
                def fibonacciTail(n:Int):Int={
        @tailrec
        def fibonacciTailHelper(n_act:Int,f_act_1:Int,f_act_2:Int):Int={
                val f_act=f_act_1+f_act_2
                if(n==n_act)f_act
                else fibonacciTailHelper(n_act+1,f_act,f_act_1) // last expression
                }
                if(n<=2)1
                else fibonacciTailHelper(3,1,1)
                }

                println(fibonacciTail(8))


                }
