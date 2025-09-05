Algoritmo Horoscopos
	Definir dia, mes Como Entero
	Definir sig Como Caracter
	Escribir "Ingrese su día de nacimiento"
	Leer dia
	Escribir "Ingrese su mes de nacimiento"
	Leer mes
	
	Segun mes Hacer
		Caso 1:
			Si dia >= 1 Y dia <= 19 Entonces
				Escribir "Capricornio"
			Sino	
				Si dia >= 20 Y dia <= 31 Entonces
					Escribir  "Acuario"
				FinSi
			FinSi
		Caso 2:
			Si dia >= 1 Y dia <= 18 Entonces
				Escribir "Acuario"
			Sino	
				Si dia >= 19 Y dia <= 29 Entonces
					Escribir "Piscis"
				FinSi
			FinSi
		Caso 3:
			Si dia >= 1 Y dia <= 20 Entonces
				Escribir "Piscis"
			Sino	
				Si dia >= 21 Y dia <= 31 Entonces
					Escribir "Aries"
				FinSi
			FinSi
		Caso 4:
			Si dia >= 1 Y dia <= 19 Entonces
				Escribir "Aries"
			Sino	
				Si dia >= 20 Y dia <= 30 Entonces
					Escribir "Tauro"
				FinSi
			FinSi
		Caso 5:
			Si dia >= 1 Y dia <= 20 Entonces
				Escribir "Tauro"
			Sino	
				Si dia >= 21 Y dia <= 31 Entonces
					Escribir "Géminis"
				FinSi
			FinSi
		Caso 6:
			Si dia >= 1 Y dia <= 20 Entonces
				Escribir "Geminis"
			Sino	
				Si dia >= 21 Y dia <= 30 Entonces
					Escribir "Cáncer"
				FinSi
			FinSi
		Caso 7:
			Si dia >= 1 Y dia <= 22 Entonces
				Escribir"Cáncer"
			Sino	
				Si dia >= 23 Y dia <= 31 Entonces
					Escribir "Leo"
				FinSi
			FinSi
		Caso 8:
			Si dia >= 1 Y dia <= 22 Entonces
				Escribir"Leo"
			Sino	
				Si dia >= 23 Y dia <= 31 Entonces
					Escribir "Virgo"
				FinSi
			FinSi
		Caso 9:
			Si dia >= 1 Y dia <= 22 Entonces
				Escribir "Virgo"
			Sino	
				Si dia >= 23 Y dia <= 30 Entonces
					Escribir "Libra"
				FinSi
			FinSi
		Caso 10:
			Si dia >= 1 Y dia <= 22 Entonces
				Escribir"Libra"
			Sino	
				Si dia >= 23 Y dia <= 31 Entonces
					Escribir "Escorpio"
				FinSi
			FinSi
		Caso 11:
			Si dia >= 1 Y dia <= 21 Entonces
				Escribir "Escorpio"
			Sino	
				Si dia >= 22 Y dia <= 30 Entonces
					Escribir "Sagitario"
				FinSi
			FinSi
		Caso 12:
			Si dia >= 1 Y dia <= 21 Entonces
				Escribir"Sagitario"
			Sino	
				Si dia >= 22 Y dia <= 30 Entonces
					Escribir "Capricornio"
				FinSi
			FinSi
		De Otro Modo:
			Escribir "Entrada no valida"
	FinSegun
	
FinAlgoritmo
