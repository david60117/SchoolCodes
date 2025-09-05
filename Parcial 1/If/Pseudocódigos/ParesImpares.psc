Algoritmo ParesImpares
	Definir pares, impares Como Entero
	pares<-0
	impares<-0
	para i<-1 Hasta 100 Hacer
		Si i%2=0 Entonces
			pares=pares+i
		SiNo
			impares=impares+i
		FinSi
	FinPara
	Escribir "Pares: ", pares
	Escribir "Impares: ", impares
FinAlgoritmo
