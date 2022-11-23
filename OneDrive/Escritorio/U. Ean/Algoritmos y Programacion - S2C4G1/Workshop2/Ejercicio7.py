'''
Definir un procedimiento que visualice por pantalla el total a pagar por una compra
en una tienda de jeans (formato factura). Teniendo en cuanta las siguientes reglas
de descuentos:
    • Si se compran de dos a cinco jeans, se aplica un descuento del 25% de
        descuento.
    • Si se compran más de cinco jeans, un jean sale gratis.
Recuerde que se debe visualizar la descripción del producto, cantidad, el precio de
venta. Para liquidar recuerde discriminar el valor del IVA (19%). Los datos que
necesite deben pasarse por parámetro.
'''

comprador = input("Nombre de comprador: ")
fecha = "22/10/2021"
descripcion = "Descripcion del Jean"
precioJean = 80000
numJeans = int(input("Numero de Jeans a comprar: "))
def facturarTotal(fecha,comprador, numJeans, precioJean, descripcion):
    if numJeans == 1:
        subTotal = precioJean
        iva = precioJean * 0.19
        subTotal = precioJean-iva
        total = precioJean
        print("\nFecha de venta:     "+str(fecha)+
            "\nComprador:          "+comprador+"\n"
            "\nDescripcion:        "+descripcion+
            "\nCantidad:           ("+str(numJeans)+") Unidad"
            "\nSubtotal:           "+str(subTotal)+
            "\nIVA (19%):          "+str(iva)+
            "\nDescuento:          No aplica"
            "\n"
            "\nTOTAL A PAGAR:      "+str(total)+"\n")

    elif 2 <= numJeans <= 5:
        subTotal = numJeans * precioJean
        descuento25 = subTotal*0.25
        iva = subTotal * 0.19
        total = (subTotal + iva) - descuento25
        print("\nFecha de venta:     "+str(fecha)+
            "\nComprador:          "+comprador+"\n"
            "\nDescripcion:        "+descripcion+
            "\nCantidad:           ("+str(numJeans)+") Unidades"
            "\nSubtotal:           "+str(subTotal)+
            "\nIVA (19%):          "+str(iva)+
            "\nDescuento (25%)    -"+str(descuento25)+
            "\n"
            "\nTOTAL A PAGAR:      "+str(total)+"\n")

    elif numJeans > 5:
        descuentoJean = precioJean
        subTotal = numJeans * precioJean
        iva = subTotal * 0.19
        total = (subTotal + iva) - descuentoJean
        print("\nFecha de venta:     "+str(fecha)+
            "\nComprador:          "+comprador+"\n"
            "\nDescripcion:        "+descripcion+
            "\nCantidad:           ("+str(numJeans)+") Unidades"
            "\nSubtotal:           "+str(subTotal)+
            "\nIVA (19%):          "+str(iva)+
            "\nDescuento (Jean):  -"+str(descuentoJean)+
            "\n"
            "\nTOTAL A PAGAR:      "+str(total)+"\n")

facturarTotal(fecha,comprador, numJeans, precioJean, descripcion)
