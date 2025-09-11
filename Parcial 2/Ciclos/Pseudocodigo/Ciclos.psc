Algoritmo FirstWhile
	Definir n, result Como Entero
	n<-1
	result<-0
	Mientras n<10 Hacer
		result<-result+n
		n<-n+1
	FinMientras
	Escribir result
	
	n<-1
	result<-0
	Repetir
		result=result+n
		n<-n+1
	Hasta Que n=10
	Escribir result
	
	result<-0
	Para n<-1 Hasta 9 Con Paso 1 Hacer
		result=result+n
	Fin Para
	Escribir result
	
FinAlgoritmo
