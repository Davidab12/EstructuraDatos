

import numpy as np

numCal = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
calificaciones = [70, 48, 98, 59, 29, 62, 81, 90, 89,71, 59]
porcentajes = [10, 20, 5, 5, 5, 5, 10, 15, 5, 5, 15]
notasPorcentadas = []

arrayNumCal = np.array(numCal)
arrayCalicaciones = np.array(calificaciones)
arrayPorcentajes = np.array(porcentajes)


print("\nCalificaciones del estudiante:\n")
for i in range(len(arrayNumCal)):
    print("Calificacion numero "+str(arrayNumCal[i])+"     Nota: "+str(arrayCalicaciones[i])+"     Porcentaje: "+str(arrayPorcentajes[i])+"%")
    notasPorcentadas.append(arrayCalicaciones[i]*(arrayPorcentajes[i]/100))

print("\nPromediado del estudiante",np.sum(notasPorcentadas))

print("\nDimension NumCal:", arrayNumCal.ndim)
print("Dimension Cal:", arrayCalicaciones.ndim)






print("")


