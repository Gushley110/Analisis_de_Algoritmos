package com.ipn.mx.main;

import com.ipn.mx.algoritmos.MMIterativo;
import com.ipn.mx.algoritmos.MMRecursivo;
import com.ipn.mx.grafica.Grafica;
import java.util.ArrayList;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author EIEB
 */
public class MainP04 {

    public static void main(String[] args) {
        ArrayList<Long> datos = new ArrayList();
        ArrayList<Integer> elementos = new ArrayList();

        MMRecursivo mmr;
        for (int i = 1; i <= Math.pow(2, 9); i *= 2) {
            mmr = new MMRecursivo(i);
            datos.add(mmr.medirTiempo());
            elementos.add(i);
        }

        Grafica graficaRecursiva = new Grafica("Multiplicación de matrices", "Recursivo", datos, elementos);
        graficaRecursiva.pack();
        RefineryUtilities.centerFrameOnScreen(graficaRecursiva);
        graficaRecursiva.setVisible(true);

        datos.clear();
        elementos.clear();

        MMIterativo mmi;

        for (int i = 100; i <= 2000; i += 100) {
            mmi = new MMIterativo(i);
            datos.add(mmi.medirTiempo());
            elementos.add(i);
        }

        Grafica graficaIterativa = new Grafica("Multiplicación de matrices", "Iterativo", datos, elementos);
        graficaIterativa.pack();
        RefineryUtilities.centerFrameOnScreen(graficaIterativa);
        graficaIterativa.setVisible(true);

    }

}
