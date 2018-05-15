/*
 INSTITUTO POLITÉCNICO NACIONAL
 ESCUELA SUPERIOR DE CÓMPUTO
 Análisis de Algoritmos
 GRUPO: 3CM10
 ALUMNOS:
         Cortés González Sergio Alberto
         Lugo Concha Jacob Aarón
 PROFESOR: BENJAMÍN LUNA BENOSO
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
TITULO: Multiplicacion.java
DESARROLLO:
 
FECHA: 27/Abril/2016
*/
public class Multiplicacion{
public static int contador=0;

	public int[][] llenaMatriz(int n){
		int [][] m1 = new int[n][n];
		for (int i=0;i<n ;i++ ) {
			for (int j=0;j<n ;j++ ) {
				m1[i][j]=(int)(Math.random()*9);
			}
		}
		return m1;
	}
	public void imprimeMatriz(int m1[][]){
			for (int i=0;i<m1.length ;i++ ) {
				for (int j=0;j<m1.length ;j++ ) {
					System.out.printf("%d \t",m1[i][j]);
				}
				System.out.println(" ");
			}
			System.out.println(" ");
	}
	public int[][] MultiplicacionM(int m1[][], int m2[][]){
		int [][] S1 = new int [m1.length][m1.length];
		int i,j,suma,z;
		for ( i = 0; i<m1.length ; ++i)
		{
			for ( j = 0; j <m1.length ; ++j)
			{
				suma =0;
				for ( z = 0; z <m1.length ; ++z)
				{
					contador+=1;
					suma+=m1[i][z]*m2[z][j];
				}
				S1[i][j]=suma;
				
			}
		}
		return S1;
	}
	public static void main(String[] args) {
			Multiplicacion ml= new Multiplicacion();
			for (int i=2;i<=256 ;i=i*2 ) {
				int [][] m1= new int [i][i];
				int [][] m2= new int [i][i];
				int [][] S1= new int [i][i];
				m1=ml.llenaMatriz(i);
				m2=ml.llenaMatriz(i);
				//ml.imprimeMatriz(m1);
				//ml.imprimeMatriz(m2);
				S1=ml.MultiplicacionM(m1,m2);
				//ml.imprimeMatriz(S1);

			System.out.printf("La funcion MM con n= %d realiza %d pasos\n",i,contador);
			}
	}
}