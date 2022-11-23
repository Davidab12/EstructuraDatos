

from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt
import numpy as np


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




