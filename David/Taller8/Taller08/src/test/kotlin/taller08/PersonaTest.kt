package taller08

import ean.collections.IList
import ean.collections.Lists
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.FileReader
import java.io.Reader

internal class PersonaTest {
    // Atributos globales
    private val personas: IList<Persona> = Lists.empty()

    @BeforeEach
    fun setUp() {
        // Vamos a leer los archivos
        try {
            val datos: Reader = FileReader("./resources/Personas.csv")
            val registros = CSVParser(datos, CSVFormat.DEFAULT.withHeader())
            for (registro in registros) {
                val cedula = registro["\uFEFFCédula"].toInt()
                val edad = registro["Edad"].toInt()
                val genero = if (registro["Genero"] == "0") "M" else "F"
                val hijos = registro["No de hijos"].toInt()
                val educacion = when (registro["Nivel Educativo"]) {
                    "1" -> "PRIMARIA"
                    "2" -> "SECUNDARIA"
                    "3" -> "PREGRADO"
                    "4" -> "POSTGRADO"
                    else -> "NINGUNO"
                }
                val estrato = registro["Estrato Socio"].toInt()
                val ingresos = registro["Ingresos"].toInt()
                val peso = registro["Peso"].toInt()
                val talla = registro["Talla"].toInt()
                val fuma = registro["Fuma"] == "1"
                val lentes = registro["Lentes"] == "1"
                val casa = registro["Casa propia"] == "1"
                val automovil = registro["Automovil"] == "1"
                val persona = Persona(
                    cedula,
                    edad,
                    genero,
                    hijos,
                    educacion,
                    estrato,
                    ingresos,
                    peso,
                    talla,
                    fuma,
                    lentes,
                    casa,
                    automovil
                )
                personas.add(persona)
            }
        }
        catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    @Test
    fun pruebaContarMujeresConAutomovil() {
        assertEquals(142, contarMujeresConAutomovil(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio1a() {
        assertEquals(264, ejercicio1a(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio1b() {
        assertTrue { !ejercicio1b(personas) }
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio2a() {
        assertEquals(161_844_000, ejercicio2a(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio2b() {
        assertEquals(2636,  ejercicio2b(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio3a() {
        assertEquals(40.8333, ejercicio3a(personas), 1e-4)
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio3b() {
        assertEquals(2_954_500.0, ejercicio3b(personas, "POSTGRADO"))
        assertEquals(2_199_000.0, ejercicio3b(personas, "PREGRADO"))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio3c() {
        assertEquals(19.2678, ejercicio3c(personas), 1e-4)
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaIMC() {
        assertEquals(18.1018, imc(personas[0]), 1e-4)
        assertEquals(22.7583, imc(personas[500]), 1E-4)
        assertEquals(33.0236, imc(personas[100]), 1E-4)
        assertEquals(25.5296, imc(personas[200]), 1E-4)
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaNivelPeso() {
        assertEquals("Bajo peso", nivelPeso(personas[0]))
        assertEquals("Normal", nivelPeso(personas[500]))
        assertEquals("Obesidad", nivelPeso(personas[100]))
        assertEquals("Sobrepeso", nivelPeso(personas[200]))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio3d() {
        assertEquals(40.70175, ejercicio3d(personas), 1e-5)
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio4a() {
        assertEquals(1_085_422_030, ejercicio4a(personas))
        println("Prueba superada ✔")
    }

    @Test
    fun pruebaEjercicio4b() {
        assertEquals(1_099_918_021, ejercicio4b(personas))
        println("Prueba superada ✔")
    }
}