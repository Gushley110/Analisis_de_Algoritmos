package com.ipn.mx.algoritmos;

import java.util.Random;

/**
 *
 * @author EIEB
 */
public class FFT {

    private Complex A[];
    private Complex F[];

    public FFT(int n) {
        A = generateA(n);
    }

    public Complex[] getA() {
        return A;
    }

    public Complex[] getF() {
        return F;
    }

    public void setF(Complex[] F) {
        this.F = F;
    }
    
    public Complex[] generateA(int n) {
        Random r = new Random();
        Complex[] A = new Complex[n];
        for (int i = 0; i < n; i++) {
            A[i] = new Complex(r.nextDouble() * 100, 0);
        }
        return A;
    }

    public Complex[] fFT(Complex[] A) {
        int n = A.length;

        // base case
        if (n == 1) {
            return new Complex[]{A[0]};
        }

        // radix 2 Cooley-Tukey FFT
        if (n % 2 != 0) {
            throw new RuntimeException("n no es una potencia de dos");
        }

        // fft of even terms
        Complex[] even = new Complex[n / 2];
        for (int k = 0; k < n / 2; k++) {
            even[k] = A[2 * k];
        }
        Complex[] q = fFT(even);

        // fft of odd terms
        Complex[] odd = even;  // reuse the array
        for (int k = 0; k < n / 2; k++) {
            odd[k] = A[2 * k + 1];
        }
        Complex[] r = fFT(odd);

        // combine
        Complex[] y = new Complex[n];
        for (int k = 0; k < n / 2; k++) {
            double kth = -2 * k * Math.PI / n;
            Complex wk = new Complex(Math.cos(kth), Math.sin(kth));
            y[k] = q[k].plus(wk.times(r[k]));
            y[k + n / 2] = q[k].minus(wk.times(r[k]));
        }
        return y;
    }

    public void show(Complex[] x, String title) {
        System.out.println(title);
        System.out.println("-------------------");
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
        System.out.println();
    }
    
    public long calcularTiempo() {
        long inicio, fin, tiempo;
        inicio =  System.currentTimeMillis();
        fFT(A);
        fin = System.currentTimeMillis();
        tiempo = fin - inicio;
        System.out.println("Tiempo = " + tiempo + "ms");
        return tiempo;
    }

}
