package Taller_01

import kotlin.math.sin

fun main() {
    /*
    * Ejercicio 7
    * Mediante una función:
    *   Conociendo un ángulo de inclinación α (alfa), y su cateto opuesto X (a la vez, altura)
    *   Se halla la hipotenusa (a la vez, longitud, o Y)
    *
    * Se escribe un programa el cual ejecute la función anterior
    */

    println("Ingrese el ángulo de inclinación de la escalera (en radianes):")
    val anguloInclinacion = readLine()!!.toDouble()
    println("Ingrese la altura de la escalera:")
    val alturaEscalera = readLine()!!.toDouble()

    val result = getLengthFromAngleAndOppositeLeg(anguloInclinacion, alturaEscalera)
    println("La longitud (y) de la escalera es de $result (misma unidad de medida de la altura)")
}



fun getLengthFromAngleAndOppositeLeg(angle:Double, oppositeLeg:Double) : Double {
    /*
    *  (x = oppositeLeg, α = angle (in radians), y = Length)
    *
    *          sen (α) 	    = 	x / y
    *    --->  y 		    = 	x / sin(α)
    */

    return oppositeLeg / sin(angle)
}