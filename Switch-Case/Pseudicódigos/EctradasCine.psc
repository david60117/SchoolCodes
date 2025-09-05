Algoritmo EctradasCine
	Definir per, dia, pars, din, sol Como Real
	Definir mem Como Logico
	Escribir "¿Qué día es"
	Escribir "0. Domingo. 1.Lunes. 2. Martes. 3.Miércoles. 4.Jueves. 5.Viernes. 6.Sabado"
	Leer dia
	Escribir "¿Cuantas entradas desea comprar?"
	Leer per
	Escribir "¿Tiene Membresia?"
	Leer mem
	
	Segun dia Hacer
		caso 0,1,2,5,6:
			Si mem Entonces
				din=(50*per)*0.9
			SiNo
				din=50*per
			FinSi
		caso 3:
			Si mem Entonces
				din=(30*per)*0.9
			SiNo
				din=30*per
			FinSi
		caso 4:
			Si mem Entonces
				Si per%2=0 Entonces
					din=(37.5*per)*.9
				SiNo
					pars=trunc(per/2)
					tper=pars*2
					sol= per%2
					din=((tper*37.5)+(sol*50))*.9
				FinSi
			SiNo
				Si per%2=0 Entonces
					din=37.5*per
				SiNo
					pars=trunc(per/2)
					tper=pars*2
					sol= per%2
					din=((tper*37.5)+(sol*50))
				FinSi
			FinSi
	FinSegun
	Escribir "Su total es de: ", din
FinAlgoritmo
