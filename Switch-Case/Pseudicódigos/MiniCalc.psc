Algoritmo  MiniCalc
    Definir a, b, resultado Como Entero
    Definir ope Como Caracter
	
    Escribir "Escribe dos n�meros enteros"
	
    Escribir "a: "
    Leer a
	
    Escribir "b: "
    Leer b
	
    Escribir "Escribe un car�cter comprendido entre (+, -, *, /): "
    Leer ope
	
    Segun ope Hacer
        '+':
            resultado <- a + b
            Escribir "Resultado: ", resultado
        '-':
            resultado <- a - b
            Escribir "Resultado: ", resultado
        '*':
            resultado <- a * b
            Escribir "Resultado: ", resultado
        '/':
            Si b <> 0 Entonces
                resultado <- a / b
                Escribir "Resultado: ", resultado
            SiNo
                Escribir "No se puede dividir entre 0"
            FinSi
        De Otro Modo:
            Escribir "Entrada no v�lida"
    FinSegun
FinAlgoritmo

