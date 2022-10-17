package Taller_01

import kotlin.math.pow

fun main() {
    println("Escriba el radio del circulo m�s grande: ")
    val bigRadius = readLine()!!.toDouble()
    println("Escriba el radio del circulo m�s peque�o: ")
    val smallRadius = readLine()!!.toDouble()

    println("El area de la corona circular es de: ${getCrownArea(bigRadius, smallRadius)}")

}

fun getCircleArea(radius:Double): Double {
    return Math.PI * radius.pow(2);
}

fun getCrownArea(bigRadius:Double, smallRadius:Double): Double {
    return getCircleArea(bigRadius) - getCircleArea(smallRadius)
}