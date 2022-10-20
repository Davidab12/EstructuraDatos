/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Objetos Comparadores
 * Autor: EAN - 13 de octubre de 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package taller18

import ean.utils.maxBetween
import java.time.LocalDateTime

class SuperHéroe(val nombre: String, val poder: Int, val universo: String): Comparable<SuperHéroe> {
    /**
     * Primer criterio de comparación es el nombre, y el segundo será el poder.
     * Compares this object with the specified object for order. Returns zero if this object is equal
     * to the specified [other] object, a negative number if it's less than [other], or a positive number
     * if it's greater than [other].
     */
    override fun compareTo(other: SuperHéroe): Int {
        return when{
            //Para el nombre
            this.nombre == other.nombre -> 0
            this.nombre < other.nombre -> -1
            else -> 1
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SuperHéroe

        if (nombre != other.nombre) return false
        if (poder != other.poder) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nombre.hashCode()
        result = 31 * result + poder
        return result
    }


}

/**
 * Clase que representa la información de un producto.
 * Use el precio del producto como criterio de comparación.
 */

data class Producto(var nombre: String, var precio: Double, var cantidad: Int) : Comparable<Producto> {

    override fun compareTo(other: Producto): Int {
        return when{
            this.precio == other.precio -> 0
            this.precio < other.precio -> -1
            else -> 1
        }
    }

}

//--------------------------------------------------------------------
// Un comparador de productos, usando el nombre como criterio de
// comparación.
//--------------------------------------------------------------------

class ComparadorDeProductosPorNombre : Comparator<Producto> {

    // Compara los productos por nombre
    override fun compare(o1: Producto?, o2: Producto?): Int {
        if (o1 != null && o2 != null) {
            return when{
                o1.nombre == o2.nombre -> 0
                o1.nombre < o2.nombre -> -1
                else -> 1
            }
        }
        return -1
    }
}

object ComparadorPorNombreYPrecio : Comparator<Producto> {

    override fun compare(o1: Producto?, o2: Producto?): Int {
        return compareValuesBy(o1!!,o2!!, Producto::nombre, Producto::precio)
    }


}

object ComparadorPorCantidad: Comparator<Producto> {

    override fun compare(o1: Producto?, o2: Producto?): Int {
        if (o1 != null && o2 != null) {
            return when{
                o1.cantidad == o2.cantidad -> 0
                o1.cantidad < o2.cantidad -> -1
                else -> 1
            }
        }
        return -1
    }
}

/**
 * Clase que representa un Reloj
 */
class Reloj : Comparable<Reloj> {
    /**
    Atributos: Un reloj tiene horas, minutos y segundos.
    La hora están 0 y 23, los minutos y segundos entre 0 y 59
     */

    var hora: Int = 0
    var minutos: Int = 0
    var segundos: Int= 0

    /**
     * Agregue un constructor que inicialice el reloj en la hora
     * actual del computador (este es el constructor por defecto)
     */
    constructor() {
        var date = LocalDateTime.now()
        this.hora = date.hour
        this.minutos = date.minute
        this.segundos = date.second
    }

    constructor(hora: Int, minutos: Int, segundos: Int) {
        require(hora in 0 .. 24 && minutos in 0 .. 59 && segundos in 0 .. 59)
        this.hora = hora
        this.minutos = minutos
        this.segundos = segundos
    }

    /*
     * Agregue una función toString que muestre la hora en formato hh:mm:ss
     * y otra función toAMPMString que muestre el tiempo en hh:mm:ss AMPM
     */

    override fun toString(): String {
        return if (segundos in 0..9){
            "${hora}:${minutos}:0${segundos}"
        } else{
            "${hora}:${minutos}:${segundos}"
        }
    }

    fun toAMPMString(): String {
        return if (this.hora in 0..11) {
            "${hora}:${minutos}:${segundos} AM"
        } else {
            var horaN = this.hora - 12
            if (horaN in 0..9 || segundos in 0..9){
                "0${horaN}:${minutos}:0${segundos} PM"
            } else{
                "${horaN}:${minutos}:${segundos} PM"
            }
        }
    }

    /*
     * Agregue métodos para avanzar el reloj un segundo y otro para retrocederlo un segundo.
     * Adicionalmente un método equals.
     */
    fun avanzarUnSegundo() {
        if (this.segundos == 59) {
            this.segundos = 0
            if (this.minutos == 59) {
                this.minutos = 0
                if (this.hora == 23) {
                    this.hora = 0
                } else {
                    this.hora++
                }
            } else {
                this.minutos++
            }
        } else {
            this.segundos++
        }
    }

    fun retrocederUnSegundo() {
        if (this.segundos == 0) {
            this.segundos = 59
            if (this.minutos == 0) {
                this.minutos = 59
                if (this.hora == 0) {
                    this.hora = 23
                } else {
                    this.hora--
                }
            } else {
                this.minutos--
            }
        } else {
            this.segundos--
        }
    }

    /**
     * La función de comparación
     */
    override fun compareTo(other: Reloj): Int {
        return compareValuesBy(this, other, Reloj::hora, Reloj::minutos, Reloj::segundos)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Reloj

        if (hora != other.hora) return false
        if (minutos != other.minutos) return false
        if (segundos != other.segundos) return false

        return true
    }

    override fun hashCode(): Int {
        var result = hora
        result = 31 * result + minutos
        result = 31 * result + segundos
        return result
    }
}


