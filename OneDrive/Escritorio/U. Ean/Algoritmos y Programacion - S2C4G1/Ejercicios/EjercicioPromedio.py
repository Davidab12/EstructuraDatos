cal1 = int(100)
cal2 = int(100)
cal3 = int(80)
cal4 = int(90)


def calcularPromedio(cal1,cal2,cal3,cal4):
    prom = float((cal1+cal2+cal3+cal4)/4)

    if prom >=90:
        clasificacion = "\nExcelente academicamente\n"
    elif 80>=prom<90:
        clasificacion = "\nBueno academicamente\n"
    elif 60>=prom<80:
        clasificacion = "\nAceptable academicamente\n"
    elif prom<60:
        clasificacion = "\nDeficiente academicamente\n"
    return clasificacion

print(calcularPromedio(cal1,cal2,cal3,cal4))


