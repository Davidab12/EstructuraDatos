package ean.estructuradedatos.taller

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Funciones Recursivas
 * Fecha: 29 de septiembre de 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.IList
import ean.collections.newLinkedList
import java.util.LinkedList
import kotlin.Int.Companion.MIN_VALUE
import kotlin.math.max


import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Halla el factorial del número entero n
 * n! = n * (n-1) * (n-2) * ... * 2 * 1
 */
fun factorial(n: Int): Int =
    if (n == 0){
        1
    }else{
        n * factorial(n-1)
    }


/**
 * Halla el n-ésimo término de la serie de fibonacci
 */
fun fibonacci(n: Int): Int =
    when(n){
        1,2 -> 1
        else -> fibonacci(n-1) + fibonacci(n-2)
    }

/**
 * Permite determinar el término n,m del triángulo de Pascal
 * n = fila, m = término
 */
fun pascal(n: Int, m: Int): Int {
    return when(m){
        1, n+1 -> 1
        else -> pascal(n-1,m) + pascal(n-1, m-1)
    }
}
/**
 * Halla el valor de x^y =
 * si y es cero entonces retorne 1
 * sino retorne x multiplicado por elevar x a la y - 1
 */
fun elevar(x: Int, y: Int): Int =
    if (y == 0){
        1
    }else{
        x * elevar(x,y-1)
    }

/**
 * Halla la suma de todos los números enteros entre 1 y n
 */
fun sumatoria(n: Int): Int =
    if (n == 0){
        0
    }else{
        n + sumatoria(n-1)
    }

/**
 * Halla la suma de los cuadrados de los números de 1 hasta n
 */
fun sumaCuadrados(n: Int): Int =
    if (n == 0){
        0
    }else {
        n * n + sumaCuadrados(n - 1)
    }
/**
 * Hallar el valor de la sumatoria de 1/(2i+1) desde  1 hasta n
 */
fun serie(n: Int): Double =
    if (n == 1){
        1.0/3.0
    }else{
        1.0/((2*n)+1) + serie(n-1)
    }

/**
 * Hallar el valor de la sumatoria de 1 hasta n de i/(i^2+1)
 */
fun sumatoria2(n: Int): Double =
    if (n == 1){
        1.0/2.0
    }else{
        n.toDouble()/((n*n)+1) + sumatoria2(n-1)
    }
/**
 * Permite saber la cantidad de digitos que posee un número entero positivo n
 */
fun contarDigitos(n: Int): Int {
    return when (n) {
        in 0..9 -> 1
        else -> {
            val ult = n / 10
            contarDigitos(ult) + contarDigitos(n%ult)
        }
    }
}


/**
 * Permite saber el número de ceros que tiene un número.
 * Por ejemplo: 2020 tiene dos ceros.
 */
fun numeroDeCeros(n: Int): Int =
    when(n){
        in 0..9 -> if (n == 0) 1 else 0
        else -> {
            val ult = n % 10
            val resto = n / 10
            numeroDeCeros(resto) + (if (ult == 0) 1 else 0)
        }
    }

/**
 * Permite hallar la suma de los dígitos de un número entero positivo n
 */
fun sumarDigitos(n: Int): Int {
    return if (n == 0) {
        0
    } else {
        sumarDigitos(n / 10) + n % 10;
    }
}

/**
 * Un número entero positivo en múltiplo de 3 si:
 *  - tiene una cifra y es 0, 3, 6, o 9
 *  - tiene más de una cifra y la suma de sus dígitos es múltiplo de 3 (recursion)
 *  - en cualquier otro caso, el número no es múltiplo de 3
 *
 *  - NO PUEDEN USAR LA OPERACIÓN MÓDULO (%) PARA SABER SI ES DIVISIBLE
 */
fun esMultiploDe3(n: Int): Boolean {
    return when(n){
        0,3,6,9 -> true
        else -> {
            var sumatoria = sumarDigitos(n)
            sumatoria % 3 == 0
        }
    }
}

/**
 * Cuenta el número de dígitos pares que tiene un número entero positivo >= 1
 */
fun cantidadDigitosPares(n: Int): Int {
    return when(n){
        in 0..9 -> if (n%2 == 0) 1 else 0
        else -> {
            val ult = n % 10
            val resto = n / 10
            cantidadDigitosPares(resto) + cantidadDigitosPares(ult)
        }
    }
}

/**
 * Determina si el número dado es binario o no.
 * Los números binarios solo contienen los dígitos 1 y 0
 * Por ejemplo: el numero 100011110 es binario, pero 231 no lo es
 */
fun esNumeroBinario(n: Int): Boolean {
    return when(n){
        0,1 -> true
        2,3,4,5,6,7,8,9 -> false
        else -> {
            val resto = n/10
            esNumeroBinario(resto)
        }
    }
}

/**
 * Permite saber si el número dado posee el dígito indicado
 */
fun poseeDigito(n: Int, digito: Int): Boolean {
    /*
    si el numero n posee un solo digito, entonces
       si n y el digito son iguales -> retorne true sino retorne false
    sino si el número n tiene más de un dígito, entonces
       si el ultimo dígito del número n es igual al dígito, entonces
         listo, lo encontramos, retorne true
       sino
         halle el resto de n
         mire si el resto de n posee el dígito indicado
     */
    TODO()
}

/**
 * Retorna el dígito más grande que hace parte del número n
 * Ejemplo: el dígito más grande del númer 381704 es el 8
 * si el número tiene un solo dígito, el digito más grande es el numero
 * sino
 *    halle el resto y el último
 *    halla el digito mas grande del resto
 *    retorne el mayor entre el último y el dígito más grande del resto
 */
fun digitoMasGrande(n: Int): Int {
    return when(n){
        in 0..9 -> n
        else -> if (n%10 > digitoMasGrande(n/10)) n%10 else digitoMasGrande(n/10)
    }
}

/**
 * Halla el máximo común divisor entre m y n, utilizando el método de
 * Euclides.
 */
fun mcd(m: Int, n: Int): Int =
    TODO("Completar")

/**
 * Imprimir cada elemento de la lista, pero de manera recursiva
 */
fun <T> imprimirLista(lista: IList<T>) {
    require(!lista.isEmpty)
    if (lista.size == 1){
        print(lista[0])
    }
    else{
        TODO()
    }
}

/**
 * Obtiene recursivamente la lista de los dígitos del número entero positivo n
 * Ejemplo: digitos(351804) == [3, 5, 1, 8, 0, 4]
 */
fun digitos(n: Int): IList<Int> {
    var lista : IList<Int> = newLinkedList()

    lista.add(7)
    return lista

}

/**
 * Dado un número entero positivo >= 0, retorna una lista con la representación binaria
 * del número dado.
 * Ejemplo: convertirDecimalBinario(231) = List(1, 1, 0, 0, 1, 1, 1, 1, 1, 1)
 */
fun convertirDecimalBinario(n: Int): IList<Int> {
    TODO("Completar")
}

/**
 * Determina cuantas palabras en la lista son verbos.
 * Recursivamente.
 */
fun contarVerbos(palabras: IList<String>): Int =
    TODO("Completar")

/**
 * Recursion con listas: Hallar la suma de los números pares de la lista que se recibe
 * como parámetro.
 * Ejemplo: sumarParesLista([40, 21, 8, 31, 6]) == 54
 */
fun sumarParesLista(lista: IList<Int>): Int {
    TODO("Completar")
}


/**
 * Invertir una cantidad de enteros -> 1234 = 4321
 */
fun invertirDigitos(n : Int): Int{
    return when(n){
        in 0 .. 9 -> 9
        else -> elevar(n%10, contarDigitos(n/10)) + invertirDigitos(n/10)
    }
}

/**
 * Recursión con listas: construir una función recursiva que retorne la posición del elemento en la lista
 * Si la lista está vacía, retorne -1. No se puede usar indexOf o lastIndexOf
 */
fun buscarElementoEnUnaLista(lista: IList<Int>, elem: Int): Int {
    TODO("Completar")
}

/**
 * Traduce los diversos dígitos de la lista a un número entero
 * Ejemplo: convertirListaDigitosNumero([3, 4, 1, 7, 9]) == 34179
 */
fun convertirListaDigitosNumero(digitos: IList<Int>): Int {
    TODO("Completar!")
}

/**
 * Función genérica y recursiva que permite saber si un elemento está dentro
 * de la lista. No debe usarse la función indexOf o contains. Debe ser
 * recursiva. Para buscar un elemento hay que tener en cuenta
 * - si la lista está vacía, el elemento no está
 * - si el primero de la lista es igual al elemento, retornamos true (el elemento está)
 * - sino es igual al primero, entonces hay que ver si el elemento está en el resto de la lista
 */
fun <T> existeElemento(lista: IList<T>, elem: T): Boolean {
    TODO("Completar")
}

/** Escribir una función recursiva que, sin usar pilas ni colas
 * ni ninguna otra lista, obtenga la misma lista, pero invertida
 */
fun invertirLista(lista: IList<Char>): IList<Char> {
    TODO("Completar")
}

/**
 * Una palabra es palíndrome si se lee igual de izquierda a derecha y de derecha
 * a izquierda. Esta función recibe la palabra (sin espacios) y de forma recursiva
 * determina si la palabra es palíndrome.
 */
fun esPalindrome(palabra: String): Boolean = TODO("Completar")

/**
 * Recursividad con listas. Escriba una función recursiva
 * Obtiene el número más grande de la lista. Si la lista está vacía retorne el número
 * entero más pequeño.
 */
fun mayorDeUnaLista(lista: IList<Int>): Int {
    return if (lista.isEmpty){
        MIN_VALUE
    }
    else{
        val primero = lista.first
        val mayorResto = mayorDeUnaLista(lista.tail())
        max(primero, mayorResto)
    }
}


/**
 * Una clase auxiliar
 */
data class Punto(val x: Int, val y: Int) {
    fun distanciaAlOrigen(): Double = sqrt(x.toDouble().pow(2) + y.toDouble().pow(2))
}

/**
 * Recursivamente, obtener una lista con aquellos puntos que están en el origen o
 * que hacen parte del primer cuadrante.
 */
fun puntosPrimerCuadrante(puntos: IList<Punto>): IList<Punto> {
    TODO("Completar")
}

/**
 * Recursivamente, obtiene el punto que está más lejano del origen.
 * Si la lista esta vacía, retorne null
 * Si la lista tiene un solo elemento, retorne ese elemento
 * si la lista tiene más de un elemento, tome el primer elemento y
 * compárelo con el punto más lejano del resto de la lista.
 */
fun puntoMasLejano(puntos: IList<Punto>): Punto? {
    TODO("Completar")
}


/**
 * Contar los puntos en un eje con la lista
 */
fun contarPuntosEnLosEjes(puntos: IList<Punto>): Int{
    if(puntos.isEmpty){
        return 0
    }
    var cont = 0
    if (puntos.first.x == 0 || puntos.first.y == 0){
        cont +=1
    }
    return contarPuntosEnLosEjes(puntos.tail()) + cont
}


//Ejemplo de complementacion en clase

data class Nota(val materia: String, val definitiva:Double, val sem: Int)

// Promedio de notas

fun promedioNotas(notas: IList<Nota>, semestre: Int): Double{
    val (cant, suma) = contarSumarNotasSemestre(notas, semestre)
    return suma/cant
}


fun contarSumarNotasSemestre(notas: IList<Nota>, semestre: Int):Pair<Int,Double>{
    return if (notas.isEmpty){
        0 to 0.0
    }
    else{
        val (cant, suma) = contarSumarNotasSemestre(notas.tail(), semestre)
        if (notas.first.sem == semestre){
            (cant + 1) to (suma + notas.first.definitiva)
        }
        else {
            cant to suma
        }
    }
}