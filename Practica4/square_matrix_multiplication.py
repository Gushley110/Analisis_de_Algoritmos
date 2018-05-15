def matrix_multiplication(a,b):
	c = list()
	if(len(a[0]) == 1 and len(b[0]) == 1):
		c[0][0] = a[0][0] * b[0][0]
	return c

def main():
	#a = [[1,2],[3,4]]
	#b = [[5,6],[7,8]]

	a = [[1]]
	b = [[2]]

	matrix_multiplication(a,b)

if __name__ == '__main__':
    main()