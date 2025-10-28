from sys import path

# Añadimos la ruta de la carpeta donde está nuestro módulo
# (si estás ejecutando main.py desde fuera de /Modulos)
path.append('..\\modules')

# Mostramos todas las rutas que Python usa para buscar módulos
for ruta in path:
    print(ruta)

# Importamos nuestro módulo personalizado
import module

print("\n🧠 Estamos en main.py\n")

# Podemos acceder a las funciones del módulo
print(module.saludar("Alex"))
print("Suma:", module.sumar(5, 7))

# También podemos leer variables del módulo
print("Contador actual:", module.contador)

# Llamamos varias veces a incrementar_contador
print("Nuevo valor del contador:", module.incrementar_contador())
print("Nuevo valor del contador:", module.incrementar_contador())

# Si quieres usar un alias
import module as mod
print(mod.saludar("con alias mod 😎"))
