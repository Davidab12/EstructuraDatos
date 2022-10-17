import ean.collections.*

data class Plato (val baseMenor: Double, val baseMayor:Double, val altura:Double) {
    fun area(): Double = ( ( baseMenor + baseMayor ) / 2 ) * altura
}

data class Horno (val identificador: Int, val lado: Double, val temperatura: Double) {
    fun elPlatoCabe(plato: Plato) : Boolean = (plato.baseMayor <= lado && plato.altura <= lado)
}

fun mejorHorno (hornos: IList<Horno>, plato: Plato): Horno? {
    // Hornos donde cabe el plato
    val hornosPrimerFiltro = hornos.filter { it.elPlatoCabe(plato) }

    // Horno que de el mejor espacio de convención
    var hornoMejorConvencion = hornosPrimerFiltro[0]; var convencion = 0.0
    for (horno in hornosPrimerFiltro) {
        var areaConvencion:Double = (horno.lado * 4) - plato.area()
        if(convencion > areaConvencion) {
            hornoMejorConvencion = horno
            convencion = areaConvencion
        }
    }

    // Retorna el horno de mejor convención si su identificador es par. Si no es par, retorna null
    return if (hornoMejorConvencion.identificador % 2 == 0)
        hornoMejorConvencion
    else null
}