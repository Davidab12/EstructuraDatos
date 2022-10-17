package Taller01

import kotlin.math.sqrt

/**
 * Una empresa inmobiliaria vende terrenos con la forma a continuación:
 * Escriba funciones que nos ayuden a encontrar el área y el perímetro del terreno.
 *
 * Escriba una función que halle el área de un rectángulo a partir de su base y su altura
 * Escriba una función que halle la hipotenusa de un triángulo rectángulo a partir de los catetos del triángulo.
 * Encuentre el área de un triángulo a partir de su base y su altura
 * Encuentre el perímetro del terreno a partir de los lados A, B, C (hay que encontrar la hipotenusa).
 * El programa debe leer las dimensiones de los 3 lados y hallar el área y el perímetro del terreno usando las funciones anteriores.
 */

class Ejercicio11 {
}

fun Ejercicio_11(){
    println("***EJERCICIO 11***")
    println("")
    print("Ingresa la dimension 'A': ")
    var ladoA = readLine()!!.toDouble()
    print("Ingresa la dimension 'B': ")
    var ladoB = readLine()!!.toDouble()
    print("Ingresa la dimension 'C': ")
    var ladoC = readLine()!!.toDouble()
    println("El area del terreno es: "+ areaTerreno(ladoA,ladoB,ladoC))
    println("El perimetro del terreno es: "+ periTerreno(ladoA,ladoB,ladoC))
}

fun areaRect(base:Double, altura:Double) : Double{
    return base*altura
}

fun hipTriangRect(ladoA:Double, ladoB:Double) : Double{
    return sqrt((ladoA*ladoA)+(ladoB*ladoB))
}

fun areaTriang(base:Double, altura:Double) : Double{
    return (base*altura)/2
}

fun periTerreno(ladoA: Double, ladoB: Double, ladoC:Double) : Double{
    var hipot = hipTriangRect(ladoB,(ladoA-ladoC))
    return hipot+ladoA+ladoB+ladoC
}

fun areaTerreno(ladoA: Double, ladoB: Double, ladoC:Double) : Double{
    var areaTriang = areaTriang(ladoB, (ladoA-ladoC))
    var areaRect = areaRect(ladoB, ladoC)
    return areaTriang+areaRect
}