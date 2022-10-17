/**
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Proyecto EAN Collections
 * @author UniversidadEAN
 * Fecha: Ago 30, 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.taller10

/**
 * Esta constante indica el tamaño máximo de una lista
 */
const val MAX_ARRAY_SIZE = 100

/**
 * Implementación del tipo abstracto de datos Lista, especificado
 * en la interface IList. Esta implementación utiliza un arreglo
 * o vector estático para almacenar la información respectiva
 */
class ArrayList<T>() : IList<T> {
    //---------------------------------------------------------
    // Atributos
    //---------------------------------------------------------
    /**
     * El número de elementos que tiene actualmente la lista
     */
    private var tam: Int = 0

    /**
     * Info tiene los elementos de la lista
     */
    private var info: Array<T?> = arrayOfNulls<Any?>(MAX_ARRAY_SIZE) as Array<T?>

    //---------------------------------------------------------
    // Métodos
    //---------------------------------------------------------

    override fun isEmpty(): Boolean = this.tam == 0

    override fun size(): Int = tam

    override fun addToHead(element: T) {
        for (i in tam downTo 0) {
            info[i+1] = info[i]
        }
        info[0] = element
        tam++
    }

    override fun add(element: T) {
        info[tam] = element
        tam ++
    }

    override fun add(position: Int, element: T) {
        require(position in 0 until tam)
        for (i in tam downTo position) {
            info[i+1] = info[i]
        }
        info[position] = element
        tam++
    }

    override fun removeFirst() {
        for (i in 0 .. tam) {
            info[i] = info[i+1]
        }
        tam--
    }

    override fun removeLast() {
        tam--
    }

    override fun remove(position: Int) {
        require(position in 0 until tam)
        for (i in position..tam) {
            info[i] = info[i+1]
        }
        tam--
    }

    override fun clear() {
        tam = 0
    }

    override fun get(position: Int): T {
        require(position in 0 until tam)
        return info[position]!!
    }

    override fun indexOf(element: T): Int {
        for(element_index in 0..tam) {
            if(info[element_index] == element)
                return element_index
        }
        return -1
    }

    override fun set(position: Int, element: T) {
        require(position in 0 until tam)
        info[position] = element
    }
}