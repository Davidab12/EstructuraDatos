package Taller_01

fun main() {
    /*
    * Ejercicio 5
    * Función en Kotlin que halla el área y el perímetro de un rectángulo
    * Además, un programa que lee la base y la altura, y a partir de lo anterior
    * imprime el área y el perímetro, usando la función anterior.
    */

    println("Ingrese la base del rectángulo")
    var base = readLine()!!.toDouble()

    println("Ingrese la altura del rectángulo")
    var altura = readLine()!!.toDouble()

    val (area, perimetro) = getAreaAndPerimeterOfRectangle(base, altura)
    println("El área y el perímetro del rectángulo son:")
    println("Área: $area - Perímetro: $perimetro")
}

fun getAreaAndPerimeterOfRectangle(base:Double, height:Double) : Pair<Double, Double> {
    /*
    *   Returns Pair<Double, Double>       -->     <Area, Perimeter>
    */
    return Pair(base*height, (base*2)+(height*2));
}