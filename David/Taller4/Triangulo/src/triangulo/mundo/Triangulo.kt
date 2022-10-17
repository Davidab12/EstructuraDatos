/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios de Estructura de Datos
 * Ejercicio: Triangulo
 * Basado en el ejercicio de Cupi2
 * Realizado por: David y Jesus
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package triangulo.mundo

import org.testng.annotations.Test
import kotlin.math.sqrt
import kotlin.test.assertEquals

/**
 * Clase que representa un triángulo.
 */
class Triangulo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Primer punto del triángulo.
     */
    private val punto1: Punto = Punto(200.0, 50.0)

    /**
     * Segundo punto del triángulo.
     */
    private val punto2: Punto = Punto(300.0, 200.0)

    /**
     * Tercer punto del triángulo.
     */
    private val punto3: Punto = Punto(100.0, 200.0)

    /**
     * Color de las líneas.
     */
    private val colorLineas: Color = Color(60, 168, 56)

    /**
     * Color del relleno.
     */
    private val colorRelleno: Color = Color(0, 83, 24)

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el punto 1 del triángulo.
     * @return Punto 1.
     */
    fun darPunto1(): Punto {
        return Punto(this.punto1.darX(),this.punto1.darY())
    }

    /**
     * Retorna el punto 2 del triángulo.
     * @return Punto 2.
     */
    fun darPunto2(): Punto {
        return Punto(this.punto2.darX(),this.punto2.darY())
    }

    /**
     * Retorna el punto 3 del triángulo.
     * @return Punto 3.
     */
    fun darPunto3(): Punto {
        return Punto(this.punto3.darX(),this.punto3.darY())
    }

    /**
     * Retorna el color de las líneas del triángulo.
     * @return Color de las líneas.
     */
    fun darColorLineas(): Color {
        return Color(this.colorLineas.darRojo(), this.colorLineas.darVerde(), this.colorLineas.darAzul())
    }

    /**
     * Retorna el color del relleno del triángulo.
     * @return Color del relleno.
     */
    fun darColorRelleno(): Color {
        return Color(this.colorRelleno.darRojo(), this.colorRelleno.darVerde(), this.colorRelleno.darAzul())
    }

    /**
     * Retorna el perímetro del triángulo.
     * @return Perímetro del triángulo.
     */
    fun darPerimetro(): Double {
        // Retorna la suma de todos los lados
        return calcularLado1() + calcularLado2() + calcularLado3()
    }

    @Test
    fun pruebaPerimetro(){
        assertEquals(560.5551275463989,darPerimetro())
        println("Se ha superado la prueba del perimetro! :)")
    }

    /**
     * Retorna el área del triángulo, calculada utilizando la formula de Herón. <br></br>
     * @return Área del triángulo.
     */
    fun darArea(): Double {
        // Calcula y devuelve el área
        var semiP = (calcularLado1() + calcularLado2() + calcularLado3()) / 2
        return sqrt(semiP * (semiP - calcularLado1()) * (semiP - calcularLado2()) * (semiP - calcularLado3()))
    }

    @Test
    fun pruebaArea(){
        assertEquals(15000.0,darArea())
        println("Prueba del area fue superada! :)")
    }

    /**
     * Calcula la altura del triángulo, teniendo en cuenta como base la línea entre el punto 1 y 2. <br></br>
     * Tenga en cuenta que Área = (Base * Altura) / 2.
     * @return Altura del triángulo.
     */
    fun darAltura(): Double {
        // se despejo la formula del area para hallar la altura del triangulo
        return (darArea() * 2) / calcularLado1()
    }

    @Test
    fun pruebaAltura(){
        assertEquals(166.41005886756875,darAltura())
        println("Prueba de la altura fue superada! :)")
    }

    /**
     * Calcula la distancia entre el punto 1 y 2.
     * @return Distancia entre el punto 1 y el punto 2.
     */
    fun calcularLado1(): Double {
        return sqrt(((punto2.darX() - punto1.darX()) * (punto2.darX() - punto1.darX())) + ((punto2.darY() - punto1.darY()) * (punto2.darY() - punto1.darY())))
    }

    /**
     * Calcula la distancia entre el punto 2 y 3.
     * @return Distancia entre el punto 2 y 3.
     */
    fun calcularLado2(): Double {
        return sqrt(((punto3.darX() - punto2.darX()) * (punto3.darX() - punto2.darX())) + ((punto3.darY() - punto2.darY()) * (punto3.darY() - punto2.darY())))
    }

    /**
     * Calcula la distancia entre el punto 3 y 1.
     * @return Distancia entre el punto 3 y 1.
     */
    fun calcularLado3(): Double {
        return sqrt(((punto3.darX() - punto1.darX()) * (punto3.darX() - punto1.darX())) + ((punto3.darY() - punto1.darY()) * (punto3.darY() - punto1.darY())))
    }

    /**
     * Calcula el ángulo opuesto entre un vértice de referencia y los otros dos vértices de un triángulo.
     * @param pX1 Coordenada X del vértice de referencia.
     * @param pY1 Coordenada Y del vértice de referencia.
     * @param pX2 Coordenada X del vértice opuesto 1.
     * @param pY2 Coordenada Y del vértice opuesto 1.
     * @param pX3 Coordenada X del vértice opuesto 2.
     * @param pY3 Coordenada Y del vértice opuesto 2.
     * @return Ángulo opuesto entre vértice de referencia y los otros dos vértices.
     */
    fun calcularAnguloOpuesto(pX1: Double, pY1: Double, pX2: Double, pY2: Double, pX3: Double, pY3: Double): Double {
        // Ángulo 1
        var angulo1 = Math.atan2(pY2 - pY1, pX2 - pX1)

        // Ángulo 2
        var angulo2 = Math.atan2(pY3 - pY1, pX3 - pX1)

        // Garantiza que la diferencias de ángulos sea la más pequeña.
        if (Math.abs(angulo1 - angulo2) > Math.PI) {
            angulo1 = if (angulo1 < 0) angulo1 + 2.0 * Math.PI else angulo1
            angulo2 = if (angulo2 < 0) angulo2 + 2.0 * Math.PI else angulo2
        }

        // Calcula el ángulo opuesto
        var anguloOpuesto = (angulo1 + angulo2) / 2.0 + Math.PI
        anguloOpuesto = anguloOpuesto % (2.0 * Math.PI)
        return anguloOpuesto
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto1(pX: Double, pY: Double) {
        this.punto1.cambiarX(pX)
        this.punto1.cambiarY(pY)
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto2(pX: Double, pY: Double) {
        this.punto2.cambiarX(pX)
        this.punto2.cambiarY(pY)
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto3(pX: Double, pY: Double) {
        this.punto3.cambiarX(pX)
        this.punto3.cambiarY(pY)
    }

    /**
     * Cambia el color de relleno del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    fun cambiarColorRelleno(pRojo: Int, pVerde: Int, pAzul: Int) {
        this.colorRelleno.cambiarRojo(pRojo)
        this.colorRelleno.cambiarVerde(pVerde)
        this.colorRelleno.cambiarAzul(pAzul)
    }

    /**
     * Cambia el color de la líneas del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    fun cambiarColorLineas(pRojo: Int, pVerde: Int, pAzul: Int) {
        this.colorLineas.cambiarRojo(pRojo)
        this.colorLineas.cambiarVerde(pVerde)
        this.colorLineas.cambiarAzul(pAzul)
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Permite obtener el tipo del triángulo
     * "equilátero" si los tres lados son iguales
     * "isosceles" si dos lados son iguales
     * "escaleno" si los tres lados son diferentes
     *
     * Prueba para equilatero = A(1 , 0) , B(9 , 0) , C(5 , 6.92820323027551)
     */
    fun tipo(): String {
        var tipo = if ((calcularLado1() == calcularLado2()) && (calcularLado1() == calcularLado3())){
            "Equilatero"
        } else if((calcularLado1() == calcularLado2()) || (calcularLado1() == calcularLado3()) || (calcularLado2() == calcularLado3())){
            "Isosceles"
        }else{
            "Escaleno"
        }
        return tipo
    }

    /**
     * Permite obtener el punto en el centro del triángulo, conocido como el centroide
     */
    fun centroide(): Punto {
        var coordX = (punto1.darX() + punto2.darX() + punto3.darX()) / 3
        var coordY = (punto1.darY() + punto2.darY() + punto3.darY()) / 3
        return Punto(coordX, coordY)
    }
}

/**
 * Permite obtener el punto que se encuentra en el incentro del triángulo t
 * El incentro es el punto donde las bisectrices de los tres ángulos internos
 * se intersecan.
 * https://www.neurochispas.com/wiki/incentro-de-un-triangulo-definicion-formulas-y-ejemplos/
 */

fun incentro(t: Triangulo): Punto {
    //Se halla el incentro con la formula
    var a = t.calcularLado2()
    var b = t.calcularLado3()
    var c = t.calcularLado1()
    var coordX = ((a*t.darPunto1().darX()) + (b*t.darPunto2().darX()) + (c*t.darPunto3().darX())) / (a + b + c)
    var coordY = ((a*t.darPunto1().darY()) + (b*t.darPunto2().darY()) + (c*t.darPunto3().darY())) / (a + b + c)
    return Punto(coordX, coordY)
}

