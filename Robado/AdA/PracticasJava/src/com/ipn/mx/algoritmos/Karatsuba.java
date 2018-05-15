package com.ipn.mx.algoritmos;

import java.math.BigInteger;

/**
 *
 * @author EIEB
 */
public class Karatsuba {

    private BigInteger num1;
    private BigInteger num2;
    private BigInteger multi;

    public Karatsuba(BigInteger num1, BigInteger num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public BigInteger multiplicacionKaratsuba(BigInteger x, BigInteger y) {

        // cutoff to brute force
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) {
            return x.multiply(y);
        }

        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // x = a + 2^N b,   y = c + 2^N d
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac = multiplicacionKaratsuba(a, c);
        BigInteger bd = multiplicacionKaratsuba(b, d);
        BigInteger abcd = multiplicacionKaratsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
    }

    public long calcularTiempo() {
        long inicio, fin, tiempo;
        inicio = System.currentTimeMillis();
        multi = multiplicacionKaratsuba(num1, num2);
        fin = System.currentTimeMillis();
        tiempo = fin - inicio;
        System.out.println("Tiempo = " + tiempo + "ms");
        return tiempo;
    }
}
