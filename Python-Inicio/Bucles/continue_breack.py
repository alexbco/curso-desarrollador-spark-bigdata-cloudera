"""
Ejemplos documentados del uso de break y continue.

Archivo: continue_breack.py
"""

def ejemplo_break_for():
    """Busca el primer número par en una lista y usa break para salir del bucle."""
    nums = [1, 3, 5, 7, 8, 9, 10]
    print("Ejemplo break (for): buscar primer par")
    for n in nums:
        print(f"  comprobando {n}...")
        if n % 2 == 0:
            print(f"  -> encontrado el primer par: {n}, saliendo con break\n")
            break
    else:
        # El else del for se ejecuta solo si NO se ejecutó break
        print("  No se encontró ningún número par\n")


def ejemplo_break_for_sin_encontrar():
    """Muestra el else del for cuando no hay break."""
    nums = [1, 3, 5, 7]
    print("Ejemplo break (for) con else: no hay pares")
    for n in nums:
        print(f"  comprobando {n}...")
        if n % 2 == 0:
            print(f"  -> encontrado el primer par: {n}, saliendo con break\n")
            break
    else:
        print("  Else: No se encontró ningún número par (se llegó al final sin break)\n")


def ejemplo_continue_for():
    """Imprime números del 1 al 10 saltando los múltiplos de 3 con continue."""
    print("Ejemplo continue (for): imprimir 1..10 saltando múltiplos de 3")
    for i in range(1, 11):
        if i % 3 == 0:
            # Omite el resto del cuerpo y continúa con la siguiente iteración
            print(f"  {i} es múltiplo de 3 -> continue")
            continue
        print(f"  imprimir {i}")
    print()


def ejemplo_break_while():
    """While que cuenta hasta 10 pero se interrumpe si la suma supera 15."""
    print("Ejemplo break (while): sumar hasta que la suma supere 15")
    total = 0
    i = 1
    while True:
        print(f"  añadiendo {i} (total actual {total})")
        total += i
        if total > 15:
            print(f"  -> total {total} > 15, saliendo con break\n")
            break
        i += 1


def ejemplo_continue_while():
    """While que muestra cómo continue afecta al flujo (evitar incrementar produce bucle infinito)."""
    print("Ejemplo continue (while): saltar números pares al imprimir, evitando bucle infinito")
    i = 0
    while i < 6:
        i += 1  # IMPORTANTE: incrementar antes del continue para no crear bucle infinito
        if i % 2 == 0:
            print(f"  {i} es par -> continue")
            continue
        print(f"  imprimir {i}")
    print()


def ejemplo_break_en_bucle_anidado():
    """Muestra que break sale solo del bucle más interno."""
    print("Ejemplo break en bucle anidado:")
    for fila in range(1, 4):
        for col in range(1, 6):
            print(f"  fila {fila}, col {col}")
            if col == 3:
                print("  -> break rompe solo el bucle interior (col)\n")
                break
        else:
            print("  else del bucle interior (no se ejecuta si hubo break)")
        print("  continuación del bucle exterior\n")


if __name__ == "__main__":
    ejemplo_break_for()
    ejemplo_break_for_sin_encontrar()
    ejemplo_continue_for()
    ejemplo_break_while()
    ejemplo_continue_while()
    ejemplo_break_en_bucle_anidado()