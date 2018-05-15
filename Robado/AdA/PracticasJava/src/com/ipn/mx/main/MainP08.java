package com.ipn.mx.main;

import com.ipn.mx.algoritmos.DFT;
import com.ipn.mx.algoritmos.FFT;
import com.ipn.mx.grafica.Grafica;
import java.util.ArrayList;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author EIEB
 */
public class MainP08 {
    
    public static void main(String[] args) {
        ArrayList<Long> datos = new ArrayList();
        ArrayList<Integer> elementos = new ArrayList();
        DFT dft;
        FFT fft;
        for (int i = (int)Math.pow(2, 6); i <= Math.pow(2, 14); i *= (int)Math.pow(2, 2)) {
            dft = new DFT(i);
            
            datos.add(dft.calcularTiempo());
            elementos.add(i);
        }
        
        Grafica graficaRecursiva = new Grafica("Fourier Transform", "Discrete Fourier Transform", datos, elementos);
        graficaRecursiva.pack();
        RefineryUtilities.centerFrameOnScreen(graficaRecursiva);
        graficaRecursiva.setVisible(true);
        
        for (int i = (int)Math.pow(2, 6); i <= Math.pow(2, 14); i *= (int)Math.pow(2, 2)) {
            fft = new FFT(i);
            
            datos.add(fft.calcularTiempo());
            elementos.add(i);
        }
        
        Grafica graficaRecursiva1 = new Grafica("Fourier Transform", "Fast Fourier Transform", datos, elementos);
        graficaRecursiva.pack();
        RefineryUtilities.centerFrameOnScreen(graficaRecursiva1);
        graficaRecursiva1.setVisible(true);
    }
    
}
