Algoritmo PasteleriaCiclo
	Definir din, snk, dinsnk, dintt Como Real
	Definir rep Como Cadena
	Escribir '¿Desea registrar una venta? (Si/No)'
	Leer rep
	Mientras Minusculas(rep)='si' Hacer
		Escribir 'Sabores: 1.Manzana 2.Fresa. 3.Chocoloate'
		Escribir 'Ingrese su sabor: '
		Leer sab
		Según sab Hacer
			1:
				din <- 200
			2:
				din <- 250
			3:
				Escribir 'Chocolate: 1.Negro 2.Blanco'
				Leer choc
				Si choc=1 Entonces
					din <- 280
				SiNo
					din <- 300
				FinSi
			De Otro Modo:
				Escribir 'No valido'
		FinSegún
		Escribir 'Snack´s: fresa, galleta, durazno'
		Escribir '¿Cuántos snaks desea agregar?'
		Leer snk
		dinsnk <- din+(snk*25)
		Escribir 'Nombre personalisado (si/no)'
		Leer nom
		Si Minusculas(nom)='si' Entonces
			dintt <- dinsnk+30
		SiNo
			dintt <- dinsnk+0
		FinSi
		Escribir 'Su total es de: ', dintt
		Escribir '¿Desea registrar otra venta? (Si/No)'
		Leer rep
	FinMientras
FinAlgoritmo
