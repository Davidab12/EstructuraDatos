package Taller_01

import kotlin.math.pow

fun main() {
    /*
    *   Ejercicio 9
    *   Funciones para hallar distintas propiedades de un triángulo isósceles
    */

    /*val sideA = 10.toDouble(); val sideB = 5.toDouble();
    println("Altura: ${getIsoscelesTriangleHeight(sideA, sideB)} - Perimetro: ${getIsoscelesTrianglePerimeter(sideA, sideB)} - Area: ${getIsoscelesTriangleArea(sideA, sideB)}")*/
}


/*
*   Función que devuelve la altura de un triángulo isósceles conociendo sus dos lados diferentes
*
*   Cabe mencionar que: la fórmula es válida únicamente cuando el lado B es menor o igual al lado A multiplicado por 2
*   De lo contrario, se estaría operando la raíz de un número negativo, raíz no definida en los números reales.
*/
fun getIsoscelesTriangleHeight(sideA:Double, sideB:Double): Double {
    return if(sideB <= sideA*2) ( sideA.pow(2) - ( (sideB.pow(2)) / 4 ) ).pow(0.5)
    else Double.NaN
}


/*
*   Función que devuelve el perímetro de un triángulo isósceles conociendo sus dos lados diferentes
*/
fun getIsoscelesTrianglePerimeter(sideA:Double, sideB:Double): Double {
    return sideB + 2*sideA
}


/*
*   Función que devuelve el área de un triángulo isósceles conociendo sus dos lados diferentes
*
*   Cabe mencionar que: la fórmula es válida únicamente cuando el lado A es mayor o igual al lado B
*   De lo contrario, se estaría operando la raíz de un número negativo, raíz no definida en los números reales.
*/
fun getIsoscelesTriangleArea(sideA:Double, sideB:Double): Double {
    return if(sideA >= sideB) ( ( sideB * ( (sideA.pow(2) - sideB.pow(2)) / 4 ).pow(0.5) ) / 2 )
    else Double.NaN
}