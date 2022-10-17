package Taller_01

fun main() {
    /*
    * Ejercicio 3
    * Juancho en 38 segundos camina 100 metros
    * --> Camina 1 (un) metro en [(38/100) = 0.38] segundos
    * --> (O también, en un segundo, Juan camina [100/38] metros)
    * Dado el número de metros que hay entre su casa y la tienda (Input dado por el usuario)
    * Mostrarle cuánto tiempo le tomaría ir y regresar a la tienda.
    */

    println("Ingrese la distancia desde la casa de Juancho hasta la tienda (metros)")
    var distanciaDeCasaATienda : Double = readLine()!!.toDouble()

    var tiempoDeIda : Double = 0.38*distanciaDeCasaATienda
    val tiempoTotal = tiempoDeIda * 2

    /*
    *   ¿Es necesario redondear el resultado?
    */

    println("A Juancho le tomará $tiempoTotal segundos en ir y regresar de la casa a la tienda")

}