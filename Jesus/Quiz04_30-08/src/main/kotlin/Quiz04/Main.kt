package Quiz04

import ean.collections.IList

class Curso(
    var nombreCurso: String,
    var primerCorte: Double,
    var segundoCorte: Double,
    var pruebasObjetivas: Double,
    var tipo: String
) {
    fun notaFinal() : Double {
        return when (this.tipo) {
            "normal" -> {
                this.primerCorte*0.4 + segundoCorte*0.5 + pruebasObjetivas*0.1
            }
            else -> {
                this.primerCorte*0.4 + segundoCorte*0.6
            }
        }
    }
}

class Estudiante(var cursos: IList<Curso>) {
    fun notaFinalCurso(nombreCurso: String): Double {
        for(curso in cursos) {
            if(curso.nombreCurso == nombreCurso)
                return curso.notaFinal()
        }
        return -1.0
    }

    fun nombreCursoConNotaMasAlta(tipoCurso: String): String {
        var nombreCursoNotaMasAlta = ""

        for (curso in cursos) {
            if(curso.tipo == tipoCurso) {
                if(nombreCursoNotaMasAlta == "" || curso.notaFinal() > this.notaFinalCurso(nombreCursoNotaMasAlta))
                    nombreCursoNotaMasAlta = curso.nombreCurso
            }
        }
        return nombreCursoNotaMasAlta
    }
}