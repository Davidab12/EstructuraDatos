package Taller01

/**
 * Juancho ha calculado que le toma 38 segundos caminar 100 metros, y quiere que le escribamos
 * un programa donde dado el número de metros que hay entre su casa y la tienda,
 * le muestre cuánto tiempo le tomaría ir y regresar a la tienda.
 */

class Ejercicio03 {
}

fun Ejercicio3(){
    println("***EJERCICIO 03***")
    println("")
    print("Juancho, ingresa los metros que hay entre tu casa y la tienda: ")
    var dist = readLine()!!.toDouble()*2
    var seg = (dist*38)/100
    print("Juancho, te demoraras "+seg+" segundos en ir y regresar de la tienda.")
}