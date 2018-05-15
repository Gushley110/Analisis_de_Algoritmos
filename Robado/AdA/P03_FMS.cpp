# include <stdio.h>
# include <vector>
# define matriz vector<int>

using namespace std;

matriz findMaxCrossingSubArray(matriz &A, int low, int mid, int high) {
	matriz res(3,0);
	int leftSum = -2000000000;
	int sum = 0;
	for(int i = mid; i >= low; i--) {
		sum += A[i];
		if(sum > leftSum) {
			leftSum = sum;
			res[0] = i;
		}
	}
	int rightSum = -2000000000;
	sum = 0;
	for(int j = mid+1; j <= high; j++) {
		sum += A[j];
		if(sum > rightSum) {
			rightSum = sum;
			res[1] = j;
		}
	}
	res[2] = leftSum + rightSum;
	return res;
}

matriz findMaximumSubArray(matriz &A, int low, int high) {
	matriz res;
	if( high == low) {
		res.push_back(low);
		res.push_back(high);
		res.push_back(A[low]);
		return res;
	} else {
		int mid = (low + high)/2;
		matriz left(findMaximumSubArray(A, low, mid));
		matriz right(findMaximumSubArray(A, mid+1, high));
		matriz cross(findMaxCrossingSubArray(A, low, mid, high));
		if(left[2] >= right[2] && left[2] >= cross[2]) {
			res.push_back(left[0]);
			res.push_back(left[1]);
			res.push_back(left[2]);
			return res;
		} else {
			if(right[2] >= left[2] && right[2] >= cross[2]) {
				res.push_back(right[0]);
				res.push_back(right[1]);
				res.push_back(right[2]);
				return res;
			} else {
				res.push_back(cross[0]);
				res.push_back(cross[1]);
				res.push_back(cross[2]);
				return res;
			}
		}
	}
}

int main() {
	matriz A;
	matriz final(findMaximumSubArray(A, 0, A.size()-1));
	printf("{");
	for(int i = final[0]; i <= final[1]; i++) {
		printf("%d, ", A[i]);
	}
	printf("\b\b} = %d\n", final[2]);
	return 0;
}
