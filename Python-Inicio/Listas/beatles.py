# Paso 1: crea una lista vacía llamada beatles
beatles = []
print("Paso 1:", beatles)

# Paso 2: agrega los primeros tres miembros
beatles.append("John Lennon")
beatles.append("Paul McCartney")
beatles.append("George Harrison")
print("Paso 2:", beatles)

# Paso 3: agrega Stu Sutcliffe y Pete Best usando for y append
for miembro in ["Stu Sutcliffe", "Pete Best"]:
    beatles.append(miembro)
print("Paso 3:", beatles)

# Paso 4: elimina a Stu Sutcliffe y Pete Best
beatles.remove("Stu Sutcliffe")
beatles.remove("Pete Best")
print("Paso 4:", beatles)

# Paso 5: agrega a Ringo Starr al principio
beatles.insert(0, "Ringo Starr")
print("Paso 5:", beatles)

# Resultado final
print("\nLos Beatles finales son:", beatles)
