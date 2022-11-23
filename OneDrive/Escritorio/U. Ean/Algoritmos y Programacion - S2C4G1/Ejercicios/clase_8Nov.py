productos = {

            }

valores = {

            }

entrada = ""
sumaSubtotal = 0
Iva = 0
totalPago = 0

while entrada != "x":
    entrada = input("n = Agregar producto\ni = Iniciar compra\nx = Salir de la App\n")
    if entrada == "n":
        code = int(input("\nCodigo del Producto: "))
        producto = input("Nombre del Producto: ")
        precio = float(input("Precio del Producto: "))
        productos[code] = str(producto)
        valores[code] = float(precio)
        print("\n¡",producto," ha sido guardad@ con exito !\n")

    elif entrada == "i":
        lista = [["Code" , "Name" , "Price" , "Unid", "subT"]]
        while entrada != "q":
            code = int(input("\nCodigo del Producto: "))
            unidades = int(input("Unidades del Producto: "))
            Iva += (valores[code]*unidades)*0.19
            sumaSubtotal += (valores[code]*unidades)-((valores[code]*unidades)*0.19)
            totalPago += valores[code]*unidades
            lista.append([code,productos[code],valores[code],unidades, valores[code]*unidades])
            entrada = input("\nc = Seguir comprando\nf = Facturar\nq = Cancelar\n")

            if entrada == "f":
                for i in range(len(lista)):
                    Codigo = lista[i][0]
                    Nombre = lista[i][1]
                    Precio = lista[i][2]
                    Cantidad = lista[i][3]
                    SubT = lista[i][4]
                    print(Codigo,"\t",Nombre,"\t   ",Precio,"\t",Cantidad,"\t",SubT)
                print("\nSubTotal:\t\t\t\t",sumaSubtotal,"\nIVA:\t\t\t\t\t",Iva,"\nTotal A Pagar:\t\t\t\t",totalPago,"\n")
                break
        if entrada == "q":
            print("\nCompra cancelada\n")
    elif entrada != ("i" and "n" and "x"):
        print("\nERROR | Opcion no existente\n")

print("\n¡Gracias por usar la APP!\n")

