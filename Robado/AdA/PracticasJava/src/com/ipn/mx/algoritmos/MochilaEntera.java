package com.ipn.mx.algoritmos;

import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EIEB
 */
public class MochilaEntera {

    private List<ObjetoMochila> P = new ArrayList<ObjetoMochila>();
    private int[][] M;
    private int n;
    private final int W = 100000;

    public MochilaEntera(int n) {
        this.n = n;
        M = new int[n][W+1];
        generarObjetos();
        System.out.println("P = " + P);
    }

    private void generarObjetos() {
        P.clear();
        for (int i = 0; i < n; i++) {
            P.add(ObjetoMochila.generarObjetoMochila());
        }
    }

    private void knapSack() {
        for (int w = 0; w <= W; w++) {
            M[0][w] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int w = 0; w < W; w++) {
                if (P.get(i).getW() > w) {
                    M[i][w] = M[i - 1][w];
                } else {
                    M[i][w] = max(M[i - 1][w], M[i - 1][w - P.get(i).getW()] + P.get(i).getV());
                }
            }
        }
    }
    
    public long medirTiempo() {
        long inicio, fin, tiempo;
        inicio =  System.currentTimeMillis();
        knapSack();
        fin = System.currentTimeMillis();
        tiempo = fin - inicio;
        System.out.println("Tiempo = " + tiempo + "ms");
        return tiempo;
    }

}
