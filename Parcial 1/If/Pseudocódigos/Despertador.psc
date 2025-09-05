Algoritmo Despertador
	Definir dia  Como Entero
	Definir vac Como Logico
	Escribir "¿Son vacaciones? (true/false) "
	Leer vac
	
	Escribir "0=Domingo. 1=Lunes. 2=Martes. 3=Miercoles 4=Jueves. 5=Viernes. 6=Sábado"
	
	Escribir "Qué dia de la semana es: "
	Leer dia
	
	Si vac = Falso Entonces
		Si dia >0 y dia <6 Entonces
			Escribir "Alarma 6:00"
		SiNo
			Escribir "Alarma 9:00"
		FinSi
	SiNo
		Si dia >0 y dia <6 Entonces
			Escribir "Alarma 8:00"
		SiNo
			Escribir "Sin alarma"
		FinSi
	FinSi
	
	
FinAlgoritmo
