/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Unidad de Estudios: Estructura de Datos
 * Taller: 02
 * Fecha: 1 de agosto de 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package co.edu.ean.estructuradedatos.taller02

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.round

/**
 * Ejercicio 1:
 * Una tienda de licores compra a su distribuidor cajas de vino que luego vende
 * por botellas. Dado una caja de vino que tiene un costo c y contiene n botellas,
 * se desea calcular el precio p al que se debe vender cada botella, de manera tal
 * que se obtenga un 30% de utilidad sobre el costo total de las cajas.
 */
fun ejercicio1(c : Double, n : Int) : Double {
    var p = (c*1.3)/n
    return p
}

/**
 * Ejercicio 2:
 * Se sabe que un profesor universitario contratado como catedrático, dedica
 * una hora a preparar una clase de dos horas y por cada diez horas de clase
 * desarrolladas hace una evaluación, la cual le toma 4 horas calificar.
 * Si al docente se le asigna un curso de n horas al semestre, ¿cuántas horas
 * trabajará en total durante el semestre?
 *
 * 1 -> 2 = 3
 *
 */
fun ejercicio2(n : Int) : Int {
    var hrTrabajada = 0
    if ((n/10)>0){
        var numV = n/10
        hrTrabajada+=(4*numV)+(n/2)
    }else{
        hrTrabajada+=0
    }
    return hrTrabajada
}

/**
 * Ejercicio 3
 * Un profesor diseña un examen con n preguntas, estima que para calificar
 * cada pregunta requiere m minutos. Si el examen se aplica a k estudiantes,
 * ¿cuánto tiempo (horas y minutos) necesita para calificar todos los exámenes?.
 */
fun ejercicio3(n : Int, m : Int, k : Int) : Pair<Int, Int> {
    var segTotal = n*m*k
    var min = (segTotal-(3600*(segTotal/3600)))/60;
    var seg = segTotal-(((segTotal/3600)*3600)+(min*60));
    return Pair(min, seg)
}

/**
 * Ejercicio 4:
 * Tres personas deciden invertir su dinero para fundar una empresa. Cada una
 * de ellas invierte una cantidad distinta. Obtener el porcentaje que cada cual
 * invierte con respecto a la cantidad total invertida.
 */
fun ejercicio4(persona1 : Double, persona2 : Double, persona3 : Double) : Triple<Double, Double, Double> {
    var invTotal = persona1+persona2+persona3
    var porcPer1 = ((persona1*100)/invTotal)/100
    var porcPer2 = ((persona2*100)/invTotal)/100
    var porcPer3 = ((persona3*100)/invTotal)/100
    return Triple(porcPer1, porcPer2, porcPer3)
}

/**
 * Ejercicio 5:
 * Dado un número de 3 dígitos, retornar cada uno de sus tres dígitos :
 * miles, centenas, decenas y unidades.
 */
fun ejercicio5(numero : Int) : Triple<Int, Int, Int> {
    var centenas = (numero/10)/10
    var decenas = (numero/10)%10
    var unidades = numero%10
    return Triple(centenas, decenas, unidades)
}

/**
 * Ejercicio 6:
 * Un estudiante desea saber cuál será su calificación final en Programación.
 * Dicha calificación se compone del promedio de tres notas parciales. Cada
 * nota parcial se obtiene a partir de un taller, una evaluación teórica y
 * una evaluación práctica. Los talleres equivalen al 25% de la nota del
 * parcial, las evaluaciones teóricas al 35% y las evaluaciones prácticas al 40%.
 */

fun ejercicio6(notaTaller : Double, notaEvTeo : Double, notaEvPrac : Double): Double {
    return (notaTaller*0.25)+(notaEvTeo*0.35)+(notaEvPrac*0.4)
}

/**
 * Ejercicio 7:
 * Las utilidades de una empresa se distribuyen entre tres socios así: socio
 * A = 40%, socio B = 25% y socio C = 35%. Dada una cantidad de dinero
 * ¿cuánto corresponderá a cada uno?
 */

fun ejercicio7(cantDinero: Double) : Triple<Double, Double, Double> {
    var cantA = cantDinero*0.4
    var cantB = cantDinero*0.25
    var cantC = cantDinero*0.35
    return Triple(cantA, cantB, cantC)
}

/**
 * Ejercicio 8:
 * Un vendedor recibe un 10% de comisión sobre sus ventas. Si en un mes
 * cualquiera hace tres ventas por valores diferentes ¿cuánto recibirá
 * por comisión en cada una de las ventas? y ¿cuánto en total?
 */

///////////////////////////////////////////////////
//class comision(var comision1: Double, var comision2: Double, var comision3: Double, var comisionTotal: Double)

fun ejercicio8(venta1 : Double, venta2 : Double, venta3 : Double) : ArrayList<Double> {
    var arraylistVent = ArrayList<Double>(4)
    arraylistVent.add(venta1*0.1)
    arraylistVent.add(venta2*0.1)
    arraylistVent.add(venta3*0.1)
    arraylistVent.add(venta1*0.1+venta2*0.1+venta3*0.1)
    return arraylistVent
}

/**
 * Ejercicio 9:
 * En el nuevo edificio de la universidad, cada piso tendrá el mismo
 * número de salones y suponga que todos los salones del nuevo edificio
 * tendrán el mismo número de sillas, conocida esta como la capacidad del
 * salón. Calcule el número de salones y el número de pisos que tendrá
 * el nuevo edificio a partir de la capacidad del salón, el número
 * de salones que habrá en cada piso y el número de
 * estudiantes que van a la universidad.
 */

fun ejercicio9(capacidadSalon : Int, numSalonesPiso : Int, numEstudiantes : Int) : Pair<Int, Int> {
    var numPisos = (numEstudiantes/capacidadSalon)/numSalonesPiso
    var numSalones = numSalonesPiso*numPisos
    return Pair(numSalones, numPisos)
}

/**
 * Ejercicio 10:
 * Un año es bisiesto si es múltiplo de 4 pero no de 100, también se
 * es bisiesto cuando es múltiplo de 400. Escriba una función que reciba
 * un año (un número entero) y que retorne si ese año es bisiesto o no.
 * Ejemplo: 2024 es bisiesto, pero 1900 no lo fue.
 */

fun ejercicio10(anio : Int) : Boolean {
    return (anio % 4 == 0) and ((anio % 100 != 0) || (anio % 400 == 0))
}