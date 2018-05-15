package com.ipn.mx.algoritmos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author EIEB
 */
public class HireAssistant {

    private int n, best;
    private ArrayList<Integer> s;
    private ArrayList<Integer> p;

    public HireAssistant(int n) {
        this.n = n;
        s = new ArrayList<>(n);
        p = new ArrayList<>(n);
        permuteBySorting();
    }
    
    private int hireAssistantAlgorithm() {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s.get(i) > res) {
                res = s.get(i);
                if (res == n) {
                    break;
                }
            }
        }
        return res;
    }

    private void permuteBySorting() {
        if (!s.isEmpty()) {
            s.clear();
            p.clear();
        }
        for (int i = 1; i <= n; i++) {
            s.add(i);
            p.add(random());
        }
        sortSUsingP();
    }

    private void sortSUsingP() {
        ArrayList<Integer> c = new ArrayList<>(p);
        c.sort(null);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (c.get(i).compareTo(p.get(j)) == 0) {
                    s.set(i,j+1);
                    break;
                }
            }
        }

    }

    private int random() {
        Random r = new Random();
        return (r.nextInt((int) Math.pow(n, 3)));
    }
    
    public long calcularTiempo() {
        long inicio, fin, tiempo;
        inicio =  System.currentTimeMillis();
        best = hireAssistantAlgorithm();
        fin = System.currentTimeMillis();
        tiempo = fin - inicio;
        System.out.println("Tiempo = " + tiempo + "ms");
        return tiempo;
    }

}
