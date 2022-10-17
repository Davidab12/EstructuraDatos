package Taller_01

import kotlin.math.pow

fun main() {
    /*
    *   Ejercicio 11
    *   Hallar perímetro y área de un terreno irregular que se compone de:
    *       Un espacio rectangular, cuyos lados, tanto base como altura, están dados
    *       Un espacio triangular, cuya base es la misma del espacio rectangular, y el resto de lados se pueden inferir.
    */

    println("Ingrese el lado A del terreno:")
    val sideA = readLine()!!.toDouble()
    println("Ingrese el lado B del terreno:")
    val sideB = readLine()!!.toDouble()
    println("Ingrese el lado C del terreno:")
    val sideC = readLine()!!.toDouble()

    val triangleHeight          = sideA - sideC
    val triangleArea            = (sideB * triangleHeight) / 2
    val triangleHypotenuse      = getTriangleHypotenuse(triangleHeight, sideB)
    val rectangleArea           = getRectangleArea(sideB, sideC)
    val landArea                = rectangleArea + triangleArea
    val landPerimeter           = sideA + sideB + sideC + triangleHypotenuse

    println("Información sobre el terreno:")
    println("Área de la parte triangular del terreno: $triangleArea - Área del rectángulo: $rectangleArea")
    println("Área de todo el terreno: $landArea")
    println("Perímetro del terreno: $landPerimeter")
}


/*
*   Función que devuelve el área de un rectángulo a partir de la base y la altura
*   (Ambos lados del rectángulo)
*/

fun getRectangleArea(base:Double, height:Double): Double {
    return base * height
}


/*
*   Función que devuelve la hipotenusa de un triángulo a partir de los catetos
*/
fun getTriangleHypotenuse(hickA: Double, hickB: Double): Double {
    return (hickA.pow(2) + hickB.pow(2)).pow(0.5)
}
