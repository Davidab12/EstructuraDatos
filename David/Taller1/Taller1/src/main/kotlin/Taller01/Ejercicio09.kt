package Taller01

import kotlin.math.sqrt

/**
 * Un triángulo isosceles es un triángulo donde se tienen que dos lados son iguales,
 * tal como se muestra en la figura a continuación:
 *
 * Primero, escriba una función que encuentra la altura del triángulo a partir
 * de los lados a y b.
 * Después escriba una función que halle el perímetro del triángulo, y finalmente,
 * el área a partir de los dos lados. La fórmulas que necesitarán son:
 */

class Ejercicio09 {
}

fun Ejercicio9(){
    println("***EJERCICIO 09***")
    println("")
    print("Ingresa el valor del lado 'a' del triangulo Isosceles: ")
    var ladoA = readLine()!!.toDouble()
    print("Ingresa el valor del lado 'b' del triangulo isosceles: ")
    var base = readLine()!!.toDouble()
    println("El perimetro del triangulo isosceles es: "+ perimIso(base,ladoA))
    println("La altura del triangulo isosceles es: "+ alturaIso(base, ladoA))
    println("El area del triangulo isosceles es: "+ areaIso(base,ladoA))
}

fun perimIso(base:Double, ladoA:Double) : Double{
    return base+(2*ladoA)
}

fun alturaIso(base:Double, ladoA:Double) : Double{
    return sqrt((ladoA*ladoA)-((base*base)/4))
}

fun areaIso(base:Double, ladoA:Double) : Double{
    return (base*(sqrt((ladoA*ladoA)-((base*base)/4))))/2
}