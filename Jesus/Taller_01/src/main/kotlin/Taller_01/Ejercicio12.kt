package Taller_01

import kotlin.math.pow

fun main() {
    /*
    *   Ejercicio 12
    *   Obtener algunas propiedades al trabajar con dos puntos en el plano bidimensional
    */

    println("Ingrese la coordenada X (abscisa) del punto #1")
    val abs1 = readLine()!!.toDouble()
    println("Ingrese la coordenada Y (ordenada) del punto #1")
    val ord1 = readLine()!!.toDouble()

    println("Ingrese la coordenada X (abscisa) del punto #2")
    val abs2 = readLine()!!.toDouble()
    println("Ingrese la coordenada Y (ordenada) del punto #2")
    val ord2 = readLine()!!.toDouble()

    println("\nPara los puntos: ($abs1, $ord1) y ($abs2, $ord2)")
    println("* La distancia entre los puntos es de: ${getDistanceBetweenTwoPoints(abs1, ord1, abs2, ord2)}")
    println("* La pendiente de la recta que une ambos puntos es de: ${getSlopeBetweenTwoPoints(abs1, ord1, abs2, ord2)}")

    val (middleAbs, middleOrd) = getMiddlePointBetweenTwoPoints(abs1, ord1, abs2, ord2)
    println("* El punto medio entre ambos puntos es: (x, y) = ($middleAbs, $middleOrd)")

}


/*
*   Función que devuelve la distancia entre dos puntos
*   (recibe las coordenadas x e y de ambos puntos)
*/
fun getDistanceBetweenTwoPoints(x1:Double, y1:Double, x2:Double, y2:Double): Double {
    return ( (y2-y1).pow(2) + (x2-x1).pow(2) ).pow(0.5)
}


/*
*   Función que devuelve la pendiente de la recta que une dos puntos
*   (recibe las coordenadas x e y de ambos puntos)
*/
fun getSlopeBetweenTwoPoints(x1:Double, y1:Double, x2:Double, y2:Double): Double {
    return (y2-y1)/(x2-x1)
}


/*
*   Función que devuelve el punto medio entre dos puntos
*   (recibe las coordenadas x e y de ambos puntos)
*/
fun getMiddlePointBetweenTwoPoints(x1:Double, y1:Double, x2:Double, y2:Double): Pair<Double, Double>{
    return Pair((x1+x2)/2, (y1+y2)/2);
}