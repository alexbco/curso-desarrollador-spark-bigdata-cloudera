import math
import logging

# Configuramos logging (guarda errores en un archivo)
logging.basicConfig(filename="errores.log", level=logging.ERROR, format="%(asctime)s - %(levelname)s - %(message)s")

print("=== DEMO COMPLETA DE TRY/EXCEPT ===\n")

while True:
    try:
        # 🧮 Pedimos dos números
        num1 = int(input("👉 Introduce el primer número: "))
        num2 = int(input("👉 Introduce el segundo número: "))

        # 🧨 Posibles errores: división, raíz negativa, etc.
        division = num1 / num2
        raiz = math.sqrt(num1)  # error si num1 es negativo

        print(f"✅ División: {num1} / {num2} = {division:.2f}")
        print(f"✅ Raíz cuadrada de {num1} = {raiz:.2f}")

        # 💥 Forzamos un posible error de tipo
        if num1 == 13:
            raise TypeError("Número 13 prohibido (mala suerte 😈)")

        # 🟢 Si todo va bien, salimos del bucle
        break

    # 1️⃣ Error de conversión
    except ValueError as e:
        print(f"❌ Valor no válido: {e}")
        logging.error(f"ValueError: {e}")

    # 2️⃣ División por cero
    except ZeroDivisionError as e:
        print(f"💀 No se puede dividir entre 0: {e}")
        logging.error(f"ZeroDivisionError: {e}")

    # 3️⃣ Error matemático (raíz de número negativo)
    except ValueError as e:
        print(f"⚠️ Error matemático: {e}")
        logging.error(f"MathError: {e}")

    # 4️⃣ Error de tipo (nuestro personalizado)
    except TypeError as e:
        print(f"🚫 Error de tipo: {e}")
        logging.error(f"TypeError: {e}")

    # 5️⃣ Captura genérica (cualquier otro error)
    except Exception as e:
        print(f"😵 Error desconocido: {type(e).__name__} → {e}")
        logging.error(f"Unhandled Exception: {type(e).__name__}: {e}")

    # 6️⃣ Si NO hubo errores → se ejecuta else
    else:
        print("🎉 Todo salió perfecto, no hubo errores.")

    # 7️⃣ Se ejecuta SIEMPRE → cierre de recursos, limpieza, etc.
    finally:
        print("🔚 Fin del intento (esto se ejecuta siempre)\n")
