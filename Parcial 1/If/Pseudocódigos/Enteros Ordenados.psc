Algoritmo EnterosOrdenados
	Definir a,b,c Como Entero
	Definir rep Como Logico
	Escribir "Ingrese los valores de a, b, c, correspondientemente"
	Leer a,b,c
	Escribir "¿Se permite EqualOk?"
	Leer rep
	
	Si rep Entonces
		Si a <= b y b <= c Entonces
			Escribir "Verdadero"
		SiNo 
			Escribir "Falso"
		FinSi
	SiNo
		Si a < b y b < c Entonces
			Escribir "Verdadero"
		SiNo 
			Escribir "Falso"
		FinSi
	FinSi
	
	
	
FinAlgoritmo
