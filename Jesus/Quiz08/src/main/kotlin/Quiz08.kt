
import ean.collections.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Persona (val cedula: Int, val apellidos: String, val nombres: String, val edad: Int)

fun promedioEdadPersonasConApellidoXYCedulaTerminaEn5(listaPersonas: IList<Persona>, apellido: String): Double {
    val cumpleCondicional: (Persona, String) -> Boolean = {pers:Persona, ap:String -> ( pers.cedula%10 == 3 || pers.cedula%10 == 5) && pers.apellidos == ap }
    return when(listaPersonas.size) {
        1 -> {
            if (cumpleCondicional(listaPersonas.first, apellido))  listaPersonas[0].edad.toDouble()
            else 0.0
        }
        else -> {
            val listaPersonasCopy = listaPersonas.copy(); listaPersonasCopy.removeFirst()
            val promedioResto =  promedioEdadPersonasConApellidoXYCedulaTerminaEn5(listaPersonasCopy, apellido)

            return if (cumpleCondicional(listaPersonas.first, apellido))  promedioResto + listaPersonas[0].edad.toDouble() / 2.0
            else promedioResto

        }
    }
}

internal class Test {
    @Test
    fun test() {
        val listaPersonas: IList<Persona> = TList()
        listaPersonas.add(Persona(12345, "Perez", "Jesus", 18))
        listaPersonas.add(Persona(54513, "Perez", "David", 20))
        listaPersonas.add(Persona(45641, "Juan", "Perez", 19))

        assertEquals(19.0, promedioEdadPersonasConApellidoXYCedulaTerminaEn5(listaPersonas, "Perez"))
    }
}
