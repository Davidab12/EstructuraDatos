package Taller01

import java.lang.Math.PI

/**
 * Escriba una función que halle el área de un círculo de acuerdo a la siguiente fórmula:
 * Ahora escriba una función que halle el área de la corona circular
 * (región en verde en la siguiente figura) a partir de la resta de las áreas del círculo
 * grande (con radio R) y el círculo pequeño (con radio r). En esta segunda función debe usar la primera.
 * Además escriba un programa que lea el valor de los dos radios y, usando la función anterior,
 * calcule y halle el área de la corona circular.
 */

class Ejercicio10 {
}

fun Ejercicio_10(){
    println("***EJERCICIO 10***")
    println("")
    print("Ingresa el radio del circulo grande: ")
    var circBig = readLine()!!.toDouble()
    print("Ingresa el radio del circulo pequeno: ")
    var circSma = readLine()!!.toDouble()
    print("El are de la corona es de: "+areaCoronaCircle(circBig,circSma))
}

fun areaCircle(radioC:Double) : Double{
    return (radioC*radioC)*PI
}

fun areaCoronaCircle(radioG:Double, radioP:Double) : Double{
    return areaCircle(radioG)-areaCircle(radioP)
}
