package Taller01

/**
 * Escriba una función en Kotlin que halle el área y el perímetro de un
 * rectángulo a partir de la base y la altura del rectángulo
 * (OJO: Una sola función). Escriba un programa que lea la base y la altura
 * y que imprima el área y el perímetro, usando la función anterior.
 */

class Ejercicio05 {
}

fun Ejercicio5() {
    println("***EJERCICIO 05***")
    println("")
    print("Ingresa el valor de la base del rectangulo: ")
    var valBase = readLine()!!.toDouble()
    print("Ingresa el valor de la altura del rectangulo ")
    var valAltura = readLine()!!.toDouble()

    var (a,p) = ejercicio5(valBase, valAltura)

    println("Area del rectangulo es: "+a)
    print("Perimetro del rectangulo es: "+p)
}

fun ejercicio5(base:Double,altura:Double) : Pair<Double, Double> {
    var area = base*altura
    var perimetro = (base*2)+(2*altura)
    return Pair(area, perimetro)
}