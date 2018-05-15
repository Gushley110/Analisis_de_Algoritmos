/*
 	INSTITUTO POLITÉCNICO NACIONAL
 	  ESCUELA SUPERIOR DE CÓMPUTO
 		Análisis de Algoritmos
			GRUPO: 3CV2
	  Martinez Berumen Luis Daniel
 	Profesor: Benjamin Luna Benoso
*/
#include<bits/stdc++.h>
using namespace std;
typedef struct  str{
	int ini;
	int fini;
	int sum;	
	 str(){};
	 str(int a,int b,int c){
		ini = a;
		fini = b;
		sum = c;
	};
	bool operator >( str& p){
		return sum > p.sum;
	}
	ostream& operator<<(ostream& o){
		o<<ini<<" "<<fini<<" "<<sum<<'\n';
		return o;
	}
}  maxSubArr;


 maxSubArr maxSubCruzado(int a[],int ini, int mitad, int fini,int* contador){
	int s1=INT_MIN,s2=INT_MIN;
	int sumaAux = 0;
	int min=mitad,max=mitad;
	for(int i=mitad;i>=ini;--i){
		(*contador)++;
		sumaAux += a[i]; 
		if(sumaAux > s1){
			s1 = sumaAux;
			min = i;
		}
	}
	sumaAux=0;
	for(int i=mitad+1;i<=fini;++i){
		(*contador)++;
		sumaAux += a[i]; 
		if(sumaAux>s2){
			s2 = sumaAux;
			max = i;
		}
	}
	 maxSubArr res(min,max,s1+s2);
	return res;
}


 maxSubArr maximoSubarreglo(int a[],int ini,int fini,int* contador){
	(*contador)++;
	if(ini!=fini){
		int mitad = (ini+fini)/2;
		 maxSubArr  maxSubArr1 = maximoSubarreglo(a,ini,mitad,contador);
		 maxSubArr  maxSubArr2 = maxSubCruzado(a,ini,mitad,fini,contador);
		 maxSubArr  maxSubArr3 = maximoSubarreglo(a,mitad+1,fini,contador);
		if( maxSubArr1 >  maxSubArr2){
			if( maxSubArr3 >  maxSubArr1){
				return  maxSubArr3;
			}
			else{
				return  maxSubArr1;
			}
		}
		else{
			if( maxSubArr3 >  maxSubArr2){
				return  maxSubArr3;
			}else{
				return  maxSubArr2;
			}
		}
	}
	else{
		 maxSubArr res(ini,fini,a[ini]);
		return res;
	}
}


int main(){
	int *contador;
	int p;
	contador=&p;
	for(int i=0;i<30;++i){
		p=0;
		int a[i+1];
		for(int j=0;j<i+1;++j){
			a[j] = 20 - (rand()%40 + 1); 
			printf("%d ",a[j]);
		}
		puts("");
		 maxSubArr res = maximoSubarreglo(a,0,i,contador);
		for(int j=res.ini;j<=res.fini;++j){
			printf("%d ", a[j]);
		}
		puts("");
	}
	return 0;
}