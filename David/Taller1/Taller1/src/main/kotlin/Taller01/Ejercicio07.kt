package Taller01

import kotlin.math.roundToLong
import kotlin.math.sin

/**
 * Escriba una función que calcule la longitud de la escalera
 * teniendo en cuenta que conocemos la altura  que tiene la escalera
 * cuando está inclinada sobre la pared con un ángulo . Tenga en cuenta la siguiente figura:
 * Escriba el programa que use la función anterior para hallar la
 * longitud de la escalera a partir de los otros datos.
 */

class Ejercicio07 {
}

fun Ejercicio7(){
    println("***EJERCICIO 07***")
    println("")
    print("Ingresa la altura: ")
    var valAlt = readLine()!!.toDouble()
    print("Ingresa el angulo en grados: ")
    var valAng = readLine()!!.toDouble()
    var angDeg = (valAng*0.0174533)
    var longEsc = valAlt/sin(angDeg)
    print("La escalera debe tener una longitud de: "+longEsc)
}