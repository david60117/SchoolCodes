Algoritmo PolCompTelef
	
	Escribir "Politicas de cobro sobre el uso del teléfono"
	Definir min, dia, turn Como Entero
	Definir prec, tprec Como Real
	Escribir "0. Domingo. 1.Lunes. 2. Martes. 3.Miércoles. 4.Jueves. 5.Viernes. 6.Sábado"
	Escribir "Qué día es: "
	Leer dia
	Escribir "Turno: (1.Matutino 2.Vespertino)"
	Leer turn
	Escribir "Minutos: "
	Leer min
	
	Si	min<=5 Entonces
		prec=(min)
	SiNo
		Si min>=6 y min <=8 Entonces
			prec=(5+((min%5)*(0.8)))
		SiNo
			Si min>=9 y min <=10 Entonces
				prec=(7.4+((min%8)*(0.7)))
			SiNo
				prec=(8.8+((min-10)*(0.5)))
			FinSi
		FinSi
	FinSi
	
	Segun dia Hacer
		Caso 0:
			tprec=prec*1.03
		Caso 1,2,3,4,5,6:
			si turn=1 Entonces
				tprec=prec*1.15
			SiNo
				si	turn=2 Entonces
					tprec=prec*1.1
				SiNo
					Escribir "Entrada no valida"
				FinSi
			FinSi
		De Otro Modo:
			Escribir "error"
	FinSegun
	Escribir "Precio antes de imp.: ", prec
	Escribir "Precio: ", tprec
	
FinAlgoritmo
