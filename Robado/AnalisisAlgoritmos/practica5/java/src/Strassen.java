/*
 	INSTITUTO POLITÉCNICO NACIONAL
 	  ESCUELA SUPERIOR DE CÓMPUTO
 		Análisis de Algoritmos
			GRUPO: 3CV2
	  Martinez Berumen Luis Daniel
	  Profesor: Benjamin Luna Benoso
*/
public class Strassen {
	public int contador;
	private int[][] suma(int[][] a, int[][] b,int n){
		int[][] c = new int[n][n];
		for(int i=0;i<n;++i) {
			for (int j = 0; j < n; ++j) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}

	private int[][] resta(int[][] a, int[][] b,int n){
		int[][] c = new int[n][n];
		for(int i=0;i<n;++i) {
			for (int j = 0; j < n; ++j) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		return c;
	}

	private int[][] multiplica(int[][] a,int[][] b){
		int[][] c = new int[2][2];
		int s1 = (a[0][1]-a[1][1])*(b[1][0]+b[1][1]);
		int s2 = (a[0][0]+a[1][1])*(b[0][0]+b[1][1]);
		int s3 = (a[0][0]-a[1][0])*(b[0][0]+b[0][1]);
		int s4 = (a[0][0]+a[0][1])*b[1][1];
		int s5 = a[0][0]*(b[0][1]-b[1][0]);
		int s6 = a[1][1]*(b[1][0]-b[0][0]);
		int s7 = (a[1][0]+a[1][1])*b[0][0];

		c[0][0] = s1 + s2 - s4 + s6;
		c[0][1] = s4+s5;
		c[1][0] = s6 + s7;
		c[1][1] = s2 -s3 +s5 -s7;
		contador+=7;
		return c;
	}

	public void imprimir(int[][] a, int n){
		for(int i=0;i<n;++i){
			for(int j=0;j<n;++j) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
	}


	public int[][] mult(int[][] a,int[][] b, int n){
		int[][] c = new int[n][n];
		if(n==2){
			c = multiplica(a,b);
		}
		else {
			contador++;
			int[][] A11 = new int[n/2][n/2];
			int[][] A12 = new int[n/2][n/2]; 
			int[][] A21 = new int[n/2][n/2]; 
			int[][] A22 = new int[n/2][n/2]; 
			int[][] B11 = new int[n/2][n/2]; 
			int[][] B12 = new int[n/2][n/2]; 
			int[][] B21 = new int[n/2][n/2]; 
			int[][] B22 = new int[n/2][n/2]; 

			int l= n/2;

			for(int i=0;i<n/2;++i) {
				for(int j=0;j<n/2;++j) {
					A11[i][j] = a[i][j];
					B11[i][j] = b[i][j];
					A12[i][j] = a[i][l+j];
					B12[i][j] = b[i][l+j];

					A21[i][j] = a[i+l][j];
					B21[i][j] = b[i+l][j];
					A22[i][j] = a[i+l][l+j];
					B22[i][j] = b[i+l][l+j];
				}
			}

			int[][] s1 = mult(resta(A12,A22,n/2),suma(B21,B22,n/2),n/2);
			int[][] s2 = mult(suma(A11,A22,n/2),suma(B11,B22,n/2),n/2);
			int[][] s3 = mult(resta(A11,A21,n/2),suma(B11,B12,n/2),n/2);
			int[][] s4 = mult(suma(A11,A12,n/2),B22,n/2);
			int[][] s5 = mult(A11,resta(B12,B22,n/2),n/2);
			int[][] s6 = mult(A22,resta(B21,B11,n/2),n/2);
			int[][] s7 = mult(suma(A21,A22,n/2),B11,n/2);
			int[][] C11 = suma(resta(suma(s1,s2,n/2),s4,n/2),s6,n/2);
			int[][] C12 = suma(s4,s5,n/2);
			int[][] C21 = suma(s6,s7,n/2);
			int[][] C22 = resta(suma(resta(s2,s3,n/2),s5,n/2),s7,n/2);

			for(int i=0;i<l;++i) {
				for (int j = 0; j < l; ++j) {
					c[i][j] = C11[i][j];
					c[i][j + l] = C12[i][j];
					c[i + l][j] = C21[i][j];
					c[i + l][j + l] = C22[i][j];
				}
			}
 		}
 		return c;
	}
	public static void main(String[] args){
		Strassen stras = new Strassen();
		for(int p=2;p<=256;p*=2) {
			stras.contador=0;
			int[][] a = new int[p][p];
			int[][] b = new int[p][p];
			for(int i=0;i<p;++i) {
				for(int j=0;j<p;++j) {
					a[i][j]=(int)(Math.random()*9);
					b[i][j]=(int)(Math.random()*9);
				}
			}
			int[][] c = stras.mult(a,b,p);
			System.out.printf("%d ,%d",p,stras.contador);
		}
	}
}