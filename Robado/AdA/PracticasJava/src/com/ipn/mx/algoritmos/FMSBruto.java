package com.ipn.mx.algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author EIEB
 */
public class FMSBruto {

    private ArrayList<Integer> numeros;

    public FMSBruto() {
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

    public void fMS() {
        int mejor = numeros.get(0);
        int iniMejor = 0;
        int finMejor = 0;
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = i; j < numeros.size(); j++) {
                int suma = 0;
                for (int k = i; k <= j; k++) {
                    suma += numeros.get(k);
                }
                if (suma > mejor) {
                    mejor = suma;
                    iniMejor = i;
                    finMejor = j;
                }
            }
        }
        //System.out.println("Inicio = " + iniMejor + " Fin = " + finMejor + " Suma = " + mejor);
    }
    
    public long calcularTiempo() {
        long inicio, fin, tiempo;
        inicio =  System.currentTimeMillis();
        fMS();
        fin = System.currentTimeMillis();
        tiempo = fin - inicio;
        System.out.println("Tiempo = " + tiempo + "ms");
        return tiempo;
    }

}
