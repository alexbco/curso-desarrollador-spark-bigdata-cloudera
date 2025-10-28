# module.py

# Variable "global" del módulo
contador = 0

def saludar(nombre):
    """
    Devuelve un saludo personalizado.
    """
    return f"Hola {nombre}, bienvenido 😎"

def sumar(a, b):
    """
    Suma dos números y devuelve el resultado.
    """
    return a + b

def incrementar_contador():
    """
    Sube el contador interno en 1 y devuelve el nuevo valor.
    OJO: usamos 'global' para modificar la variable contador definida arriba.
    """
    global contador
    contador += 1
    return contador

# Este bloque solo se ejecuta si corres module.py directamente
if __name__ == "__main__":
    print("🔥 Ejecutando module.py directamente...")
    print(saludar("Alex"))
    print("2 + 3 =", sumar(2, 3))
    print("Contador tras 3 incrementos:")
    print(incrementar_contador())
    print(incrementar_contador())
    print(incrementar_contador())
else:
    # Esto se ejecuta cuando otro archivo importa este módulo
    print("📦 module.py ha sido importado correctamente ✅")
