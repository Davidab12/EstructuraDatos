'''
Defina una función que dado un número del 1 a 7 por parámetro retorne el nombre
del día de la semana, según corresponda.
'''
num = int(input("Numero: "))

def nombrarDiaDeLaSemana(numero):
    if numero == 1:
        dia = "Lunes"
    elif numero == 2:
        dia = "Martes"
    elif numero == 3:
        dia = "Miercoles"
    elif numero == 4:
        dia = "Jueves"
    elif numero == 5:
        dia = "Viernes"
    elif numero == 6:
        dia = "Sabado"
    elif numero == 7:
        dia = "Domingo"
    else:
	    dia='Ingrese un número entero válido de 1 a 7'
    return dia

print(nombrarDiaDeLaSemana(num))

