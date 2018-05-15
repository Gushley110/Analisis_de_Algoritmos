def max_crossing_subarray(array,low,mid,high):
	left = -10000
	right = -10000
	sum = 0

	for i in range(mid,low-1,-1):
		sum += array[i]
		print("Left:",array[i])

		if (sum > left):
			left = sum
			max_left = i

	sum = 0


	for j in range(mid+1,high):
		sum += array[j]
		print("Right:",array[j])

		if (sum > right):
			right = sum
			max_right = j

	return [max_left,max_right,left+right]

def main():
	array = [2, 3, 4, 5, 7]
	low = 0
	high = len(array)
	mid = (low + high) // 2
	print(max_crossing_subarray(array,low,mid,high))


if __name__ == '__main__':
    main()