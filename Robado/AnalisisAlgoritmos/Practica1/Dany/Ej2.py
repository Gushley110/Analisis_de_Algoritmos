#  Instituto Plitecnico Nacional
#   Escuela Superior de Computo
#   Martinez Berumen Luis Daniel
#           3CV2
#   Analisis de Algoritmos
# graficar fibo para el peor de los casos
# vamos a tomar el mayor de los numeros....
cont = 0

def fib(n):
 a,b = 1,1
 for i in range(n-1):
  a,b = b,a+b
 return a


def mcd(m, n):
    r=1
    global cont
    while r != 0:
        cont =cont +1
        r = m % n
        m = n
        n = r
    return m

for i in range (79):
    #print "El mcd para: ",fib(i)," y ", fib(i+1)," es: ", mcd(fib(i), fib(i+1))
    mcd(fib(i), fib(i + 1))
    print "Para:[",fib(i),"] , [",fib(i + 1),"]El contador es: ",cont
    cont =0


