Algoritmo Horario
	Definir hora Como Entero
	Definir rep Como Cadena
	Repetir
		Escribir '�Qu� hora es? (Ingrese la hora en formato hrs.)'
		Leer hora
		Seg�n hora Hacer
			6, 7, 8, 9, 10, 11, 12:
				Escribir 'Buenos d�as'
			13, 14, 15, 16, 17, 18, 19, 20:
				Escribir 'Buenas tardes'
			21, 22, 23, 24, 1, 2, 3, 4, 5:
				Escribir 'Buenas noches'
			De Otro Modo:
				Escribir 'Entrada no valida'
		FinSeg�n
		Escribir '�Desea introducir otra hora?'
		Leer rep
	Hasta Que Minusculas(rep)='no'
FinAlgoritmo
