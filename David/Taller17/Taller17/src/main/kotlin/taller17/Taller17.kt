
/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología de la Información y Comunicaciones
 * Faculta de Ingeniería
 *
 * Taller Árboles Binarios
 * Fecha: 11 de octubre de 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package taller17

import ean.collections.IBinTree
import ean.collections.IList
import ean.collections.Lists
import kotlin.math.max

/**
 * Informar si un elemento se encuentra presente en un árbol binario
 */
fun <T> estaArbin(a: IBinTree<T>, elem: T): Boolean =
    when {
        a.isEmpty -> false //elem no esta en el arbol
        a.root == elem -> true //el elem es la raiz
        else -> estaArbin(a.left, elem) || estaArbin(a.right, elem)
    }

/**
 * Permite obtener el número de vocales que hay en el árbol
 */
fun contarVocales(arbol: IBinTree<String>): Int =
    when{
        arbol.isEmpty -> 0
        else -> {
            var cont = contarVocales(arbol.left) + contarVocales(arbol.right)
            if (arbol.root in Lists.of("A","E","I","0","U")){
                cont ++
            }
            cont
        }
    }

/**
 * Permite determinar cuantos elementos en el árbol son de dos dígitos y la suma de ambos dígitos es 7
 */
fun contarArbol(a: IBinTree<Int>): Int =
    when{
        a.isEmpty -> 0
        else -> {
            a.root in 10..99
            val ultimo = a.root % 10
            val resto = a.root / 10
            if (ultimo + resto == 7){
                1 + contarArbol(a.left) + contarArbol(a.right)
            }else{
                contarArbol(a.left) + contarArbol(a.right)
            }
        }
    }

/**
 * Permite conocer el porcentaje (entre 0 y 100) de pares en el árbol
 */

fun canT(a: IBinTree<Int>): Int =
    when{
        a.isEmpty -> 0
        else -> {
            1 + canT(a.left) + canT(a.right)
        }
}

fun canPar(a: IBinTree<Int>): Int =
    if (a.isEmpty) {
        0
    }else{
        var contador = canPar(a.left) + canPar(a.right)
        var raiz = a.root
        if (raiz % 2 == 0){
            contador += 1
        }
        contador
    }


fun porcentajePares(a: IBinTree<Int>): Double =
    when{
        a.isEmpty -> 0.0
        else -> {
            var canP = canPar(a)
            var canT = canT(a)
            (canP.toDouble() * 100) / canT
        }
    }

/**
 * Determinar la suma de los elementos pares del árbol
 */
fun sumaPares(arbol: IBinTree<Int>): Int =
    when{
        arbol.isEmpty -> 0
        else -> {
            var suma = sumaPares(arbol.left) + sumaPares(arbol.right)
            if (arbol.root %2 == 0){
                suma += arbol.root
            }
            suma
        }
    }

/**
 * Obtener una lista con aquellos elementos del árbol que sean múltiplos de 6
 */
fun multiplosDeSeis(arbol: IBinTree<Int>): IList<Int> {
    return when{
        arbol.isEmpty -> Lists.empty()
        else -> {
            val resultado = multiplosDeSeis(arbol.left) + multiplosDeSeis(arbol.right)
            if (arbol.root % 6 == 0){
                resultado.add(arbol.root)
            }
            resultado
        }
    }
}

/**
 *   Calcular el peso de un árbol binario
 */
fun <T> peso(a: IBinTree<T>): Int {
    return if (a.isEmpty){
        0
    }else {
        return 1 + peso(a.left) + peso(a.right)
    }
}

/**
 * Esta función externa, NO ES RECURSIVA, y permite saber si el árbol a es una hoja o no.
 * Un árbol a es una hoja si no es vacio y el árbol izquierdo de a si es vacío y el árbol
 * derecho de a también es vacío. En cualquier otro caso, el árbol no es una hoja.
 */
fun <T> esUnaHoja(a: IBinTree<T>): Boolean =
    when{
        a.isEmpty -> false
        else -> {
            a.right.isEmpty && a.left.isEmpty
        }
    }

/**
 * Esta función externa y genérica recursiva y cuenta el número de hojas. La definición
 * recursiva sería la siguiente:
 * - Si el árbol es vacío, no hay hojas
 * - Sino Si el árbol es una hoja, entonces hay 1 hoja
 * - Sino el número total de hojas que hay en el árbol es el número de hojas del árbol izquierdo más
 *        el número de hojas del árbol derecho.
 */
fun <T> contarHojas(a: IBinTree<T>): Int =
    when {
        a.isEmpty -> 0
        esUnaHoja(a) -> 1
        else -> {
            contarHojas(a.left) + contarHojas(a.right)
        }
    }

/**
 * Permite obtener la altura de un árbol binario
 */
fun <T> altura(a: IBinTree<T>): Int =
    when{
        a.isEmpty -> 0
        else -> max(altura(a.left), altura(a.right)) + 1
    }

/**
 * Imprime el árbol binario a en preorden
 */
fun <T> preorden(a: IBinTree<T>): Unit {
    if (!a.isEmpty){
        a.root
        preorden(a.left)
        preorden(a.right)
        println("${a.right}")
    }
}

/**
 * Imprime el árbol binario a en postorden
 */
fun <T> postorden(a: IBinTree<T>): Unit {
    if (!a.isEmpty){
        postorden(a.left)
        postorden(a.right)
        println("${a.root}")
    }
}

/**
 * Imprime el árbol binario a en inorden
 */
fun <T> inorden(a: IBinTree<T>) {
    if (!a.isEmpty){
        inorden(a.left)
        a.root
        inorden(a.right)
        println("${a.right}")
    }
}

/**
 * Ayuda a determinar el nivel en que se encuentra un elemento. El algoritmo es el siguiente:
 * si el árbol está vacío, el nivel del elemento es -1
 * sino si el elemento es igual a la raíz del árbol a, el nivel del elemento es cero
 * sino si el elemento esta en el árbol izquierdo de a,
 *    el nivel del elemento es 1 + el nivel del elemento en el árbol izquierdo
 * sino si el elemento esta en el árbol derecho de a,
 *    el nivel del elemento es 1 + el nivel del elemento en el árbol derecho
 * sino
 *    retorne -1
 */
fun <T> nivelElementoArbol(a: IBinTree<T>, elem: T): Int =
    when {
        a.isEmpty -> -1
        a.root == elem -> 0
        a.left == elem -> 1
        a.right == elem -> 1
        else -> {
            if (!a.left.isEmpty) {
                1 + nivelElementoArbol(a.left, elem)
            }
            if (!a.right.isEmpty) {
                1 + nivelElementoArbol(a.right, elem)
            }
            else{
                -1
            }
        }
    }


/**
 * Obtiene el elemento padre del elemento e. Para hallar el papá tenemos el siguiente algoritmo
 * Si el árbol está vacío, el papá es nulo
 * sino si la raíz del árbol es igual al elemento, el papá es nulo también
 * sino si el izquierdo de a no es vacío y la raiz del izquierdo de a es igual al elemento, retorne la raiz de a
 * sino si el derecho de a no es vacío y la raiz del derecho de a es igual al elemento, retorne la raiz de a
 * sino si el elemento está en el árbol izquierdo de a, halle el papá del elemento e en el izquierdo de a
 * sino si el elemento está en el árbol derecho de a, halle el papá del elemento e en el árbol derecho de a
 * sino, retorne nulo.
 */
fun <T> padre(a: IBinTree<T>, e: T): T? =
    when {
        a.isEmpty -> null
        a.root == e -> null
        !a.left.isEmpty && a.left == e -> a.root
        !a.right.isEmpty && a.right == e -> a.root
        else -> {
            if (!a.left.isEmpty){
                padre(a.left, e)
            }
            else if (!a.right.isEmpty){
                padre(a.right, e)
            }
            else{
                null
            }
        }
    }

/**
 * Esta función recursiva, es muy parecida al algoritmo de hallar el papá,
 * pero buscando al hermano. Es posible que el elemento no tenga hermano.
 */
fun <T> hermanoElementoArbol(a: IBinTree<T>, elem: T): T? {
    TODO("Completar")
}

/**
 *  Calcular cuantas veces aparece un elemento en un arbol
 */
fun <T> contarNumVecesApareceElemento(a: IBinTree<T>, e: T): Int =
    if (a.isEmpty) {
        0
    }else{
        var contador = contarNumVecesApareceElemento(a.left,e) + contarNumVecesApareceElemento(a.right, e)
        var raiz = a.root
        if (raiz == e){
            contador += 1
        }
        contador
    }

/**
 * Calcular el menor de un árbol binario. El Algoritmo es el siguiente
 * Si el árbol está vacío, digamos que el menor es un número grande, por ejemplo Int.MAX_VALUE
 * sino hay que retornar el menor entre la raíz, el menor del árbol izquierdo y el menor del árbol derecho
 */
fun menorArbol(arbol: IBinTree<Int>): Int =
    when{
        arbol.isEmpty -> Int.MAX_VALUE
        else -> {
            val menorIzq = menorArbol(arbol.left)
            val menorDer = menorArbol(arbol.right)
            val raiz = arbol.root
            if (raiz < menorIzq && raiz < menorDer){
                raiz
            }
            else if (menorIzq < raiz && menorIzq < menorDer){
                menorIzq
            }
            else{
                menorDer
            }
        }
    }

/**
 * Retorna true si todas las palabras que están en el árbol
 * son verbos. Falso, si hay al menos una palabra que no sea un verbo.
 * Los árboles vacíos son verbales.
 */
fun esVerbo(pal:String): Boolean {
    return pal.endsWith("AR") || pal.endsWith("ER") || pal.endsWith("IR")
}

fun verbal(arbol: IBinTree<String>): Boolean =
    when{
        arbol.isEmpty -> true
        !esVerbo(arbol.root.uppercase()) -> false
        else -> verbal(arbol.left) && verbal(arbol.right)
    }

/**
 * Un árbol binario es "digital" si cada elemento del árbol
 * tienen un solo dígito. Esta función retorna true si el
 * árbol es digital y false si no lo es. Los árboles vacíos
 * son digitales.
 */
fun digital(arbol: IBinTree<Int>): Boolean {
    return when{
        arbol.isEmpty -> true
        arbol.root >= 10 -> false
        else -> digital(arbol.left) && digital(arbol.right)
    }
}

/**
 * Retornar la palabra más larga del árbol binario.
 * Si el árbol es vacío, la palabra más larga es vacía ""
 */
fun palabraMasLarga(palabras: IBinTree<String>): String =
    if (palabras.isEmpty) {
        ""
    } else {
        var masLarga = ""
        var raiz = palabras.root
        if (raiz.length > masLarga.length) {
            masLarga = raiz
        }
        palabraMasLarga(palabras.right)
    }

/**
 * Especificación de la clase Producto
 */
data class Producto(val nombre: String, val precio: Double)

/**
 * Retorna el producto más caro del árbol de productos.
 * Si el árbol está vacío, retorna null
 * Sino, retorna el producto más caro entre el arbol izquierdo, el derecho y la raíz
 * Hay que tener en cuenta cuando el más caro de algún árbol es nulo.
 */
fun productoMasCaro(a: IBinTree<Producto>): Producto? {
    TODO("Completar")
}

/**
 * Halla el promedio de precios de todos los productos del árbol
 */

fun sumaPrecios(a: IBinTree<Producto>): Double =
    if (a.isEmpty) {
        0.0
    }else{
        var contador = sumaPrecios(a.left) + sumaPrecios(a.right)
        contador += a.root.precio
        contador
    }


fun promedioPrecios(a: IBinTree<Producto>): Double =
    if (a.isEmpty){
        0.0
    }
    else {
        var totPro = peso(a)
        var sumPre = sumaPrecios(a)
        sumPre / totPro
    }

/**
 * Obtiene una lista con los nombres de los productos que tienen un precio
 * inferior al promedio de precios de todos los productos del árbol
 */
fun productosInferiorPromedio(a: IBinTree<Producto>): IList<String> {
    // Obtiene una lista con los nombres de productos con precio inferior al que se pasa por parámetro
    fun productosInferiorPrecio(a: IBinTree<Producto>, precio: Double): IList<String> {
        TODO("Completar")
    }
    // -------------------------------------------------------------
    val promedio = promedioPrecios(a)
    return productosInferiorPrecio(a, promedio)
}

/**
 * Obtiene el precio del producto que tiene el nombre dado
 * Si el árbol es vacío, deberá retornar null.
 */
fun encontrarPrecioProducto(prods: IBinTree<Producto>, nomProducto: String): Double? =
    when{
        prods.isEmpty -> 0.0
        else -> {
            var price = 0.0
            var contI = encontrarPrecioProducto(prods.left, nomProducto)
            var contD = encontrarPrecioProducto(prods.right, nomProducto)
            if (prods.root.nombre == nomProducto){
                price = prods.root.precio
            }
            null
        }
    }

/**
 * Determina la cantidad de productos cuyo nombre comienzan con la letra
 * que se pasa como parámetro.
 */
fun contarProductosNombreComienzanConLetra(prods: IBinTree<Producto>, letra: Char): Int =
    when{
        prods.isEmpty -> 0
        else -> {
            var cont = contarProductosNombreComienzanConLetra(prods.left, letra) + contarProductosNombreComienzanConLetra(prods.right, letra)
            if (prods.root.nombre.startsWith(letra)){
                cont ++
            }
            cont
        }
    }

/**
 * Un árbol de producto es un inventario correcto si todos
 * los elementos del árbol de productos tienen un precio superior a 100.0
 * Los árboles vacíos son un inventario correcto
 */
fun inventarioCorrecto(prods: IBinTree<Producto>): Boolean =
    when{
        prods.isEmpty -> true
        prods.root.precio <= 100.0 -> false
        else -> inventarioCorrecto(prods.left) && inventarioCorrecto(prods.right)
    }

