Algoritmo AreasFiguras
	Definir lad, bas, alt, rad, res Como Real
	Definir selec Como Entero
	Escribir "¿De que figura quieres conocer tu areá?"
	Escribir "1. Cuadrado. 2.Rectángulo. 3.Triángulo. 4.Circulo."
	Leer selec
	
	Segun selec hacer
		Caso 1:
			Escribir "lado: "
			Leer lad
			res=lad*lad
			Escribir "Area: ",res
		Caso 2:
			Escribir "base: "
			Leer bas
			Escribir "altura: "
			Leer alt
			res=bas*alt
			Escribir "Area: ",res
		Caso 3:
			Escribir "base: "
			Leer bas
			Escribir "altura: "
			Leer alt
			res=(bas*alt)/2
			Escribir "Area: ",res
		Caso 4:
			Escribir "Radio. "
			Leer rad
			res= 3.1416*(rad)^2
			Escribir "Area: ", res
		De Otro Modo:
			Escribir "Entrada no valida"
	FinSegun
FinAlgoritmo
