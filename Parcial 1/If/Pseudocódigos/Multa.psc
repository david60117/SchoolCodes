Algoritmo Multa
	Escribir "�Es tu cumplea�os? 1.S�  2.No"
	Leer cump, velocidad
	Si cump = 2 Entonces
		Si velocidad <= 60 Entonces
			Escribir "O = Sin multa"
		SiNo
			Si velocidad > 60 y valocidad <=80 Entonces
				Escribir "1 = Multa peque�a"
			SiNo
				Escribir "2 = Multa grande"
			FinSi
		FinSi
	SiNo
		Escribir "No hay multa"
	FinSi
FinAlgoritmo
