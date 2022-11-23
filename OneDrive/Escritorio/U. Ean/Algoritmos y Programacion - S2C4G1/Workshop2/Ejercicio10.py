'''
Dados dos números por parámetro, defina una función que:
    • si son iguales, retorne el producto de los dos
    • si el primero es mayor, retorne la diferencia de los dos.
    • si el segundo es mayor, la suma de los dos.
'''

num1 = int(input("Numero 1: "))
num2 = int(input("Numero 2: "))

def diferenciarNumeros(a,b):
    num1 = int(a)
    num2 = int(b)

    if num1 == num2:
        resultado = "El producto es: "+str(num1 * num2)
    elif num1 > num2:
        resultado = "La diferencia es: "+str(num1 - num2)
    elif num1 < num2:
        resultado = "La suma es: "+str(num1 + num2)
    return resultado

print(diferenciarNumeros(num1,num2))

