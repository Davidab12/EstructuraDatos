/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Etructura de Datos - Taller 06
 * Ejercicio: Empresa de Transporte
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package empresaTransporte.mundo

/**
 * Empresa de transporte.
 */
class EmpresaTransporte() {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Camión 1 de la empresa.
     */
    val camion1 = Camion("BAC213", 150, 85.0)

    /**
     * Camión 2 de la empresa.
     */
    val camion2 = Camion("CAP384", 190, 70.0)

    /**
     * Camión 3 de la empresa.
     */
    val camion3 = Camion("GER273", 280, 100.0)

    /**
     * Camión 4 de la empresa.
     */
    val camion4 = Camion("JKV232", 215, 110.0)

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Carga el camión que posee la matricula dada con la carga dada por parámetro.
     * Retorna true si pudo realizar la carga, false en caso contrario.
     */
    fun cargarCamion(matriculaCamion: String, pesoCargar: Int): Boolean {
        if(camion1.matricula == matriculaCamion){
            camion1.cargar(pesoCargar)
            return true
        }
        else if(camion2.matricula == matriculaCamion){
            camion2.cargar(pesoCargar)
            return true
        }
        else if(camion3.matricula == matriculaCamion){
            camion3.cargar(pesoCargar)
            return true
        }
        else if(camion4.matricula == matriculaCamion){
            camion4.cargar(pesoCargar)
            return true
        }else{
            return false
        }
    }

    /**
     * Descarga el camión que posee la matrícula dada por parámetro.
     */
    fun descargarCamion(matriculaCamion: String): Unit {
        return when(matriculaCamion){
            camion1.matricula -> camion1.descargar()
            camion2.matricula -> camion2.descargar()
            camion3.matricula -> camion3.descargar()
            camion4.matricula -> camion4.descargar()
            else -> Unit
        }
    }

    /**
     * Retorna la capacidad total de carga de todos los camiones. Es decir,
     * la suma de las capacidades de los 4 camiones.
     */
    fun darCapacidadTotal(): Int {
        return camion1.capacidad + camion2.capacidad + camion3.capacidad + camion4.capacidad
    }

    /**
     * Retorna la carga total de los camiones.
     */
    fun darCargaTotal(): Int {
        return camion1.cargaActual + camion2.cargaActual + camion3.cargaActual + camion4.cargaActual
    }

    /**
     * Retorna la carga promedio por camión.
     * O sea, la carga total dividida por el número de camiones.
     */
    fun calcularCargaPromedio(): Double {
        return (this.darCargaTotal()/4).toDouble()
    }

    /**
     * Retorna el mejor camión para transportar la carga especificada.
     * El mejor camión es aquel que tiene la capacidad para cargar la
     * carga dada y además tiene un menor consumo de gasolina.
     * Si ningún camión es apto para la carga retorna null.
     */
    fun darMejorCamion(pesoCarga: Int): Camion? {
        var mejorCamion: Camion? = null
        var menorConsumo = Double.MAX_VALUE

        if(camion1.capacidad >= pesoCarga && camion1.consumo < menorConsumo){
            mejorCamion = camion1
            menorConsumo = camion1.consumo
        }
        if(camion2.capacidad >= pesoCarga && camion2.consumo < menorConsumo){
            mejorCamion = camion2
            menorConsumo = camion2.consumo
        }
        if(camion3.capacidad >= pesoCarga && camion3.consumo < menorConsumo){
            mejorCamion = camion3
            menorConsumo = camion3.consumo
        }
        if(camion4.capacidad >= pesoCarga && camion4.consumo < menorConsumo){
            mejorCamion = camion4
            menorConsumo = camion4.consumo
        }
        return mejorCamion
    }

    /**
     * Retorna la matrícula de aquel camión de los cuatro camiones de la
     * empresa de transporte que tiene la carga actual más grande.
     */
    fun matriculaCamionMasCargado(): String {
        var camionMasCargado: Int = 0
        var matriculaCamionMasCargado = ""

        if(camion1.cargaActual > camionMasCargado){
            camionMasCargado = camion1.cargaActual
            matriculaCamionMasCargado = camion1.matricula
        }
        if(camion2.cargaActual > camionMasCargado){
            camionMasCargado = camion2.cargaActual
            matriculaCamionMasCargado = camion2.matricula
        }
        if(camion3.cargaActual > camionMasCargado){
            camionMasCargado = camion3.cargaActual
            matriculaCamionMasCargado = camion3.matricula
        }
        if(camion4.cargaActual > camionMasCargado){
            camionMasCargado = camion4.cargaActual
            matriculaCamionMasCargado = camion4.matricula
        }
        return matriculaCamionMasCargado
    }

    /**
     * Obtiene y retorna cuántos camiones están descargados.
     */
    fun cantidadCamionesDescargados(): Int {
        var contadorCamionesLlenos : Int = 0

        if(camion1.cargaActual == 0){
            contadorCamionesLlenos +=1
        }
        if(camion2.cargaActual == 0){
            contadorCamionesLlenos +=1
        }
        if(camion3.cargaActual == 0){
            contadorCamionesLlenos +=1
        }
        if(camion4.cargaActual == 0){
            contadorCamionesLlenos +=1
        }
        return contadorCamionesLlenos
    }
}