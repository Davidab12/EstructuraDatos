'''
Determinar si un alumno aprueba o reprueba un curso, sabiendo que aprobara si su
promedio de cinco calificaciones es mayor o igual a 60; reprueba en caso contrario.
'''
cal1 = input("cal1=")
cal2 = input("cal2=")
cal3 = input("cal3=")
cal4 = input("cal4=")
cal5 = input("cal5=")


def promediar5Calificaciones(cal1,cal2,cal3,cal4,cal5):
    cal_1 = float(cal1)
    cal_2 = float(cal2)
    cal_3 = float(cal3)
    cal_4 = float(cal4)
    cal_5 = float(cal5)
    promedio = (cal_1+cal_2+cal_3+cal_4+cal_5)/5

    if promedio >= 60:
        print("APROBADO")
    else:
        print("REPROBADO")


promediar5Calificaciones(cal1,cal2,cal3,cal4,cal5)

