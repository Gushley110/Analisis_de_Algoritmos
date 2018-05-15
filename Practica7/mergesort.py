def merge(array, p, q, r):
	
	n1 = q - p + 1
	n2 = r - q

	L = [array[p + i - 1] for i in range(1,n1)]
    R = [array[q + j] for j in range(1,n2)]

    L[n1 + 1] = float('inf')
    R[n2 + 1] = float('inf')
    i = 1
    j = 1
    k = p

    for k in range(r):
    	if( L[i] <= R[j]):
    		array[k] = L[i]
    		i += 1
    	else:
    		array[k] = R[j]
    		j += 1

    return array

def mergesort(array,p,r):
	if p < r:
		q = 


def main():

	u_array = [3,2,6,8,9,1,5,4,7]

if __name__ == '__main__':
    main()