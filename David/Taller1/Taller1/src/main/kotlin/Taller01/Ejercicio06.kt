package Taller01

import java.lang.Math.ceil

/**
 * El paseo: ya que se acabó la pandemia, vamos a organizar un paseo.
 *
 * Al paseo irán estudiantes gordos y flacos. Un estudiante gordo ocupa
 * dos sillas de un bus y un estudiante flaco ocupa solo una silla.
 * Si sabemos cuánta sillas tiene un bus, cuántos estudiantes gordos van
 * al paseo y cuántos estudiantes flacos van al paseo, escriba una función
 * y un programa que encuentre el número de buses que se necesitan alquilar
 * para llevar a todos esos estudiantes al paseo.
 */

class Ejercicio06 {
}

fun Ejercicio6(){
    println("***EJERCICIO 06***")
    println("")
    print("Ingresa el numero de estudiantes flacos: ")
    var estFla = readLine()!!.toDouble()
    print("Ingresa el numero de estudiantes gordos: ")
    var estGor = readLine()!!.toDouble()
    print("Ingresa las sillas que dispone el bus: ")
    var numSillas = readLine()!!.toDouble()
    val cantBuses = cantBus(estFla, estGor, numSillas)
    print("Se necesita una cantidad de "+cantBuses+" bus(es)")
}

fun cantBus(estFlac:Double, estGor:Double, cantSillas:Double) : Int {
    var estsGor = estGor*2
    return ceil((estFlac+estsGor)/cantSillas).toInt()
}