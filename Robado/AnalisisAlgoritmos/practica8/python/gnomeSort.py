'''
 	INSTITUTO POLITÉCNICO NACIONAL
 	  ESCUELA SUPERIOR DE CÓMPUTO
 		Análisis de Algoritmos
			GRUPO: 3CV2
	  Martinez Berumen Luis Daniel
 	Profesor: Benjamin Luna Benoso
'''

from random import randrange
def gnomesort(seq):
    i = 0
    while i < len(seq):
        if i == 0 or seq[i-1] <= seq[i]:
            i += 1
        else:
            seq[i], seq[i-1] = seq[i-1], seq[i]
            i -= 1

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


num=peor(10)
print "Antes", nums
gnomesort(nums)
print "Despues", nums