package com.ipn.mx.algoritmos;

import java.util.Random;

/**
 *
 * @author EIEB
 */
public class ObjetoMochila {

    private int w;
    private int v;
    private static Random r = new Random();

    public ObjetoMochila(int w, int v) {
        this.w = w;
        this.v = v;
    }
    
    public static ObjetoMochila generarObjetoMochila(){
        return new ObjetoMochila(r.nextInt(20)+1, r.nextInt(20)+1);
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "(" + w + ", " + v + ')';
    }

}
