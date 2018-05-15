'''
 	INSTITUTO POLITÉCNICO NACIONAL
 	  ESCUELA SUPERIOR DE CÓMPUTO
 		Análisis de Algoritmos
			GRUPO: 3CV2
	  Martinez Berumen Luis Daniel
 	Profesor: Benjamin Luna Benoso
'''

def cocktailSort(a):
    n = len(a)
    swapped = True
    start = 0
    end = n - 1
    while (swapped == True):
        swapped = False
        for i in range(start, end):
            if (a[i] > a[i + 1]):
                a[i], a[i + 1] = a[i + 1], a[i]
                swapped = True
        if (swapped == False):
            break
        swapped = False
        end = end - 1
        for i in range(end - 1, start - 1, -1):
            if (a[i] > a[i + 1]):
                a[i], a[i + 1] = a[i + 1], a[i]
                swapped = True
        start = start + 1

def peor(tam):
    A=[]
    for i in range(tam):
        A.append(tam)
        tam=tam-1
    return A

def Mejor(largo):
    A=[]
    for i in xrange(largo):
        A.append(i)
    return A

a = [5, 1, 4, 2, 8, 0, 2]
print "Antes", a
cocktailSort(a)
print "Despues", a