'''
A un trabajador le pagan, según sus horas trabajadas, una tarifa de pago por hora.
Si la cantidad de horas trabajadas es mayor a 48 horas, la tarifa se incrementa en
un 50% para las horas extras. Defina un procedimiento que calcule el salario del
trabajador dadas las horas trabajadas y la tarifa.
'''

horasTrabajadas = int(input("Horas trabajadas: "))
tarifa = int(input("Tarifa: "))


def calcularSalario(horasTrabajadas, tarifa):
    if horasTrabajadas > 48:
        horasExtra = horasTrabajadas - 48
        incrementoTarifa = tarifa * 1.5
        incrementoAHorasExtra = horasExtra*incrementoTarifa
        salario = (48*tarifa) + (incrementoAHorasExtra)
        print("El salario del trabajador es: "+str(salario))
    else:
        salario = horasTrabajadas*tarifa
        print("El salario del trabajador es: "+str(salario))

calcularSalario(horasTrabajadas,tarifa)

