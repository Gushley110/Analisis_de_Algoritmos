import random
contQuickS =0
contPart=0
def quickSort(arreglo,primero,ultimo):
   global contQuickS
   contQuickS = contQuickS+1
   if primero<ultimo:
       mitad = partition(arreglo,primero,ultimo)
       quickSort(arreglo,primero,mitad-1)
       quickSort(arreglo,mitad+1,ultimo)
       contQuickS = contQuickS -1


def partition(arreglo,primero,ultimo):
    global contPart
    pivote = arreglo[primero]
    izq = primero+1
    der = ultimo
    edo = False
    while not edo:
       contPart = contPart + 1
       while izq <= der and arreglo[izq] <= pivote:
           izq = izq + 1
       while arreglo[der] >= pivote and der >= izq:
           der = der -1
       if der < izq:
           edo = True
       else:
           temp = arreglo[izq]
           arreglo[izq] = arreglo[der]
           arreglo[der] = temp
    temp = arreglo[primero]
    arreglo[primero] = arreglo[der]
    arreglo[der] = temp
    return der

def chk(arreglo, numero):
    if numero in arreglo:
        return False
    else:
        return True

def llenadoDesc(n,arr):
    for i in range(n):
        arr.append(i)
    arr.reverse()
    return arr

def llenadoRandom(arr,rango):
    for i in range(rango):
        num = random.randint(1, rango)
        while not chk(arr,num):
            num = random.randint(1, rango)
        arr.append(num)
    return arr

def llenadoUnos(arr,n):
    for i in range(n):
        arr.append(1)
    return arr

arreglo = []
pruebas = 50
for j in range (pruebas):
    #arreglo = llenadoRandom(arreglo,j+1)
    #arreglo = llenadoDesc(j+1, arreglo)
    arreglo = llenadoUnos(arreglo,j+1)
    #print "Antes de ordenar:\n",arreglo
    quickSort(arreglo,0, len(arreglo)-1)
    print "Despues de ordenar\n",arreglo
    print "Pasos de QuickSort:",contQuickS
    print "Pasos de Partition:",contPart,'\n'
    arreglo = []
    contQuickS=0
    contPart=0