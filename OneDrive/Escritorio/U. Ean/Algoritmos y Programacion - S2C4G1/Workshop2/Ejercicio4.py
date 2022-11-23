'''
Defina una función, que dados tres valores numéricos por parámetro, retorne el
menor de los tres.
'''

a = input("a:")
b = input("b:")
c = input("c:")

def retornarNumeroMenor(num1,num2,num3):
    num_a = float(num1)
    num_b = float(num2)
    num_c = float(num3)

    if num_a < num_b and num_a < num_c:
        numeroMinimo = num_a
    elif num_b < num_a and num_b < num_c:
        numeroMinimo = num_b
    elif num_c < num_a and num_c < num_b:
        numeroMinimo = num_c

    return numeroMinimo

print("Numero menor: "+str(retornarNumeroMenor(a,b,c)))

