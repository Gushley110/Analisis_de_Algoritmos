package com.ipn.mx.main;

import com.ipn.mx.algoritmos.HireAssistant;
import com.ipn.mx.grafica.Grafica;
import java.util.ArrayList;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author EIEB
 */
public class MainP05 {
    
    public static void main(String[] args) {
        ArrayList<Long> datos = new ArrayList();
        ArrayList<Integer> elementos = new ArrayList();
        HireAssistant ha;
        for (int i = 10000; i <= 100000; i +=10000) {
            ha = new HireAssistant(i);
            datos.add(ha.calcularTiempo());
            elementos.add(i);
        }
        Grafica graficaRecursiva = new Grafica("HireAssistant", "HireAssistant", datos, elementos);
        graficaRecursiva.pack();
        RefineryUtilities.centerFrameOnScreen(graficaRecursiva);
        graficaRecursiva.setVisible(true);
    }
    
}
