# include <stdio.h>
# include <time.h>

long long int MCD(long long int a, long long int b) {
	if(b == 0) return a;
    else{
    	printf("Modulo=%lld\n", a%b);
    	return MCD(b, a%b);	
    } 
}

int main() {
	long long int m, n;
	printf("Ingrese los valores de la funcion MCD:\n");
	scanf("%lld %lld", &m, &n);
	clock_t t_ini, t_fin;
	t_ini = clock();
	double secs;
	printf("%lld\n", MCD(m, n));
	t_fin = clock();
	secs = (double)(t_fin - t_ini) / CLOCKS_PER_SEC;
	printf("%.16g milisegundos\n", secs * 1000.0);
	return 0;
}