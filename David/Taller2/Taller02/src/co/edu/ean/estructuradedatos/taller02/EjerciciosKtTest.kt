/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Unidad de Estudios: Estructura de Datos
 * Taller: 02
 * Fecha: 1 de agosto de 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package co.edu.ean.estructuradedatos.taller02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EjerciciosKtTest {

    /**
     * Prueba del ejercicio 1
     */
    @Test
    fun pruebaEjercicio1() {
        assertEquals(52.0, ejercicio1(1000.0, 25))
        assertEquals(650.0, ejercicio1(50_000.0, 100))
        println("Prueba 1 superada :)")
    }

    /**
     * Prueba del ejercicio 2
     */
    @Test
    fun pruebaEjercicio2() {
        assertEquals(18, ejercicio2(20))
        assertEquals(45, ejercicio2(50))
        println("Prueba 2 superada :)")
    }

    /**
     * Prueba del ejercicio 3
     */
    @Test
    fun pruebaEjercicio3() {
        assertEquals(33 to 20, ejercicio3(25, 4, 20))
        assertEquals(39 to 36, ejercicio3(33, 6, 12))
        println("Prueba 3 superada :)")
    }

    /**
     * Prueba del ejercicio 4
     */
    @Test
    fun pruebaEjercicio4() {
        assertEquals(Triple(0.5, 0.3, 0.2), ejercicio4(500.0, 300.0, 200.0))
        assertEquals(Triple(0.3846153846153846, 0.15384615384615385, 0.4615384615384615), ejercicio4(75.0, 30.0, 90.0))
        println("Prueba 4 superada :)")
    }

    /**
     * Prueba del ejercicio 5
     */
    @Test
    fun pruebaEjercicio5() {
        assertEquals(Triple(2, 7, 1), ejercicio5(271))
        assertEquals(Triple(8, 5, 2), ejercicio5(852))
        println("Prueba 5 superada :)")
    }

    /**
     * Prueba del ejercicio 6
     */
    @Test
    fun pruebaEjercicio6() {
        assertEquals(81.65, ejercicio6(90.0, 73.0, 84.0))
        assertEquals(66.0, ejercicio6(29.0, 81.0, 76.0))
        println("Prueba 6 superada :)")
    }

    /**
     * Prueba del ejercicio 7
     */
    @Test
    fun pruebaEjercicio7() {
        assertEquals(Triple(147560.0, 92225.0, 129114.99999999999), ejercicio7(368900.0))
        assertEquals(Triple(105952.0, 66220.0, 92708.0), ejercicio7(264880.0))
        println("Prueba 7 superada :)")
    }

    /**
     * Prueba del ejercicio 8
     */
    @Test
    fun pruebaEjercicio8() {
        assertEquals(arrayListOf(1200.0, 5800.0, 630.0, 7630.0), ejercicio8(12000.0,58000.0,6300.0))
        assertEquals(arrayListOf(3400.0, 9300.0, 740.0, 13440.0), ejercicio8(34000.0,93000.0,7400.0))
        println("Prueba 8 superada :)")
    }

    /**
     * Prueba del ejercicio 9
     */
    @Test
    fun pruebaEjercicio9() {
        assertEquals(Pair(5, 1), ejercicio9(20, 5,100))
        assertEquals(Pair(20, 5), ejercicio9(25,4,550))
        println("Prueba 9 superada :)")
    }

    /**
     * Prueba del ejercicio 10
     */
    @Test
    fun pruebaEjercicio10() {
        assertEquals(true, ejercicio10(2024))
        assertEquals(false, ejercicio10(1900))
        println("Prueba 10 superada :)")
    }
}