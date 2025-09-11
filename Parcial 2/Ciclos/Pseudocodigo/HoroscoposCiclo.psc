Algoritmo Horoscopos
	Definir dia, mes, numcump, rep Como Entero
	Definir sig Como Cadena
	Escribir 'Cuantas fechas de nacimiento desea ingresar: '
	Leer numcump
	Para rep<-1 Hasta numcump Con Paso 1 Hacer
		Escribir 'Cumpleños no. ', rep
		Escribir 'Ingrese su día de nacimiento'
		Leer dia
		Escribir 'Ingrese su mes de nacimiento'
		Leer mes
		Según mes Hacer
			1:
				Si dia>=1 Y dia<=19 Entonces
					Escribir 'Capricornio'
				SiNo
					Si dia>=20 Y dia<=31 Entonces
						Escribir 'Acuario'
					FinSi
				FinSi
			2:
				Si dia>=1 Y dia<=18 Entonces
					Escribir 'Acuario'
				SiNo
					Si dia>=19 Y dia<=29 Entonces
						Escribir 'Piscis'
					FinSi
				FinSi
			3:
				Si dia>=1 Y dia<=20 Entonces
					Escribir 'Piscis'
				SiNo
					Si dia>=21 Y dia<=31 Entonces
						Escribir 'Aries'
					FinSi
				FinSi
			4:
				Si dia>=1 Y dia<=19 Entonces
					Escribir 'Aries'
				SiNo
					Si dia>=20 Y dia<=30 Entonces
						Escribir 'Tauro'
					FinSi
				FinSi
			5:
				Si dia>=1 Y dia<=20 Entonces
					Escribir 'Tauro'
				SiNo
					Si dia>=21 Y dia<=31 Entonces
						Escribir 'Géminis'
					FinSi
				FinSi
			6:
				Si dia>=1 Y dia<=20 Entonces
					Escribir 'Geminis'
				SiNo
					Si dia>=21 Y dia<=30 Entonces
						Escribir 'Cáncer'
					FinSi
				FinSi
			7:
				Si dia>=1 Y dia<=22 Entonces
					Escribir 'Cáncer'
				SiNo
					Si dia>=23 Y dia<=31 Entonces
						Escribir 'Leo'
					FinSi
				FinSi
			8:
				Si dia>=1 Y dia<=22 Entonces
					Escribir 'Leo'
				SiNo
					Si dia>=23 Y dia<=31 Entonces
						Escribir 'Virgo'
					FinSi
				FinSi
			9:
				Si dia>=1 Y dia<=22 Entonces
					Escribir 'Virgo'
				SiNo
					Si dia>=23 Y dia<=30 Entonces
						Escribir 'Libra'
					FinSi
				FinSi
			10:
				Si dia>=1 Y dia<=22 Entonces
					Escribir 'Libra'
				SiNo
					Si dia>=23 Y dia<=31 Entonces
						Escribir 'Escorpio'
					FinSi
				FinSi
			11:
				Si dia>=1 Y dia<=21 Entonces
					Escribir 'Escorpio'
				SiNo
					Si dia>=22 Y dia<=30 Entonces
						Escribir 'Sagitario'
					FinSi
				FinSi
			12:
				Si dia>=1 Y dia<=21 Entonces
					Escribir 'Sagitario'
				SiNo
					Si dia>=22 Y dia<=30 Entonces
						Escribir 'Capricornio'
					FinSi
				FinSi
			De Otro Modo:
				Escribir 'Entrada no valida'
		FinSegún
	FinPara
FinAlgoritmo
