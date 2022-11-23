
#INVENTARIO PARA LA TIENDA

"""
------------DICCIONARIOS----------------

    llamado: PRODUCTS
        llave sera el codigo del producto
            una lista formada por atributos = (nombre, precio ,unidades, ubicacion)

---------------FUNCIONES--------------------

    construir 8 funciones que representan a:
        AGREGAR
            agregar un nuevo producto
        ACTUALIZAR
            actualizar producto
        BORRAR
            borrar producto
        PRODUCTO
            ver producto especifico
        INFORME
            datos importantes del invetario
        INVENTARIO
            tabla con todos los productos disponibles
        COMPRAR
            realizar proceso de compra de productos
        CLIENTES
            lista de los clientes con mas puntos a menos puntos

--------------ENTRADAS------------
compuesta por dos lineas
    primera linea:
        formada por una cadena de texto que identifica la operacion a realizar
        (ACTUALIZAR, BORRAR, AGREGAR, PRODUCTO, INFORME, INVENTARIO, COMPRAR, CLIENTES)

    segunda linea.
        ACTUALIZAR
            Ingresar los dados del producto
        BORRAR
            Ingresar los dados del producto
        AGREGAR
            Ingresar los dados del producto
        PRODUCTO
            Ingresar los dados del producto
        INFORME
            NO TIENE OTRA ENTRADA
        INVENTARIO
            NO TIENE OTRA ENTRADA
        COMPRAR
            Ingresar los dados del producto a comprar
            seguir comprando
            Facturar compra
            cancelar compra
        CLIENTES
            NO TIENE OTRA ENTRADA

------------SALIDAS-----------------
    ACTUALIZAR
        Producto actualizado
    BORRAR
        Producto borrado
    AGREGAR
        Producto guardado
    PRODUCTO
        lista del los datos del Producto
    INFORME
        Datos importantes del inventario
    INVENTARIO
        todos los productos del inventario
    COMPRAR
        factura o compra cancelada
    CLIENTES
        lista de los clientes con mas puntos

"""

'''
-----------------------------------------------------------------
------------------------DICCIONARIOS-----------------------------
-----------------------------------------------------------------
'''

#llave(codigo) : [nombre , precio , unidades, ubicacion]

products = {
            int(1): [str('Naranjas'),  float(7000.0), int(35)],\
            int(2): [str('Limones'),   float(2500.0), int(15)],\
            int(3): [str('Peras'),     float(2700.0), int(65)],\
            int(4): [str('Arandanos'), float(9300.0), int(34)],\
            int(5): [str('Tomates'),   float(2100.0), int(42)],\
            int(6): [str('Fresas'),    float(9100.0), int(20)],\
            int(7): [str('Helado'),    float(4500.0), int(41)],\
            int(8): [str('Galletas'),  float(500.0),  int(8)],\
            int(9): [str('Chocolates'),float(4500.0), int(80)],\
            int(10):[str('Jamon'),     float(17000.0),int(48)],\
            }



#llave(id) : [nombre , puntos]

clients = {

            int(1): [str('Sebastian'), int(12)],\
            int(2): [str('Leiva'),     int(17)],\
            int(3): [str('Tatiana'),   int(26)],\
            int(3): [str('David'),     int(21)],\

        }





'''
-----------------------------------------------------------------
---------------------------FUNCIONES-----------------------------
-----------------------------------------------------------------
'''



#-----------------------------AGREGAR----------------------------

def addProduct():
    data = input().split()
    code = int(data[0])
    name = str(data[1])
    price = data[2]
    inventory = int(data[3])

    check = (code in products)
    if check == False:
        products[code]= name, float(price), inventory
    else:
        print('ERROR')


#--------------------------ACTUALIZAR----------------------------

def upProduct():
    data = input().split()
    code = int(data[0])
    name = str(data[1])
    price = data[2]
    inventory = int(data[3])

    check = (code in products)
    if check == True:
        products[code]= [name, float(price), inventory]
    else:
        print('ERROR')

#------------------------------BORRAR----------------------------

def delProduct():
    data = input().split()
    code = int(data[0])
    name = str(data[1])
    price = data[2]
    inventory = data[3]

    check = (code in products)
    if check == True:
        del (products[code])
    else:
        print('ERROR')



'''
-----------------------------------------------------------------
------------------------PROGRAMA PRINCIPAL-----------------------
-----------------------------------------------------------------
'''


option = input()

#ACTUALIZAR ------------------------------------------------------
if option == 'ACTUALIZAR':
    data = input().split()
    code = int(data[0])
    name = str(data[1])
    price = data[2]
    inventory = int(data[3])

    check = (code in products)
    if check == True:
        products[code]= [name, float(price), inventory]

        lista=[]
        tprice = []
        numinv = []
        nomprod = []

        for valores in products:
            lista.append(products[valores])
        for datas in lista:
            tprice.append(datas[1])
            numprice = len(tprice)
            promprice = sum(tprice)/numprice
            numinv.append(datas[1]*datas[2])
            v_inv = sum(numinv)
            nomprod.append(datas[0])

            maxprod = max(tprice)
            minprod = min(tprice)
            poscmax = tprice.index(maxprod)
            poscmin = tprice.index(minprod)
            mayorprod = nomprod[poscmax]
            menorprod = nomprod[poscmin]

        print(mayorprod,menorprod,round(promprice,1),round(v_inv,1))
    else:
        print('ERROR')

#AGREGAR ---------------------------------------------------------------
elif option == 'AGREGAR':
    data = input().split()
    code = int(data[0])
    name = str(data[1])
    price = data[2]
    inventory = int(data[3])

    check = (code in products)
    if check == False:
        products[code]= name, float(price), inventory

        lista=[]
        tprice = []
        numinv = []
        nomprod = []

        for valores in products:
            lista.append(products[valores])
        for datas in lista:
            tprice.append(datas[1])
            numprice = len(tprice)
            promprice = sum(tprice)/numprice
            numinv.append(datas[1]*datas[2])
            v_inv = sum(numinv)
            nomprod.append(datas[0])

            maxprod = max(tprice)
            minprod = min(tprice)
            poscmax = tprice.index(maxprod)
            poscmin = tprice.index(minprod)
            mayorprod = nomprod[poscmax]
            menorprod = nomprod[poscmin]

        print(mayorprod,menorprod,round(promprice,1),round(v_inv,1))
    else:
        print('ERROR')


#BORRAR ------------------------------------------------------------------
elif option == 'BORRAR':
    data = input().split()
    code = int(data[0])
    name = str(data[1])
    price = data[2]
    inventory = data[3]

    check = (code in products)
    if check == True:
        del (products[code])

        lista=[]
        tprice = []
        numinv = []
        nomprod = []

        for valores in products:
            lista.append(products[valores])
        for datas in lista:
            tprice.append(datas[1])
            numprice = len(tprice)
            promprice = sum(tprice)/numprice
            numinv.append(datas[1]*datas[2])
            v_inv = sum(numinv)
            nomprod.append(datas[0])

            maxprod = max(tprice)
            minprod = min(tprice)
            poscmax = tprice.index(maxprod)
            poscmin = tprice.index(minprod)
            mayorprod = nomprod[poscmax]
            menorprod = nomprod[poscmin]

        print(mayorprod,menorprod,round(promprice,1),round(v_inv,1))
    else:
        print('ERROR')

#########################################################################################
lista = []
    #print(products.values())
for key in products.keys():
    lista.append(products[key])

print("{:<16} {:<17} {:<13} {:<10} {:<10}".format('|   Name    |',' DateVenc    |','Price    |','Unid   |',"Ubic   |"))
print("--------------------------------------------------------------------")
for i in range(len(lista)):
    Codigo = lista[i][0]
    Nombre = lista[i][1]
    Precio = lista[i][2]
    Cantidad = lista[i][3]
    SubT = lista[i][4]

    print("{:<16} {:<17} {:<13} {:<10} {:<10}".format( "  "+Codigo, str(Nombre), Precio, " "+str(Cantidad), " "+str(SubT)))




