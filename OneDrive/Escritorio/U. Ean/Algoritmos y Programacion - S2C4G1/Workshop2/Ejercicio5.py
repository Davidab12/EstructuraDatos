'''
Defina una función, que dados tres valores numéricos por parámetro, retorne el
mayor de los tres.

'''

a = input("a:")
b = input("b:")
c = input("c:")

def retornarNumeroMayor(num1,num2,num3):
    num_a = float(num1)
    num_b = float(num2)
    num_c = float(num3)

    if num_a > num_b and num_a > num_c:
        numeroMayor = num_a
    elif num_b > num_a and num_b > num_c:
        numeroMayor = num_b
    elif num_c > num_a and num_c > num_b:
        numeroMayor = num_c

    return numeroMayor

print("Numero mayor: "+str(retornarNumeroMayor(a,b,c)))