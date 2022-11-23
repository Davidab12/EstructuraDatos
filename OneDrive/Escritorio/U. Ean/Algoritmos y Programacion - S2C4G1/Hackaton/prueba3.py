veces = int(input())

for i in range(veces):
    numeros = input()
    numero = numeros.split(' ')
    a = int(numero[0])
    b = int(numero[1])
    c = int(numero[2])

    if (a+b) == c:
        print("Possible")

    elif ((b-a) or (a-b)) == c:
        print("Possible")

    elif (a*b) == c:
        print("Possible")

    elif ((b/a) or (a/b)) == c:
        print("Possible")

    elif (a-b) or (b-a) <0:
        print("Impossible")

    else:
        print("Impossible")

