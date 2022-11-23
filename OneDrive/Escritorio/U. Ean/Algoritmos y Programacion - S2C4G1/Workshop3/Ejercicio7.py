#Calcule la siguiente productoria:
#Ecuacon = (raizde(2*k+3)/raizde(2k+5))

import math

sumaProducto = 1
for k in range(39,500+1):
    sumaProducto *= (math.sqrt(2*k+3)/math.sqrt(2*k+5))

print("La productoria es aproximadamente:",round(sumaProducto,2))

