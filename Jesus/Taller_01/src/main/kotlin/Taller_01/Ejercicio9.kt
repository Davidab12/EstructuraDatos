package Taller_01

import kotlin.math.pow

fun main() {
    /*
    *   Ejercicio 9
    *   Funciones para hallar distintas propiedades de un tri�ngulo is�sceles
    */

    /*val sideA = 10.toDouble(); val sideB = 5.toDouble();
    println("Altura: ${getIsoscelesTriangleHeight(sideA, sideB)} - Perimetro: ${getIsoscelesTrianglePerimeter(sideA, sideB)} - Area: ${getIsoscelesTriangleArea(sideA, sideB)}")*/
}


/*
*   Funci�n que devuelve la altura de un tri�ngulo is�sceles conociendo sus dos lados diferentes
*
*   Cabe mencionar que: la f�rmula es v�lida �nicamente cuando el lado B es menor o igual al lado A multiplicado por 2
*   De lo contrario, se estar�a operando la ra�z de un n�mero negativo, ra�z no definida en los n�meros reales.
*/
fun getIsoscelesTriangleHeight(sideA:Double, sideB:Double): Double {
    return if(sideB <= sideA*2) ( sideA.pow(2) - ( (sideB.pow(2)) / 4 ) ).pow(0.5)
    else Double.NaN
}


/*
*   Funci�n que devuelve el per�metro de un tri�ngulo is�sceles conociendo sus dos lados diferentes
*/
fun getIsoscelesTrianglePerimeter(sideA:Double, sideB:Double): Double {
    return sideB + 2*sideA
}


/*
*   Funci�n que devuelve el �rea de un tri�ngulo is�sceles conociendo sus dos lados diferentes
*
*   Cabe mencionar que: la f�rmula es v�lida �nicamente cuando el lado A es mayor o igual al lado B
*   De lo contrario, se estar�a operando la ra�z de un n�mero negativo, ra�z no definida en los n�meros reales.
*/
fun getIsoscelesTriangleArea(sideA:Double, sideB:Double): Double {
    return if(sideA >= sideB) ( ( sideB * ( (sideA.pow(2) - sideB.pow(2)) / 4 ).pow(0.5) ) / 2 )
    else Double.NaN
}