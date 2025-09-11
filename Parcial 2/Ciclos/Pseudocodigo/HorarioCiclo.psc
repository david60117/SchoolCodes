Algoritmo Horario
	Definir hora Como Entero
	Definir rep Como Cadena
	Repetir
		Escribir '¿Qué hora es? (Ingrese la hora en formato hrs.)'
		Leer hora
		Según hora Hacer
			6, 7, 8, 9, 10, 11, 12:
				Escribir 'Buenos días'
			13, 14, 15, 16, 17, 18, 19, 20:
				Escribir 'Buenas tardes'
			21, 22, 23, 24, 1, 2, 3, 4, 5:
				Escribir 'Buenas noches'
			De Otro Modo:
				Escribir 'Entrada no valida'
		FinSegún
		Escribir '¿Desea introducir otra hora?'
		Leer rep
	Hasta Que Minusculas(rep)='no'
FinAlgoritmo
