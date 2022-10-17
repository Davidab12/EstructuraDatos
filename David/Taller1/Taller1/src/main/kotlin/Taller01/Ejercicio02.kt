package Taller01

/**
 * Escriba un programa que pregunte las notas que obtuvo un estudiante en el primer corte, segundo corte y
 * pruebas objetivas de una unidad de estudios de ciclo, y que imprima la nota definitiva del estudiante
 * en esa unidad de estudio, teniendo en cuenta que el primero corte pesa el 40% de la nota definitiva,
 * el segundo corte pesa el 50% y las pruebas objetivas pesan el 10%.
 */

class Ejercicio02 {
}

fun Ejercicio2() {
    println("***EJERCICIO 02***")
    println("")
    print("Ingresa la nota del primer corte: ")
    var nota1 = readLine()!!.toDouble()
    print("Ingresa la nota del segundo corte: ")
    var nota2 = readLine()!!.toDouble()
    print("Ingresa la nota de las pruebas objetivas: ")
    var nota3 = readLine()!!.toDouble()

    var notaDef = nota1*0.4 + nota2*0.5 + nota3*0.1
    println("Nota definitiva: "+notaDef)

}