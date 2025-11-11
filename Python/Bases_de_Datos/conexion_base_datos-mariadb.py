# necesario instalar módulo
# para conectar a mariaDB
# desde terminal:
# sudo apt update
# sudo apt update
# sudo apt install libmariadb-dev python3-venv python3-pip
# python3 -m venv myenv
# source myenv/bin/activate

###########################################################################################
# crear la base de datos si no existe (por si acaso)
# CREATE DATABASE IF NOT EXISTS training CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

# USE training

# CREATE TABLE IF NOT EXISTS empleados (
#     id INT AUTO_INCREMENT PRIMARY KEY,
#     nombre VARCHAR(100) NOT NULL,
#     edad INT,
#     salario DECIMAL(10,2)
# );

# -- Mostrar las tablas existentes (opcional)
# SHOW TABLES;

# INSERT INTO empleados (nombre, edad, salario) VALUES
# ('Ana Torres', 28, 32000.00),
# ('Luis Gómez', 35, 41000.50),
# ('María Sánchez', 42, 52000.00),
# ('Carlos Ruiz', 30, 39000.75),
# ('Laura Pérez', 26, 31000.00),
# ('José Ramírez', 45, 58000.25),
# ('Lucía Fernández', 33, 43000.10),
# ('Miguel Castro', 29, 36000.00),
# ('Elena Moreno', 31, 40000.00),
# ('Pedro Ortega', 40, 47000.90),
# ('Carmen Navarro', 27, 33500.00),
# ('Javier Vidal', 38, 49500.00),
# ('Patricia León', 36, 46500.80),
# ('David Martín', 34, 44500.00),
# ('Sandra Gil', 32, 42000.00),
# ('Raúl Domínguez', 39, 48000.60),
# ('Beatriz Molina', 25, 30500.00),
# ('Alberto Ríos', 41, 51000.00),
# ('Nuria Delgado', 37, 46000.00),
# ('Francisco López', 43, 53000.00);
###########################################################################################
import mariadb
#############################################
# comprobar la versión de mariaDB
#############################################
print(mariadb.__version__)

# Configuración de la conexión a la base de datos

config = {
    "host": "localhost",
    "user": "training",
    "password": "training",
    "database": "training",
    "port": 3306
}
#############################################
# prueba de conexión a la base de datos
#############################################

# try:
#     conn = mariadb.connect(**config)
#     print("Conectado")
# except mariadb.Error as e:
#     print(f"Error al conectar: {e}")
# finally:
#     if 'conn' in locals():
#         conn.close()

#############################################
# consultar las tablas de la base de datos
# con SHOW_TABLES
#############################################

# try:
#     conn = mariadb.connect(**config)
#     cursor = conn.cursor()

#     # Consulta para obtener las tablas de la base de datos actual
#     cursor.execute("SHOW TABLES")

#     print("Tablas en la base de datos 'training':")
#     for (tabla,) in cursor:
#         print(f" - {tabla}")

# except mariadb.Error as e:
#     print(f"Error al recuperar las tablas: {e}")

# finally:
#     if 'conn' in locals():
#         cursor.close()
#         conn.close()

#############################################
# consultar las tablas de la base de datos
# con information_schema.tables
#############################################

# try:
#     conn = mariadb.connect(**config)
#     cursor = conn.cursor()

#     # Consulta para obtener las tablas de la base de datos actual
#     cursor.execute( """
#         SELECT table_name, engine, table_rows 
#         FROM information_schema.tables 
#         WHERE table_schema = 'training'
#     """ )

#     print( "Detalles de las tablas:" )
#     for (tabla, engine, filas) in cursor:
#       print( f" - {tabla} | Motor: {engine} | Filas estimadas: {filas}" )

# except mariadb.Error as e:
#     print(f"Error al recuperar las tablas: {e}")

# finally:
#     if 'conn' in locals():
#         cursor.close()
#         conn.close()

#############################################
# Comprobar la estructura de una tabla
# con SHOW_COLUMNS
#############################################
# try:
#     conn = mariadb.connect(**config)
#     cursor = conn.cursor()

#     cursor.execute("SHOW COLUMNS FROM empleados")

#     # Definir el ancho de cada columna
#     widths = [15, 20, 6, 8, 10, 15]

#     # Imprimir encabezados con ancho fijo
#     headers = ["Nombre", "Tipo", "Nulo", "Clave", "Default", "Extra"]
#     print("-" * sum(widths))
#     print("".join(h.ljust(w) for h, w in zip(headers, widths)))
#     print("-" * sum(widths))

#     # Imprimir cada fila con formato fijo
#     for fila in cursor:
#         print("".join(str(valor).ljust(w) for valor, w in zip(fila, widths)))

#     print("-" * sum(widths))

# except mariadb.Error as e:
#     print(f"Error al obtener la estructura: {e}")

# finally:
#     if 'conn' in locals():
#         cursor.close()
#         conn.close()

#############################################
# Comprobar la estructura de una tabla
# con DESCRIBE
#############################################
# try:
#     conn = mariadb.connect(**config)
#     cursor = conn.cursor()

#     # Obtener la estructura de la tabla
#     cursor.execute("DESCRIBE emp")

#     # Definir el ancho de cada columna
#     widths = [15, 20, 6, 8, 10, 15]

#     # Imprimir encabezados con ancho fijo
#     headers = ["Nombre", "Tipo", "Nulo", "Clave", "Default", "Extra"]
#     print("-" * sum(widths))
#     print("".join(h.ljust(w) for h, w in zip(headers, widths)))
#     print("-" * sum(widths))

#     # Imprimir cada fila con formato fijo
#     for fila in cursor:
#         print("".join(str(valor).ljust(w) for valor, w in zip(fila, widths)))

#     print("-" * sum(widths))

# except mariadb.Error as e:
#     print(f"Error al obtener la estructura: {e}")

# finally:
#     if 'conn' in locals():
#         cursor.close()
#         conn.close()

#############################################
# eliminación de tablas
#############################################
# try:
#     conn = mariadb.connect(**config)
#     cursor = conn.cursor()

#     # Eliminar la tabla 'empleados'
#     cursor.execute("DROP TABLE IF EXISTS empleados")
#     # conn.commit()
#     print("Tabla 'empleados' eliminada correctamente.")

# except mariadb.Error as e:
#     print(f"Error: {e}")

# finally:
#     cursor.close()
#     conn.close()

#############################################
# creación de tablas
#############################################
# try:
#     conn = mariadb.connect(**config)
#     cursor = conn.cursor()

#     cursor.execute("""
#         CREATE TABLE IF NOT EXISTS empleados (
#             id INT AUTO_INCREMENT PRIMARY KEY,
#             nombre VARCHAR(100) NOT NULL,
#             edad INT,
#             salario DECIMAL(10,2)
#         )
#     """)
#     # conn.commit()
#     print("Tabla 'empleados' creada correctamente.")

# except mariadb.Error as e:
#     print(f"Error: {e}")

# finally:
#     cursor.close()
#     conn.close()

#############################################
# inserción de datos
#############################################

# try:
#     conn = mariadb.connect(**config)
#     cursor = conn.cursor()

#     cursor.execute("INSERT INTO empleados (nombre, edad, salario) VALUES (%s, %s, %s)",
#                    ("César Martín", 30, 45000.50))
#     conn.commit()
#     print("Empleado insertado correctamente.")

# except mariadb.Error as e:
#     print(f"Error: {e}")

# finally:
#     cursor.close()
#     conn.close()

#############################################
# recuperación de datos
#############################################

try:
    conn = mariadb.connect(**config)
    cursor = conn.cursor()

    cursor.execute("SELECT * FROM empleados")
    empleados = cursor.fetchall()

    print("ID  | Nombre          | Edad | Salario")
    print("---------------------------------------")
    for emp in empleados:
        print(f"{emp[0]:<3} | {emp[1]:<>15} | {emp[2]:>4} | {emp[3]:<7}")

except mariadb.Error as e:
    print(f"Error: {e}")

finally:
    cursor.close()
    conn.close()

#############################################
# actualización de datos
#############################################

# try:
#     conn = mariadb.connect(**config)
#     cursor = conn.cursor()

#     cursor.execute("UPDATE empleados SET salario = %s WHERE nombre = %s",
#                    (50000, "César Martín"))

#     if cursor.rowcount == 0:
#         raise mariadb.Error("El empleado no existe en la tabla")

#     conn.commit()
#     print("Salario actualizado correctamente.")

# except mariadb.Error as e:
#     print(f"Error: {e}")
# finally:
#     cursor.close()
#     conn.close()

#############################################
# eliminación de datos
#############################################

# try:
#     conn = mariadb.connect(**config)
#     cursor = conn.cursor()

#     cursor.execute("DELETE FROM empleados WHERE nombre = %s", 
#                     ("César Martín",))

#     if cursor.rowcount == 0:
#         raise mariadb.Error("El empleado no existe en la tabla")

#     conn.commit()
#     print("Empleado eliminado correctamente.")

# except mariadb.Error as e:
#     print(f"Error: {e}")

# finally:
#     cursor.close()
#     conn.close()

