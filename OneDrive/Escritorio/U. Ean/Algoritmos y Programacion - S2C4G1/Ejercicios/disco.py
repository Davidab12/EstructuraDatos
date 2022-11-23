"""
Una disco requiere un control del acceso al sitio para indicarle
al cliente el valor de la cover y el valor que tendra el licor del
establecimiento, dependiendo el dia y el sexo del cliente cumpliendo
las siguientes reglas de ingreso:
    lunes-martes-miercoles: mujer-no cover, hombre-no cover
    lunes-martes: mujer-licor 80%, hombre-licor 80%
    jueves-domingo: mujer-barraLibre, hombre-cover 50%
    viernes-sabado: mujer-cover 100%, hombre-cover 100%

    loop: realizar la simulacion para 10 personas que ingresan
    a la disco (utilizar for y break), y calcular el dinero recolectado
    en el cover(valor persona: 20000)
"""

import random


cover = 20000
licor = 10000
dias = ["Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"]
generoPer = ["Mujer","Hombre"]
recoleccionCover = 0

for i in range(1,10+1):
    dia = random.choice(dias)
    genero = random.choice(generoPer)
    #print(dia,genero)

    if dia == "Lunes" or dia == "Martes" or dia == "Miercoles":
        if genero == "Mujer" or genero == "Hombre":
            recoleccionCover += 0
        elif dia == "Lunes" or dia == "Martes":
            valorLicor = licor*0.8
    elif dia == "Jueves" or dia == "Domingo":
        if genero == "Mujer":
            recoleccionCover += cover
            valorLicor = 0
        elif genero == "Hombre":
            recoleccionCover += cover*0.5
    elif dia == "Viernes" or dia == "Sabado":
        if genero == "Mujer" or genero == "Hombre":
            recoleccionCover += cover
    #print(recoleccionCover)

print("\nEl valor recolectado en el cover fue de",float(recoleccionCover),"\n")
