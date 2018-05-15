package com.ipn.mx.main;

import com.ipn.mx.algoritmos.MochilaEntera;
import com.ipn.mx.grafica.Grafica;
import java.util.ArrayList;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author EIEB
 */
public class MainP10 {
    
    public static void main(String[] args) {
        ArrayList<Long> datos = new ArrayList();
        ArrayList<Integer> elementos = new ArrayList();
        MochilaEntera me;
        
        for (int n = 100; n <= 1000; n+=100) {
            me = new MochilaEntera(n);
            datos.add(me.medirTiempo());
            elementos.add(n);
        }
        
        Grafica graficaRecursiva = new Grafica("Mochila Entera", "knapSack", datos, elementos);
        graficaRecursiva.pack();
        RefineryUtilities.centerFrameOnScreen(graficaRecursiva);
        graficaRecursiva.setVisible(true);
    }
    
}
