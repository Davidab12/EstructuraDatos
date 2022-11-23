#Calcule la siguiente productoria:
#Ecuacion = (k+((2**j)/j))

import math

n=3
suma = 0

for j in range(2,n+1):
    for k in range(1,j+1):
        suma += k+(math.pow(2,j)/j)
print("La doble sumatoria es:",suma)

