/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Instrucciones Repetitivas
 * Autor: Universidad EAN - 23 de agosto de 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller08

import ean.collections.IList
import kotlin.math.pow

/**
 * Información que mantenemos de una persona
 */
data class Persona(
    val cedula: Int,
    val edad: Int,
    val genero: String,
    val hijos: Int,
    val nivelEducativo: String,
    val estrato: Int,
    val ingresos: Int,
    val peso: Int,
    val altura: Int,
    val fuma: Boolean,
    val tieneLentes: Boolean,
    val tieneCasa: Boolean,
    val tieneAutomovil: Boolean
)

//-----------------------------------------------------------------------------
// Operaciones a llevar a cabo
//-----------------------------------------------------------------------------


fun contarMujeresConAutomovil(personas: IList<Persona>): Int {
    var cont = 0;

    for(persona in personas){
        if((persona.genero == "F") && persona.tieneAutomovil){
            cont += 1
        }
    }
    return cont
}

/**
 * Contar el número de personas que pesan entre 60 y 80 kilos
 */
fun ejercicio1a(personas: IList<Persona>): Int {
    var cont = 0;

    for (persona in personas){
        if (persona.peso in 60..80){
            cont += 1
        }
    }
    return cont
}

/**
 * Determinar si la cantidad de mujeres es superior a la cantidad de hombres
 * El método deberá retornar true si hay más mujeres que hombres y false
 * en caso contrario.
 */
fun ejercicio1b(personas: IList<Persona>): Boolean {
    var cantMuj = 0; var cantHomb = 0
    for (persona in personas){
        if (persona.genero == "F"){
            cantMuj += 1
        }else{
            cantHomb += 1
        }
    }
    return (cantMuj > cantHomb)
}

/**
 * Encontrar la suma de los ingresos de aquellas personas
 * que no fuman y que sean mayores de 50 años de edad
 */
fun ejercicio2a(personas: IList<Persona>): Int {
    var sumaIngresos : Int = 0
    for (persona in personas){
        if(!persona.fuma && persona.edad > 50){
            sumaIngresos += persona.ingresos
        }
    }
    return sumaIngresos
}

/**
 * Escriba una función que retorne la suma de los pesos
 * de las personas de genero femenino, cuyo cédula es par
 * y no tiene hijos
 */
fun ejercicio2b(personas: IList<Persona>): Int {
    var sumaPeso : Int = 0
    for(persona in personas){
        if((persona.genero == "F") && (persona.cedula % 2 == 0) && (persona.hijos == 0)){
            sumaPeso += persona.peso
        }
    }
    return sumaPeso
}

/**
 * Escriba una función que retorne el promedio de edad
 * de los hombres que se ganan entre 2 y 3 millones
 */
fun ejercicio3a(personas: IList<Persona>): Double {
    var sumaEdad : Double = 0.0
    val conditional : (Persona) -> Boolean = {((it.genero == "M") && (it.ingresos in 2000000 .. 3000000))}
    personas.filter(conditional).forEach { sumaEdad += it.edad }
    return (sumaEdad / personas.count(conditional))
}

/**
 * ¿Cual es el promedio de ingresos de aquellas personas que tienen una
 * altura inferior a 170 centímetros, y que pesan entre 80 y 90 kilos
 * y no fuman ni usan lentes y cuyo nivel educativo sea igual al que
 * se pasa como parámetro
 */
fun ejercicio3b(personas: IList<Persona>, nivel: String): Double {
    var sumaIngresos : Double = 0.0; var cont : Int = 0
    for (persona in personas){
        if ((persona.altura < 170)
            && (persona.peso in 80 .. 90)
            && (!persona.fuma)
            && (!persona.tieneLentes)
            && (persona.nivelEducativo == nivel)){
            sumaIngresos += persona.ingresos
            cont += 1
        }
    }
    return (sumaIngresos / cont)
}

/**
 * Cuál es el porcentaje de mujeres que viven en estrato 1, 2 o 3 y que tienen casa
 */
fun ejercicio3c(personas: IList<Persona>): Double {
    var contTotalPersonas : Int = 0; var contMujeresAptas : Int = 0
    for (persona in personas){
        contTotalPersonas += 1
        if ((persona.genero == "F")
            && ((persona.estrato == 1) || (persona.estrato == 2) || (persona.estrato == 3))
            && (persona.tieneCasa)){
            contMujeresAptas += 1
            }
        }
    return (contMujeresAptas.toDouble() / contTotalPersonas) * 100
}

/**
 * Hallar el indice de masa corporal de una persona
 * Este indice se halla p / h^2, donde p es el peso en kilos, y h es la altura
 * en centímetros (ES METROS).
 */
fun imc(persona: Persona): Double {
    return ((persona.peso).toDouble() / (persona.altura/100.0).pow(2))
}

/**
 * El nivel de peso de una persona depende del imc de esa persona
 * de acuerdo a la siguiente:
 * nivel = "Bajo peso" cuando el imc está por debajo de 18.5
 * nivel = "Normal" cuando el imc está entre 18.5 y 24.9
 * nivel = "Sobrepeso" cuando el imc está entre 25.0 y 29.9
 * nivel = "Obesidad" cuando el imc es 30.0 o superior
 * Escriba una función que halle el nivel de peso de una persona
 * USE LA FUNCIÓN IMC HECHA ANTERIORMENTE
 */
fun nivelPeso(p: Persona): String {
    var nivelPeso : String = if (imc(p) < 18.5){
        "Bajo peso"
    }else if (imc(p) < 25.0 ){
        "Normal"
    }else if (imc(p) < 30.0){
        "Sobrepeso"
    }else {
        "Obesidad"
    }
    return nivelPeso
}

/**
 * Halle el promedio de edad de los hombres obesos
 */
fun ejercicio3d(personas: IList<Persona>): Double {
    var sumaEdad : Double = 0.0
    var cont : Int = 0
    for (persona in personas){
        if(nivelPeso(persona) == "Obesidad" && persona.genero == "M"){
            sumaEdad += persona.edad
            cont += 1
        }
    }
    return (sumaEdad / cont)
}

/**
 * Hallar la cédula de la mujer más alta
 */
fun ejercicio4a(personas: IList<Persona>): Int {
    var mujerAlta : Persona? = null
    personas.forEach {
        if (mujerAlta == null || mujerAlta!!.altura < it.altura){
            mujerAlta = it
        }
    }
    return mujerAlta!!.cedula
}

/**
 * Escriba una función que retorne la cédula del hombre
 * mayor de 30 años que tiene los ingresos más bajos
 */
fun ejercicio4b(personas: IList<Persona>): Int {
    var hombreIngresoMenor: Persona = personas[0]

    personas.forEach {
        if (it.genero == "M" && it.edad > 30 && it.ingresos < hombreIngresoMenor.ingresos) {
            hombreIngresoMenor = it
        }
    }
    return hombreIngresoMenor.cedula

    /*
    var ingresoMayor: Int = Int.MAX_VALUE
    var cedula : Int = 0
    for (persona in personas){
        if (persona.genero == "M" && persona.edad > 30){
            if(persona.ingresos < ingresoMayor){
                ingresoMayor = persona.ingresos
                cedula = persona.cedula
            }
        }
    }
    return cedula
     */
}
