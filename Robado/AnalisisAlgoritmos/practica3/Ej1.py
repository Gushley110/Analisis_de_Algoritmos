import random
cMSort = 0
cMerge = 0
def merge(numbers):
    n = len(numbers)
    global cMerge
    cMerge = cMerge+1
    if (n == 1):
        return numbers
    izq = merge(numbers[:(n / 2)])
    der = merge(numbers[(n / 2):])
    cMerge = cMerge - 1
    return mergeSort(izq, der)

def mergeSort(izq, der):
    result = []
    i = 0
    j = 0
    len_izq = len(izq)
    len_der = len(der)
    global cMSort
    while (i < len_izq or j < len_der):
        cMSort = cMSort + 1
        if (i >= len_izq):
            result.append(der[j])
            j = j + 1
        elif (j >= len_der):
            result.append(izq[i])
            i = i + 1
        elif (izq[i] < der[j]):
            result.append(izq[i])
            i = i + 1
        else:
            result.append(der[j])
            j = j + 1

    return result


def test(actual):
    global cMSort
    global cMerge
    sort = merge(actual)
    #print "\nLen :", len(actual)
    #print actual, "Se ordeno como:", sort
    #print cMSort
    print cMerge
    cMSort =  0
    cMerge = 0

def chk(arreglo, numero):
    if numero in arreglo:
        return False
    else:
        return True

A = [ ]
pruebas = 100
rango = 100
A.append(1)
for j in range (pruebas):
    #print j+1
    for i in range(j):
        #num = i+2
        num = random.randint(1, rango)
        while not chk(A,num):
            num = random.randint(1, rango)
        A.append(num)
    test(A)
    A = [1]