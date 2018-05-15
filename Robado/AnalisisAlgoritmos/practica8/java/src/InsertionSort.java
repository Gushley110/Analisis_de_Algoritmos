//Escuela Superior de Computo Instituto Politecnico Nacional
//Padilla Calderon Jose Manuel	
//Salgado Alarcon Genaro
//Analisis de Algoritmos - Dr. Luna Benoso Benjamin 3CV2
//Practica 8 Algoritmos de Ordenacion

import java.util.*;

public class InsertionSort {
    static int pasos;
    
    
    void InsertionSort(int[] arreglo){
        int tamanio = arreglo.length;
        int aux, posicion;
        
        for(int i=0; i<tamanio; i++){
            pasos = pasos+1;
            aux = arreglo[i];
            posicion = i-1;
            
            while(posicion>=0 && arreglo[posicion]>aux){
                pasos = pasos+1;
                arreglo[posicion+1] = arreglo[posicion];
                posicion = posicion-1;
            }
            arreglo[posicion+1] = aux;
        }
    }
    
    public static void main(String[] args) {
        InsertionSort insertion = new InsertionSort();
        Scanner entrada =  new Scanner(System.in);
        int tamanio, aux;
        int[] arreglo;
        
        for(int i=1; i<=50; i++){
            pasos = 0;
            arreglo = new int[i];
            tamanio = arreglo.length;
            
            for(int j=0; j<tamanio; j++){
                arreglo[j] = (int)( Math.random()*100 );
            }
            
            //System.out.println("Arreglo original: ");
            //insertion.imprimirArreglo(arreglo);
            insertion.InsertionSort(arreglo);
            //System.out.println("Arreglo ordenado: ");
            //insertion.imprimirArreglo(arreglo);
            System.out.println("Tamaño del arreglo: " +i);
            System.out.println("Numero de pasos: " +pasos);
            System.out.println(" ");
        }
        
    }
    
}
