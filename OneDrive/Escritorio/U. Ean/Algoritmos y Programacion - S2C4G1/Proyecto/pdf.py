
from fpdf import FPDF

class PDF(FPDF):
    pass

    def logo(self, name, x, y, w, h):
        self.image(name, x, y, w, h)

    def texts(self, name):
        with open(name, 'rb') as xy:
            txt = xy.read().decode('latin-1')
        self.set_xy(10.0, 80.0)
        self.set_text_color(0, 0, 0)
        self.set_font('Courier', '',12)
        self.multi_cell(0, 10, txt)

    def titles(self, title):
        self.set_xy(0.0, 45)
        self.set_text_color(0, 0, 110)
        self.set_font('Courier', 'B',16)
        self.cell(w = 210.0, h = 40.0, align = 'C', txt = title, border = 0)


file = open("prueba.txt",'w')
file.write('ji')

file.close()
from datetime import date, datetime
now = datetime.now()


pdf = PDF()
pdf.add_page()
pdf.titles('Factura de Cliente, Fecha: '+str(now.day)+"/"+str(now.month)+"/"+str(now.year)+", "+str(now.hour)+":"+str(now.minute))
pdf.logo('logoMarkean.jpeg', 70, 1, 68, 60)
pdf.texts('prueba.txt')
pdf.logo('qr.png', 70, 240, 68, 30)
pdf.set_author('MarkEan Store')
pdf.cell(40, 10, 'Qr factura MarkEan')
pdf.output('Factura.pdf', 'F')


pdf = PDF()
pdf.add_page()
pdf.titles('Informe de tienda MarkEan, Fecha: '+str(now.day)+"/"+str(now.month)+"/"+str(now.year)+", "+str(now.hour)+":"+str(now.minute))
pdf.logo('logoMarkean.jpeg', 70, 1, 68, 60)
pdf.texts('prueba.txt')
pdf.logo('qr.png', 70, 240, 68, 30)
pdf.set_author('MarkEan Store')
pdf.output('Informe.pdf', 'F')


