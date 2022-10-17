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
     * Carga el camión que posee la matrícula dada con la carga dada por parámetro.
     * Retorna true si pudo realizar la carga, false en caso contrario.
     */
    fun cargarCamion(matriculaCamion: String, pesoCargar: Int): Boolean {
        return when(matriculaCamion) {
            camion1.matricula -> camion1.cargar(pesoCargar)
            camion2.matricula -> camion2.cargar(pesoCargar)
            camion3.matricula -> camion3.cargar(pesoCargar)
            camion4.matricula -> camion4.cargar(pesoCargar)
            else -> false
        }
    }

    /**
     * Descarga el camión que posee la matrícula dada por parámetro.
     */
    fun descargarCamion(matriculaCamion: String): Unit {
        return when(matriculaCamion) {
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
        return this.darCargaTotal() / 4.0
    }

    /**
     * Retorna el mejor camión para transportar la carga especificada.
     * El mejor camión es aquel que tiene la capacidad para cargar la
     * carga dada y además tiene un menor consumo de gasolina.
     * Si ningún camión es apto para la carga retorna null.
     */
    fun darMejorCamion(pesoCarga: Int): Camion? {
        var mejorCamion: Camion? = null

        if(camion1.capacidad >= pesoCarga)
            mejorCamion = camion1

        if(camion2.capacidad >= pesoCarga && (mejorCamion == null || camion2.consumo < mejorCamion.consumo ))
            mejorCamion = camion2

        if(camion3.capacidad >= pesoCarga && (mejorCamion == null || camion3.consumo < mejorCamion.consumo ))
            mejorCamion = camion3

        if(camion4.capacidad >= pesoCarga && (mejorCamion == null || camion4.consumo < mejorCamion.consumo ))
            mejorCamion = camion4

        return mejorCamion
    }

    /**
     * Retorna la matrícula de aquel camión de los cuatro camiones de la
     * empresa de transporte que tiene la carga actual más grande.
     */
    fun matriculaCamionMasCargado(): String {
        var camionMasCargado: Camion = camion1

        if (camion2.cargaActual > camionMasCargado.cargaActual)
            camionMasCargado = camion2
        if (camion3.cargaActual > camionMasCargado.cargaActual)
            camionMasCargado = camion3
        if (camion4.cargaActual > camionMasCargado.cargaActual)
            camionMasCargado = camion4

        return camionMasCargado.matricula
    }

    /**
     * Obtiene y retorna cuántos camiones están descargados.
     */
    fun cantidadCamionesDescargados(): Int {
        var camionesVacios = 0

        if(camion1.cargaActual == 0) camionesVacios++
        if(camion2.cargaActual == 0) camionesVacios++
        if(camion3.cargaActual == 0) camionesVacios++
        if(camion4.cargaActual == 0) camionesVacios++

        return camionesVacios
    }
}