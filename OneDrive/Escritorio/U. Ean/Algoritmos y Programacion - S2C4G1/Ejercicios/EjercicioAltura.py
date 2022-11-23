#EJERCICIO PARA LA ALTURA DE UNA PERSONA

estatura = int(input("Ingresa tu estatura en centrimetros: "))

def estaturaPersona(num):
    if num <= 150 :
        clasificacion = print("\nEstatura Baja\n")
    if 150 < num <= 170 :
        clasificacion = print("\nEstatura Media\n")
    if num > 170 :
        clasificacion = print("\nEstatura Alta\n")
    return clasificacion

estaturaPersona(estatura)