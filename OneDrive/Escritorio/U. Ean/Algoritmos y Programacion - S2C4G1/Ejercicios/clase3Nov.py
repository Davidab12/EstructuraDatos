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

