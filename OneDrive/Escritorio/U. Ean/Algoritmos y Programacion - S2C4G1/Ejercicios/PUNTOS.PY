"""
PROBLEMA HOSPITAL

"""



saturacion = int(input("Saturacion: "))
tension_s = int(input("Tension(S): "))
tension_d = int(input("Tension(D): "))
frec_cardiaca = int(input("Frecuencia Cardiaca: "))
sintomaRespiratorio = input("¿Tiene algun Sintoma respiratorio?(SI o NO): ")

def clasificarPaciente(saturacion,tension_s,tension_d,frec_cardiaca,sintomaRespiratorio):
    if saturacion <= 70 or tension_s < 180 or tension_d <120:
        clasificacion = "\nTriage: 1\nAtencion Inmediata\n"
    elif 75 < saturacion <89 or frec_cardiaca < 50:
        clasificacion = "\nTriage: 2\nAtencian de 1 a 2 horas\n"
    elif saturacion >= 90 and (sintomaRespiratorio=="SI") or tension_s <180 or tension_d <120:
        clasificacion = "\nTriage: 3\nAtencion de 2 a 4 horas\n"
    elif frec_cardiaca > 100 or (sintomaRespiratorio=="SI"):
        clasificacion = "\nTriage: 4\nAtencion de 4 a 6 horas\n"
    else:
        clasificacion = "\nTriage: 5\nNo es urgencia y debe solicitar cita medica\n"
    return clasificacion

print(clasificarPaciente(saturacion,tension_s,tension_d,frec_cardiaca,sintomaRespiratorio))




