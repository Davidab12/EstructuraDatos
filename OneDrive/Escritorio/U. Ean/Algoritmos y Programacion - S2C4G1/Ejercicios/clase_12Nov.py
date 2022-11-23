import numpy as np
#------- MATRICES CON LISTAS --------------
matriz = [ [1,2] , [3,4] , [5,6] ]
print("\n MATRIZ: \n",matriz)
filas = 3
columnas = 2
print("\n")
for f in range(filas):
    for c in range(columnas):
        print(matriz[f][c],end=" ")
    print("")

#------- MATRICES CON NUMPY --------------
#----- array 1D -----
vector = np.array([1,2,3])
print("\n vector: \n",vector)
#----- array 2D -----
print("\n matriz 2D:")
mat2D = np.array([[1,2,3],[4,5,6],[7,8,9]])
print(mat2D)