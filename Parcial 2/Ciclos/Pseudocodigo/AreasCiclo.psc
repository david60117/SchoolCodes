Algoritmo AreasCiclo
	Definir lad, bas, alt, rad, res Como Real
	Definir selec Como Entero
	Definir rep Como Cadena
	Repetir
		Escribir '�De que figura quieres conocer tu are�?'
		Escribir '1. Cuadrado. 2.Rect�ngulo. 3.Tri�ngulo. 4.Circulo.'
		Leer fig
		Seg�n fig Hacer
			1:
				Escribir 'lado: '
				Leer lad
				res <- lad*lad
				Escribir 'Area: ', res
			2:
				Escribir 'base: '
				Leer bas
				Escribir 'altura: '
				Leer alt
				res <- bas*alt
				Escribir 'Area: ', res
			3:
				Escribir 'base: '
				Leer bas
				Escribir 'altura: '
				Leer alt
				res <- (bas*alt)/2
				Escribir 'Area: ', res
			4:
				Escribir 'Radio. '
				Leer rad
				res <- 3.1416*(rad)^2
				Escribir 'Area: ', res
			De Otro Modo:
				Escribir 'Entrada no valida'
		FinSeg�n
		Escribir '�Quiere obtener el �rea de otra figura?'
		Leer rep
	Hasta Que Minusculas(rep)='no'
FinAlgoritmo
