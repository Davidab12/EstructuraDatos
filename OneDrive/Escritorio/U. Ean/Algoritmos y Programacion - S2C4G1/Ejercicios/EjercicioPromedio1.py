

estudiante1 = "100,90,40,100"

def calcularPromedio(calEstudiante):
    calificaciones = calEstudiante.split(",")
    cal1 = int(calificaciones[0])
    cal2 = int(calificaciones[1])
    cal3 = int(calificaciones[2])
    cal4 = int(calificaciones[3])
    prom = float((cal1+cal2+cal3+cal4)/4)

    if prom >=90:
        print("\nExcelente academicamente\n")
    elif 80>=prom<90:
        print("\nBueno academicamente\n")
    elif 60>=prom<80:
        print("\nAceptable academicamente\n")
    elif prom<60:
        print("\nDeficiente academicamente\n")

calcularPromedio(estudiante1)

