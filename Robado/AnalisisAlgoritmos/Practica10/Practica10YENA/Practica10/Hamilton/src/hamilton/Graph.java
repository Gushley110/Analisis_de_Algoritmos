//Escuela Superior de Computo Instituto Politecnico Nacional
//Padilla Calderon Jose Manuel	
//Salgado Alarcon Genaro
//Analisis de Algoritmos - Dr. Luna Benoso Benjamin 3CV2
//Practica 10 Verificacion en Tiempo Polinomial


import java.util.*;

public class Graph{
	int n, j=0;
	Node[] mat;

	public Graph(Node[] mat, int n){
		this.mat=mat;
		this.n=n;
	}

	public boolean verify(Node[] c){
                System.out.println("Grafo " +j);
                j++;
		if(c.length!=this.n){
			System.out.println("No contiene todos los nodos");
			return false;	
		}
		else{
			for(int i=0; i<this.n-1; i++){
				System.out.println(c[i].n+"->"+c[i+1].n);
				if(c[i].ad.contains(c[i+1])){
					for(int j=0; j<this.n; j++){
						if(j!=i && c[j].n==c[i].n){
							System.out.println("El nodo "+c[i].n+" ya fue visitado");
							return false;
						}
					}
				}
				else{
					System.out.println(c[i].n+" no se conecta con "+c[i+1].n+" en el grafo");
					return false;
				}
			}
			if(c[this.n-1].ad.contains(c[0])){
				return true;
			}
			else{
				return false;
			}
		}
	}
}