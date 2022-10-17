package Taller_01

import kotlin.math.pow

fun main() {
    /*
    *   Ejercicio 11
    *   Hallar per�metro y �rea de un terreno irregular que se compone de:
    *       Un espacio rectangular, cuyos lados, tanto base como altura, est�n dados
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

    println("Informaci�n sobre el terreno:")
    println("�rea de la parte triangular del terreno: $triangleArea - �rea del rect�ngulo: $rectangleArea")
    println("�rea de todo el terreno: $landArea")
    println("Per�metro del terreno: $landPerimeter")
}


/*
*   Funci�n que devuelve el �rea de un rect�ngulo a partir de la base y la altura
*   (Ambos lados del rect�ngulo)
*/

fun getRectangleArea(base:Double, height:Double): Double {
    return base * height
}


/*
*   Funci�n que devuelve la hipotenusa de un tri�ngulo a partir de los catetos
*/
fun getTriangleHypotenuse(hickA: Double, hickB: Double): Double {
    return (hickA.pow(2) + hickB.pow(2)).pow(0.5)
}
