"""
EJERCICIOS CON LA LIBRERIA NUMPY
@AUTOR: ARIAS BERNAL DAVID GIOVANNY

"""

import numpy as np

#FUNCIONES-----------------------------------

lista = [1, 2, 4, 5, 7, 8]
array = np.array(lista)
print("lista a Array")
print("lista:",lista)
print("array:",array)


array3D = np.random.random((3,3,2))
valMin = np.argmin(array3D)
valMax = np.argmax(array3D)
print("array3D:\n",array3D)
print("\nindice del valor minimo:\n",valMin)
print("\nindice del valor maximo:\n",valMax)


print("\narray3D:\n",array3D)
print("\nDimension:",array3D.ndim)
print("Dimensiones de array:",array3D.shape)
print("Numero de elementos:",array3D.size)
print("Tipo de dato:",array3D.dtype)

#ARRAYS UNIDIMENCIONALES 1D--------------------------------------

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


#ARRAYS BIDIMENCIONALES 2D--------------------------------------

def tiposAsientos(matriz):
    mBool1 = matriz == 0
    cant0 = np.sum(mBool1)
    mBool2 = matriz == 1
    cant1 = np.sum(mBool2)
    mBool3 = matriz == 2
    cant2 = np.sum(mBool3)

    return cant0 , cant1 , cant2


array_2d = np.random.randint(0,3,(4,11))
print(array_2d)

cant0, cant1, cant2 = tiposAsientos(array_2d)

print("\ncantidad 0:",cant0)
print("cantidad 1:",cant1)
print("cantidad 2:",cant2)

print("\nDimension array:", array_2d.ndim)

print("")

#ARRAYS MULTIDIMENCIONALES 3D--------------------------------------

from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt


figura = plt.figure()
ejes = Axes3D(figura)

def f(x,y):
    return 10-np.exp(-1*(x*x + 3*y*y))

limiteMinX = -1
limiteMinY = -1
limiteMaxY = 1
limiteMaxX = 1

x = np.linspace(limiteMinX,limiteMaxX,40)
y = np.linspace(limiteMinY,limiteMaxY,40)
x,y = np.meshgrid(x,y)
z = f(x,y)

ejes.plot_surface(x,y,z, cmap="twilight")

ejes.set_xlabel("X axis")
ejes.set_ylabel("Y axis")
ejes.set_zlabel("Z axis")

plt.show()

