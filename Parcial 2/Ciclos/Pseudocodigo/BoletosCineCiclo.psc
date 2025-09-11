Algoritmo BoletosCineCiclo
	Definir per, dia, pars, din, sol Como Real
	Definir rep, mem Como Cadena
	Escribir '¿Desea registrar una venta? (Si/No)'
	Leer rep
	Mientras Minusculas(rep)='si' Hacer
		Escribir '¿Qué día es'
		Escribir '0. Domingo. 1.Lunes. 2. Martes. 3.Miércoles. 4.Jueves. 5.Viernes. 6.Sabado'
		Leer dia
		Escribir '¿Cuantas entradas desea comprar?'
		Leer per
		Escribir '¿Tiene Membresia?'
		Leer mem
		Según dia Hacer
			0, 1, 2, 5, 6:
				Si Minusculas(mem)='si' Entonces
					din <- (50*per)*0.9
				SiNo
					din <- 50*per
				FinSi
			3:
				Si Minusculas(mem)='si' Entonces
					din <- (30*per)*0.9
				SiNo
					din <- 30*per
				FinSi
			4:
				Si Minusculas(mem)='si' Entonces
					Si per MOD 2=0 Entonces
						din <- (37.5*per)*.9
					SiNo
						pars <- trunc(per/2)
						tper <- pars*2
						sol <- per MOD 2
						din <- ((tper*37.5)+(sol*50))*.9
					FinSi
				SiNo
					Si per MOD 2=0 Entonces
						din <- 37.5*per
					SiNo
						pars <- trunc(per/2)
						tper <- pars*2
						sol <- per MOD 2
						din <- ((tper*37.5)+(sol*50))
					FinSi
				FinSi
		FinSegún
		Escribir 'Su total es de: ', din
		Escribir '¿Desea registrar otra venta? (Si/No)'
		Leer rep
	FinMientras
FinAlgoritmo
