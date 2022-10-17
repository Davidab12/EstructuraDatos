package Taller

import ean.collections.IList
import ean.collections.Lists

data class Apto(val numero:Int, val tamaño: Double, val piso: Int)

data class Edificio(val nombre: String, val direccion: String) {
    // La lista de apartamentos
    val aptos: IList<Apto> = Lists.empty()

    // Método para Obtener cantidad de apartamentos en el edificio
    fun cantidadAptos() = aptos.size
    /*
        // Propiedad, que cumple con lo mismo que el método anterior - (Propiedad o método sin datos de entrada)
        val cantidadAptos: Int
            get() = aptos.size
    */

    // Busco un apto dado el numero
    fun buscarAptoPorNumero(numApto: Int): Apto? {
        return this.aptos.find { it.numero == numApto }
    }

    /*
        Recibe número, tamaño y piso de un apartamento
        Si el apartamento con el numero dado no existe, es creado con los datos de entrada
        Retorna true si se crea un nuevo apartamento o false en caso contrario.
     */
    fun agregarApto(num: Int, tam: Double, piso: Int): Boolean {
        if(buscarAptoPorNumero(num) == null) {
            val nuevoApto = Apto(num, tam, piso)
            aptos.add(nuevoApto)
            return true
        }
        return false
    }

    /*
        *
        * Método para:
        * Eliminar apartamento que tenga un número dado
        *
    * */
    fun eliminarApto(num: Int) {
        val apto = buscarAptoPorNumero(num)
        if( apto !== null)
            aptos.removeElement(apto)
    }

    /*
        * Método para:
        * Obtener el número de apartamento, del apartamento que tenga el tamaño más grante en un determinado piso
        *
    */
    fun numApatoMasGrandePiso(piso: Int): Int {
        return if(aptos.filter { it.piso == piso }.isNotEmpty())
            aptos.filter { it.piso == piso }.maxBy { it.tamaño }.numero
            //aptos.filter{ it.piso == piso }.maxWith(Comparator.comparingDouble() { it.tamaño })!!.numero
        else 0
    }
}