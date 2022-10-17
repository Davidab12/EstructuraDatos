package Taller01

/**
 * Escriba una función en Kotlin que encuentre el valor de la siguiente expresión algebraica:
 */

class Ejercicio04 {
}

fun Ejercicio4() {
    println("***EJERCICIO 04***")
    println("")
    print("Ingresa el valor de X: ")
    var valX = readLine()!!.toDouble()
    print("Ingresa el valor de la Y: ")
    var valY = readLine()!!.toDouble()

    print("El resultado es: "+ejercicio4(valX, valY))
}

fun ejercicio4(x:Double,y:Double) : Double {
    return (x*x) + (2*x*y) + (y*y)
}