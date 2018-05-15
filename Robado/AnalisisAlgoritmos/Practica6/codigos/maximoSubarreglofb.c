/*
 	INSTITUTO POLITÉCNICO NACIONAL
 	  ESCUELA SUPERIOR DE CÓMPUTO
 		Análisis de Algoritmos
			GRUPO: 3CV2
	  Martinez Berumen Luis Daniel
 	Profesor: Benjamin Luna Benoso
*/
#include "stdio.h"

int maximoSubArrFBSubArrFB(int n , int array[], int *contador){
	int suma,i,j,maxi=0;
	for ( i = 0; i <n ; i++){	
		suma=0;
			for ( j =i; j <n; j++){
				*(contador)+=1;
				suma+=array[j];
				if (suma>maxi){
					maxi=suma;
				}
			}
	}
	return maxi;
}


int main(int argc, char const *argv[]){
	int i,suma=0,m=0,p=0;
	int *contador;
	for (m = 1; m<30; m++){
		int array[m];
		for ( i = 0; i < m; ++i){
			array[i]=rand()%10;
		}
		p=0;
		contador=&p;
		maximoSubArrFB(m,array,contador);
	}	
	return 0;
}