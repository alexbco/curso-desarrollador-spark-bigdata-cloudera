"""Había una vez un sombrero. El sombrero no contenía conejo, sino una lista de cinco números: 1, 2, 3, 4, y 5.

Tu tarea es:

escribir una línea de código que solicite al usuario que reemplace el número central en la lista con un número entero ingresado por el usuario (Paso 1)
escribir una línea de código que elimine el último elemento de la lista (Paso 2)
escribir una línea de código que imprima la longitud de la lista existente (Paso 3).
¿Listo para este desafío?"""


hat_list = [1, 2, 3, 4, 5]

# Paso 1: pedir número al usuario
numero_sustituido_medio = int(input("Introduce un número para reemplazar el del medio: "))

# Paso 1: reemplazar el número del medio
indice_medio = len(hat_list) // 2
hat_list[indice_medio] = numero_sustituido_medio

# Paso 2: eliminar el último elemento
hat_list.pop()

# Paso 3: imprimir la longitud
print(f"Longitud actual de la lista: {len(hat_list)}")

# Mostrar la lista final
print("Lista actualizada:", hat_list)
