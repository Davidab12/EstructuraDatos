productos = {
            int(1): str('Pan'),\
            int(2): str('Leche'),\
            }

valores = {
            int(1): float(400.0),\
            int(2): float(2000.0),\
            }

entrada = ""
sumaSubtotal = 0

while entrada != "x":
    entrada = input("n = agregar un producto\ni = Iniciar compra\nx = Salir de la App\n")
    if entrada == "n":
        entradaAgregar = input("Agrega codigo, nombre y precio respectivamnete")
        datos = entradaAgregar.split(" ")
        code = int(datos[0])
        producto = datos[1]
        precio = datos[2]
        productos[code] = str(producto)
        valores[code] = float(precio)


    while entrada != "q":
        
        entradaCompra = input("ingresa codigo y unidades a comprar respectivamente\n")
        datos = entradaCompra.split(" ")
        code = int(datos[0])
        unidades = int(datos[1])
        sumaSubtotal += valores[code]*unidades

        entrada = input("c = desea ingresar otro codigo\nf = generar factura\nq = cancelar la compra\n")
        if entrada == "f":

            print("Factura\n",sumaSubtotal)
    print("Compra Cancelada")

