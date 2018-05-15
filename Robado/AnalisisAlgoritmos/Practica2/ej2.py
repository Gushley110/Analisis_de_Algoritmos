contIte = 0
contRec = 0

def sumaRec(n):
    global contRec
    contRec = contRec+1
    if n==1:
        return 1
    else:
        return sumaRec(n-1)+n*n*n
def sumaIte(n):
    global contIte
    a=0
    b=n
    if n == 1:
        contIte = contIte + 1
        a+=1
    else:
       for i in range(n):
           contIte = contIte + 1
           a+=n*n*n
           n=n-1
    return a

for i in range(50):
    sumaIte(i+1)
    sumaRec(i+1)
    print " para",i+1,"  ContRec=", contRec, "contIte =", contIte
    #print contIte
    #print contRec
    #print "........."
    contIte=0
    contRec=0