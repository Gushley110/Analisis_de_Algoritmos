# include <bits/stdc++.h>
using namespace std;

int n;
vector<long long int> numeros;

int main (){

	printf ("Ingrese el numero de elementos\n");
	scanf ("%d", &n);
	printf ("Ingrese los %d numeros\n", n);
	for (int i = 0; i < n; i++){
		long long int aux;
		scanf ("%lld", &aux);
		numeros.push_back(aux);
	}
	long long int mejor = numeros[0];
	int iniMejor = 0;
	int finMejor = 0;
	for (int i = 0; i < numeros.size(); i++){
		for (int j = i; j < numeros.size(); j++){
			long long int suma = 0;
			for (int k = i; k <= j; k++){
				suma += numeros[k];
			}
			if (suma > mejor){
				mejor = suma;
				iniMejor = i;
				finMejor = j;
			}
		}	
	}
	printf ("Suma: %lld, Inicio: %d, Fin: %d\n", mejor, iniMejor, finMejor);
	return 0;
}