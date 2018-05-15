package com.ipn.mx.main;

import com.ipn.mx.algoritmos.Karatsuba;
import com.ipn.mx.grafica.Grafica;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author EIEB
 */
public class MainP06 {

    public static void main(String[] args) {
        ArrayList<Long> datos = new ArrayList();
        ArrayList<Integer> elementos = new ArrayList();
        Random r = new Random();
        BigInteger num1, num2;
        Karatsuba ka;
        int n, ant = 0;
        for (int i = 1000000; i <= 10000000; i += 1000000) {
            num1 = new BigInteger(i, r);
            num2 = new BigInteger(i, r);
            n = Math.max(num1.bitLength(), num2.bitLength());
            if (n > ant) {
                System.out.println("ant = " + ant + " n = " + n);
                ka = new Karatsuba( num1, num2);
                datos.add(ka.calcularTiempo());
                elementos.add(n);
                ant = n;
            } else {
                i--;
            }
        }
        Grafica graficaRecursiva = new Grafica("Karatsuba", "Karatsuba", datos, elementos);
        graficaRecursiva.pack();
        RefineryUtilities.centerFrameOnScreen(graficaRecursiva);
        graficaRecursiva.setVisible(true);
    }

}
