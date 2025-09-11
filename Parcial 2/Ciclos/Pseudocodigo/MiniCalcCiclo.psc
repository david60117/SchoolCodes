Algoritmo MiniCalcCiclo
	Definir a, b, resultado Como Real
	Definir rep, numop Como Entero
	Definir ope Como Cadena
	Escribir '¿Cuántas operaciones requiere hacer?'
	Leer numop
	Para rep<-1 Hasta numop Con Paso 1 Hacer
		Escribir 'Operación no. ', rep
		Escribir 'Escribe dos números enteros'
		Escribir 'a: '
		Leer a
		Escribir 'b: '
		Leer b
		Escribir 'Escribe un carácter comprendido entre (+, -, *, /): '
		Leer ope
		Según ope Hacer
			'+':
				resultado <- a+b
				Escribir 'Resultado: ', resultado
			'-':
				resultado <- a-b
				Escribir 'Resultado: ', resultado
			'*':
				resultado <- a*b
				Escribir 'Resultado: ', resultado
			'/':
				Si b<>0 Entonces
					resultado <- a/b
					Escribir 'Resultado: ', resultado
				SiNo
					Escribir 'No se puede dividir entre 0'
				FinSi
			De Otro Modo:
				Escribir 'Entrada no válida'
		FinSegún
	FinPara
FinAlgoritmo
