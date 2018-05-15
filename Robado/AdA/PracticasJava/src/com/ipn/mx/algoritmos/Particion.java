/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.algoritmos;

/**
 *
 * @author César
 */
public class Particion {
    
    private int cifras[];
    private int N;
    private int j;
    private int meta;
    private int elegidos[];
    
    public Particion(int arreglo[], int suma){
        
    }
    
    public boolean Partir(int cifras[], int j, int N, int meta, int elegidos[]){
        boolean temp;
        if(j==N)
            return false;
        if(meta==0)
            return true;
        if(cifras[j]>meta)
            Partir(cifras,j+1,N,meta,elegidos);
        elegidos[j]=1;
        temp=Partir(cifras,j+1,N,meta-cifras[j],elegidos);
        if(temp)
            return true;
        elegidos[j]=0;
        Partir(cifras,j+1,N,meta,elegidos);
        return false;
    }
    
    public long calcularTiempo() {
        long inicio, fin, tiempo;
        boolean r;
        inicio =  System.currentTimeMillis();
        r=Partir(this.cifras,this.N,this.j,this.meta,this.elegidos);
        fin = System.currentTimeMillis();
        tiempo = fin - inicio;
        System.out.println("Tiempo = " + tiempo + "ms");
        System.out.println("R:"+r);
        return tiempo;
    }
}
