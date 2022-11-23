
cantNumeros = int(input())
listaNumerosImp = []
listaNumerosPar = []

for i in range(cantNumeros):
    numero = int(input())

    if numero%2 == 1:
        listaNumerosImp.insert(i, numero)
        listaNumerosImp.sort()
    else:
        listaNumerosPar.insert(i, numero)
        listaNumerosPar.sort(reverse=True)

lista = listaNumerosImp+listaNumerosPar

for l in lista:
    print(l)

