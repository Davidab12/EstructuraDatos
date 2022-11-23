"""


"""

ingreso = 0
personas = int(input("Numero de personas: "))
contador = 0
if personas <= 8:
    while contador < personas:
        contador += 1
        edad = int(input("Edad de persona "+str(contador)+": "))
        estatura = float(input("Estatura: "))
        peso = int(input("peso de persona "+str(contador)+": "))
        mEmb = input("¿Es una mujer embarazada? (SI / NO): ")
        minutos = int(input("Minutos en la pista (5,10 o 15): "))
        if ((edad > 14) and (1.5 < estatura < 1.9) and (peso <= 95) and (mEmb.upper() == "NO")):
            listaBuy = []
            if minutos == 5:
                ingreso += 20000

            elif minutos == 10:
                ingreso += 35000

            elif minutos == 15:
                if personas <4 or personas >8:
                    print("Deben haber minimo 4 personas y maximo 8 personas")
                    break
                ingreso += 50000
        else:
            print("Usuario no apto")
else:
    print("El maximo de usuarios es de 8")

print("El ingreso fue de : $"+str(ingreso))