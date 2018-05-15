# include <stdio.h>
# include <time.h>

int main() {
	long long int n;
	scanf("%lld", &n);
	char a[n+1], b[n+1];
	scanf("%s %s", a, b);
	int acarreo = 0, i;
	int c[n+1];
	clock_t t_ini, t_fin;
	t_ini = clock();
	double secs;
	for (i = 0; i <= n; i++) c[i] = 0;
	for (i = n-1; i >= 0; i--){
		if (a[i] == '0' && b[i] == '0') {
			c[i+1] = acarreo;
			acarreo = 0;
		} else if (a[i] != b[i]) {
			if (acarreo == 0) c[i+1] = 1;
			else c[i+1] = 0;
		} else if (a[i] == '1' && b[i] == '1') {
			if (acarreo == 0) c[i+1] = 0;
			else c[i+1] = 1;
			acarreo = 1;
		}
	}
	c[0] = acarreo;
	t_fin = clock();
	secs = (double)(t_fin - t_ini) / CLOCKS_PER_SEC;
	printf("%.16g milisegundos\n", secs * 1000.0);
	printf("\n%s + %s = ", a, b);
	for (i = 0; i <= n; i++) printf("%d", c[i]);
	printf("\n");
	return 0;
}