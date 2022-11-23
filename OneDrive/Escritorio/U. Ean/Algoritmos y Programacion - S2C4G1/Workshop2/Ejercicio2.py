'''
Defina una función que dado un caracter, valide si es o no una vocal.
'''
voc = input("Ingresa un caracter: ")

def validarVocal(caracter):
    if (caracter == 'a' or
        caracter == 'e' or
        caracter == 'i' or
        caracter == 'o' or
        caracter == 'u'):
        validacion = "El caracter SI es una vocal"
    else:
        validacion = "El caracter NO es una vocal"
    return validacion

print(validarVocal(voc))

