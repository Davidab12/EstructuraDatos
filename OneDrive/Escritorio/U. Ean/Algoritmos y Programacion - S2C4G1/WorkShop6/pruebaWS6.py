
import numpy as np
'''
lista = [1, 2, 4, 5, 7, 8]
array = np.array(lista)
print("lista a Array")
print("lista:",lista)
print("array:",array)
'''

array3D = np.random.random((3,3,2))
valMin = np.argmin(array3D)
print("array3D:\n",array3D)
print("\nindice del valor minimo:\n",valMin)


'''
print("\narray3D:\n",array3D)
print("\nDimension:",array3D.ndim)
print("Dimensiones de array:",array3D.shape)
print("Numero de elementos:",array3D.size)
print("Tipo de dato:",array3D.dtype)
'''