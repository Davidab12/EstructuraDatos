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
 * Implementación de la interface IList pero utilizando
 * nodos sencillamente encadenados. Esta lista consiste
 * en una secuencia de nodos, en los que se guardan
 * campos de datos arbitrarios y una referencia, enlaces
 * o punteros al nodo posterior.
 */
class LinkedList<T>() : IList<T> {
    //---------------------------------------------------------
    // Definición de un Nodo
    //---------------------------------------------------------
    class Nodo<T>(var info: T, var sig: Nodo<T> ? = null)

    //---------------------------------------------------------
    // Atributos
    //---------------------------------------------------------
    /**
     * El número de elementos que tiene actualmente la lista
     */
    private var tam: Int = 0

    /**
     * primero referencia o apunta al primer nodo de la lista
     */
    private var primero: Nodo<T>? = null

    //---------------------------------------------------------
    // Métodos a implementar
    //---------------------------------------------------------

    /**
     * Retorna `true` si la lista está vacía (no contiene elementos),
     * retorna `false` si tiene al menos un elemento
     */
    override fun isEmpty(): Boolean = (primero == null)

    /**
     * Retona el número de elementos que hacen parte de la lista
     */
    override fun size(): Int = this.tam

    /**
     * Agrega un nuevo elemento al principio de la lista
     */
    override fun addToHead(element: T) {
        val newNode: Nodo<T> = Nodo(element)
        if(this.isEmpty()) this.primero = newNode
        else {
            newNode.sig = primero
            primero = newNode
        }
        tam++
    }

    /**
     * Agrega un elemento al final de la lista
     */
    override fun add(element: T) {
        if (this.isEmpty())
            this.addToHead(element)
        else {
            val newNode:Nodo<T> =  Nodo(element)
            var lastNode = this.getNodeInPosition(this.size()-1)
            lastNode!!.sig = newNode
            tam++
        }
    }

    /**
     * Agrega un elemento en la posición específica de la lista
     */
    override fun add(position: Int, element: T) {
        require(position <= this.size())
        when(position) {
            0 -> this.addToHead(element)
            this.size() -> this.add(element)
            else -> {
                val newNode = Nodo(element);
                val nodeBeforePosition = this.getNodeInPosition(position-1)
                val nodeInPosition = nodeBeforePosition!!.sig
                nodeBeforePosition!!.sig = newNode
                newNode.sig = nodeInPosition
                tam++
            }
        }
    }

    /**
     * Elimina el primer elemento de la lista
     */
    override fun removeFirst() {
        require(!this.isEmpty())
        this.primero = this.primero!!.sig
        tam--
    }

    /**
     * Elimina el último elemento de la lista
     */
    override fun removeLast() {
        require(!this.isEmpty())
        var beforeLastNode = this.getNodeInPosition(this.size()-2)
        beforeLastNode!!.sig = null
        tam--
    }

    /**
     * Elimina el elemento que se encuentra en la posición indicada
     */
    override fun remove(position: Int) {
        require(!isEmpty() && position in 0 until this.size())

        when (position) {
            0 -> this.removeFirst()
            (this.size() - 1) -> this.removeLast()
            else -> {
                var nodeBeforePosition = this.getNodeInPosition(position-1)
                var nodeAfterPosition = this.getNodeInPosition(position+1)
                nodeBeforePosition!!.sig = nodeAfterPosition
                tam--
            }
        }
    }

    /**
     * Elimina todos los elementos de esta lista
     */
    override fun clear() {
        // ?
        this.primero = null
        tam = 0
    }

    /**
     * Retorna el elemento que se encuentra una determinada posición de la lista
     */
    override fun get(position: Int): T {
        require(!isEmpty() && position in 0 until this.size())
        var nodeInPosition = this.getNodeInPosition(position)
        return nodeInPosition!!.info
    }

    /**
     * Retorna la posición de la primer vez que encuentra el elemento
     * especificado en la lista, o -1 si el elemento dado no
     * existe en la lista
     */
    override fun indexOf(element: T): Int {
        require(!this.isEmpty())

        var currentNode = this.primero
        var index = 1

        while(index < this.size()-1) {
            if(currentNode!!.info == element)
                return index-1
            else {
                currentNode = currentNode!!.sig
                index++
            }
        }

        return -1
    }

    /**
     * Reemplaza el elemento en la posición especificada en la lista
     * por elemento dado.
     */
    override fun set(position: Int, element: T) {
        require(!isEmpty() && position in 0 until this.size())
        var nodeInPosition = this.getNodeInPosition(position)
        nodeInPosition!!.info = element
    }

    override fun last(): T {
        require(!this.isEmpty())
        var lastNode = this.getNodeInPosition(this.size()-1)
        return lastNode!!.info
    }

    fun getNodeInPosition(position: Int, lastNode: Nodo<T>? = this.primero): Nodo<T> ? {
        require(!isEmpty() && position in 0 until this.size())
        return when (position) {
            0 -> lastNode
            else -> getNodeInPosition(position-1, lastNode!!.sig)
        }
    }
}