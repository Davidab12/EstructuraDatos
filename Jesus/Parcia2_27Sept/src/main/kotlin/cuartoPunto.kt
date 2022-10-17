import kotlin.math.ceil

data class Motocicleta (val placa:String, val capacidad:Int) {
    fun soat(): Double {
        var valorSoat = when(placa.get(placa.length-1).toUpperCase()) {
            'A', 'E', 'I', 'O', 'U' -> 15000.0*capacidad
            else -> (35000*capacidad) + 50000.0
        }
        return valorSoat
    }
    fun numViajes(personas: Int): Int {
        val capacidadReal = capacidad - 1
        return ceil(personas / capacidadReal.toDouble()).toInt()
    }
}