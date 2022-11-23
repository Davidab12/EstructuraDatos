#PRIMERO
def double_char(str):
    cont = 0
    salida = ""
    while cont < len(str):
        salida += str[cont]*2
        cont += 1
    return salida

#SEGUNDO
def count_hi(str):
    salida = 0
    cont = 0
    while cont < len(str):
        salida = str.count("hi")
        cont +=1
    return salida

#TERCERO

def cat_dog(str):
    numcat = 0
    numdog = 0
    cont = 0

    while cont < len(str):
        numcat = str.count("cat")
        numdog = str.count("dog")
        cont += 1

    if numcat == numdog:
        salida = True
    else:
        salida = False

    return salida

#CUARTO

def count_code(str):
    a=''
    count=0
    for char in ("abcdefghijklmnopqrstuvwxyz"):
        a=char
        count+=str.count("co"+a+"e")
    return count


def count_code(str):
    letras = ''
    salida = 0
    lista = str
    while "co" in lista:
        for caracter in ("abcdefghijklmnopqrstuvwxyz"):
            letras = caracter
            salida += str.count("co"+letras+"e")
        lista = lista.replace("co","")
    return salida

#print(count_code2("aaacodebbb"))

#QUINTO


def end_other(a, b):
    A = a.lower()
    B = b.lower()
    cont = 0
    while cont < (len(A) and len(B)):
        cont += 1
        if (A in B) or (B in A):
            compB = B.endswith(A)
            compA = A.endswith(B)
            if compA or compB == True:
                salida = True
            else:
                salida = False
        else:
            salida = False
    return salida


#print(end_other("ab","12ab"))


#SEXTO

def xyz_there(str):
    cont = 0
    salida = False
    while cont < len(str):
        compPuntoxyz = str.count('.xyz')
        compxyz = str.count('xyz')
        if compPuntoxyz != compxyz:
            salida = True
        cont +=1
    return salida

#SEPTIMO


def count_evens(nums):
    par = 0
    cont = 0
    while cont < len(nums):
        if nums[cont] % 2 == 0:
            par += 1
        cont += 1
    return par

#OCTAVO

def big_diff(nums):
    minNum = min(nums)
    mayNum = max(nums)

    diferencia = mayNum-minNum

    return diferencia


def big_diff(nums):
    cont = 0
    while cont < len(nums):
        minNum = min(nums)
        mayNum = max(nums)
        cont += 1
        diferencia = mayNum-minNum
    return diferencia


#NOVENO

def centered_average(nums):
    nums.remove(nums[nums.index(max(nums))])
    nums.remove(nums[nums.index(min(nums))])
    cont = 0
    suma = 0

    while cont < len(nums):
        suma += nums[cont]
        promedio = suma//len(nums)
        cont += 1
    return promedio

#print(centered_average(nums))

#DECIMO

def sum13(nums):
    suma = 0
    cont = 0
    while cont < len(nums):
        if nums[cont] == 13:
            cont += 2
        else:
            suma += nums[cont]
            cont += 1
    return suma


#ONCE

def sum67(nums):
    suma = 0
    cont = 0
    while cont < len(nums):
        if nums[cont] == 6:
            while nums[cont] != 7:
                cont += 1
            cont += 1
        if cont < len(nums) and nums[cont] != 6:
                suma += nums[cont]
                cont += 1
    return suma


#DOCE


def has22(nums):
    conf = False

    if len(nums) < 1:
        conf = False
    elif len(nums) > 1:
        n= 0
        for i in nums:
            An = n
            n = i
            if An == n:
                if An == 2:
                    conf = True
    return conf

#print(has22([2,1,1]))