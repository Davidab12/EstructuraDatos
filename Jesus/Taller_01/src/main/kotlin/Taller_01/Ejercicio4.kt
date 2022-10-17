package Taller_01

fun main() {
    /*
    * Ejercicio 4
    * Uso de la función "function_f"
    */

    println("Ingrese el parámetro x")
    var parameterX = readLine()!!.toDouble()

    println("Ingrese el parámetro y")
    var parameterY = readLine()!!.toDouble()

    val resultFunctionF = function_f(parameterX, parameterY)
    println("Resultado de la función: $resultFunctionF")
}

fun function_f(x:Double, y:Double) : Double {
    /*
    * Equivalente a la expresión algebraica : f = x^2 + 2xy + y^2
    * Donde x,y son los parámetros de la función: f(x,y)
    */

    return (x*x) + (2*x*y) + (y*y)
}