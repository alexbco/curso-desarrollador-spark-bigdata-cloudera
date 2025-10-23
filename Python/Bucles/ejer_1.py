from io import StringIO

# ejemplos de los "tipos" de for más comunes en Python
# archivo: ejer_1.py
# Cada bloque muestra una variante/documentación breve en español.

def for_sobre_lista():
    # Iterar sobre una lista
    numeros = [1, 2, 3, 4]
    for n in numeros:
        print("lista:", n)


def for_con_enumerate():
    # Enumerate: índice y valor
    frutas = ["manzana", "pera", "plátano"]
    for i, fruta in enumerate(frutas):
        print("enumerate:", i, fruta)


def for_con_range():
    # range: iterar por índices o secuencias numéricas
    for i in range(0, 5):          # 0,1,2,3,4
        print("range:", i)
    for i in range(1, 10, 2):     # paso de 2
        print("range paso 2:", i)


def for_sobre_cadena():
    # Iterar sobre caracteres de una cadena
    texto = "hola"
    for ch in texto:
        print("cadena:", ch)


def for_sobre_tupla():
    # Iterar sobre tuplas
    tupla = (10, 20, 30)
    for x in tupla:
        print("tupla:", x)


def for_sobre_diccionario():
    # Iterar sobre diccionarios: claves, valores, items
    d = {"a": 1, "b": 2}
    for clave in d:                 # por defecto itera claves
        print("dict clave:", clave)
    for valor in d.values():
        print("dict valor:", valor)
    for clave, valor in d.items():  # desempaquetado de tuplas (clave, valor)
        print("dict item:", clave, valor)


def for_con_desempaquetado():
    # Desempaquetado en el propio for
    pares = [(1, "uno"), (2, "dos")]
    for numero, palabra in pares:
        print("desempaquetado:", numero, palabra)


def for_anidado():
    # Bucle for anidado
    matriz = [[1, 2], [3, 4]]
    for fila in matriz:
        for elemento in fila:
            print("anidado:", elemento)


def for_else_demo():
    # for-else: el else se ejecuta si no hubo break
    for i in range(3):
        print("for-else:", i)
    else:
        print("for-else: termine sin break")
    for i in range(3):
        if i == 1:
            break
    else:
        print("esto NO se imprimirá porque hubo break")


def for_with_break_continue():
    # break y continue dentro de for
    for i in range(5):
        if i == 2:
            print("continue en", i)
            continue
        if i == 4:
            print("break en", i)
            break
        print("normal:", i)


def for_con_reversed_zip():
    # reversed: iterar al revés
    seq = [1, 2, 3]
    for x in reversed(seq):
        print("reversed:", x)
    # zip: iterar múltiples secuencias en paralelo
    a = [1, 2, 3]
    b = ["a", "b", "c"]
    for num, letra in zip(a, b):
        print("zip:", num, letra)


def for_iterando_archivo():
    # Iterar sobre líneas de un archivo (aquí usamos StringIO para ejemplificar)
    fake_file = StringIO("línea1\nlínea2\n")
    for linea in fake_file:
        print("archivo:", linea.strip())
    fake_file.close()


def comprehension_examples():
    # Comprensiones (no son exactamente 'for' pero usan bucles internamente)
    cuadrados = [x * x for x in range(5)]
    print("comprehension list:", cuadrados)
    gen = (x * x for x in range(3))  # generador por comprensión
    for v in gen:
        print("comprehension gen:", v)


if __name__ == "__main__":
    for_sobre_lista()
    for_con_enumerate()
    for_con_range()
    for_sobre_cadena()
    for_sobre_tupla()
    for_sobre_diccionario()
    for_con_desempaquetado()
    for_anidado()
    for_else_demo()
    for_with_break_continue()
    for_con_reversed_zip()
    for_iterando_archivo()
    comprehension_examples()