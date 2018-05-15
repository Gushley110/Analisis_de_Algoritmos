'''
 	INSTITUTO POLITÉCNICO NACIONAL
 	  ESCUELA SUPERIOR DE CÓMPUTO
 		Análisis de Algoritmos
			GRUPO: 3CV2
	  Martinez Berumen Luis Daniel
 	Profesor: Benjamin Luna Benoso
'''

def insertionsort(A):
    for j in range(1,len(A)):
        key = A[j]
        i = j-1
        while (i > -1) and key < A[i]:
            A[i+1]=A[i]
            i=i-1
        A[i+1] = key
    return A
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

for i in xrange(10):
    pasos=0
    x=Mejor(i)
    print "Antes", x
    insertionsort(x)
    print "Despues", x
    print " "