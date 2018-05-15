package com.ipn.mx.algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FMS {

    private ArrayList<Integer> numeros;

    public FMS() {
        numeros = new ArrayList();
    }

    public List getNumeros() {
        return numeros;
    }

    public void llenarNumeros(int n) {
        Random rand = new Random();
        numeros.clear();
        for (int i = 0; i < n; i++) {
            if (rand.nextBoolean()) {
                numeros.add((int) (10 * rand.nextDouble()));
            } else {
                numeros.add((int) (-10 * rand.nextDouble()));
            }
        }
    }
    
    public void llenarNumeros2(int n) {
        Random rand = new Random();
        numeros.clear();
        for (int i = 0; i < n; i++) {
            numeros.add(5);
        }
    }

    public int[] findMaximumSubArray(int low, int high) {
        int res[] = new int[3];
        if (high == low) {
            res[0] = low;
            res[1] = high;
            res[2] = numeros.get(low);
            return res;
        } else {
            int mid = (low + high) / 2;
            int left[] = findMaximumSubArray(low, mid);
            int right[] = findMaximumSubArray(mid + 1, high);
            int cross[] = findMaxCrossingSubArray(low, mid, high);
            if (left[2] >= right[2] && left[2] >= cross[2]) {
                res[0] = left[0];
                res[1] = left[1];
                res[2] = left[2];
                return res;
            } else if (right[2] >= left[2] && right[2] >= cross[2]) {
                res[0] = right[0];
                res[1] = right[1];
                res[2] = right[2];
                return res;
            } else {
                res[0] = cross[0];
                res[1] = cross[1];
                res[2] = cross[2];
                return res;
            }
        }
    }

    private int[] findMaxCrossingSubArray(int low, int mid, int high) {
        int res[] = {0,0,0};
	int leftSum = -2000000000;
	int sum = 0;
	for(int i = mid; i >= low; i--) {
		sum += numeros.get(i);
		if(sum > leftSum) {
			leftSum = sum;
			res[0] = i;
		}
	}
	int rightSum = -2000000000;
	sum = 0;
	for(int j = mid+1; j <= high; j++) {
		sum += numeros.get(j);
		if(sum > rightSum) {
			rightSum = sum;
			res[1] = j;
		}
	}
	res[2] = leftSum + rightSum;
	return res;
    }
    
    public long calcularTiempo() {
        long inicio, fin, tiempo;
        inicio =  System.currentTimeMillis();
        int res[] = findMaximumSubArray(0, numeros.size() - 1);
        fin = System.currentTimeMillis();
        tiempo = fin - inicio;
        System.out.println("Tiempo = " + tiempo + "ms");
        return tiempo;
    }

}
