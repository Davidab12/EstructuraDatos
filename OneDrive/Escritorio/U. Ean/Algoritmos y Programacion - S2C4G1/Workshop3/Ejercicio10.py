#Calcule la siguiente productoria:
#Ecuacion = 3[2i+(-1**i)*j]

import math

sumatoria=0
productoria = 1
for i in range(4,5+1):
    productoria *= 3*(2*i+math.pow(-1,i))
    #print("productoria",productoria)
    for j in range(3,7+1):
        sumatoria+= productoria * j
        #print("sumatoria",sumatoria)

print("la sumatoria de la productoria es:",sumatoria)

