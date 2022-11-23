#La suma de todos los números impares desde 1 hasta 100
#Ecuacio = (2i-1)


sumaImp = 0

for i in range(1,100+1):
    if i % 2 == 1:
        sumaImp += (2*i-1)

print("La sumatoria es:",sumaImp)

