package Taller_01

fun main() {
    /*
    * Ejercicio 2
    * Cálculo de una nota definitiva a partir de las notas ingresadas por el usuario
    * (Cada nota, contará con un porcentaje determinado)
    * Primer corte --> 40% | Segundo corte --> 50% | Pruebas objetivas --> 10%
    */

    println("Por favor, ingrese la nota del primer corte (40%)")
    var notaPrimerCorte : Double = readLine()!!.toDouble()
    println("Ingrese la nota del segundo corte (50%)")
    var notaSegundoCorte : Double = readLine()!!.toDouble()
    println("Ingrese la nota de la prueba objetiva (10%)")
    var notaPruebaObjetiva : Double = readLine()!!.toDouble()

    val notaDefinitiva = (notaPrimerCorte*0.4) + (notaSegundoCorte*0.5) + (notaPruebaObjetiva*0.1)
    println("La nota definitiva es de $notaDefinitiva")
}