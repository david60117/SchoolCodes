Algoritmo Meses
	Definir mes Como Entero
	Definir rep Como Cadena
	Repetir
		Escribir 'Ingresa el n�mero correspondiente al mes'
		Leer mes
		Seg�n mes Hacer
			1:
				Escribir 'Enero, 31 d�as'
			2:
				Escribir 'Febrero, 28 d�as'
			3:
				Escribir 'Marzo, 31 d�as'
			4:
				Escribir 'Abril, 30 d�as'
			5:
				Escribir 'Mayo, 31 d�as'
			6:
				Escribir 'Junio, 30 d�as'
			7:
				Escribir 'Julio, 31 d�as'
			8:
				Escribir 'Agosto, 31 d�as'
			9:
				Escribir 'Septiembre, 30 d�as'
			10:
				Escribir 'Octubre, 31 d�as'
			11:
				Escribir 'Noviembre, 30 d�as'
			12:
				Escribir 'Diciembre, 31 d�as'
			De Otro Modo:
				Escribir 'No v�lido'
		FinSeg�n
		Escribir '�Requiere ingresar otro mes? (Si/No)'
		Leer rep
	Hasta Que Minusculas(rep)='no'
FinAlgoritmo
