

import numpy as np


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