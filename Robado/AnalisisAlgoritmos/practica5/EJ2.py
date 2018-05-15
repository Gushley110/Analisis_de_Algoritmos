import random
n=200
for a in range(n):
	a=a+1
	filas1,columnas1 = a,a
	filas2,columnas2 = a,a
	count =0
	if (columnas1==filas2):

		matriz1 = []
		for i in range(filas1):
			matriz1.append( [0] * columnas1 )

		matriz2 = []
		for i in range(filas2):
			matriz2.append( [0] * columnas2 )

		for i in range(filas1):
			for j in range(columnas1):
				matriz1[i][j] = random.randint(0,10)
		for i in range(filas2):
			for j in range(columnas2):
				matriz2[i][j] = random.randint(0,10)
		#print 'Sus matrices son:'
		#print 'A=', matriz1
		#print 'B=', matriz2
		matriz3 = []
		for i in range(filas1):
			matriz3.append( [0] * columnas2 )
		for i in range(filas1):
			for j in range(columnas2):
				for k in range(filas2):
					count = count +1
					matriz3[i][j] += matriz1[i][k] * matriz2[k][j]
		#print ('Su matriz resultante es')
		#print 'C=',matriz3
		print 'Para',a,'veces=',count
		count =0
	else:
		print ('Debe ser mxn * nxp')