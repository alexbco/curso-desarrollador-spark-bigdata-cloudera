
# Comprender las columnas
# PassengerId: identificador único del pasajero. 
# Survived: si el pasajero sobrevivió (0 = no, 1 = sí). 
# Pclass: clase del billete (1 = primera, 2 = segunda, 3 = tercera) — es un proxy de estatus socio-económico. 
# Name: nombre del pasajero.
# Sex: género del pasajero (male/female).
# Age: edad en años (puede haber valores fraccionarios para bebés). 
# SibSp: número de hermanos/esposos a bordo. 
# Parch: número de padres/hijos a bordo. 
# Ticket: número o código del billete.
# Fare: tarifa pagada por el billete.
# Cabin: número de camarote (muchos valores faltan). 
# Embarked: puerto de embarque (C = Cherbourg, Q = Queenstown, S = Southampton). 



##########################################################
# TUTORIAL BÁSICO DE PANDAS CON EL DATASET DEL TITANIC
# Fuente de datos: https://github.com/datasciencedojo/datasets/blob/master/titanic.csv
# Autor: Ejemplo educativo para practicar pandas sin usar gráficos
##########################################################

import pandas as pd

# =========================================================
# 1. CARGA DE DATOS
# =========================================================
file = "titanic.csv"
df = pd.read_csv(file)

print("=== Primeras 5 filas ===")
print(df.head(), "\n")

print("=== Información general del DataFrame ===")
print(df.info(), "\n")

print("=== Estadísticas básicas ===")
print(df.describe(), "\n")

print("=== Dimensiones del DataFrame ===")
print("Filas:", df.shape[0], "Columnas:", df.shape[1], "\n")

# =========================================================
# 2. INSPECCIÓN Y LIMPIEZA DE DATOS
# =========================================================
print("=== Valores nulos por columna ===")
print(df.isnull().sum(), "\n")

# Eliminamos columnas poco útiles para análisis inicial
df = df.drop(columns=["Cabin", "Ticket", "Name", "PassengerId"])

# Rellenamos valores faltantes en 'Age' con la media
df["Age"].fillna(df["Age"].mean(), inplace=True)

# Rellenamos 'Embarked' con el valor más frecuente
df["Embarked"].fillna(df["Embarked"].mode()[0], inplace=True)

print("=== Después de la limpieza ===")
print(df.info(), "\n")

# =========================================================
# 3. ANÁLISIS DESCRIPTIVO
# =========================================================
print("=== Número de pasajeros por sexo ===")
print(df["Sex"].value_counts(), "\n")

print("=== Número de pasajeros por clase ===")
print(df["Pclass"].value_counts().sort_index(), "\n")

print("=== Tasa de supervivencia global ===")
print(f"{df['Survived'].mean() * 100:.2f}%\n")

print("=== Tasa de supervivencia por sexo ===")
print(df.groupby("Sex")["Survived"].mean().to_string(index=False) * 100, "\n")

print("=== Tasa de supervivencia por clase ===")
print(df.groupby("Pclass")["Survived"].mean().to_string(index=False) * 100, "\n")

print("=== Edad promedio por clase ===")
print(df.groupby("Pclass")["Age"].mean().to_string(index=False), "\n")

print("=== Edad promedio por sexo ===")
print(df.groupby("Sex")["Age"].mean().to_string(index=False), "\n")

print("=== Tarifa promedio (Fare) por clase ===")
print(df.groupby("Pclass")["Fare"].mean().to_string(index=False), "\n")

print("=== Pasajeros por puerto de embarque ===")
print(df["Embarked"].value_counts(), "\n")

print("=== Supervivencia por puerto de embarque ===")
print(df.groupby("Embarked")["Survived"].mean() * 100, "\n")

# =========================================================
# 4. CREACIÓN DE NUEVAS COLUMNAS
# =========================================================
# Tamaño de la familia = hermanos/esposos + padres/hijos + pasajero mismo
df["FamilySize"] = df["SibSp"] + df["Parch"] + 1

# Indicador de si viajaba solo o no
df["IsAlone"] = df["FamilySize"] == 1

print("=== Ejemplo de nuevas columnas ===")
print(df[["SibSp", "Parch", "FamilySize", "IsAlone"]].head().to_string(index=False), "\n")

print("=== Tasa de supervivencia según si viajaba solo ===")
print(df.groupby("IsAlone")["Survived"].mean() * 100, "\n")

# =========================================================
# 5. FILTRADO Y CONSULTAS
# =========================================================
print("=== Primeros 5 pasajeros mayores de 60 años ===")
print(df[df["Age"] > 60].head().to_string(index=False), "\n")

print("=== Pasajeros de primera clase que sobrevivieron ===")
print(df[(df["Pclass"] == 1) & (df["Survived"] == 1)][["Sex", "Age", "Fare"]].head().to_string(index=False), "\n")

print("=== Pasajeros menores de 12 años que no sobrevivieron ===")
print(df[(df["Age"] < 12) & (df["Survived"] == 0)][["Sex", "Pclass", "Age"]].head().to_string(index=False), "\n")

# =========================================================
# 6. AGRUPACIONES MÁS COMPLEJAS
# =========================================================
print("=== Supervivencia por clase y sexo ===")
print(df.groupby(["Pclass", "Sex"])["Survived"].mean() * 100, "\n")

print("=== Edad media y tarifa media por clase y sexo ===")
print(df.groupby(["Pclass", "Sex"])[["Age", "Fare"]].mean(), "\n")

# =========================================================
# 7. EXPORTAR RESULTADOS
# =========================================================
df.to_csv("titanic_limpio.csv", index=False)
print("Archivo titanic_limpio.csv generado correctamente.\n")

print("=== FIN DEL ANÁLISIS ===")
##########################################################
