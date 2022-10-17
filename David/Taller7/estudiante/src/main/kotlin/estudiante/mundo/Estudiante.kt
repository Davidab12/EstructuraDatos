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
 * Estudiante que tiene 4 cursos.
 */
class Estudiante(
    val codigo: Int = 1001001001,       // Código del estudiante.
    val nombre: String = "Juliana",     // Nombre del estudiante.
    val apellido: String = "Ramírez"    // Apellido del estudiante.
) {
    // -----------------------------------------------------------------
    // Atributos Adicionales
    // -----------------------------------------------------------------

    val curso1 = Curso("VFP0012", "Algoritmos", "Sistemas", 3);
    val curso2 = Curso("AFP0012", "Calculo", "Matematica", 3);
    val curso3 = Curso("EST0110", "Bioestadistica", "Biologia", 4);
    val curso4 = Curso("ALG1100", "Fisica 1", "Fisica", 3);

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Calcula el promedio ponderado del estudiante de los cursos que tienen nota asignada.
     * Para hallar el promedio ponderado debe sumarse la multiplicacion de la nota por
     * los creditos y dividirlo por la suma de los créditos. Ojo: SOLO LOS QUE TIENEN NOTA
     */
    fun calcularPromedioEstudiante(): Double {
        var notaPromedio : Double = 0.0
        var sumaCreditos : Int = 0
        if(curso1.estaCalificado()){
            notaPromedio += (curso1.darNota() * curso1.creditos)
            sumaCreditos += curso1.creditos
        }
        if(curso2.estaCalificado()){
            notaPromedio += (curso2.darNota() * curso2.creditos)
            sumaCreditos += curso2.creditos
        }
        if(curso3.estaCalificado()){
            notaPromedio += (curso3.darNota() * curso3.creditos)
            sumaCreditos += curso3.creditos
        }
        if(curso4.estaCalificado()){
            notaPromedio += (curso4.darNota() * curso4.creditos)
            sumaCreditos += curso4.creditos
        }
        return (notaPromedio / sumaCreditos)
    }

    /**
     * Indica si el estudiante se encuentra en prueba académica (promedio < 65.0).
     * @return Retorna true si se encuentra en prueba, false de lo contrario.
     */
    fun estaEnPrueba(): Boolean {
        return calcularPromedioEstudiante() < 65.0
    }

    /**
     * Indica si el estudiante es candidato a una beca. (promedio > 95.0)
     * Retorna true si es candidato a beca, false de lo contrario.
     */
    fun esCandidatoBeca(): Boolean {
        return calcularPromedioEstudiante() >= 95.0
    }

    /**
     * Buscar un curso dado su código.
     * Retorna el Curso buscado, null en caso de no encontrarlo.
     */
    fun buscarCurso(codigoCurso: String): Curso? {
        return when(codigoCurso){
            curso1.codigo -> curso1
            curso2.codigo -> curso2
            curso3.codigo -> curso3
            curso4.codigo -> curso4
            else -> null
        }
    }

    /**
     * Asigna la nota al curso dado por parámetro.
     * Retorna true si pudo asignar la nota, false de lo contrario.
     */
    fun asignarNotaCurso(codigoCurso: String, nota: Double): Boolean {
        var curso : Curso? = buscarCurso(codigoCurso)
        return when(null){
            curso -> false
            else -> {
                curso.asignarNota(nota)
                true
            }
        }
    }

    /**
     * Cambia el curso con el código dado por parámetro a un nuevo curso
     * con los valores dados por parámetro. Si ya existe un curso con el
     * código que se desea asignar, no se cambiar la información del curso.
     * Retorna true si se cambió el curso, false si no se cambió porque
     * ya existía un curso con el código que se deseaba asignar.
     */
    fun cambiarCurso(codigoActual: String, nuevoCodigo: String, nuevoNombre: String, nuevoCreditos: Int, carrera: String): Boolean {
        val cursoNuevo : Curso? = buscarCurso(nuevoCodigo)

        return when(cursoNuevo){
            null -> {
                var cursoActual : Curso = buscarCurso(codigoActual)!!
                cursoActual.codigo = nuevoCodigo
                cursoActual.nombre = nuevoNombre
                cursoActual.carrera = carrera
                cursoActual.creditos = nuevoCreditos
                true
            }
            else -> false
        }
    }

    /**
     * Retorna el curso con la mejor nota de los 4 cursos que tiene el estudiante
     */
    fun mejorNota(): Curso? {
        var mejorNotaCurso : Curso = curso1
        if(mejorNotaCurso.darNota() < curso2.darNota()){
            mejorNotaCurso = curso2
        }
        if(mejorNotaCurso.darNota() < curso3.darNota()){
            mejorNotaCurso = curso3
        }
        if(mejorNotaCurso.darNota() < curso4.darNota()){
            mejorNotaCurso = curso4
        }
        return mejorNotaCurso
    }

    /**
     * Retorna la cantidad de cursos reprobados por el estudiantes
     */
    fun cursosReprobados(): Int {
        var cursosReprobados : Int = 0
        if(!curso1.aproboCurso()){
            cursosReprobados += 1
        }
        if(!curso2.aproboCurso()){
            cursosReprobados += 1
        }
        if(!curso3.aproboCurso()){
            cursosReprobados += 1
        }
        if(!curso4.aproboCurso()){
            cursosReprobados += 1
        }
        return cursosReprobados
    }
}