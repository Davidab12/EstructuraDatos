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
 * Una lista es una estructura lineal compuesta
 * por una secuencia de 0 o más elementos. Esta interface
 * representa las operaciones que las diversas
 * implementaciones de la lista debe realizar.
 */
interface IList<T> : Iterable<T> {
    /**
     * Retorna `true` si la lista está vacía (no contiene elementos),
     * retorna `false` si tiene al menos un elemento
     */
    fun isEmpty(): Boolean

    /**
     * Retona el número de elementos que hacen parte de la lista
     */
    fun size(): Int


    /**
     * Agrega un nuevo elemento al principio de la lista
     */
    fun addToHead(element: T)

    /**
     * Agrega un elemento al final de la lista
     */
    fun add(element: T): Unit

    /**
     * Agrega todos los elementos de la lista dada a esta lista al final
     */
    fun addAll(elements: IList<T>) {
        for (elem in elements) {
            this.add(elem)
        }
    }

    /**
     * Agrega un elemento en la posición específica de la lista
     */
    fun add(position: Int, element: T): Unit

    /**
     * Elimina el primer elemento de la lista
     */
    fun removeFirst()

    /**
     * Elimina el último elemento de la lista
     */
    fun removeLast()

    /**
     * Elimina el elemento que se encuentra en la posición indicada
     */
    fun remove(position: Int): Unit

    /**
     * Elimina todos los elementos de esta lista
     */
    fun clear(): Unit

    /**
     * Retorna el elemento que se encuentra una determinada posición de la lista
     */
    operator fun get(position: Int): T

    /**
     * Retorna la posición de la primer vez que encuentra el elemento
     * especificado en la lista, o -1 si el elemento dado no
     * existe en la lista
     */
    fun indexOf(element: T): Int

    /**
     * Reemplaza el elemento en la posición especificada en la lista
     * por elemento dado.
     */
    operator fun set(position: Int, element: T)

    //---------------------------------------------------------
    // Métodos ya realizados
    //---------------------------------------------------------

    /**
     * Retorna un iterador sobre los elementos de esta secuencia de elementos
     */
    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            // Atributos
            private var index = 0

            /**
             * Returns `true` if the iteration has more elements.
             */
            override fun hasNext(): Boolean = index < size()

            override fun next(): T {
                if (!hasNext()) {
                    throw NoSuchElementException()
                }

                val elem = get(index)
                index++
                return elem!!
            }

        }
    }

    /**
     * Retorna el primer elemento de la lista
     */
    fun first() = get(0)

    /**
     * Retorna el último elemento de la lista
     */
    fun last() = get(size() - 1)

}