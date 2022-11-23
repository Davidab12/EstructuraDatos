'''
Defina una función que, dado un tiempo en segundos, calcule los segundos restantes
que le corresponden para convertirse exactamente en minutos.
'''
segundos = input("segundos:")


def calcularSegundosFaltantes(segundos):
    seg = int(segundos)
    minutos = seg/60
    minutosStr = str(minutos)
    separacionNumeros = minutosStr.split(".")
    minutosEnDec = int(separacionNumeros[0])
    minutosALlegar = minutosEnDec+1
    diferenciaMin = minutosALlegar-minutos
    diferenciaSeg = diferenciaMin*60

    if diferenciaSeg == 60:
        diferenciaSeg=0
        segFaltantes = "Estan los "+str(round(seg))+" segundos exactos para "+str(minutosALlegar-1)+" minuto(s)"
    else:
        segFaltantes = "Faltan "+str(round(diferenciaSeg))+" segundos para llegar a "+str(minutosALlegar)+" minuto(s)"
    return segFaltantes


print(calcularSegundosFaltantes(segundos))

