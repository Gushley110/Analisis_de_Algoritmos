/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.main;

import com.ipn.mx.algoritmos.Particion;
import java.util.ArrayList;
import com.ipn.mx.grafica.Grafica;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author César
 */
public class MainProyecto {
    
    
    public static void main(String[] args){
        
        ArrayList<Long> datos = new ArrayList();
        ArrayList<Integer> elementos = new ArrayList();
        int cifras[]={1,2,3,4,5,5,4,3,2,1};
        int elegidos[];
        elegidos= new int[10];
        int suma=15;
        boolean r;
        Particion p=new Particion(cifras,suma);
        
        r=p.Partir(cifras, 0, 9, suma, elegidos);
        System.out.println("R:"+r);
        
    }
}
