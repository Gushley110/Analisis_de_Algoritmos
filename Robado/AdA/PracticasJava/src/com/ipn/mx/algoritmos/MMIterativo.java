package com.ipn.mx.algoritmos;

import java.util.Random;

/**
 *
 * @author EIEB
 */
public class MMIterativo {

    private int A[][];
    private int B[][];
    private int C[][];

    public MMIterativo(int tam) {
        A = new int[tam][tam];
        B = new int[tam][tam];
        C = new int[tam][tam];
        llenarMatriz(A);
        llenarMatriz(B);
    }

    public void llenarMatriz(int matriz[][]) {
        Random rnd = new Random();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (rnd.nextBoolean()) {
                    matriz[i][j] = (int) (-10 * rnd.nextDouble());
                } else {
                    matriz[i][j] = (int) (10 * rnd.nextDouble());
                }
            }
        }
    }

    public void multiplicar() {
        int aux = 0;
        for (int i = 0; i < A.length; i++) {
            int suma = 0;
            for (int j = 0; j < A.length; j++) {
                suma += (A[i][j] * B[j][aux]);
            }
            C[i][aux++] = suma;
            if (aux < A.length) {
                i--;
            } else {
                aux = 0;
            }
        }
    }

    public long medirTiempo() {
        long inicio, fin, tiempo;
        inicio =  System.currentTimeMillis();
        multiplicar();
        fin = System.currentTimeMillis();
        tiempo = fin - inicio;
        System.out.println("Tiempo = " + tiempo + "ms");
        return tiempo;
    }

}
