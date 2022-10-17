package Taller_01

import kotlin.math.ceil


fun main() {
    /*
    * Ejercicio 6
    * Teniendo en cuenta que:
    *   para un paseo un "estudiante gordo" ocupa 2 asientos de bus,
    *   mientras que un "estudiante flaco" ocupa solo un (1) asiento.
    * Conociendo, también:
    *   cuantos asientos tiene un bus
    *   y cuantos estudiantes (tanto "gordos" como "flacos") asistirán al paseo
    *
    * Este programa, que mediante una función, encuentra el número de buses necesarios
    * para llevar a los estudiantes al paseo.
    */

    println("Ingrese el número de estudiantes gordos que asistirán al paseo:")
    val estudiantesGordos = readLine()!!.toInt()

    println("Ingrese el número de estudiantes flacos que asistirán al paseo:")
    val estudiantesFlacos = readLine()!!.toInt()

    println("Ingrese el número de asientos que tiene cada bus:")
    val asientosPorBus = readLine()!!.toInt()

    val numBusesNecesarios = numberOfBusesNeeded(estudiantesFlacos, estudiantesGordos, asientosPorBus)
    println("Se necesitarán $numBusesNecesarios buses para llevar a todos los estudiantes al paseo")
}



/*
*   Returns the number (Integer, rounded up) of buses needed
*       according to the number of students (both skinny and fat) and available seats per bus.
*/

fun numberOfBusesNeeded(skinnyStudents: Int, fatStudents: Int, seatsPerBus: Int) : Int {
    val seatsNeeded = skinnyStudents + (fatStudents * 2)
    println("Seats: $seatsNeeded")
    val busesNeeded : Double = seatsNeeded.toDouble() / seatsPerBus
    val busesNeededRoundedUp : Int = ceil(busesNeeded).toInt()
    return busesNeededRoundedUp;
}