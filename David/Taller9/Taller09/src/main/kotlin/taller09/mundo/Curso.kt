/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Estructura de Dato - Taller 09
 * Ejercicio: Notas de un curso
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller09.mundo

import ean.collections.IList
import ean.collections.Lists

/**
 * Constantes utilizadas en el programa.
 */
const val TOTAL_EST = 12

/**
 * Clase que representa un curso.
 */
class Curso {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Notas de los estudiantes.
     */
    private val notas: IList<Double> = Lists.empty()

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo curso, inicializando todas las notas en cero.
     */
    constructor() {
        // Vamos a inicializar
        for (i in 0 until TOTAL_EST) {
            notas.add(0.0)
        }
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Calcula el promedio del curso.
     */
    fun promedio(): Double {
        return notas.average()
    }

    /**
     * Retorna la cantidad de estudiantes que tienen una nota mayor al promedio.
     */
    fun darCantidadSobrePromedio(): Int {
        return notas.count(){it>this.promedio()}
    }

    /**
     * Devuelve la nota de un estudiante del curso.
     *
     * El parámetro numEstudiante Número del estudiante : 1 <= estudiante <= 12.
     */
    fun darNota(numEstudiante: Int): Double {
        return if(numEstudiante in 1..12) notas[numEstudiante-1]
        else Double.NaN
    }

    /**
     * Cambia la nota de un estudiante en el curso.
     *
     * @param numEstudiante Número del estudiante. 1 <= estudiante <= 12.
     * @param nota          Nota del estudiante.
     */
    fun cambiarNota(numEstudiante: Int, nota: Double) {
        if (numEstudiante in 1 .. 12)
            this.notas.set(numEstudiante-1, nota)
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Obtener la cantidad de estudiantes que no pasaron el curso
     */
    fun cantidadReprobados(): Int {
        return this.notas.count(){ it<60.0 }
    }

    /**
     * Obtener la mejor nota del curso.
     */
    fun mejorNota(): Double {
        return this.notas.max()
    }

    /**
     * Obtener el porcentaje de estudiantes que pasaron el curso
     * Debe ser un número entre 0 y 100.
     */
    fun darPorcentajePasaron(): Double {
        return (this.notas.count(){ it>=60.0 }.toDouble() / this.notas.count())*100
    }

    /**
     * Determinar si todos los estudiantes del curso pasaron la materia
     * Retorna true si todos tuvieron notas aprobatorias, o false cuando al menos
     * un estudiante reprobó la materia.
     */
    fun todosPasaron(): Boolean {
        return this.darPorcentajePasaron() == 100.0
    }

}