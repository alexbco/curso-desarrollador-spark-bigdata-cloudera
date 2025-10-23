palabras = ["pera", "manzana", "kiwi", "plátano", "fresa"]

# el método sort devuelve None, modifica la lista existente pero no la devuelve

palabras.sort()
print(palabras)


def longitud(cadena):
    return len(cadena)

palabras.sort(key=longitud)
print(palabras)

palabras.sort(key=lambda c: len(c))
print(palabras)

# la función sorted crea una lista nueva ordenada y la devuelve

ordenadas = sorted(palabras)
print("Original:", palabras)
print("Ordenadas:", ordenadas)


ordenadas = sorted(palabras, key=longitud)
print("Por longitud:", ordenadas)


ordenadas = sorted(palabras, key=lambda c: len(c))
print("Por longitud (lambda):", ordenadas)
