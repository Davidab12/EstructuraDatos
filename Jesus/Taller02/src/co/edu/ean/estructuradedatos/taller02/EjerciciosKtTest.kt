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
        println("Prueba superada 🦾")
    }

    /* Nota: las horas en TOTAL deberían también incluir las horas de clase (n) */
    @Test
    fun pruebaEjercicio2() {
        assertEquals(38, ejercicio2(20))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio3() {
        assertEquals(33 to 20, ejercicio3(25, 4, 20))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio4() {
        assertEquals(Triple(0.5, 0.3, 0.2), ejercicio4(500.0, 300.0, 200.0))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio5() {
        assertEquals(Triple(2,7,1), ejercicio5(271))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio6() {
        assertEquals(95.2, ejercicio6(95.2,95.2,95.2,95.2,95.2,95.2,95.2,95.2,95.2))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio7() {
        assertEquals(Triple(40.0,25.0,35.0), ejercicio7(100.0))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio8() {
        val expectedResult = Pair( Triple(1.0, 2.0, 3.0), 6.0 )
        assertEquals(expectedResult, ejercicio8(10.0,20.0,30.0))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio9() {
        val expectedResult = Pair(60, 5)
        assertEquals(expectedResult, ejercicio9(20,12,1134))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio10() {
        assertEquals(true, ejercicio10(2024))
        assertEquals(false, ejercicio10(1900))
        println("Prueba superada ✔")
    }

    @Test
    fun testAllMyCode() {
        pruebaEjercicio1()
        pruebaEjercicio2()
        pruebaEjercicio3()
        pruebaEjercicio4()
        pruebaEjercicio5()
        pruebaEjercicio6()
        pruebaEjercicio7()
        pruebaEjercicio8()
        pruebaEjercicio9()
        pruebaEjercicio10()
    }
}