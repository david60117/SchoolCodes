Algoritmo Figuras
	Escribir "¿Qué figuara requiere dibujar? (1. Cuadrado 2.Triángulo 3. Triángulo inverso)"
	Leer fig
	Escribir "Líneas: "
	Leer lin
	Segun fig
		Caso 1:
			Para i<-1 Hasta lin Con Paso 1 Hacer
				Para j<-1 Hasta lin Con Paso 1 Hacer
					Escribir Sin Saltar "*"
				FinPara
				Escribir ""
			FinPara
		Caso 2:
			Para i<-1 hasta lin Hacer
				Para j<-1 hasta (lin-i) Hacer
					Escribir Sin Saltar " "
				FinPara
				Para j<-1 Hasta (2*i-1) Hacer
					Escribir Sin Saltar "*"
				FinPara
				Escribir ""
			FinPara
		Caso 3:
			Para i <- lin Hasta 1 Con Paso -1 Hacer
				Para j <- 1 Hasta (lin - i) Hacer
					Escribir Sin Saltar " "
				FinPara
				
				Para j <- 1 Hasta (2*i - 1) Hacer
					Escribir Sin Saltar "*"
				FinPara
				Escribir ""  
			FinPara
			
		De Otro Modo:
	FinSegun
FinAlgoritmo
