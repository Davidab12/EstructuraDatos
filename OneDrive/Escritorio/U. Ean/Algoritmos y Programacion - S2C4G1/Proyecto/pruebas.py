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
#----------------DICCIONARIO DE LOS PRODUCTOS--------------------
#llave(codigo) : [code, nombre , fecha de vencimiento, precio , unidades, estanteria]

products = {
        int(1): [str("1"), str('Naranjas'),  date(2021, 12, 16), float(7000.0), int(35), str('A1')],\
        int(2): [str("2"), str('Limones'),   date(2021, 12, 1),  float(2500.0), int(7),  str('C1')],\
        int(3): [str("3"), str('Peras'),     date(2022, 1, 15),  float(2700.0), int(65), str('B1')],\
        int(4): [str("4"), str('Arandanos'), date(2021, 12, 12), float(9300.0), int(34), str('A1')],\
        int(5): [str("5"), str('Tomates'),   date(2021, 12, 2),  float(2100.0), int(42), str('A2')],\
        int(6): [str("6"), str('Fresas'),    date(2021, 12, 27), float(9100.0), int(20), str('B1')],\
        int(7): [str("7"), str('Helado'),    date(2022, 1, 5),   float(4500.0), int(41), str('A3')],\
        int(8): [str("8"), str('Galletas'),  date(2022, 1, 23),  float(500.0),  int(8),  str('C2')],\
        int(9): [str("9"), str('Chocolates'),date(2021, 12, 21), float(4500.0), int(7),  str('B2')],\
        int(10):[str("10"),str('Jamon'),     date(2021, 12, 7),  float(17000.0),int(48), str('C1')],\
        }

#------------------DICCIONARIO DE LOS CLIENTES--------------------
#llave(id) : [id, nombre, puntos]

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







                                    file = open("factura.txt",'w')
                                    file.write("\nTABLE OF BUYED PRODUCTS\n")
                                    file.write(tableBuy)
                                    file.write("\n\nTABLE TO PAY\n")
                                    file.write(tableFinal)
                                    file.write("\n\nPuntos actuales: "+str(clients[idClient][2]))
                                    file.close()