

verdugos = int(input())
latigazos = input()
listaLat = []

for i in range(1):
    latigazo = latigazos.split(' ')
    listaLat += latigazo

minLat = min(listaLat)
menLat = listaLat.index(minLat)
print(menLat+1)