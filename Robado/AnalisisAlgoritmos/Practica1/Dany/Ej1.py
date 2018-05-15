#  Instituto Plitecnico Nacional
#   Escuela Superior de Computo
#   Martinez Berumen Luis Daniel
#           3CV2
#   Analisis de Algoritmos
#

import random
A = []
B = []
C = []

def gen(Arr,tama):
    for i in range(tama):
        Arr.append(random.randint(0,1))
    Arr.reverse()
    return Arr

def suma(A, B):
    acarreo = 0
    sum=0
    contFor=0
    contIF=0
    for i in range(len(A)):
        contFor=contFor+1
        sum = A[i]+B[i]+ acarreo
        acarreo=0
        if i == len(A)-1:
            if sum == 1:
                C.append(1)
            if sum == 2:
                C.append(0)
                C.append(1)
            if sum == 3:
                C.append(1)
                C.append(1)
            if sum == 0:
                C.append(0)
            break
        if sum == 1:
            C.append(1)
        if sum == 2:
            C.append(0)
            acarreo = 1;
        if sum == 3:
            C.append(1)
            acarreo = 1
        if sum ==0:
            C.append(0)
        sum = 0
    C.reverse()
    print "Para un arreglo de ",len(A),"Entro: ",contFor, "veces"
tam=1
for i in range(20):
    A=[]
    B=[]
    C=[]
    #tam = input("Ingrese el tamagno de sus arreglos: ")
    A=gen(A,i)
    B=gen(B,i)
    suma(B, A)
    B.reverse()
    A.reverse()
    #print "A= ", A, "\nB= ", B
    #print "C= ", C