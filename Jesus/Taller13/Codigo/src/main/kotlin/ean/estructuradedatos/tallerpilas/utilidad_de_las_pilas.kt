package ean.estructuradedatos.tallerpilas

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 * <p>
 * Proyecto Taller con las Pilas
 * Autor: Universidad EAN - Septiembre 15, 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.*
import ean.ui.tryWith

/**
 * Objeto que permite convertir una expresión infija normal a una expresión en notación
 * postfija. Utiliza pilas para realizar la conversión.
 */
object Evaluador {

    //-------------------------------------
    // Métodos
    //-------------------------------------

    /**
     * Verifica que la expresión tiene los símbolos de agrupación bien balanceados
     * @return true si la expresión está balanceados
     */
    fun estánSímbolosAgrupaciónBalanceados(expresion: IList<String>): Boolean {
        /*
        *  Lista de simbolos de apertura y cierre, ordenados,
        *  es decir, en la posición 0 de la lista 'openSymbols' se encuentra un simbolo de apertura
        *  y su respectivo simbolo de cierre se encuentra en la lista 'closeSymbols' en la misma posición (0).
        * */
        val openSymbols = Utils.parse("([{")
        val closeSymbols = Utils.parse(")]}")

        val pilaSimbolos: IStack<String> = TLinkedStack()

        for(checkingSymbol in expresion)
        {
            /*Si el simbolo de la expresión es uno de apertura*/
            if(openSymbols.contains(checkingSymbol))
                pilaSimbolos.push(checkingSymbol) //Se añaden únicamente los simbolos de apertura

            /*Si el simbolo de la expresión es uno de cierre*/
            else if(closeSymbols.contains(checkingSymbol))
            {
                if(pilaSimbolos.isEmpty) return false

                /*Comparación de las posiciones*/

                //Índice en la lista 'openSymbols' del último elemento añadido a la pila (último simbolo de apertura añadido).
                val lastOpenSymbolIndex = openSymbols.indexOf(pilaSimbolos.peek())

                //Índice en la lista 'closeSymbols' del simbolo de cierre (actual)
                val closeSymbolIndex = closeSymbols.indexOf(checkingSymbol) //

                // Debido al orden de las listas, ambos índices deben coincidir, de lo contrario, existe un error
                if( lastOpenSymbolIndex != closeSymbolIndex) return false

                pilaSimbolos.pop()
            }
        }

        return true
    }

    /**
     * Transforma la expresión, cambiando los simbolos de agrupación [] y {} por ()
     */
    fun reemplazarDelimitadoresPorParéntesis(expresion: IList<String>): Unit {
        val replaceableOpenSymbols = Utils.parse("[{")
        val replaceableCloseSymbols = Utils.parse("]}")

        for(i in 0 until expresion.size) {
            if(replaceableOpenSymbols.contains(expresion[i]))
                expresion[i] = "("
            else if(replaceableCloseSymbols.contains(expresion[i]))
                expresion[i] = ")"
        }
    }

    /**
     * Realiza la conversión de la notación infija a postfija
     * @return la expresión convertida a postfija
     */
    fun convertirAPostfijo(expresion: IList<String>): IList<String> {
        val operators = Utils.parse("+-*/%")
        val pila: IStack<String> = TLinkedStack()
        val lista: IList<String> = TList()

        expresion.forEach() { currentTerm ->
            when (currentTerm) {
                "(" -> return@forEach
                ")" -> {
                    lista.add(pila.peek())
                    pila.pop()
                }
                else -> {
                    if(operators.contains(currentTerm))
                        pila.push(currentTerm)
                    else lista.add(currentTerm)
                }
            }
        }

        return lista;
    }

    /**
     * Realiza la evaluación de la expresión postfija almacenada en la lista
     * llamada "expresión". Realiza las operaciones de acuerdo al algoritmo
     * presentado.
     */
    fun evaluarExpresiónPostfija(expression: IList<String>): Int {
        val pila: IStack<Int> = TLinkedStack()

        val operators = Utils.parse("+-*/%")
        val isNumeric = {str:String -> try {
            str.toInt()
            true
        } catch (e:Exception) {false} }
        val operatorIndex = {element:String -> operators.indexOf(element)}

        val peekAndPop = {pila:IStack<*> ->
            val lastElement = pila.peek()
            pila.pop()
            lastElement
        }

        expression.forEach() {currentElement->
            if(isNumeric(currentElement))
                pila.push(currentElement.toInt())

            else if(operatorIndex(currentElement) != -1){
                val num2 = peekAndPop(pila).toString().toInt()
                val num1 = peekAndPop(pila).toString().toInt()
                var result = when(operatorIndex(currentElement)) {
                    0 -> num1 + num2
                    1 -> num1 - num2
                    2 -> num1 * num2
                    3 -> num1 / num2
                    else -> -1
                }
                pila.push(result)
            }
        }

        return pila.peek()
    }
}
