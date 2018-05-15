/*
 	INSTITUTO POLITÉCNICO NACIONAL
 	  ESCUELA SUPERIOR DE CÓMPUTO
 		Análisis de Algoritmos
			GRUPO: 3CV2
	  Martinez Berumen Luis Daniel
 	Profesor: Benjamin Luna Benoso
*/

#include <bits/stdc++.h>
using namespace std;
#include "huff.h"

void codificar(){
	FILE *archivoOrigen = fopen("origen.txt","r");
	FILE *archivoFrec = fopen("Frecuencia.txt","w");
	FILE *archivoCod = fopen("Codificacion.txt","w");
	FILE *archivoNuevo = fopen("Archivo_Codificado.txt","w");
	vector<Nodo> array;
	vector<Nodo> tabla_valores;
	for(int i=0;i<=256;++i)
		array.push_back(crearNodo((unsigned char)i));

	unsigned char aux;
	int char_dif=0;
	string cadena("");
	while(fscanf(archivoOrigen,"%c",&aux)!=EOF){
		cadena += aux;
		if((array[aux]->frecuencia)==0)
			char_dif++;
		(array[aux]->frecuencia)++;
	}
	sort(array.begin(),array.end(),ordenar);
	for(int i=0;i<char_dif;++i){
		tabla_valores.push_back(crearNodo(array[i]->caracter));
		tabla_valores[i]->frecuencia = array[i]->frecuencia;
	}
	llenarArchFrec(archivoFrec,tabla_valores);
	Nodo arbol = construirArbol(tabla_valores);
	vector<struct nodoCod> tabla_cod = getTablaCod(arbol,"");
	llenarArchCod(archivoCod,tabla_cod);
	llenarArchCodificado(archivoNuevo, cadena,tabla_cod);

	fclose(archivoOrigen);
	fclose(archivoFrec);
	fclose(archivoNuevo);
	fclose(archivoCod);
}

void decodificar(){
	FILE *archivoFrec = fopen("Frecuencia.txt","r");
	FILE *archivoCod = fopen("Archivo_Codificado.txt","r");
	FILE *archivoNuevo = fopen("Archivo_decodificado.txt","w");

	vector<Nodo> array;
	vector<Nodo> tabla_valores;

	unsigned char aux;
	int frec=0;
	char salto;
	int count=0;
	while(fscanf(archivoFrec,"%c %d%c",&aux,&frec,&salto)!=EOF){
		tabla_valores.push_back(crearNodo(aux));
		tabla_valores[count++]->frecuencia = frec;
	}
	Nodo arbol = construirArbol(tabla_valores);
	vector<struct nodoCod> tabla_cod = getTablaCod(arbol,"");

	llenarArchivoDec(archivoCod,archivoNuevo,arbol,tabla_cod);

	fclose(archivoFrec);
	fclose(archivoNuevo);
	fclose(archivoCod);
}

int main(){
	int opc;
	puts("1) Codificar");
	puts("2) Decodificar");
	scanf("%d",&opc);
	if(opc==1)
		codificar();
	else if(opc==2){
		decodificar();
	}
	else{
		puts("Opcion Incorrecta");
	}
	return 0;
}
