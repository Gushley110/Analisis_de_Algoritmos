/*
 	INSTITUTO POLITÉCNICO NACIONAL
 	  ESCUELA SUPERIOR DE CÓMPUTO
 		Análisis de Algoritmos
			GRUPO: 3CV2
	  Martinez Berumen Luis Daniel
 	Profesor: Benjamin Luna Benoso
*/

typedef struct nodo
{
	unsigned char caracter;
	int frecuencia;
	struct nodo* izq;
	struct nodo *der;
}*Nodo;

struct nodoCod
{
	char caracter;
	string cod;
};

Nodo crearNodo(unsigned char c)
{
	Nodo nuevo = (Nodo)malloc(sizeof(struct nodo));
	nuevo->caracter = c;
	nuevo->frecuencia = 0;
	nuevo->izq = NULL;
	nuevo->der = NULL;
	return nuevo;
}

bool ordenar(Nodo a,Nodo b)
{
	if(a->frecuencia==0 && b->frecuencia==0)
		return false;
	else if(a->frecuencia ==0)
		return false;
	else if(b->frecuencia ==0)
		return true;
	else if(a->frecuencia==b->frecuencia)
		return a->caracter < b->caracter;
	else
		return a->frecuencia<b->frecuencia;	
}

int getCaracter(FILE* arch, Nodo a, int i,string aux)
{
	if(a->caracter == '\0')
	{
		if(aux[i]=='0')
			return getCaracter(arch,a->izq,i+1,aux);
		else
			return getCaracter(arch,a->der,i+1,aux);
	}
	else
	{
		fprintf(arch,"%c",a->caracter);
		return i;
	}
}

string getBinaria(unsigned int e)
{
	unsigned int n=e;
	string a;
	while(n>0)
	{
		if(n%2==1)
			a = '1' + a;
		else
			a = '0' + a;
		n= n/2;
	}
	while(a.length()<8)
		a = '0' + a;
	return a;
}

unsigned int getEntero(string c)
{
	int r=1;
	unsigned int e=0;
	for(int i=c.length()-1;i>=0;--i)
	{
		if(c[i]=='1')
			e+=r;
		r*=2;
	}
	return e;
}


void llenarArchFrec(FILE *archivo,vector<Nodo> a)
{
	for(int i=0;i<a.size();++i)
		fprintf(archivo, "%c %d\n",a[i]->caracter,a[i]->frecuencia);
}

void llenarArchCod(FILE *archivo,vector<struct nodoCod> a)
{
	for(int i=0;i<a.size();++i)
		fprintf(archivo, "%c %s\n",a[i].caracter,a[i].cod.c_str());
}

void llenarArchivoDec(FILE* arch1, FILE* arch2, Nodo arbol,vector<struct nodoCod> n)
{
	unsigned char e;
	string aux;
	string r;
	while(fscanf(arch1,"%c",&e)!=EOF)
	{
		//printf("%c\n",e);
		r = getBinaria((unsigned int)e);;
		aux += r;
	}
	int k=0;
	while(k<aux.length())
	{
		k = getCaracter(arch2,arbol,k,aux);
	}
}

void llenarArchCodificado(FILE *archivo,string cad,vector<struct nodoCod> a)
{
	string cadenaAux="";
	for(int i=0;i<cad.length();++i)
	{
		for(int j=0;j<a.size();++j)
		{
			if(cad[i]==a[j].caracter)
			{
				cadenaAux +=a[j].cod;
				if(cadenaAux.length()==8)
				{
					unsigned int entero = getEntero(cadenaAux);
					fprintf(archivo, "%c",(unsigned char)entero);
					//cout<<cadenaAux<<'.';
					cadenaAux="";
				}
				else if(cadenaAux.length()>8)
				{
					string x = cadenaAux.substr(0,8);
					unsigned int entero = getEntero(x);
					fprintf(archivo, "%c",(unsigned char)entero);
					//cout<<x<<'.';
					cadenaAux = cadenaAux.substr(8);
				}
			}
		}
	}
	if(cadenaAux.length()>0)
	{
		unsigned int entero = getEntero(cadenaAux);
		fprintf(archivo, "%c",(unsigned char)entero);
		//cout<<cadenaAux<<'.';
	}
}

Nodo construirArbol(vector<Nodo> a)
{
	int i=0;
	while(a.size()>1)
	{
		Nodo base = crearNodo('\0');
		base->frecuencia = a[0]->frecuencia + a[1]->frecuencia;
		base->izq = a[0];
		base->der = a[1];
		a.erase(a.begin()+0);
		a.erase(a.begin()+0);
		a.push_back(base);
		sort(a.begin(),a.end(),ordenar);
	}
	return a[0];
}

vector<struct nodoCod> getTablaCod(Nodo a,string cad)
{
	vector<struct nodoCod> v,w,r;
	string aux1("");
	string aux2("");
	if(a->caracter == '\0')
	{
		aux1 = cad + "0";
		aux2 = cad + "1";
		v = getTablaCod(a->izq,aux1);
		w = getTablaCod(a->der,aux2);
		r.assign(v.begin(),v.end());
		for(int k=0;k<w.size();++k)
			r.push_back(w[k]);
		return r;
	}
	else
	{
		struct nodoCod r;
		r.caracter = a->caracter;
		r.cod = cad;
		v.push_back(r);
		return v;
	}
}