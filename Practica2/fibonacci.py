from matplotlib import pyplot
import numpy as np
import timeit
from functools import partial

def recursive_fibonacci(n):
    """Funcion que genera la secuencia de Fibonacci para un numero n de manera recursiva"""
    if n<0:
        return None
    elif n == 1 or n == 2:
        return 1
    else:
        return recursive_fibonacci(n-1)+recursive_fibonacci(n-2)

def iterative_fibonacci(n):
    """Funcion que genera la secuencia de Fibonacci para un numero n de manera iterativa"""
    array = [0]*n
    array[0] = 0
    array[1] = 1
    for x in range(2,n):
        array[x] = array[x-2]+array[x-1]
    return array[n-1]

def plotTC(fn, nMin, nMax, nInc, nTests):
    """
    Run timer and plot time complexity
    """
    x = []
    y = []
    for i in range(nMin, nMax, nInc):
        N = i
        testNTimer = timeit.Timer(partial(fn, N))
        t = testNTimer.timeit(number=nTests)
        x.append(i)
        y.append(t)
    p1 = pyplot.plot(x, y, 'o')
    #pyplot.legend([p1,], [fn.__name__, ])

def main():
    plotTC(recursive_fibonacci,2,40,1,1)
    plotTC(iterative_fibonacci,2,40,1,1)

    pyplot.show()

if __name__ == '__main__':
    main()