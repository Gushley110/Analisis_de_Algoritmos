package com.ipn.mx.algoritmos;

import java.util.Random;

/**
 *
 * @author EIEB
 */
public class DFT {

    private Complex A[];
    private Complex F[];

    public DFT(int n) {
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
            A[i] = new Complex(r.nextDouble() * 10, r.nextDouble() * 10);
        }
        return A;
    }

    public Complex[] dFT(Complex[] A) {
        int n = A.length;

        // base case
        if (n == 1) {
            return new Complex[]{A[0]};
        }

        // radix 2 Cooley-Tukey FFT
        if (n % 2 != 0) {
            throw new RuntimeException("n no es una potencia de dos");
        }
        
        double phi = (2*Math.PI)/n;
        Complex wn = new Complex(Math.cos(phi), Math.sin(phi));
        Complex[] y = new Complex[n];
        for (int i = 0; i < n; i++) {
            y[i] = new Complex(0, 0);
        }
        for (int j = 0; j < n; j++) {
            Complex w = new Complex(1, 0);
            y[j] = new Complex(0, 0);
            for (int k = 0; k < n; k++) {
                y[j] = y[k].plus(A[k].times(w));
                w = w.times(wn);
            }
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
        inicio = System.currentTimeMillis();
        dFT(A);
        fin = System.currentTimeMillis();
        tiempo = fin - inicio;
        System.out.println("Tiempo = " + tiempo + "ms");
        return tiempo;
    }
}
