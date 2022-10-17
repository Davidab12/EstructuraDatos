package ean.estructuradedatos.tallerpilas

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 * <p>
 * Proyecto Taller con las Pilas
 * Autor: Universidad EAN - Septiembre 15, 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.IList
import ean.collections.Utils
import ean.collections.Utils.join
import org.testng.Assert.*

import org.testng.annotations.Test


internal class ConvertidorDeInfijoAPostfijoTest {
    //-------------------------------------
    // Métodos
    //-------------------------------------
    @Test
    fun probarBalanceador() {
        // Ejemplo de expresión bien balanceada
        assertTrue(
            chequearBalanceo("[a {b / (c-d) + e/(f+g)}-h]")
        )

        // Ejemplo de expresión mal balanceada
        assertFalse(
            chequearBalanceo("a {b [c - d ] e] ) f")
        )

        // Ejemplo de expresión mal balanceada
        assertFalse(
            chequearBalanceo("{a ( b * c ) / [d + e] / f )- g}")
        )
        println("Prueba superada!")
    }

    @Test
    fun testReplaceDelimiters() {
        val first = reemplazarDelimitadores("x [ {a ( b * c ) / [d + e] / f }- g]")
        val secnd = dividirExpresion("x ( (a ( b * c ) / (d + e) / f )- g)")
        assertTrue(first == secnd)
        println("Prueba superada!")
    }

    @Test
    fun probarConvertirInfijoPostfijo() {
        // 1. Primera prueba
        var postfijo: String = convertir("((40 + 30) - 25)")
        assertEquals("40 30 + 25 -", postfijo)
        println("Prueba 1 superada!")

        // 2. Prueba
        postfijo = convertir("(a + (b * c))")
        assertEquals("a b c * +", postfijo)
        println("Prueba 2 superada!")

        // 3. Prueba
        postfijo = convertir("((a - b) * c)")
        assertEquals("a b - c *", postfijo)
        println("Prueba 3 superada!")

        // 4. Prueba
        postfijo = convertir("((a % b) * (c % d))")
        assertEquals("a b % c d % *", postfijo)
        println("Prueba 4 superada!")

        // 5. Prueba
        postfijo = convertir("(a / (b * (c + (d - 5))))")
        assertEquals("a b c d 5 - + * /", postfijo)
        println("Prueba 5 superada!")

        // 6. Prueba
        postfijo = convertir("((a / (b - c)) * d)")
        assertEquals("a b c - / d *", postfijo)
        println("Prueba 6 superada!")

        // 7. Prueba
        postfijo = convertir("((a - ((b / ((c - d) * e)) + f )) % g)")
        assertEquals("a b c d - e * / f + - g %", postfijo)
        println("Prueba 7 superada!")

        // 8. Prueba
        postfijo = convertir("(((a - b) * c) / (((d * e) / (f % g)) + h))")
        assertEquals("a b - c * d e * f g % / h + /", postfijo)
        println("Prueba 8 superada!")

        // 9. Prueba
        postfijo = convertir("(a * (((b + c) * d) + e))")
        assertEquals("a b c + d * e + *", postfijo)
        println("Prueba 9 superada!")
    }

    @Test
    fun pruebaFinal() {
        // Original: se encuentra desbalanceada en el simbolo '}' cerca a '+ {5 * 6}})'
        // val aEvaluar = dividirExpresion("({[3 * 3] / (4 - 2)} + {5 * 6}})")
        // Modificada:
        val aEvaluar = dividirExpresion("({[3 * 3] / (4 - 2)} + {5 * 6})")
        if (Evaluador.estánSímbolosAgrupaciónBalanceados(aEvaluar)) {
            Evaluador.reemplazarDelimitadoresPorParéntesis(aEvaluar)
            val expresiónFinal = Evaluador.convertirAPostfijo(aEvaluar)
            val valorFinal = Evaluador.evaluarExpresiónPostfija(expresiónFinal)
            assertEquals(34, valorFinal)
        }
        else {
            fail("Algo malo ocurrió por aquí")
        }
    }
}

//-----------------------------------------------------------------------------------------------------------

/**
 * Función de utilidad para realizar la conversión
 */
fun convertir(expresión: String): String {
    val anExpression = Utils.parse(expresión)
    return join(Evaluador.convertirAPostfijo(anExpression))
}

/**
 */
fun dividirExpresion(expresión: String): IList<String> = Utils.parse(expresión)

fun chequearBalanceo(expresión: String): Boolean {
    return Evaluador.estánSímbolosAgrupaciónBalanceados(dividirExpresion(expresión))
}

fun reemplazarDelimitadores(expresión: String): IList<String> {
    val expr = dividirExpresion(expresión)
    Evaluador.reemplazarDelimitadoresPorParéntesis(expr)
    return expr
}
