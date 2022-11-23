'''
Defina un procedimiento que resuelva la ecuación cuadrática de la forma: ax2 + bx
+ c, dados por parámetro, los valores de los coeficientes a, b y c.
'''
valora = input("a=")
valorb = input("b=")
valorc = input("c=")

def resolverEcuacionCuadratica( a, b, c):
    a1 = int(a)
    b1 = int(b)
    c1 = int(c)

    dentroRaiz = (b1**2)-(4*a1*c1)
    denominador = (2*a1)

    if denominador == 0 or dentroRaiz < 0:
        print("No tiene solucion")
    else:
        x1 = (-b1+(dentroRaiz**0.5))/denominador
        x2 = (-b1-(dentroRaiz**0.5))/denominador
        if x1 == x2:
            print("Resultado Unico:\n X = "+str(x1))
        else:
            print("Resultados:\n X1 = "+str(round(x1,1)),'\n X2 = '+str(round(x2,1)))


resolverEcuacionCuadratica(valora,valorb,valorc)

