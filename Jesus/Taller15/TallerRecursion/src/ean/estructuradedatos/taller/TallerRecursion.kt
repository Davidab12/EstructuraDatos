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

/*
*
* POR: JESUS D. GARCÍA CUELLO & DAVID G. ARIAS BERNAL
*
* */

import ean.collections.*
import kotlin.math.*

/**
 * Halla el factorial del número entero n
 * n! = n * (n-1) * (n-2) * ... * 2 * 1
 */
fun factorial(n: Int): Int  {
    return when(n) {
        0,1 -> 1
        else -> n * factorial(n-1)
    }
}


/**
 * Halla el n-ésimo término de la serie de fibonacci
 */
fun fibonacci(n: Int): Int {
    return when (n) {
        0 -> 0
        1, 2 -> 1
        else -> fibonacci(n-2) + fibonacci(n-1)
    }
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
fun elevar(x: Int, y: Int): Int {
    return when (y) {
        0 -> 1
        else -> x * elevar(x, y-1)
    }
}

/**
 * Halla la suma de todos los números enteros entre 1 y n
 */
fun sumatoria(n: Int): Int {
    require(n>=1)
    return when(n) {
        1 -> 1
        else -> n + sumatoria(n-1)
    }
}

/**
 * Halla la suma de los cuadrados de los números de 1 hasta n
 */
fun sumaCuadrados(n: Int): Int {
    require(n>=1)
    return when (n) {
        1 -> 1
        else -> n*n + sumaCuadrados(n-1)
    }
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
    if(n < 10) return 1
    else return 1 + contarDigitos(n/10)
}

/**
 * Permite saber el número de ceros que tiene un número.
 * Por ejemplo: 2020 tiene dos ceros.
 */
fun numeroDeCeros(n: Int): Int {
    val plusIfLastIsZero: (Int) -> Int = { number:Int -> if(number%10==0) 1 else 0}
    return if(n < 0) numeroDeCeros(n*(-1)) // Soporte para números negativos
    else when (n) {
        in 0 .. 9 -> return plusIfLastIsZero(n)
        else -> plusIfLastIsZero(n) + numeroDeCeros(n/10)
    }
}

/**
 * Permite hallar la suma de los dígitos de un número entero positivo n
 */
fun sumarDigitos(n: Int): Int {
    return if(n < 0) sumarDigitos(n*(-1)) // Soporte para números negativos
    else when(n) {
        in 0 .. 9 -> n
        else -> n%10 + sumarDigitos(n/10)
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
    return if (n<0) esMultiploDe3(n*(-1)) // Soporte para números negativos
    else when (n) {
        in 0..9 -> {
            when (n) {
                3,6,9 -> true
                else -> false
            }
        }
        else -> esMultiploDe3(sumarDigitos(n))
    }
}

/**
 * Cuenta el número de dígitos pares que tiene un número entero positivo >= 1
 */
fun cantidadDigitosPares(n: Int): Int {
    require(n>=1)
    val plusIfLastDigitIsTwoMultiple: (Int) -> Int = {number:Int -> if( (number%10)%2 == 0) 1 else 0}
    return when (n) {
        in 0 .. 9 -> plusIfLastDigitIsTwoMultiple(n)
        else -> cantidadDigitosPares(n/10) + plusIfLastDigitIsTwoMultiple(n)
    }
}

/**
 * Determina si el número dado es binario o no.
 * Los números binarios solo contienen los dígitos 1 y 0
 * Por ejemplo: el numero 100011110 es binario, pero 231 no lo es
 */
fun esNumeroBinario(n: Int): Boolean {
    require(n>=0)
    val checkIfLastDigitIsBinary: (Int) -> Boolean = {number:Int -> number%10 == 0 || number%10 == 1 }
    return when(n) {
        in 0 .. 9 -> checkIfLastDigitIsBinary(n)
        else -> esNumeroBinario(n/10) && checkIfLastDigitIsBinary(n)

    }
}

/**
 * Permite saber si el número dado posee el dígito indicado
 */
fun poseeDigito(n: Int, digito: Int): Boolean {
    return if(n<0) poseeDigito(n*(-1), digito) // Soporte para números negativos
    else if(n in 0..9) (n == digito)
    else (n%10 == digito || poseeDigito(n/10, digito))
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
    return when (n) {
        in 0..9 -> n
        else -> {
            if(n%10 > digitoMasGrande(n/10)) n%10 else digitoMasGrande(n/10)
        }
    }
}

/**
 * Halla el máximo común divisor entre m y n, utilizando el método de
 * Euclides.
 */
fun mcd(m: Int, n: Int): Int {
    return if(n > m) mcd(n, m)
    else when (n) {
        0 -> m
        else -> mcd(n, m%n)
    }
}

/**
 * Imprimir cada elemento de la lista, pero de manera recursiva
 */
fun <T> imprimirLista(lista: IList<T>) {
    when(lista.size) {
        1 -> println(lista[0])
        else -> {
            println(lista.first)
            val listaCopy = lista.copy(); listaCopy.removeFirst(); imprimirLista(listaCopy)
        }
    }
}

/**
 * Obtiene recursivamente la lista de los dígitos del número entero positivo n
 * Ejemplo: digitos(351804) == [3, 5, 1, 8, 0, 4]
 */
fun digitos(n: Int): IList<Int> {
    val list = TList<Int>()
    return when(n) {
        in 0..9 -> {
            list.add(n)
            list
        }
        else -> {
            digitos(n / 10).forEach { list.add(it) }
            list.add(n%10)
            list
        }
    }
}

/**
 * Dado un número entero positivo >= 0, retorna una lista con la representación binaria
 * del número dado.
 * Ejemplo: convertirDecimalBinario(231) = List(1, 1, 0, 0, 1, 1, 1, 1, 1, 1)
 */
fun convertirDecimalBinario(n: Int): IList<Int> {
    require(n>0)
    val list = TLinkedList<Int>()
    return when (n) {
        0 -> {list.add(0); list}
        1 -> {list.add(1); list}
        else -> {
            convertirDecimalBinario(n/2).forEach { list.add(it) }
            list.add(n%2)
            list
        }
    }
}

/**
 * Determina cuantas palabras en la lista son verbos.
 * Recursivamente.
 */
fun contarVerbos(palabras: IList<String>): Int {
    require(palabras.size > 0)
    val terminaEnVerbo: (String) -> Boolean = { str:String -> (str.endsWith("ar") || str.endsWith("er") || str.endsWith("ir")) }
    val palabrasEx = palabras.copy()
    return when(palabrasEx.size) {
        1 -> if(terminaEnVerbo(palabrasEx[0])) 1 else 0
        else -> {
            val palabra = palabrasEx[0]; palabrasEx.remove(0)
            contarVerbos(palabrasEx) + if(terminaEnVerbo(palabra)) 1 else 0
        }
    }
}

/**
 * Recursion con listas: Hallar la suma de los números pares de la lista que se recibe
 * como parámetro.
 * Ejemplo: sumarParesLista([40, 21, 8, 31, 6]) == 54
 */
fun sumarParesLista(lista: IList<Int>): Int {
    require(lista.size > 0)
    val listaEx = lista.copy();
    return when(listaEx.size) {
        1 -> if(listaEx[0]%2 == 0) listaEx[0] else 0
        else -> {
            val valor = listaEx[0]; listaEx.remove(0)
            sumarParesLista(listaEx) + if (valor % 2 == 0) valor else 0
        }
    }
}

/**
 * Recursión con listas: construir una función recursiva que retorne la posición del elemento en la lista
 * Si la lista está vacía, retorne -1. No se puede usar indexOf o lastIndexOf
 */
fun buscarElementoEnUnaLista(lista: IList<Int>, elem: Int): Int {
    return when(lista.size) {
        1 -> if(lista[0] == elem) 0 else -1
        else -> {
            if(lista[0] == elem) 0 else {
                val listaCopy = lista.copy(); listaCopy.removeFirst()
                if(buscarElementoEnUnaLista(listaCopy, elem) != -1) 1 + buscarElementoEnUnaLista(listaCopy, elem)
                else -1
            }
        }
    }
}

/**
 * Traduce los diversos dígitos de la lista a un número entero
 * Ejemplo: convertirListaDigitosNumero([3, 4, 1, 7, 9]) == 34179
 */
fun convertirListaDigitosNumero(digitos: IList<Int>): Int {
    require(digitos.size > 0)

    val listaCopy = digitos.copy()
    return when(listaCopy.size) {
        1 -> listaCopy[0]
        else -> {
            val digitoActual = listaCopy[0];
            listaCopy.removeFirst()
            digitoActual * 10.0.pow(listaCopy.size).toInt() + convertirListaDigitosNumero(listaCopy)
        }
    }
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
    return when(lista.size) {
        0 -> false
        1 -> (lista.first() == elem)
        else -> {
            val listaCopy = lista.copy(); val valorActual = lista.first(); listaCopy.removeFirst()
            (valorActual == elem) || existeElemento(listaCopy, elem)
        }
    }
}

/** Escribir una función recursiva que, sin usar pilas ni colas
 * ni ninguna otra lista, obtenga la misma lista, pero invertida
 */
fun invertirLista(lista: IList<Char>): IList<Char> {
    require(lista.size > 0)
    return when (lista.size) {
        1 -> lista
        else -> {
            val newList = TList<Char>()
            val listaCopy = lista.copy(); val valorActual = listaCopy.last(); listaCopy.removeLast()
            val valoresAnteriores = invertirLista(listaCopy)
            newList.addToHead(valorActual)
            valoresAnteriores.forEach { newList.add(it) }
            newList
        }
    }
}

/**
 * Una palabra es palíndrome si se lee igual de izquierda a derecha y de derecha
 * a izquierda. Esta función recibe la palabra (sin espacios) y de forma recursiva
 * determina si la palabra es palíndrome.
 */
fun esPalindrome(palabra: String): Boolean {
    require(palabra.isNotEmpty())
    if(palabra.length == 1) return true
    return when(palabra.length) {
        2 -> (palabra.endsWith(palabra[0]))
        else -> (palabra.endsWith(palabra[0])) && esPalindrome(palabra.subSequence(1, palabra.length-1).toString())
    }
}

/**
 * Recursividad con listas. Escriba una función recursiva
 * Obtiene el número más grande de la lista. Si la lista está vacía retorne el número
 * entero más pequeño.
 */
fun mayorDeUnaLista(lista: IList<Int>): Int {
    if(lista.size == 0) return Int.MIN_VALUE
    return when(lista.size) {
        1 -> lista[0]
        else -> {
            val biggestElement = lista[0]; val reducedList = lista.copy(); reducedList.removeFirst()
            val subBiggestElement = mayorDeUnaLista(reducedList)
            max(subBiggestElement, biggestElement)
        }
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
    require(puntos.size > 0)

    val listaResultados = TList<Punto>()
    when(puntos.size) {
        1 -> if(puntos.first().x >= 0 && puntos.first().y >= 0) listaResultados.add(puntos.first())
        else -> {
            if(puntos.first().x >= 0 && puntos.first().y >= 0)
                listaResultados.add(puntos.first())

            val listaPuntosReducida = puntos.copy(); listaPuntosReducida.removeFirst()
            val otrosPuntos = puntosPrimerCuadrante(listaPuntosReducida)
            otrosPuntos.forEach { listaResultados.add(it) }
        }
    }
    return listaResultados
}

/**
 * Recursivamente, obtiene el punto que está más lejano del origen.
 * Si la lista esta vacía, retorne null
 * Si la lista tiene un solo elemento, retorne ese elemento
 * si la lista tiene más de un elemento, tome el primer elemento y
 * compárelo con el punto más lejano del resto de la lista.
 */
fun puntoMasLejano(puntos: IList<Punto>): Punto? {
    val distanciaDesdeElOrigen: (Punto) -> Double = { sqrt(it.x.toDouble().pow(2.0) + it.y.toDouble().pow(2.0)) }
    return when(puntos.size) {
        0 -> null
        1 -> puntos.first()
        else -> {
            val distanciaPrimerPunto = distanciaDesdeElOrigen(puntos.first())

            val subList = puntos.copy(); subList.removeFirst()
            val puntoMasLejanoSubList = puntoMasLejano(subList)!!

            if(distanciaPrimerPunto > distanciaDesdeElOrigen(puntoMasLejanoSubList))
                puntos.first()
            else puntoMasLejanoSubList
        }
    }
}


