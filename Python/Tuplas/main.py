# ============================================
# 🧠 CHULETARIO DE TUPLAS EN PYTHON 🧩
# ============================================

print("=== 🧩 CHULETARIO DE TUPLAS EN PYTHON ===\n")

# 1️⃣ Qué es una tupla
mi_tupla = (1, 2, 3)
print("Tupla básica:", mi_tupla)

# Pueden contener diferentes tipos
mix = (1, "Alex", 3.14, True)
print("Tupla mixta:", mix, "\n")

# 2️⃣ Crear tuplas
vacia = ()
una_sola = (5,)
sin_parentesis = 1, 2, 3
print("Tupla vacía:", vacia)
print("Tupla con un solo elemento:", una_sola)
print("Tupla sin paréntesis:", sin_parentesis, "\n")

# 3️⃣ Acceder a elementos
t = (10, 20, 30, 40)
print("Primer elemento:", t[0])
print("Último elemento:", t[-1], "\n")

# 4️⃣ Recorrer una tupla
print("Recorriendo la tupla:")
for x in t:
    print("-", x)
print()

# 5️⃣ Desempaquetar valores
persona = ("Alex", 22, "España")
nombre, edad, pais = persona
print(f"Nombre: {nombre}, Edad: {edad}, País: {pais}")

# Ignorar un valor con _
nombre, _, pais = persona
print("Desempaquetando ignorando edad:", nombre, pais, "\n")

# 6️⃣ Concatenar y multiplicar
a = (1, 2)
b = (3, 4)
print("Concatenar:", a + b)
print("Multiplicar:", a * 3, "\n")

# 7️⃣ Funciones útiles
nums = (1, 2, 2, 3, 5, 3)
print("len(nums):", len(nums))
print("sum(nums):", sum(nums))
print("max(nums):", max(nums))
print("min(nums):", min(nums))
print("¿Está el 2?:", 2 in nums)
print("count(2):", nums.count(2))
print("index(3):", nums.index(3), "\n")

# 8️⃣ Conversión entre lista y tupla
lista = list(nums)
print("Tupla convertida en lista:", lista)
lista.append(10)
nueva_tupla = tuple(lista)
print("Lista vuelta a tupla:", nueva_tupla, "\n")

# 9️⃣ Tuplas anidadas
anidada = (("Alex", 22), ("Juan", 25))
print("Tupla anidada:", anidada)
print("Primer nombre:", anidada[0][0], "\n")

# 🔟 Usos típicos
# Datos fijos
coordenadas = (40.5, -3.7)
print("Coordenadas:", coordenadas)

# Claves de diccionario (porque son inmutables)
puntos = {(0, 0): "Inicio", (1, 2): "Destino"}
print("Diccionario con claves tipo tupla:", puntos)

# Retornar varios valores desde una función
def datos_usuario():
    return ("Alex", 22, "Guadalajara")

nombre, edad, ciudad = datos_usuario()
print(f"Datos usuario → Nombre: {nombre}, Edad: {edad}, Ciudad: {ciudad}\n")

# 11️⃣ Diferencias con listas
print("Diferencias entre lista y tupla:")
print("""
| Característica | Lista [] | Tupla () |
|----------------|-----------|-----------|
| Mutable        | Sí ✅     | No ❌     |
| Velocidad      | Más lenta | Más rápida |
| Uso común      | Datos que cambian | Datos fijos |
""")

# 12️⃣ Ejemplos prácticos
frutas = ("manzanas", "peras", "fresas")
print("Tupla de frutas:", frutas)
print("Segunda fruta:", frutas[1])

if "fresas" in frutas:
    print("Sí, hay fresas 🍓")

# Desempaquetar
a, b, c = frutas
print("Desempaquetado:", a, b, c)

# Concatenar
nueva = frutas + ("plátanos",)
print("Concatenada:", nueva)

# Contar
print("Número de peras:", nueva.count("peras"))

# Convertir a lista y volver a tupla
lista_frutas = list(nueva)
lista_frutas.append("kiwis")
print("Lista:", lista_frutas)
print("De vuelta a tupla:", tuple(lista_frutas), "\n")

# ⚡ Extra: tupla de un solo elemento
t1 = (5)
t2 = (5,)
print("t1 =", t1, "→ tipo:", type(t1))
print("t2 =", t2, "→ tipo:", type(t2), "\n")

# 🧾 Resumen visual final
print("Resumen rápido de tuplas en Python:")
print("""
- Se crean con () → t = (1, 2, 3)
- Inmutables → no se pueden modificar
- Acceso por índices
- Se pueden recorrer con for
- Soportan len(), sum(), max(), min(), count(), index()
- Puedes convertirlas a lista con list()
- Pueden usarse como claves en diccionarios
- Desempaquetado rápido: a, b, c = (1, 2, 3)
- Una sola tupla → (5,) (con coma!)
""")

print("=== FIN DEL CHULETARIO DE TUPLAS 🧠 ===")
1