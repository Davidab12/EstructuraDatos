veces = int(input())

for i in range(veces):
    numero = int(input())
    result = [i  for i in range(1, numero+1) if numero%i == 0]
    suma = 0
    for i in result:
        suma += i
    if numero == 1:
        print(str(numero)+" no es casi perfecto")
    elif (suma - numero) == numero-1:
        print(str(numero)+" es casi perfecto")
    else:
        print(str(numero)+" no es casi perfecto")
