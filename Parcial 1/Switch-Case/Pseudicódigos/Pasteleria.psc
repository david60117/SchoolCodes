Algoritmo Pasteleria
	
	Escribir 'Sabores: 1.Manzana 2.Fresa. 3.Chocoloate'
	Escribir 'Ingrese su sabor: '
	Leer sab
	Seg�n sab Hacer
		Caso 1:
			din <- 200
		Caso 2:
			din <- 250
		Caso 3:
			Escribir 'Chocolate: 1.Negro 2.Blanco'
			Leer choc
			Si choc=1 Entonces
				din <- 280
			SiNo
				din <- 300
			FinSi
	FinSeg�n
	Escribir 'Snack�s: fresa, galleta, durazno'
	Escribir '�Cu�ntos snaks desea agregar?'
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
FinAlgoritmo
