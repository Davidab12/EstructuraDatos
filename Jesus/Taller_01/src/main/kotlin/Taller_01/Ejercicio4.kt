package Taller_01

fun main() {
    /*
    * Ejercicio 4
    * Uso de la funci�n "function_f"
    */

    println("Ingrese el par�metro x")
    var parameterX = readLine()!!.toDouble()

    println("Ingrese el par�metro y")
    var parameterY = readLine()!!.toDouble()

    val resultFunctionF = function_f(parameterX, parameterY)
    println("Resultado de la funci�n: $resultFunctionF")
}

fun function_f(x:Double, y:Double) : Double {
    /*
    * Equivalente a la expresi�n algebraica : f = x^2 + 2xy + y^2
    * Donde x,y son los par�metros de la funci�n: f(x,y)
    */

    return (x*x) + (2*x*y) + (y*y)
}