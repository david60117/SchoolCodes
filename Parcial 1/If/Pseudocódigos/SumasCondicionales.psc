Algoritmo SumasCondicionales
	Definir a,b,c Como Entero
	Escribir "Ingrese los valores de a, b, c, correspondientemente"
	Leer a,b,c
	
	Si a+b=10 o b+c=10 o a+c=10 Entonces
		Escribir 10
	SiNo 
		Si a+b=b+c+10 o a+b=a+c+10 Entonces
			Escribir 5
		SiNo
			Escribir 0
		FinSi
	FinSi
	
FinAlgoritmo

