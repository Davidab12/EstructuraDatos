import ean.collections.*

fun obtenerMotoSoatCara(pila: IStack<Motocicleta>, personas: Int): Motocicleta? {
    // Motocicletas que pueden transportar el número de 'personas' en menos de 5 viajes
    val motosPrimerFiltro: IList<Motocicleta> = Lists.empty()
    val pilaCopia = pila.copy()
    while(!pilaCopia.isEmpty) {
        val moto = pilaCopia.peek()
        if(moto.numViajes(personas) < 5)
            motosPrimerFiltro.add(moto)
        pilaCopia.pop()
    }

    // Retorna null si ninguna moto es capaz de transportar el número de personas en menos de 5 viajes
    if(motosPrimerFiltro.isEmpty) return null

    // Se halla la moto que tenga el mayor valor de SOAT
    var motoMayorSoat: Motocicleta = motosPrimerFiltro[0]
    motosPrimerFiltro.forEach() {
        if(it.soat() > motoMayorSoat.soat())
            motoMayorSoat = it
    }
    return motoMayorSoat
}