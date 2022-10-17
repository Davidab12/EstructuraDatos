package Taller01

/**
 * Escriba una función y un programa en Kotlin que resuelva el siguiente problema:
 *
 * Pedro acabó de recibir el sueldo mensual. Si se gasta el 40% de ese sueldo en el
 * arriendo y el 15% del sueldo en comida, determine cuánto dinero se gastó en cada
 * uno de esos dos ítems (en arriendo y en comida) y cuanto dinero le queda al final.
 */

class Ejercicio08 {
}

fun Ejercicio8(){
    println("***EJERCICIO 08***")
    println("")
    print("Ingresa el valor de tu sueldo mensual: ")
    var salary = readLine()!!.toDouble()
    println("Dinero para el arriendo: "+salary*0.40)
    println("Dinero para la comida: "+salary*0.15)
    println("Dinero que te queda disponible: "+salary*0.45)
}