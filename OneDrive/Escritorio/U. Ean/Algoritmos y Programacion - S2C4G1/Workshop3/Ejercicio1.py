#La suma de todos los números pares desde 1 hasta 100
#Ecuacion = 2i


sumaPar = 0

for i in range(1,100+1):
    if i % 2 == 0:
        sumaPar += 2*i

print("La sumatoria es:",sumaPar)

