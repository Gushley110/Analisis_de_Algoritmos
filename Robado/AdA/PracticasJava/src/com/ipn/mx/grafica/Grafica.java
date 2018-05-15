package com.ipn.mx.grafica;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author EIEB
 */
public class Grafica extends ApplicationFrame {
    
    private final static int ANCHO = 800;
    private final static int ALTO = 480;
    
    public Grafica(String title, String tituloGrafica, ArrayList<Long> datos, ArrayList<Integer> elementos) {
        super(title);
        JFreeChart grafica = ChartFactory.createLineChart(tituloGrafica, "Número de elementos (n)", "Tiempo (ms)", obtenerDatos(datos, elementos));
        ChartPanel chartPanel = new ChartPanel( grafica );
        chartPanel.setPreferredSize(new java.awt.Dimension(ANCHO, ALTO));
        setContentPane( chartPanel );
    }

    private CategoryDataset obtenerDatos(ArrayList<Long> datos, ArrayList<Integer> elementos) {
        DefaultCategoryDataset dcds = new DefaultCategoryDataset();
        int index = 0;
        for (long dato : datos) {
            dcds.addValue(dato, "tiempo", String.valueOf(elementos.get(index++)));
        }
        return dcds;
    }
    
}
