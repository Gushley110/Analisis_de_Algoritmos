#  Instituto Plitecnico Nacional
#   Escuela Superior de Computo
#   Martinez Berumen Luis Daniel
#           3CV2
#   Analisis de Algoritmos
#       Practica 2

cont1 = 0
cont2 = 0

def fiboIteracion(n):
    global cont1
    a =1
    b = 1
    for i in range(n-1):
        cont1 = cont1+1
        a = b
        b = a + b
    return a

def fiboRecu(n):
    global cont2
    cont2 = cont2 + 1
    if n== 1 or n==2:
        return 1
    return fiboRecu(n-1) + fiboRecu(n-2)

for i in range(20):
    n = i+1
    fiboRecu(n)
    fiboIteracion(n)
    #print "No ", i+1
    #print "Para",i," Fibo ite entra:", cont1
    #print cont1
    #print "Para", i, "Fibo rec ", cont2
    print cont2
    #print "..................."
    cont1, cont2 = 0,0
