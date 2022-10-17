package pilas

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Proyecto Taller de Pilas
 * Autor: Universidad EAN - Septiembre 13, 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.*
import org.testng.Assert.*
import org.testng.annotations.Test
import java.time.Year
import java.util.LinkedList

/**
 * A partir de una pila de palabras, retornar cuántas de esas
 * palabras son verbos. La pila original no debe verse modificada
 */
fun contarVerbos(palabras: IStack<String>): Int {
    var copiaPila = palabras.copy()
    var cont = 0

    while (!copiaPila.isEmpty){
        val palabra = copiaPila.peek().lowercase()
        if ((palabra.endsWith("ar"))
            || (palabra.endsWith("er"))
            || (palabra.endsWith("ir"))){
            cont += 1
        }
        copiaPila.pop()
    }
    return cont
}

/**
 * Ejercicio 02
 * Función para sumar los números pares de tres cifras que hay en una
 * pila de enteros. La pila original no debe verse modificada.
 */
fun sumarParesTresCifras(pila: IStack<Int>): Int {
    val secondaryStack = pila.copy()
    val stackPeekAndPop = { stack:IStack<Int> -> val stackElement = stack.peek(); stack.pop(); stackElement }

    var sum = 0
    while(!secondaryStack.isEmpty) {
        val stackValue = stackPeekAndPop(secondaryStack)
        if(stackValue in 100 until 1000 && stackValue%2 == 0) {
            sum+=stackValue
        }
    }

    return sum
}

/**
 * Ejercicio 03
 * Función para determinar cuál es el número más grande de dos cifras que hay
 * en una pila de números. Si no existe ningún número de dos cifras, retorne
 * null. La pila original no debe verse modificada.
 */
fun mayorDeDosCifras(pila: IStack<Int>): Int? {
    var copiaPila = pila.copy()
    var mayor : Int? = null

    while (!copiaPila.isEmpty){
        val n = copiaPila.peek()
        if (n in 10 .. 99){
            if ((mayor == null) || (mayor!! < n)){
                mayor = n
            }
        }
        copiaPila.pop()
    }
    return mayor
}

/**
 * Ejercicio 01
 * Obtener y retornar el fondo de la pila. La pila original no debe verse
 * modificada.
 */
fun <T> obtenerFondo(pila: IStack<T>): T? {
    var copiaPila = pila.copy()
    var x: T?  = copiaPila.peek()

    while (!copiaPila.isEmpty){
        x = copiaPila.peek()
        copiaPila.pop()
    }
    return x
}

/**
 * Ejercicio 04
 * Hacer una función externa que permita guardar un elemento en el fondo
 * de la pila. GEnérica. La pila original no debe verse modificada.
 */
fun <T> guardarEnElFondo(p: IStack<T>, elem: T) {
    var copiaPila : IStack<T> = TLinkedStack()
    while (!p.isEmpty){
        var palabra = p.peek()
        copiaPila.push(palabra)
        p.pop()
    }
    p.push(elem)
    while (!copiaPila.isEmpty){
        val palabra = copiaPila.peek()
        p!!.push(palabra)
        copiaPila.pop()
    }
}

/**
 * Ejercicio 05
 * Función genérica para obtener el tamaño de una pila. La pila
 * original no debe verse modificada.
 */
fun <T> tamPila(p: IStack<T>) : Int {
    var copiaPila = p.copy()
    var cont = 0
    while (!copiaPila.isEmpty){
        cont +=1
        copiaPila.pop()
    }
    return cont
}

/**
 * Ejercicio 06
 * Función genérica que permite Invertir una pila en otra.
 * Recibe la pila y retorna la pila, pero invertida.
 * Solo puede usarse las operaciones de las pilas, no listas.
 */
fun <T> invertirPila(pila: IStack<T>): IStack<T> {
    var copiaPila = pila.copy()
    var pilaInvt : IStack<T> = TLinkedStack()
    while (!copiaPila.isEmpty){
        val x = copiaPila.peek()
        pilaInvt.push(x)
        copiaPila.pop()
    }
    return pilaInvt
}


/**
 * Ejercicio 07
 * Función genérica que copia una pila en otra.
 * La función recibe la pila y retorna la copia.
 * No debe usarse el método copy de la pila ni listas.
 * La pila original no debe verse modificada.
 */
fun <T> copiarPila(pila: IStack<T>): IStack<T> {
    return invertirPila(invertirPila(pila))
}


/**
 * Ejercicio 08
 * Función genérica que recibe una pila y un elemento y que elimina de la
 * pila todas las ocurrencias del elemento que se recibe como parámetro.
 * No debe retornar nada.
 */
fun <T> eliminarElementoPila(pila: IStack<T>, elem: T) {
    var copiaPila : IStack<T> = TLinkedStack()
    while (!pila.isEmpty){
        val x = pila.peek()
        copiaPila.push(x)
        pila.pop()
    }

    while (!copiaPila.isEmpty){
        val palabra = copiaPila.peek()
        if (palabra === elem){
            copiaPila.pop()
            continue
        }else{
            pila.push(palabra)
            copiaPila.pop()
        }

    }

}

/**
 * Ejercicio 09
 * Invertir una lista de números utilizando una pila. La función no retorna,
 * debe modificar la lista
 */
fun invertirLista(list: IList<Int>) {
    var pila : IStack<Int> = TLinkedStack()
    list.forEach { pila.push(it) }
    list.clear()
    while (!pila.isEmpty){
        var x = pila.peek()
        list.add(x)
        pila.pop()
    }
}


/**
 * Ejercicio 10
 * Usar una pila de letras para Determinar si una frase es palindrome o no
 */
fun palindrome(frase: String): Boolean {
    val pila: IStack<String> = TLinkedStack()
    frase.forEach { pila.push(it.toString()) }
    val pila_invert = invertirPila(pila)

    while (!pila.isEmpty){
        if (pila.peek() != pila_invert.peek())
            return false
        else{
            pila.pop()
            pila_invert.pop()
        }
    }
    return true
}

/**
 * Ejercicio 11
 * Determinar si dos pilas son iguales.
 * Las pilas no deben ser modificadas.0
 */
fun <T> igualesPilas(pila1: IStack<T>, pila2: IStack<T>): Boolean {
    return if (tamPila(pila1) != tamPila(pila2))  false
    else {
        while (!pila1.isEmpty) {
            if (pila1.peek() != pila2.peek())
                false
            else {
                pila1.pop()
                pila2.pop()
            }
        }
        true
    }
}

/**
 * Escriba una función que reemplace cada aparición del elemento
 * oldItem por el elemento newItem en la pila.
 */
fun reemplazarElementoPila(pila: IStack<Int>, oldItem: Int, newItem: Int) {
    var copiaPila : IStack<Int> = TLinkedStack()
    var stackPeekAndPop = { stack:IStack<Int> -> val element = stack.peek(); stack.pop(); element }

    while (!pila.isEmpty) copiaPila.push(stackPeekAndPop(pila))

    while (!copiaPila.isEmpty){
        val palabra = stackPeekAndPop(copiaPila)
        if (palabra == oldItem) pila.push(newItem)
        else pila.push(palabra)
    }
}

// Una clase que representa perros
data class Perro(var nombre: String, var edad: Int)

/**
 * Escriba una función que reciba una pila de perros y que retorne
 * una lista con los nombres de aquellos perros que tengan un nombre
 * que termine en vocal y cuya edad sea inferior a la edad que se
 * pasa como parámetro. La pila original no debe verse modificada.
 */
fun perrosMenoresEdad(perros: IStack<Perro>, edad: Int): IList<String> {
    var copiaPila = perros.copy()
    var listaPerros:IList<String> = Lists.empty()

    while (!copiaPila.isEmpty){
        val x = copiaPila.peek()
        var name = x.nombre
        if(((name.endsWith("a"))
            || (name.endsWith("e"))
            || (name.endsWith("i"))
            || (name.endsWith("o"))
            || (name.endsWith("u")))
            && (x.edad < edad)){
            listaPerros.add(name)
        }
        copiaPila.pop()
    }
    return listaPerros
}

//------------------------------------------------------------------------------------------------

class ProbarPila {
    @Test
    fun pruebaEjercicio01() {
        val pila: IStack<Int> = TLinkedStack()

        pila.push(1)
        pila.push(2)
        pila.push(3)
        pila.push(4)
        pila.push(5)
        pila.push(6)

        println("La pila es $pila")
        println("El tope es ${pila.peek()}")
        println("El fondo es ${obtenerFondo(pila)}")

        assertEquals(1, obtenerFondo(pila))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio02() {
        val p: IStack<Int> = TLinkedStack()

        p.push(2)
        p.push(25)
        p.push(250)
        p.push(2500)
        p.push(100)
        p.push(125)
        p.push(81)

        assertEquals(350, sumarParesTresCifras(p))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio03() {
        var p: IStack<Int> = TLinkedStack()

        p.push(2)
        p.push(25)
        p.push(250)
        p.push(50)
        p.push(100)
        p.push(95)
        p.push(81)

        assertEquals(mayorDeDosCifras(p), 95)
        println("Primera Prueba Superada ✔")

        p.clear()
        p.push(3)
        p.push(4)
        p.push(5)

        assertNull(mayorDeDosCifras(p))
        println("Prueba Superada ✔")

    }

    @Test
    fun pruebaEjercicio04() {
        val pila: IStack<Int> = TLinkedStack()

        pila.push(1)
        pila.push(2)
        pila.push(3)
        pila.push(4)
        pila.push(5)
        pila.push(6)

        assertEquals(1, obtenerFondo(pila))

        guardarEnElFondo(pila, 10)

        assertEquals(10, obtenerFondo(pila))
        println("Prueba superada!")
    }


    @Test
    fun pruebaEjercicio05() {
        val pila: IStack<String> = TLinkedStack()

        assertEquals(0, tamPila(pila))

        pila.push("Hola")
        pila.push("nano")
        pila.push("shell")
        pila.push("rojo")

        assertEquals(4, tamPila(pila))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio06() {
        val pila: IStack<String> = TLinkedStack()
        val lista = TList("uno", "dos", "tres", "cuatro", "cinco")

        for (elem in lista) {
            pila.push(elem)
        }

        val inv = invertirPila(pila)
        for (elem in lista) {
            assertEquals(elem, inv.peek())
            inv.pop()
        }
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio07() {
        val pila: IStack<Int> = TLinkedStack()
        val lista = Lists.of(5, 11, 8, -3, 6, 4, 31)

        for (elem in lista) {
            pila.push(elem)
        }

        val copia = copiarPila(pila)
        for (n in lista.size - 1 downTo 0) {
            assertEquals(lista[n], copia.peek())
            copia.pop()
        }
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio08() {
        val pila: IStack<Int> = TLinkedStack()
        val lista = Lists.of(5, 11, 8, -3, 5, 4, 31, 5)

        for (elem in lista) {
            pila.push(elem)
        }

        eliminarElementoPila(pila, 5)

        for (n in lista.size - 1 downTo 0) {
            if (lista[n] != 5) {
                assertEquals(lista[n], pila.peek())
                pila.pop()
            }
        }
        assertTrue(pila.isEmpty)
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio09() {
        val lista = Lists.of(8, 1, 7, 6, -4, 5, 1, 31)
        val invlst = lista.copy()

        invertirLista(lista)

        for (i in 0 until lista.size) {
            assertEquals(lista[i], invlst[lista.size - i - 1])
        }
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio10() {
        assertTrue(palindrome("nosubasabuson"))
        assertTrue(palindrome("lavanesabasenaval"))
        assertTrue(palindrome("logracasillasallisacargol"))
        assertFalse(palindrome("arrozconleche"))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaEjercicio11() {
        val pila1: IStack<String> = TLinkedStack()
        val pila2: IStack<String> = TLinkedStack()
        val pila3: IStack<String> = TLinkedStack()
        val lista = Lists.of("uno", "dos", "tres", "cuatro", "cinco")

        for (elem in lista) {
            pila1.push(elem)
            pila2.push(elem)
            pila3.push(elem)
            pila3.push(elem)
        }

        assertTrue(igualesPilas(pila1, pila2))
        assertFalse(igualesPilas(pila3, pila2))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaContarVerbos() {
        val palabras: IStack<String> = TArrayStack()

        palabras.push("casa")
        palabras.push("casar")
        palabras.push("yuca")
        palabras.push("camisa")
        palabras.push("lluvia")
        palabras.push("llover")
        palabras.push("vives")
        palabras.push("vivir")
        palabras.push("partir")
        palabras.push("toma")
        palabras.push("épico")
        palabras.push("abrigo")

        assertEquals(4, contarVerbos(palabras))
        println("Prueba Superada ✔")
    }

    @Test
    fun pruebaReemplazar() {
        val pila: IStack<Int> = TArrayStack()

        pila.push(4)
        pila.push(2)
        pila.push(3)
        pila.push(5)
        pila.push(2)
        pila.push(1)

        reemplazarElementoPila(pila, 2, 7)
        var n = 0
        var x = 0

        while (!pila.isEmpty) {
            n++
            if (pila.peek() == 7) {
                x++
            }
            else if (pila.peek() == 2) {
                assertEquals(7, pila.peek())
            }
            pila.pop()
        }
        assertTrue(n == 6 && x == 2)
        println("Prueba Superada ✔")

    }

    @Test
    fun probarPerros() {
        var pilaPerros: IStack<Perro> = TLinkedStack()

        with (pilaPerros) {
            push(Perro("juana", 12))
            push(Perro("lila", 6))
            push(Perro("leon", 5))
            push(Perro("dion", 7))
            push(Perro("leila", 11))
            push(Perro("angel", 3))
            push(Perro("angela", 4))
            push(Perro("terso", 5))
        }

        val res = perrosMenoresEdad(pilaPerros, 10)
        val res1 = res.sort()
        assertEquals(Lists.of("angela", "lila", "terso"), res1)
        println("Prueba superada!")
    }
}