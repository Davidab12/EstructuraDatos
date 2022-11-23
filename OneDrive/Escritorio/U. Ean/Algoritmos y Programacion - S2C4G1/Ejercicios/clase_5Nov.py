#AUTOR:ARIAS BERNAL DAVID GIOVANNY

#EJERCICIO DE EDAD - ADOLESCENTE


age = ""
while age != 0:
    age = int(input("Ingresa tu edad: "))
    if 15 <= age < 18:
        print("\nEs un adolescente\n")
    elif age < 0:
        print("\nEdad no valida\n")
    elif (age <15 and age>0) or age >= 18:
        print("\nNO es un adolescente\n")
print("Programa Finalizado")


#EJERCICIO CON LIMITE DE OPORTUNIDADES EN "NO ADOLESCENTE"


age = ""
oport = 0
while age != 0:
    age = int(input("Ingresa tu edad: "))
    if 15 <= age < 18:
        print("\nEs un adolescente\n")
    elif age < 0:
        print("\nEdad no valida\n")
    elif (age <15 and age>0) or age >= 18:
        print("\nNo es un adolescente\n")
        oport += 1
        if oport == 3:
            print("Lo sentimos, ha excedido los intentos")
            break
print("\nPrograma Finalizado\n")

