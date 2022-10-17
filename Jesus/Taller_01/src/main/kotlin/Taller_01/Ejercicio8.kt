package Taller_01

fun main() {
    /*
    *   Ejercicio 8
    *   Pedro gasta el 40% y el 15% de su salario en arriendo y comida respectivamente
    *   -> Tendrá un 55% del salario comprometido y un 45% del salario libre
    *   Determinar cuánto se gastó en cada item y cuánto dinero le queda.
    *   (conociendo cuánto dinero gana Pedro)
    */

    val getCostsValues = { salary:Double -> Triple(salary*0.4, salary*0.15, salary*0.45) }

    println("Hola Pedro. Por favor, ingresa tu salario:")
    val (rent, food, free) = getCostsValues(readLine()!!.toDouble())

    println("Gastarás $$rent en el arriendo (40%) y $$food en comida (15%). Gasto total: ${(rent+food)}")
    println("Te quedará $$free de tu salario.")
}