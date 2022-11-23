
nombre = input("Ingresa tu nombre: ")
programa = input("IQ: Ingenieria Quimica\nIS: Ingenieria de Sistemas\nIE: Ingenieria en Energias\n¿A que programa pertenece?: ")
genero = input("¿Eres Hombre o Mujer?: ")

def conformarEquipos(programa,genero):
    if (programa == "IQ" or programa == "iq") and (genero == "Mujer" or genero == "mujer"):
        equipo = "usted pertenece a DRAGON TEAM"
    elif (programa == "IQ" or programa == "iq") and (genero == "Hombre" or genero == "hombre"):
        equipo = "usted pertenece a LION TEAM"
    elif (programa == "IS" or programa == "is") and (genero == "Mujer" or genero == "mujer"):
        equipo = "usted pertenece a PHOENIX TEAM"
    elif (programa == "IS" or programa == "is") and (genero == "Hombre" or genero == "hombre"):
        equipo = "usted pertenece a WOLF TEAM"
    elif (programa == "IE" or programa == "ie") and (genero == "Mujer" or genero == "mujer"):
        equipo = "usted pertenece a EAGLE TEAM"
    elif (programa == "IE" or programa == "ie") and (genero == "Hombre" or genero == "hombre"):
        equipo = "usted pertenece a TIGER TEAM"
    return equipo

print("\n"+nombre+", "+conformarEquipos(programa,genero)+"\n")
