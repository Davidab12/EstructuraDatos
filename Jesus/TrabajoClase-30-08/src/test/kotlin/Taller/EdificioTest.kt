package Taller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EdificioTest {
    @Test
    fun prueba1() {
        val e = Edificio("Legacy", "Calle 79 #11-45")
        assertEquals(0, e.cantidadAptos())

        e.agregarApto(101, 100.0, 1)
        e.agregarApto(102, 12.0, 1)
        e.agregarApto(103, 88.8, 1)
        assertEquals(3, e.cantidadAptos())

        assertFalse(e.agregarApto(102, 65.1, 1))
        assertEquals(3, e.cantidadAptos())
        println("Prueba 1 (Agregar) superada :D")
    }

    @Test
    fun prueba2() {
        val e = Edificio("Legacy", "Calle 79 #11-45")

        e.agregarApto(101, 100.0, 1)
        e.agregarApto(102, 12.0, 1)
        e.agregarApto(103, 88.8, 1)

        e.eliminarApto(103)
        assertNull(e.buscarAptoPorNumero(103))

        println("Prueba 2 (Eliminar) superada :D")
    }

    @Test
    fun prueba3() {
        val e = Edificio("Legacy", "Calle 79 #11-45")

        e.agregarApto(101, 100.0, 1)
        e.agregarApto(102, 12.0, 1)
        e.agregarApto(103, 88.8, 1)

        assertEquals(101, e.numApatoMasGrandePiso(1))

        println("Prueba 3 (Mayor Tamaño) superada :D")
    }
}