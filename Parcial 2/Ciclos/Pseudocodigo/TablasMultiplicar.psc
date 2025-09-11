Algoritmo TablasMultiplicar
	Definir n,i Como Entero
	
	Repetir
		Escribir "Ingrese el número de la tabla de multiplicar: "
		Leer n
		Si n<>0 Entonces
			Escribir "Tabla de multiplicar del ",n
			Para i<-1 Hasta 10 Con Paso 1 Hacer
				Escribir n," x ",i, " = ",n*i
			FinPara
		FinSi
	Hasta Que n=0
	
	
FinAlgoritmo
