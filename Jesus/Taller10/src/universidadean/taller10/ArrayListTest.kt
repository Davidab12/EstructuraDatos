package universidadean.taller10

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ArrayListTest {

    @Test
    fun pruebaAgregarAlFinal() {
        val lista: IList<Int> = ArrayList()

        assertEquals(0, lista.size())

        lista.add(10)
        lista.add(2)
        lista.add(1)
        lista.add(8)
        lista.add(15)

        assertEquals(5, lista.size())
        assertEquals(10, lista[0])
        assertEquals(15, lista.last())
        assertEquals(1, lista[2])

        println("Pruebas superadas ✔")
    }

    /**
     * Pruebas de agregar al principio
     */
    @Test
    fun pruebasAgregarAlPrincipio() {
        // Creamos una lista
        val lista:IList<Int> = ArrayList()

        // Llenamos la lista de una serie de datos
        lista.addToHead(15)
        lista.addToHead(38)
        lista.addToHead(3)
        lista.addToHead(43)
        lista.addToHead(67)
        lista.addToHead(25)
        lista.addToHead(78)

        // Verificamos el contenido de la lista
        assertEquals(7, lista.size())

        // Ahora verificamos el contenido de la lista
        val primero = lista.first()
        assertEquals(78, primero)

        val ultimo = lista.last()
        assertEquals(15, ultimo)

        val mitad = lista[3] // El quinto elemento
        assertEquals(43, mitad)
        println("Prueba superada ✔")
    }

    @Test
    fun pruebasAgregarEnLaMitad() {
        // Creamos una lista
        val lista:IList<Int> = ArrayList()

        // Llenamos la lista de una serie de datos
        lista.add(15)
        lista.add(38)
        lista.add(3)
        lista.add(43)
        lista.add(67)
        lista.add(25)
        lista.add(78)

        // Verificamos el contenido de la lista
        assertEquals(7, lista.size())
        assertEquals(3, lista[2])
        assertEquals(43, lista[3])
        assertEquals(67, lista[4])

        // Agregamos un elemento en la mitad de la lista
        lista.add(3, 79)
        assertEquals(8, lista.size())
        assertEquals(3, lista[2])
        assertEquals(79, lista[3])
        assertEquals(43, lista[4])
        assertEquals(67, lista[5])
        println("Primera Prueba superada ✔")

        // Agregamos un elemento en la mitad de la lista
        lista.add(6, 28)
        assertEquals(9, lista.size())
        assertEquals(3, lista[2])
        assertEquals(79, lista[3])
        assertEquals(43, lista[4])
        assertEquals(67, lista[5])
        assertEquals(28, lista[6])
        assertEquals(25, lista[7])
        assertEquals(78, lista[8])
        println("Segunda Prueba superada ✔")

    }

    @Test
    fun pruebaIsEmpty() {

        // Creamos una lista
        val lista: IList<Int> = ArrayList()

        // Verificamos que la lista esté vacía
        assertTrue(lista.isEmpty())

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(35)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(35)
        lista.add(8)

        // Verificamos el contenido de la lista
        assertEquals(10, lista.size())

        // Verificamos que la lista no esté vacía
        assertFalse(lista.isEmpty())
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaRemove() {
        // Creamos una lista
        val lista: IList<Int> = ArrayList()

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(35)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(35)
        lista.add(8)

        // Verificamos el contenido de la lista
        assertEquals(10, lista.size())

        // Ahora borramos el segundo elemento, posicion 1
        lista.remove(1)

        // Verificamos el tamaño
        assertEquals(9, lista.size())

        // Verificar el contenido de la lista
        val antes = lista[0]
        val desp = lista[1]
        assertTrue(antes == 35 && desp == 3)

        assertEquals(43, lista[2])
        assertEquals(35, lista[3])
        assertEquals(45, lista[4])
        assertEquals(4, lista[5])
        assertEquals(63, lista[6])
        assertEquals(35, lista[7])
        assertEquals(8, lista[8])

        println("Primera prueba superada ✔")

        // Ahora borramos el elemento en la posición 4
        lista.remove(4)

        // Verificamos el tamaño
        assertEquals(8, lista.size())

        // Verificar el contenido de la lista
        assertEquals(35, lista[0])
        assertEquals(3, lista[1])
        assertEquals(43, lista[2])
        assertEquals(35, lista[3])
        assertEquals(4, lista[4])
        assertEquals(63, lista[5])
        assertEquals(35, lista[6])
        assertEquals(8, lista[7])

        println("Segunda prueba superada ✔")
    }

    @Test
    fun pruebaRemoveFirst() {
        // Creamos una lista
        val lista: IList<Int> = ArrayList()

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(25)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(35)
        lista.add(8)

        // Verificamos el contenido de la lista
        assertEquals(10, lista.size())

        // Ahora borramos el primer elemento
        lista.removeFirst()

        // Verificamos el tamaño
        assertEquals(9, lista.size())

        // Verificamos el contenido de la lsita
        assertEquals(8, lista[0])
        assertEquals(3, lista[1])
        assertEquals(43, lista[2])
        assertEquals(25, lista[3])
        assertEquals(45, lista[4])
        assertEquals(4, lista[5])
        assertEquals(63, lista[6])
        assertEquals(35, lista[7])
        assertEquals(8, lista[8])
        println("Primera prueba superada ✔")

        // Ahora borramos el primer elemento
        lista.removeFirst()

        // Verificamos el tamaño
        assertEquals(8, lista.size())

        // Verificamos el contenido de la lsita
        assertEquals(3, lista[0])
        assertEquals(43, lista[1])
        assertEquals(25, lista[2])
        assertEquals(45, lista[3])
        assertEquals(4, lista[4])
        assertEquals(63, lista[5])
        assertEquals(35, lista[6])
        assertEquals(8, lista[7])
        println("Segunda prueba superada ✔")
    }

    @Test
    fun pruebaRemoveLast() {
        // Creamos una lista
        val lista: IList<Int> = ArrayList()

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(25)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(42)
        lista.add(18)

        // Verificamos el contenido de la lista
        assertEquals(10, lista.size())
        assert(lista.first() == 35 && lista.last() == 18)

        // Ahora borramos el último elemento
        lista.removeLast()

        // Verificamos el tamaño
        assertEquals(9, lista.size())

        // Verificamos el contenido de la lista
        assertEquals(35, lista[0])
        assertEquals(8, lista[1])
        assertEquals(3, lista[2])
        assertEquals(43, lista[3])
        assertEquals(25, lista[4])
        assertEquals(45, lista[5])
        assertEquals(4, lista[6])
        assertEquals(63, lista[7])
        assertEquals(42, lista[8])
        println("Primera prueba superada ✔")

        // Ahora borramos el último elemento otra vez
        lista.removeLast()
        assert(lista.first() == 35 && lista.last() == 63)

        // Verificamos el tamaño
        assertEquals(8, lista.size())

        // Verificamos el contenido de la lsita
        assertEquals(35, lista[0])
        assertEquals(8, lista[1])
        assertEquals(3, lista[2])
        assertEquals(43, lista[3])
        assertEquals(25, lista[4])
        assertEquals(45, lista[5])
        assertEquals(4, lista[6])
        assertEquals(63, lista[7])
        println("Segunda prueba superada ✔")
    }

    @Test
    fun pruebaClear() {
        // Creamos una lista
        val lista:IList<Int> = ArrayList()

        // Llenamos la lista de una serie de datos
        lista.add(5)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(67)
        lista.add(45)

        // Verificamos el contenido de la lista
        assertEquals(6, lista.size())

        // Ahora limpiamos la lista
        lista.clear()

        // Ahora verificamos que la lista está vacía
        assertEquals(0, lista.size())
        assertTrue(lista.isEmpty())
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaIndexOf() {
        // Creamos una lista
        val lista: IList<Int> = ArrayList()

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(35)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(35)
        lista.add(8)

        // Verificamos el contenido de la lista
        assertEquals(10, lista.size())

        // Encontramos la posicion de un elemento existente
        var pos = lista.indexOf(8)
        val elem = lista[pos]
        assertEquals(1, pos)
        assertEquals(8, elem)

        // Y ahora la posicion de un elemento que no existe
        pos = lista.indexOf(7)
        assertEquals(-1, pos)
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaSet() {
        // Creamos una lista
        val lista: IList<Int> = ArrayList()

        // Llenamos la lista de una serie de datos
        lista.add(35)
        lista.add(8)
        lista.add(3)
        lista.add(43)
        lista.add(35)
        lista.add(45)
        lista.add(4)
        lista.add(63)
        lista.add(35)
        lista.add(8)
        lista.add(81)

        // Verificamos el contenido de la lista
        assertEquals(11, lista.size())

        var elem = lista[5]
        assertEquals(45, elem)

        lista[5] = 99
        assertEquals(11, lista.size())
        elem = lista[5]
        val antes = lista[4]
        assertTrue(elem == 99 && antes == 35)
        println("Prueba superada ✔")
    }
}