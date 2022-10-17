package taller05

import kotlin.math.atan
import kotlin.math.sqrt

/**
 * Un número complejo consta de una parte real y una parte imaginaria
 */
class NumeroComplejo(var parteReal: Double, var parteImaginaria: Double) {
    // Halla el valor absoluto del número complejo
    fun valorAbsoluto(): Double {
        return sqrt((parteReal * parteReal) + (parteImaginaria * parteImaginaria))
    }

    // Halla la fase o argumento del número complejo
    fun argumento(): Double {
        return if (parteReal != 0.0) {
            return atan(parteImaginaria / parteReal)
        }else{
            println("El numero real debe ser diferente de 0")
            return 0.0
        }
    }

    // Halla el inverso o recíproco de un número complejo
    fun inverso(): NumeroComplejo {
        var parteInvReal = (parteReal/((parteReal*parteReal) + (parteImaginaria*parteImaginaria)))
        var parteInvImaginaria = (parteImaginaria/((parteReal*parteReal) + (parteImaginaria*parteImaginaria)))
        return NumeroComplejo(parteInvReal, -parteInvImaginaria)
    }

    // Multiplica la parte real y la parte imaginaria por un escalar
    fun productoPorEscalar(escalar: Double) {
        this.parteReal = parteReal*escalar
        this.parteImaginaria = parteImaginaria*escalar
    }

    // Obtiene una versión String del número complejo
    override fun toString(): String {
        return String.format("%.2f + (%.2f)i", parteReal, parteImaginaria)
    }
}

// Función externa que halla la suma de dos números complejos
fun sumarNumComplejos(num1: NumeroComplejo, num2: NumeroComplejo): NumeroComplejo {
    var sumParteReal = num1.parteReal + num2.parteReal
    var sumParteImaginaria = num1.parteImaginaria + num2.parteImaginaria
    return NumeroComplejo(sumParteReal, sumParteImaginaria)
}

// -----------------------------------------------------------------------------------
// Clase Producto
class Producto(val nombre: String,
               val tipo: String,
               var valorUnitario: Double,
               var cantidadBodega: Int,
               val cantidadMinima: Int) {
    // Retornar el IVA correspondiente al producto. Ojo: este IVA depende del tipo de producto.
    //papeleria: 16%
    //supermercado: 4%
    //drogueria: 12%
    fun darIVA(): Double {
        return when(this.tipo){
            "papeleria" -> (0.16)
            "supermercado" -> (0.04)
            "drogueria" -> (0.12)
            else -> 0.0
        }
    }

    //  Calcula el valor final del producto, incluyendo el IVA.
    fun calcularPrecioFinal(): Double {
        return (this.darIVA() * this.valorUnitario) + this.valorUnitario
    }

    // Vende la cantidad de unidades dada por parámetro.
    fun vender(cantidad: Int) {
        this.cantidadBodega -= cantidad
        if(this.cantidadBodega < 0){
            this.cantidadBodega = 0
        }else{
            this
        }
    }

    // Aumenta la cantidad de unidades en bodega del producto en la cantidad que se recibe como dato de entrada.
    fun abastecer(cantidad: Int) {
        this.cantidadBodega += cantidad
    }

    // retorna True sin la cantidad en Bodega es menor que la cantidad mínima, y False en caso contrario.
    fun puedeAbastecer(): Boolean {
        return this.cantidadBodega < this.cantidadMinima
    }

    // Obtener una representación visual de un producto.
    override fun toString(): String {
        return "Producto(nombre='$nombre', tipo='$tipo', valorUnitario=$valorUnitario, cantidadBodega=$cantidadBodega, cantidadMinima=$cantidadMinima)"
    }
}