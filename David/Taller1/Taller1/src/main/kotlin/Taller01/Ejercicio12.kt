package Taller01

import kotlin.math.sqrt

/**
 * Todo punto del eje cartesiano está descrito por dos elementos:
 * la coordenada x (o «abscisa») y su coordenada y (que también se llama la «ordenada»).
 * Suponga que tenemos las coordenadas (x, y) de dos puntos: x1 y y1 para el primer punto,
 * y también x2y y2 para el segundo punto. Vamos a construir funciones y un programa que
 * nos ayude a resolver los siguientes interrogantes:
 */

class Ejercicio12 {
}

fun Ejercicio_12(){
    println("***EJERCICIO 12***")
    println("")
    print("Ingresa la coordenada 'x1': ")
    var x1 = readLine()!!.toDouble()
    print("Ingresa la coordenada 'y1': ")
    var y1 = readLine()!!.toDouble()
    print("Ingresa la coordenada 'x2': ")
    var x2 = readLine()!!.toDouble()
    print("Ingresa la coordenada 'y2': ")
    var y2 = readLine()!!.toDouble()
    var (xe1,ye1) = coordenadaPunto(x1, y1, x2, y2)
    println("Distancia entre los puntos: "+ distance(x1,y1,x2,y2))
    println("Pendiente de la recta: "+ pendiente(x1,y1,x2,y2))
    println("Punto medio (x,y): ("+xe1+","+ye1+")")
}

fun distance(x1:Double, y1:Double, x2:Double, y2:Double) : Double{
    return sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1))
}

fun pendiente(x1:Double, y1:Double, x2:Double, y2:Double) : Double{
    return (y2-y1)/(x2-x1)
}

fun coordenadaPunto(x1:Double, y1:Double, x2:Double, y2:Double) : Pair<Double,Double>{
    return Pair((x1+x2)/2,(y1+y2)/2)
}