package ean.estructuradedatos.tallercolas

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 * <p>
 * Proyecto Taller con las Colas
 * Autor: Universidad EAN - Septiembre 20, 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.*
import org.junit.jupiter.api.Test
import kotlin.test.*

/* Función que recibes una cola de palabras y
   que retorne la palabra más larga de la cola.
   La cola original no debe verse modificada. Usa una copia.
 */
fun palabraMasLarga(colaPals: IQueue<String>): String {
    var palabraMayor = ""
    var copiaCola = colaPals.copy()
    var cont = 0
    var xcont : Int

    while (!copiaCola.isEmpty){
        val x = copiaCola.front
        var colaChar : IQueue<Char> = TLinkedQueue()

        //for (i in x){
        //    colaChar.enqueue(i)
        //}

        x.forEach { it in x; colaChar.enqueue(it) }

        xcont = tamCola(colaChar)
        if (xcont > cont){
            palabraMayor = x
            cont = xcont
        }
        copiaCola.dequeue()
    }
    return palabraMayor
}

/*
Escriba una función genérica que determine el tamaño de una cola.
La cola original no debe verse modificada.
*/
fun <T> tamCola(cola: IQueue<T>): Int {
    var copiaCola = cola.copy()
    var cont = 0
    while (!copiaCola.isEmpty){
        cont +=1
        copiaCola.dequeue()
    }
    return cont
}

/*
Función genérica que recibe un elemento y una cola y que
retorna true si el elemento está en la cola y false sino
se encuentra el elemento en la cola. La cola original no
debe verse modificada.
 */
fun <T> existeElemento(col: IQueue<T>, elem: T): Boolean {
    var copiaCola = col.copy()

    while (!copiaCola.isEmpty) {
        val x = copiaCola.front
        if (elem == x){
            return true
        }else{
            copiaCola.dequeue()
        }
    }
    return false
}

/*
Función genérica para determinar si dos colas son iguales.
Ninguna de las dos colas deben verse modificadas.
 */
fun <T> igualesColas(col1: IQueue<T>, col2: IQueue<T>): Boolean {
    var copia1 = col1.copy()
    var copia2 = col2.copy()

    if (tamCola(copia1) != tamCola(copia2)){
        return false
    } else {
        while (!copia1.isEmpty) {
            if (copia1.front != copia2.front)
                return false
            else {
                copia1.dequeue()
                copia2.dequeue()
            }
        }
        return true
    }
}

/*
Función genérica que invierte los elementos de la cola.
Debe modificar la cola. Puede usar una pila.
 */
fun <T> invertirCola(col: IQueue<T>) {
    var pilaInvt : IStack<T> = TLinkedStack()
    while (!col.isEmpty){
        val x = col.front
        pilaInvt.push(x)
        col.dequeue()
    }

    while (!pilaInvt.isEmpty){
        val x = pilaInvt.peek()
        col.enqueue(x)
        pilaInvt.pop()
    }
}

/**
 * Una cola es binario si los únicos números dentro de la cola
 * son los números 1 y 0. Escriba la siguiente función que reciba
 * una cola de números enteros y que retorne true si la cola es
 * binario y false si no es así.
 */
fun colaBinaria(cola: IQueue<Int>): Boolean {
    var copiaCola = cola.copy()

    while (!copiaCola.isEmpty) {
        val x = copiaCola.front
        if ((x == 1) || (x == 0)){
            copiaCola.dequeue()
        }else{
            return false
        }
    }
    return true
}

/**
 * Clase Apartamento: atributos el piso, el número de personas que habitan allí
 * y el tamaño del apartamento
 */
data class Apartamento(val numero: Int, val piso: Int, val habitantes: Int, val tamaño: Double)

/**
 * Escriba una función que reciba una cola de apartamento y que retorna una lista
 * con los números de aquellos apartamentos vacíos (sin habitantes) en la cola.
 * La Cola original no debe verse modificada.
 */
fun aptosSinGente(aptos: IQueue<Apartamento>): IList<Int> {
    var copiaAptos = aptos.copy()
    val resultado: IList<Int> = Lists.empty()

    while (!copiaAptos.isEmpty){
        val apto = copiaAptos.front

        if (apto.habitantes == 0){
            resultado.add(apto.numero)
            copiaAptos.dequeue()
        }else{
            copiaAptos.dequeue()
        }
    }
    return resultado;
}

/**
 * Retorna el apto más grande (de mayor tamaño)
 * que esté ubicado del piso dado hacia arriba
 * Si no hay aptos del piso dado hacia arriba, retorne null
 * La cola original no debe verse modificada.
 */
fun aptoMasGrande(aptos: IQueue<Apartamento>, piso: Int): Apartamento? {
    var aptoMayor: Apartamento? = null
    var copiaAptos = aptos.copy()
    var mayorTam = 0.0
    while (!copiaAptos.isEmpty){
        val apto = copiaAptos.front
        if (apto.piso > piso){
            if (apto.tamaño > mayorTam){
                aptoMayor = apto
                mayorTam = apto.tamaño
            }
        }
        copiaAptos.dequeue()
    }
    return aptoMayor
}

/**
 * Un edificio tiene una cola de apartamentos
 */
class Edificio {
    // Atributos
    private val apartamentos: IQueue<Apartamento> = TLinkedQueue()

    // Constructor
    constructor() {
        apartamentos.enqueue(Apartamento(101, 1, 3, 75.0))
        apartamentos.enqueue(Apartamento(102, 1, 0, 66.0))
        apartamentos.enqueue(Apartamento(201, 2, 1, 42.0))
        apartamentos.enqueue(Apartamento(202, 2, 0, 37.0))
        apartamentos.enqueue(Apartamento(301, 3, 0, 106.0))
        apartamentos.enqueue(Apartamento(302, 3, 4, 96.0))
    }

    /**
     * Retorna la altura del edificio. O sea, el piso más grande de toda la cola
     * de apartamentos. La cola original no debe verse modificada
     */
    fun altura(): Int {
        var aptoMayor: Apartamento? = null
        var copiaAptos = apartamentos.copy()
        var pisoMay = 0
        while (!copiaAptos.isEmpty){
            val apto = copiaAptos.front
            if (apto.piso > pisoMay){
                pisoMay = apto.piso
            }
            copiaAptos.dequeue()
        }
        return pisoMay
    }

    /**
     * Obtiene el número del apartamento que tiene mayor cantidad de habitantes
     * La cola original no debe verse modificada
     */
    fun aptoMasPoblado(): Int {
        var aptoMasPob: Apartamento? = null
        var copiaAptos = apartamentos.copy()
        var numHab = 0
        while (!copiaAptos.isEmpty){
            val apto = copiaAptos.front
            if (apto.habitantes > numHab){
                numHab = apto.habitantes
                aptoMasPob = apto
            }
            copiaAptos.dequeue()
        }
        return aptoMasPob!!.numero
    }

    /**
     * Dado el número del apartamento, obtiene el apartamento que tiene ese número
     * si no existe un apartamento con ese número, deberá retornarse null
     * La cola original no debe verse modificada.
     */
    fun buscarApto(numeroApto: Int): Apartamento? {
        var aptoBusc: Apartamento? = null
        var copiaAptos = apartamentos.copy()

        while (!copiaAptos.isEmpty){
            var apto = copiaAptos.front
            if (apto.numero == numeroApto){
                aptoBusc = apto
            }
            copiaAptos.dequeue()
        }
        return aptoBusc
    }
}

//--------------------------------------------------------------------
// Pruebas de las funciones anteriores
//--------------------------------------------------------------------
class Pruebas {
    @Test
    fun prueba1() {
        val cola: IQueue<String> = TLinkedQueue()

        cola.enqueue("hola")
        cola.enqueue("carro")
        cola.enqueue("internacionalizacion")
        cola.enqueue("relojito")
        cola.enqueue("ana")
        cola.enqueue("vericueto")
        cola.enqueue("rosales")

        assertEquals("internacionalizacion", palabraMasLarga(cola))
        println("Prueba superada ☺")
    }

    @Test
    fun prueba2() {
        val cola: IQueue<Double> = TLinkedQueue()

        cola.enqueue(4.5)
        cola.enqueue(-1.17)
        cola.enqueue(10.87)
        cola.enqueue(100.1)
        cola.enqueue(451.811)

        assertEquals(5, tamCola(cola))
        println("Prueba superada ☺")
    }

    @Test
    fun prueba3() {
        val c: IQueue<Char> = TLinkedQueue()

        c.enqueue('x')
        c.enqueue('d')
        c.enqueue('a')
        c.enqueue('f')
        c.enqueue('c')
        c.enqueue('3')
        c.enqueue('#')
        c.enqueue('=')
        c.enqueue('¿')
        c.enqueue('«')
        c.enqueue('y')

        assertTrue {
            existeElemento(c, '#')
        }

        assertFalse {
            existeElemento(c, '?')
        }

        println("Prueba superada ☺")
    }

    @Test
    fun prueba4() {
        var cola1: IQueue<Int> = TLinkedQueue()

        cola1.enqueue(4)
        cola1.enqueue(71)
        cola1.enqueue(27)
        cola1.enqueue(-34171)
        cola1.enqueue(181)

        var cola2: IQueue<Int> = cola1.copy()

        assertTrue(igualesColas(cola1, cola2))

        cola2.enqueue(36)
        cola2.enqueue(23)

        assertFalse(igualesColas(cola2, cola1))

        println("Prueba superada ☺")
    }

    @Test
    fun prueba5() {
        var c1: IQueue<Char> = TLinkedQueue()
        var c2: IQueue<Char> = TLinkedQueue()

        c1.enqueue('x')
        c1.enqueue('y')
        c1.enqueue('z')
        c1.enqueue('w')

        c2.enqueue('w')
        c2.enqueue('z')
        c2.enqueue('y')
        c2.enqueue('x')

        assertFalse {
            igualesColas(c1, c2)
        }

        invertirCola(c1)

        assertTrue {
            igualesColas(c1, c2)
        }

        println("Prueba superada ☺")
    }

    @Test
    fun pruebaColaBinaria() {
        val cola1: IQueue<Int> = TLinkedQueue()
        with (cola1) {
            enqueue(1)
            enqueue(0)
            enqueue(0)
            enqueue(1)
            enqueue(0)
            enqueue(1)
            enqueue(1)
            enqueue(0)
        }
        assertTrue {
            colaBinaria(cola1)
        }
        println("Primera prueba superada!")

        val cola2: IQueue<Int> = TLinkedQueue()
        with (cola2) {
            enqueue(1)
            enqueue(1)
            enqueue(0)
            enqueue(10)
            enqueue(11)
            enqueue(1)
        }
        assertFalse {
            colaBinaria(cola2)
        }
        println("Segunda prueba superada!")
    }

    @Test
    fun pruebaAptosSinGente() {
        var cola: IQueue<Apartamento> = TLinkedQueue()

        cola.enqueue(Apartamento(101, 1, 3, 75.0))
        cola.enqueue(Apartamento(102, 1, 0, 66.0))
        cola.enqueue(Apartamento(201, 2, 1, 42.0))
        cola.enqueue(Apartamento(202, 2, 0, 37.0))
        cola.enqueue(Apartamento(301, 3, 0, 106.0))
        cola.enqueue(Apartamento(302, 3, 4, 96.0))

        var lista1: IList<Int> = Lists.of(102, 202, 301)
        val lista2 = aptosSinGente(cola).sort()
        assertEquals(lista2, lista1)
        println("Prueba superada!!")
    }

    @Test
    fun pruebaAptoMasGrande() {
        var cola: IQueue<Apartamento> = TLinkedQueue()

        cola.enqueue(Apartamento(101, 1, 3, 75.0))
        cola.enqueue(Apartamento(102, 1, 0, 66.0))
        cola.enqueue(Apartamento(201, 2, 1, 42.0))
        cola.enqueue(Apartamento(202, 2, 0, 37.0))
        cola.enqueue(Apartamento(301, 3, 0, 106.0))
        cola.enqueue(Apartamento(302, 3, 4, 96.0))

        val apto = aptoMasGrande(cola, 2)
        assertNotNull(apto)
        assertEquals(301, apto.numero)
        println("Prueba superada!")
    }

    @Test
    fun pruebaEdificio() {
        var edificio: Edificio = Edificio()

        assertEquals(3, edificio.altura())
        println("Primera prueba superada!")

        assertEquals(302, edificio.aptoMasPoblado())
        println("Segunda prueba superada")

        var apto = edificio.buscarApto(203)
        assertNull(apto)
        apto = edificio.buscarApto(102)
        assertNotNull(apto)
        assertEquals(102, apto.numero)
        assertEquals(66.0, apto.tamaño)
        println("Tercera prueba superada!!")
    }
}
