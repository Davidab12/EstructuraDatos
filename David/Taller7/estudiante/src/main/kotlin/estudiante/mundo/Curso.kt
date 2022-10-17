/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Etructura de Datos - Taller 07
 * Ejercicio: El Estudiante
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package estudiante.mundo

/**
 * Curso del estudiante.
 */
class Curso(
    var codigo: String,     // Código del curso.
    var nombre: String,     // Nombre del curso.
    var carrera: String,    // carrera a la que pertenece el curso
    var creditos: Int      // Cantidad de créditos del curso
) {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    private var nota: Double = 0.0  // Nota del estudiante en el curso

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Asigna a la nota del curso, la nueva nota que se pasa como parámetro.
     * El cambio de nota solo se debe hacer si la nueva nota está entre 0 y 100
     */
    fun asignarNota(nuevaNota: Double) {
        if((nuevaNota >= 0.0) && (nuevaNota <= 100.0)){
            this.nota = nuevaNota
        }else{
            this.nota
        }
    }

    /**
     * Obtiene la nota del estudiante en el curso
     */
    fun darNota() = nota

    /**
     * Indica si el curso ya ha sido calificado (La nota no es cero)
     * Retorna true si el curso ya tiene nota, false de lo contrario
     */
    fun estaCalificado(): Boolean {
        return this.nota > 0.0
    }

    /**
     * Indica si el estudiante aprobó el curso. Retorna true si se
     * aprobó el curso, false en caso que no se haya aprobado el curso
     */
    fun aproboCurso(): Boolean {
        return this.nota >= 60.0
    }
}