package com.ipn.mx.main;

import com.ipn.mx.algoritmos.FMS;
import com.ipn.mx.algoritmos.FMSBruto;
import com.ipn.mx.grafica.Grafica;
import java.util.ArrayList;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author EIEB
 */
public class MainP03 {
    
    public static void main(String[] args) {
        
        ArrayList<Long> datos = new ArrayList();
        ArrayList<Integer> elementos = new ArrayList();
        
        FMSBruto fmsb = new FMSBruto();
        Grafica g;
        for (int i = 1000; i <= 10000; i += 1000) {
            fmsb.llenarNumeros(i);
            datos.add(fmsb.calcularTiempo());
            elementos.add(i);
        }
        g = new Grafica("Find Max Subarray", "Fuerza Bruta", datos, elementos);
        g.pack();
        RefineryUtilities.centerFrameOnScreen(g);
        g.setVisible(true);
        
        datos.clear();
        elementos.clear();
        
        FMS fms = new FMS();
        for (int i = 500000; i <= 100000000; i += 500000) {
            fms.llenarNumeros2(i);
            datos.add(fms.calcularTiempo());
            elementos.add(i);
        }
        Grafica graficaFMS = new Grafica("Find Max Subarray", "Divide and Conquer", datos, elementos);
        graficaFMS.pack();
        RefineryUtilities.centerFrameOnScreen(graficaFMS);
        graficaFMS.setVisible(true);
        
    }
    
}
