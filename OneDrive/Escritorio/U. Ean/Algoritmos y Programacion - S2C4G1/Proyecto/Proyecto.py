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
------------------------IMPORTACIONES----------------------------
-----------------------------------------------------------------
'''

from tabulate import tabulate
from fpdf import FPDF
from datetime import date, datetime
now = datetime.now()



'''
-----------------------------------------------------------------
------------------------DICCIONARIOS-----------------------------
-----------------------------------------------------------------
'''

#llave(codigo) : [code, nombre , precio , unidades, estanteria]

products = {
        int(1): [str("1"), str('Naranjas'),  date(2021, 12, 16), float(7000.0), int(35), str('A1')],\
        int(2): [str("2"), str('Limones'),   date(2021, 12, 1), float(2500.0), int(7), str('C1')],\
        int(3): [str("3"), str('Peras'),     date(2022, 1, 15), float(2700.0), int(65), str('B1')],\
        int(4): [str("4"), str('Arandanos'), date(2021, 12, 12), float(9300.0), int(34), str('A1')],\
        int(5): [str("5"), str('Tomates'),   date(2021, 12, 2), float(2100.0), int(42), str('A2')],\
        int(6): [str("6"), str('Fresas'),    date(2021, 12, 27), float(9100.0), int(20), str('B1')],\
        int(7): [str("7"), str('Helado'),    date(2022, 1, 5), float(4500.0), int(41), str('A3')],\
        int(8): [str("8"), str('Galletas'),  date(2022, 1, 23), float(500.0),  int(8),  str('C2')],\
        int(9): [str("9"), str('Chocolates'),date(2021, 12, 21), float(4500.0), int(7), str('B2')],\
        int(10):[str("10"),str('Jamon'),     date(2021, 12, 7), float(17000.0),int(48), str('C1')],\
        }


#llave(id) : [nombre , puntos]

clients = {

        int(9084): [int("9084"), str('Sebastian'), int(12)],\
        int(5388): [int("5388"), str('Leiva'),     int(17)],\
        int(1000): [int("1000"), str('Tatiana'),   int(26)],\
        int(1007): [int("1007"), str('David'),     int(20)],\
        int(5810): [int("5810"), str('Andres'),    int(21)],\
        }




'''
-----------------------------------------------------------------
---------------------------FUNCIONES-----------------------------
-----------------------------------------------------------------
'''
#------------SABER QUE CODIGO NO ESTA EN EL DICCIONARIO-----------

def numNotExist():
    num = 1
    listaKeys = []
    listaKeys.extend(products.keys())
    while num in listaKeys:
        num+=1
    return num


#-----------------------------FUNCIONES DEL PDF------------------


class PDF(FPDF):
    pass

    def logo(self, name, x, y, w, h):
        self.image(name, x, y, w, h)

    def texts(self, name):
        with open(name, 'rb') as xy:
            txt = xy.read().decode('latin-1')
        self.set_xy(10.0, 40)
        self.set_text_color(0, 0, 0)
        self.set_font('Courier', '',12)
        self.multi_cell(0, 10, txt,0,"C",0)

    def titles(self, title):
        self.set_xy(0.0, 45)
        self.set_text_color(0, 0, 110)
        self.set_font('Courier', 'B',16)
        self.cell(w = 210.0, h = 40.0, align = 'C', txt = title, border = 0)

    def header(self):
        # Logo
        self.image('logoMerkean.jpeg', 5, 3, 60,20)
        self.image('qrMerkean.png', 180, 3, 25, 25)
        # Arial bold 15
        self.set_font('Courier', 'B', 15)
        # Move to the right
        self.cell(80)
        # Line break
        self.ln(20)

    # Page footer
    def footer(self):
        # Position at 1.5 cm from bottom
        self.set_y(-15)
        # Arial italic 8
        self.set_font('Arial', 'I', 8)
        # Page number
        self.cell(0, 10, 'Page ' + str(self.page_no()) + '/{nb}', 0, 0, 'C')



#-----------------------------AGREGAR PRODUCTO------------------

def addProduct():
    listaNames = []
    for i in products.keys():
        listaNames.append(products[i][1])

    name = str(input("Nombre del producto: ")).capitalize()
    check = (name in listaNames)

    if check == False:
        print("\nFecha de vencimiento:")
        fecha_str = (input("Fecha de vencimiento (dd/mm/aaaa): "))
        ints = fecha_str.split("/")
        fecD = int(ints[0])
        fecM = int(ints[1])
        fecA = int(ints[2])
        price = input("Precio del producto: ")
        inventory = int(input("Unidades del producto: "))
        ubicacion = input("Ubicacion del producto: ")
        code = numNotExist()
        products[code]= [str(code),name, date(fecA,fecM,fecD), float(price), inventory, ubicacion]
        out = "\n¡"+str(name)+" se ha agregado con exito!\n"
        return out
    else:
        out = "\nERROR | El producto ya existe\n"
        return out




#--------------------------ACTUALIZAR PRODUCTO---------------------

def upProduct():
    listaKeys = []
    listaNames = []
    listaKeys.extend(products.keys())
    for i in products.keys():
        listaNames.append(products[i][1])

    name = str(input("Nombre del producto: ")).capitalize()
    check = (name in listaNames)

    if check == True:
        posc = listaNames.index(name)
        code =  listaKeys[posc]
        print("\nFecha de vencimiento:")
        fecha_str = (input("Fecha de vencimiento (dd/mm/aaaa): "))
        ints = fecha_str.split("/")
        fecD = int(ints[0])
        fecM = int(ints[1])
        fecA = int(ints[2])
        price = input("Precio del producto: ")
        inventory = int(input("Unidades del producto: "))
        ubicacion = input("Ubicacion del producto: ")
        products[code]= [str(code),name, date(fecA,fecM,fecD), float(price), inventory, ubicacion]
        out = "\n¡"+str(name)+" se ha actualizado con exito!\n"
        return out
    else:
        out = "\nERROR | El producto no existe\n"
        return out


#------------------------------BORRAR PRODUCTO-----------------------

def delProduct():
    listaKeys = []
    listaNames = []
    listaKeys.extend(products.keys())
    for i in products.keys():
        listaNames.append(products[i][1])

    name = str(input("Nombre del producto: ")).capitalize()
    check = (name in listaNames)

    if check == True:
        posc = listaNames.index(name)
        code =  listaKeys[posc]
        del (products[code])
        out = "\n¡"+str(name)+" se ha borrado con exito!\n"
        return out
    else:
        out = "\nERROR | El producto no existe\n"
        return out


#------------------------OBTENER PRODUCTO------------------------

def getProduct():
    listaKeys = []
    listaNames = []
    listaKeys.extend(products.keys())
    for i in products.keys():
        listaNames.append(products[i][1])

    name = str(input("Nombre del producto: ")).capitalize()
    check = (name in listaNames)

    if check == True:
        posc = listaNames.index(name)
        code =  listaKeys[posc]
        out = "\nCodigo:\t\t"+str(code)+"\nNombre:\t\t"+str(products[code][1])+"\nFecha Ven:\t"+str(products[code][2])+"\nPrecio:\t\t"+str(products[code][3])+"\nUnidades:\t"+str(products[code][4])+"\nEstanteria:\t"+str(products[code][5])+"\n"
        return out
    else:
        out = "\nERROR | El producto no existe\n"
        return out



#-----------------------------AGREGAR CLIENTE------------------

def addClient():
    code = int(input("Id: "))
    check = (code in clients)
    if check == False:
        name = str(input("Nombre del cliente: ")).capitalize()
        points = 0
        clients[code]= [str(code), name, points]
        out = "\n¡"+str(name)+" se ha agregado con exito!\n"
        return out
    else:
        out = "\nError | El cliente ya existe\n"
        return out


#--------------------------ACTUALIZAR CLIENTE---------------------

def upClient():
    print("Nuevos datos de cliente\n")
    code = int(input("Id: "))

    check = (code in clients)
    if check == True:
        name = str(input("Nombre: ")).capitalize()
        points = int(input("Puntos: "))
        clients[code]= [str(code), name, points]
        out = "\n¡"+name+" se ha actualizado con exito!\n"
        return out
    else:
        out = "\nError | El cliente no existe\n"
        return out


#------------------------------BORRAR CLIENTE-----------------------

def delClient():
    code = int(input("Id del cliente: "))

    check = (code in clients)
    if check == True:
        del (clients[code])
        out = "\n¡El Cliente se ha borrado con exito!\n"
        return out
    else:
        out = "\nError | El Cliente no existe\n"
        return out


#--------------------PRODUCTO PROXIMO A VENCER--------------------

def dueDate():
    fechas = []
    today = date.today()
    for i in products.keys():
        fechas.append(products[i][2])
    fechaVencer = min(fechas, key=lambda x: abs(x - today))

    productVencer = ""
    for f in products.keys():
        if fechaVencer == products[f][2]:
            productVencer = products[f][1]
    vencerProximo = productVencer +" : "+str(fechaVencer)

    return vencerProximo


#-------------------------FACTURAR COMPRA------------------------

def invoice(lista, iva,subtotal,total,cliente):
    out = ""
    for i in range(len(lista)):
        Codigo = lista[i][0]
        Nombre = lista[i][1]
        Precio = lista[i][2]
        Cantidad = lista[i][3]
        SubTotal = lista[i][4]
        out +=Codigo,"\t",Nombre,"\t   ",Precio,"\t",Cantidad,"\t",str(SubTotal)+"\n"
        out += "\nSubTotal:\t\t\t\t",subtotal,"\nIVA:\t\t\t\t\t",iva,"\nTotal A Pagar:\t\t\t\t",total,"\n"

    return out


#------------------------REPORTE DE INVENTARIO---------------------

def reportInventory():
    lista=[]
    tprice = []
    numinv = []
    nomprod = []
    numInvent = 0
    unitInvent = []

    for valores in products:
        lista.append(products[valores])
    for datas in lista:
        unitInvent.append(datas[4])
        tprice.append(datas[3])
        numprice = len(tprice)
        promprice = sum(tprice)/numprice
        numinv.append(datas[3]*datas[4])
        v_inv = sum(numinv)
        nomprod.append(datas[1])
        numInvent += datas[4]

        maxprod = max(tprice)
        minprod = min(tprice)
        maxInv = max(unitInvent)
        minInv = min(unitInvent)
        poscUnitmax = unitInvent.index(maxInv)
        poscUnitmin = unitInvent.index(minInv)
        mayorUnitprod = nomprod[poscUnitmax]
        menorUnitprod = nomprod[poscUnitmin]
        poscmax = tprice.index(maxprod)
        poscmin = tprice.index(minprod)
        mayorprod = nomprod[poscmax]
        menorprod = nomprod[poscmin]

        productomayor = str(mayorprod)+" : "+str(maxprod)
        productomenor = str(menorprod)+" : "+str(minprod)
        promedioInv = str(round(promprice,1))+" en "+str(numInvent)+" productos"
        masUnit = str(mayorUnitprod)+" : "+str(maxInv)
        agotado = str(menorUnitprod)+" : "+str(minInv)

    out = [["Producto con menos unidades",agotado],["Producto con mas unidades",masUnit],["Producto de mayor valor",productomayor],["Producto de menor valor",productomenor] ,["Promedio del inventario",promedioInv] ,["Valor total del inventario",str(round(v_inv,1))] , ["Producto proximo a vencer",dueDate()], ["Ganancia del dia",gananciasDia]]
    return out

#------------------------OBTENER CLIENTE------------------------

def getClient():
    listaKey = []
    listaKey.extend(clients.keys())

    code = int(input("Id del cliente: "))
    check = (code in listaKey)

    if check == True:
        posc = listaKey.index(code)
        code =  listaKey[posc]
        out = "\nId:\t\t"+str(code)+"\nName:\t\t"+str(clients[code][1])+"\nPoints:\t\t"+str(clients[code][2])+"\n"
        return out
    else:
        out = "\nERROR | El cliente no existe\n"
        return out

'''
-----------------------------------------------------------------
---------------------------PROCEDIMIENTOS------------------------
-----------------------------------------------------------------
'''

#------------------------OBTENER INVENTARIO----------------------

def getInventory():
    lista = []
    #print(products.values())
    for key in products.keys():
        lista.append(products[key])
    print("")
    print("----------------------------------------------------------------------------------------------")
    print("{:<10} {:<19} {:<18} {:<17} {:<12} {:<12}".format('    Code','|       Name     ','|     DateVenc    ','|      Price     ','|    Unit   ',"|    Loc    "))
    print("----------------------------------------------------------------------------------------------")
    for v in products.values():
        code, name, datetime, price, unid, ubic= v
        print("{:<10} {:<19} {:<18} {:<17} {:<12} {:<12}".format( "     "+code,"|     "+name,"|    "+str(datetime)+"   ", "|     "+str(price), "|     "+str(unid), "|     "+str(ubic)))
    print("----------------------------------------------------------------------------------------------")
    print("")



#------------------------OBTENER CLIENTES------------------------


def getClients():
    lista = []

    lista.append(clients.values())
    #print(products.values())
    print("")
    print("----------------------------------------------------")
    print ("{:<13} {:<18} {:<10}".format('      Id   ','|        Name       ',"|     Points  "))
    print("----------------------------------------------------")
    for v in clients.values():
        Id, name, points= v
        print("{:<13} {:<20} {:<10}".format( "     "+str(Id),"|      "+name, "|       "+str(points)))
    print("----------------------------------------------------")
    print("")


#------------------------IMPRESIONES DE MENUS---------------------
def imprimirMenu():
    print("\n----------MENU PRINCIPAL------------\n")
    print("1: Iniciar Compra")
    print("2: Submenu de productos")
    print("3: Submenu de clientes")
    print("4: Submenu de Inventario")
    print("X: Salir de la Aplicacion")

def menuProducts():
    print("\n----------SubMenu de productos------------")
    print("\n1: Agregar producto")
    print("2: Actualizar producto")
    print("3: Borrar producto")
    print("4: Visualizar producto")
    print("0: Atras")


def menuBuy1():
    print("\n----------Compra------------")
    print("\nCodigo del producto: ")
    print("Unidades a comprar: ")
    print("0: Atras")

def menuBuy2():
    print("\n----------Compra------------")
    print("\n1: Agregar otro producto a la compra")
    print("2: Facturar")
    print("0: Cancelar comprar")


def menuClients():
    print("\n----------SubMenu de clientes------------")
    print("\n1: Agregar cliente")
    print("2: Actualizar cliente")
    print("3: Borrar cliente")
    print("4: Visualizar cliente")
    print("0: Atras")

def menuInventory():
    print("\n----------SubMenu de inventario------------")
    print("\n1: Visualizar lista de productos")
    print("2: Visualizar lista de clientes")
    print("3: Generar informe")
    print("0: Atras")


'''
-----------------------------------------------------------------
------------------------PROGRAMA PRINCIPAL-----------------------
-----------------------------------------------------------------
'''

gananciasDia = 0
unidadesVend = 0
productsSold = []


action = ''
while action.upper() != "X":
    imprimirMenu()
    action = input('\nElige una opcion: ')
    if action == "1":
        delUnit = []
        listaBuy = []
        total = 0
        subtotal = 0
        iva = 0
        while action != "0":
            listaKeys = []
            listaNames = []
            listaKeys.extend(products.keys())
            for i in products.keys():
                listaNames.append(products[i][1])
            print("\nC: Cancelar")
            name = str(input("Nombre del producto: ")).capitalize()
            if name.upper() == "C":
                print("\nCompra cancelada\n")
                break
            else:
                check = (name in listaNames)
                if check == True:
                    posc = listaNames.index(name)
                    code =  listaKeys[posc]
                    print("\nHay "+str(products[code][4])+" unidades de "+name+" disponibles")
                    unidades = int(input("Unidades a comprar: "))
                    if unidades <= products[code][4]:
                        iva += (products[code][3]*unidades)*0.19
                        subtotal += (products[code][3]*unidades)-((products[code][3]*unidades)*0.19)
                        total += products[code][3]*unidades
                        listaBuy.append([code,products[code][1],products[code][3], unidades, products[code][3]*unidades])
                        delUnit.append([code,unidades])

                        menuBuy2()
                        action = input('\nElige una opcion: ')
                        if action == "2":
                            for i in range(len(listaBuy)):
                                productsSold.append([listaBuy[i][0], listaBuy[i][1], listaBuy[i][3]])

                            for i in delUnit:
                                code = i[0]
                                unitMenos = i[1]
                                products[code][4] = products[code][4]-unitMenos

                            idClient = int(input("Id de cliente: "))
                            check = (idClient in clients)
                            if check == False:
                                name = str(input("Nombre del cliente: ")).capitalize()
                                points = 0
                                clients[idClient]= str(idClient), name, points
                                out = "\n¡"+str(name)+" se ha agregado con exito!\n"
                            elif check == True:
                                name = clients[idClient][1]

                            pointsBuy = int(total//1000)
                            clients[idClient]= str(idClient), name, clients[idClient][2]+pointsBuy

                            if clients[idClient][2] >= 500:
                                clients[idClient]= str(idClient), name, clients[idClient][2]-500
                                descuento50 = total*0.5
                            else:
                                descuento50 = 0
                            totaldescuento = total-descuento50
                            gananciasDia += totaldescuento
                            tableBuy = tabulate(listaBuy, headers=["Code", "Name", "Price","Unit","Total por producto"], tablefmt = 'psql')

                            infoFinal = [ ["$"+str(subtotal),"$"+str(iva),"$"+str(total),"$"+str(descuento50),"$"+str(totaldescuento)]]
                            tableFinal = tabulate(infoFinal, headers=["SubTotal","IVA","Total sin dto","Dto","Total"], tablefmt = 'psql')
                            file = open("factura.txt",'w')
                            file.write("\nTABLE OF BUYED PRODUCTS\n")
                            file.write(tableBuy)
                            file.write("\n\nTABLE TO PAY\n")
                            file.write(tableFinal)
                            file.write("\n\nPuntos actuales: "+str(clients[idClient][2]))
                            file.close()

                            pdf = PDF()
                            pdf.add_page()
                            pdf.set_font('Courier','B',12)
                            pdf.set_text_color(0, 0, 110)
                            pdf.text(83,30,'Factura de '+name)
                            pdf.text(73,35, ' Fecha: '+str(now.day)+"/"+str(now.month)+"/"+str(now.year)+", "+str(now.hour)+":"+str(now.minute))
                            pdf.texts('factura.txt')
                            pdf.logo('barcode.png', 70, 250, 68, 30)
                            pdf.set_author('MerkEan Store')
                            pdf.output('FacturaMark'+str(idClient)+'Ean.pdf', 'F')
                            print('\n¡Se ha generado la factura de '+name+' con exito!\n')

                            break
                        if action == "0":
                            print("\nCompra cancelada\n")
                    else:
                        print("\n¡No hay suficientes unidades de "+name+"! - "+str(products[code][4])+" disponibles")

                else:
                    print("\nERROR | El producto no existe\n")

    elif action == "2":
        while action != "0":
            menuProducts()
            action = input('\nElige una opcion: ')
            if action == "1":
                print(addProduct())
            elif action == "2":
                print(upProduct())
            elif action == "3":
                print(delProduct())
            elif action == "4":
                print(getProduct())
            elif action == "0":
                break
            else:
                print("\nERROR | Opcion Invalida\n")

    elif action == "3":
        while action != "0":
            menuClients()
            action = input('Elige una opcion: ')
            if action == "1":
                print(addClient())
            elif action == "2":
                print(upClient())
            elif action == "3":
                print(delClient())
            elif action == "4":
                print(getClient())
            elif action == "0":
                break
            else:
                print("\nERROR | Opcion Invalida\n")

    elif action == "4":
        while action != "0":
            menuInventory()
            action = input('Elige una opcion: ')
            if action == "1":
                getInventory()
            elif action == "2":
                getClients()
            elif action == "3":

                tableInvent = tabulate(products.values(), headers=["Code", "Name", "Date", "Price","Unit","Loc"], tablefmt = 'psql')
                tableClients = tabulate(clients.values(), headers=["Id", "Name", "Points"], tablefmt = 'psql')
                report = tabulate(reportInventory(), headers=["Description", "Value"], tablefmt = 'psql')
                soldProducts = tabulate(productsSold, headers=["Code", "Name", "Unit Sold"], tablefmt = 'psql')

                file = open("informe.txt",'w')
                file.write("\nTABLE OF PRODUCTS\n")
                file.write(tableInvent)
                file.write("\n\nTABLE OF CLIENTS\n")
                file.write(tableClients)
                file.write("\n\nGENERAL INFORMATION\n")
                file.write(report)
                file.write("\n\nINVENTORY SOLD\n")
                file.write(soldProducts)
                file.close()

                pdf = PDF()
                pdf.add_page()
                pdf.set_font('Courier','B',12)
                pdf.set_text_color(0, 0, 110)
                pdf.text(70,30,'Informe General de MerkEan')
                pdf.text(70,35, ' Fecha: '+str(now.day)+"/"+str(now.month)+"/"+str(now.year)+", "+str(now.hour)+":"+str(now.minute))
                pdf.texts('informe.txt')
                pdf.set_author('MerkEan Store')
                fechapdf = 'Informe'+str(now.day)+str(now.month)+str(now.year)+str(now.hour)+str(now.minute)
                pdf.alias_nb_pages()
                pdf.output(fechapdf+'.pdf', 'F')
                print("\n¡Se ha generado el Informe general con exito!\n")

            elif action == "0":
                break
            else:
                print("\nERROR | Opcion Invalida\n")

    elif action.upper() == "X":
        print("\n¡Gracias por usar nuestra App!\n")
    else:
        print("\nERROR | Opcion Invalida\n")

