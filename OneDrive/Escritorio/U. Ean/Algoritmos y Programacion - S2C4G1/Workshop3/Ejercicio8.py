#Calcule la siguiente productoria:
#Ecuacion = a*k


sumaProducto = 1
a = "a"
for k in range(10,38+1):
    sumaProducto *= k
    resultado = a+str(sumaProducto)

print("La productoria es:",resultado)

