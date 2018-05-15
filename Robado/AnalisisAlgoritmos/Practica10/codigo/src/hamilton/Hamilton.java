/*
 	INSTITUTO POLITÉCNICO NACIONAL
 	  ESCUELA SUPERIOR DE CÓMPUTO
 		Análisis de Algoritmos
			GRUPO: 3CV2
	  Martinez Berumen Luis Daniel
 	Profesor: Benjamin Luna Benoso
*/
import java.util.*;
public class Hamilton {

    public static void main(String[] args) {
        Node[] mat=new Node[5];
	Node n0=new Node(0);
	Node n1=new Node(1);
	Node n2=new Node(2);
	Node n3=new Node(3);
	Node n4=new Node(4);
        
	ArrayList<Node> na0=new ArrayList<Node>();
	na0.add(n1);
	na0.add(n3);
	n0.ad=na0;
	
        ArrayList<Node> na1=new ArrayList<Node>();
	na1.add(n0);
	na1.add(n2);
	na1.add(n3);
	na1.add(n4);
	n1.ad=na1;
	
        ArrayList<Node> na2=new ArrayList<Node>();
	na2.add(n1);
	na2.add(n4);
	n2.ad=na2;
	
        ArrayList<Node> na3=new ArrayList<Node>();
	na3.add(n0);
	na3.add(n1);
	na3.add(n4);
	n3.ad=na3;
	
        ArrayList<Node> na4=new ArrayList<Node>();
	na4.add(n1);
	na4.add(n2);
	na4.add(n3);
	n4.ad=na4;
	
        mat[0]=n0;
	mat[1]=n1;
	mat[2]=n2;
	mat[3]=n3;
	mat[4]=n4;
	
        Graph graph=new Graph(mat, 5);
	
        Node[] c=new Node[5];
	Node[] c1=new Node[5];
	
        c[0]=n0;
	c[1]=n1;
	c[2]=n2;
	c[3]=n4;
	c[4]=n3;
        
        c1[0]=n0;
	c1[1]=n1;
	c1[2]=n2;
	c1[3]=n1;
	c1[4]=n3;
	
        if(graph.verify(c)){
		System.out.println("Es un ciclo Hamiltoniano");
                System.out.println(" ");
	}
        else{
		System.out.println("No es un ciclo Hamiltoniano");
                System.out.println(" ");
	}
	
        if(graph.verify(c1)){
		System.out.println("Es un ciclo Hamiltoniano");
                System.out.println(" ");
	}
        else{
		System.out.println("No es un ciclo Hamiltoniano");
                System.out.println(" ");
	}
    }
    
}
