import ean.collections.*
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

internal class ConvertidorDeInfijoAPostfijoTest {
    @Test
    fun probarEQU() {
        val pila1: IStack<Double> = TLinkedStack()
        pila1.push(3.0)
        pila1.push(2.0)
        pila1.push(1.0)
        pila1.push(4.0)
        pila1.push(7.0)
        pila1.push(3.0)
        pila1.push(1.0)
        pila1.push(5.0)
        pila1.push(6.0)

        val pila2: IStack<Double> = TLinkedStack()
        pila2.push(1.0)
        pila2.push(2.0)
        pila2.push(6.0)
        pila2.push(4.0)
        pila2.push(2.0)
        pila2.push(9.0)
        pila2.push(1.0)
        pila2.push(3.0)
        pila2.push(6.0)

        val resultado: IStack<Double> = TLinkedStack()
        resultado.push(2.0)
        resultado.push(4.0)
        resultado.push(3.0)
        resultado.push(8.0)
        resultado.push(4.0)
        resultado.push(6.0)
        resultado.push(2.0)
        resultado.push(4.0)
        resultado.push(12.0)

        assertEquals(resultado, EQU(pila1,pila2))
    }
}

fun EQU(pila1: IStack<Double>, pila2: IStack<Double>): IStack<Double>{
    val pila1_ex = pila1.copy(); val pila2_ex = pila2.copy(); val EQUResult_i:IStack<Double> = TLinkedStack()
    while(!pila1_ex.isEmpty) {
        val pila1_val = pila1_ex.peek(); val pila2_val = pila2_ex.peek()
        if(pila1_val == pila2_val)
            EQUResult_i.push(pila1_val+pila2_val)
        else {
            val average = ((pila1_val.toInt()+pila2_val.toInt())/2)
            EQUResult_i.push(average.toDouble())
        }
        pila1_ex.pop()
        pila2_ex.pop()
    }
    val EQUResult:IStack<Double>  = TLinkedStack()
    while(!EQUResult_i.isEmpty) {
        EQUResult.push(EQUResult_i.peek())
        EQUResult_i.pop()
    }
    return EQUResult
}