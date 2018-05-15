/*
 	INSTITUTO POLITÉCNICO NACIONAL
 	  ESCUELA SUPERIOR DE CÓMPUTO
 		Análisis de Algoritmos
			GRUPO: 3CV2
	  Martinez Berumen Luis Daniel
 	Profesor: Benjamin Luna Benoso
*/

import java.util.ArrayList;

public class SecuenciaMat {

    public void solOpt(int[][] s,int i, int j){
        if(i==j)
            System.out.print("A"+i);
        else{
            System.out.print("(");
            solOpt(s,i,s[i][j]);
            solOpt(s,s[i][j]+1,j);
            System.out.print(")");
        }
    }

    class Solucion {
        public int pasos;
        public String config;
        Solucion(String config,int pasos) {
            this.config = config;
            this.pasos = pasos;
        }
    }

    class RMat {
        public int[][] m;
        public int[][] s;

        RMat(int[][] a,int[][] b) {
            m = a;
            s = b;
        }
    }

    public RMat SMat(ArrayList<Integer> p){
        int n = p.size()-1;
        int[][] m = new int[n+1][n+1];
        int[][] s = new int[n+1][n+1];

        for(int i=1;i<=n;++i){
            m[i][i] = 0;
        }

        for(int l=2;l<=n;++l){
            for(int i=1;i<=n-l+1;++i){
                int j=i+l-1;
                m[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<=j-1;++k){
                    int q = m[i][k] + m[k+1][j] + p.get(i-1)*p.get(k)*p.get(j);
                    if(q<m[i][j]){
                        m[i][j]=q;
                        s[i][j]=k;
                    }
                }
            }
        }
        RMat resultado = new RMat(m,s);
        return resultado;
    }



    public ArrayList<Solucion> posSol(int i, int j,ArrayList<Integer> p){
        ArrayList<Solucion> r = new ArrayList<Solucion>();
        if(i==j){
            Solucion s = new Solucion("A"+i,0);
            r.add(s);
            return r;
        } else {
            for(int l=i;l<=j-1;++l){
                ArrayList<Solucion> q = posSol(i,l,p);
                ArrayList<Solucion> s = posSol(l+1,j,p);
                for(int a=0;a<q.size();++a) {
                    for (int b=0; b<s.size();++b ) {
                        Solucion ss = new Solucion("("+q.get(a).config+s.get(b).config+")",
                                q.get(a).pasos+s.get(b).pasos + p.get(i-1)*p.get(l)*p.get(j));
                        r.add(ss);
                    }
                }
            }
            return r;
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> m = new ArrayList<Integer>();
        m.add(3);
        m.add(5);
        m.add(6);
        m.add(5);
        m.add(3);
        m.add(3);

        SecuenciaMat sm = new SecuenciaMat();
        RMat r = sm.SMat(m);
        System.out.print("Solucion optima: ");
        sm.solOpt(r.s,1,m.size()-1);
        System.out.println("\n");

        System.out.println("Soluciones posibles");
        ArrayList<Solucion> soluciones = sm.posSol(1,m.size()-1,m);
        for(int i=0;i<soluciones.size();++i) {
            System.out.println("Sol."+i+soluciones.get(i).config + "\n" + soluciones.get(i).pasos + " operaciones escalares\n");
        }
    }
}
