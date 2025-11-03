import pandas as pd
# print(pd.__version__)

#########################################################
# creación de un DataFrame a partir de un diccionario
#########################################################

# data = {
#     'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Edad': [53, 35, 59, 26],
#     'Salario': [2800, 3500, 2175, 3250]
# }

# df = pd.DataFrame(data)
# print(df)
# print(df.columns)

#########################################################
# guardar datos de DataFrame en un fichero csv
#########################################################

# data = {
#     'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Edad': [53, 35, 59, 26],
#     'Salario': [2800, 3500, 2175, 3250]
# }
# df = pd.DataFrame(data)

# # Guardar el DataFrame a un archivo CSV
# df.to_csv('empleados.csv', index=False)

#########################################################
# leer datos del fichero csv y cargarlos en el DataFrame
#########################################################

# df = pd.read_csv('empleados.csv')

# # Mostrar las primeras n filas del DataFrame
# print(df.head(n= 3))

##################################################################
# recuperar datos de la base de datos y cargarlos en el DataFrame
##################################################################

# import mariadb
# import pandas as pd

# # Configuración de la conexión a la base de datos
# config = {
#     "host": "localhost",
#     "user": "training",
#     "password": "training",
#     "database": "training",
#     "port": 3306
# }

# # Conectar a la base de datos
# try:
#     conn = mariadb.connect( **config )
#     query = "SELECT * FROM emp"

#     # Usar pandas para cargar los datos directamente en un DataFrame
#     df = pd.read_sql( query, conn )

#     # Mostrar las primeras filas del DataFrame
#     print( df.head(n= 5) )

# except mariadb.Error as e:
#     print( f"Error al conectar a la base de datos: {e}" )

# finally:
#     # Cerrar la conexión
#     conn.close()


#########################################################
# filtrar datos del DataFrame
#########################################################

data = {
    'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
    'Edad': [53, 35, 59, 26],
    'Salario': [2800, 3500, 2175, 3250]
}
df = pd.DataFrame(data)

# Filtrar empleados mayores de 30 años
df_mayores_30 = df[df['Edad'] > 30]
print(df_mayores_30)

##################################################################
# modificar datos del DataFrame
##################################################################

# data = {
#     'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Edad': [53, 35, 59, 26],
#     'Salario': [2800, 3500, 2175, 3250]
# }
# df = pd.DataFrame(data)

# # Aumentar el salario en un 10% para todos los empleados
# df['Salario'] = df['Salario'] * 1.10
# print(df)

##################################################################
# agrupar y resumir datos de un DataFrame
##################################################################

# data = {
#     'Departamento': ['Ventas', 'Ventas', 'Finanzas', 'Finanzas'],
#     'Empleado': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Salario': [2800, 3500, 2175, 3250]
# }
# df = pd.DataFrame(data)

# print(df)

# # Agrupar por Departamento y calcular el salario promedio
# df_agrupado = df.groupby('Departamento')['Salario'].mean()
# print(df_agrupado)

##################################################################
# eliminación de columnas de un DataFrame
##################################################################

# data = {
#     'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Edad': [53, 35, 59, 26],
#     'Salario': [2800, 3500, 2175, 3250]
# }
# df = pd.DataFrame(data)

# # Eliminar la columna 'Edad'
# # axis=1:
# # El parámetro axis especifica si estamos eliminando filas o columnas.
# # axis=0 se usa para eliminar filas (por defecto).
# # axis=1 se usa para eliminar columnas.

# # inplace=True modifica el DataFrame original directamente y no devuelve una nueva copia.

# df.drop('Edad', axis=1, inplace=True)
# print(df)

##################################################################
# añadir columnas a un DataFrame a partir de valores constantes
##################################################################

# data = {
#     'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Edad': [53, 35, 59, 26],
#     'Salario': [2800, 3500, 2175, 3250]
# }
# df = pd.DataFrame(data)
# df['Ciudad'] = 'Madrid'
# print(df)

##################################################################
# añadir columnas a un DataFrame a partir de una expresión
##################################################################

# data = {
#     'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Edad': [53, 35, 59, 26],
#     'Salario': [2800, 3500, 2175, 3250]
# }
# df = pd.DataFrame(data)
# df['Salario anual'] = df['Salario'] * 14
# print(df)

##################################################################
# añadir columnas a un DataFrame a partir de una lista
##################################################################

# data = {
#     'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Edad': [53, 35, 59, 26],
#     'Salario': [2800, 3500, 2175, 3250]
# }
# df = pd.DataFrame(data)

# ciudades = ['Madrid', 'Barcelona', 'Valencia', 'La Coruña']
# df['Ciudad'] = ciudades
# print(df)

##################################################################
# añadir varias columnas a la vez a un DataFrame
##################################################################

# data = {
#     'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Edad': [53, 35, 59, 26],
#     'Salario': [2800, 3500, 2175, 3250]
# }
# df = pd.DataFrame(data)

# nuevas_columnas = {
#     'Telefono': ['676777555', '987666444', '345666555', '448666556'],
#     'Direccion': ['Mi Calle 24', 'Su Calle 38', 'Otra Calle 32', 'Otra Calle 29']
# }

# # Añadir las nuevas columnas al DataFrame
# df = df.assign(**nuevas_columnas)

# # Mostrar el DataFrame resultante
# print(df)

##################################################################
# acceso a campos individuales de un DataFrame con loc()
##################################################################

# data = {
#     'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Edad': [53, 35, 59, 26],
#     'Salario': [2800, 3500, 2175, 3250]
# }
# df = pd.DataFrame(data)

# # Acceder al valor de la celda en la fila 1 (índice 1) y columna 'Edad'
# valor_edad_marta = df.loc[1, 'Edad']

# print(f"La edad de Marta es: {valor_edad_marta}")

##################################################################
# acceso a campos individuales de un DataFrame con iloc()
##################################################################

# data = {
#     'Nombre': ['César', 'Marta', 'Carlos', 'Laura'],
#     'Edad': [53, 35, 59, 26],
#     'Salario': [2800, 3500, 2175, 3250]
# }
# df = pd.DataFrame(data)

# # Acceder al valor de la celda en la fila 1 (índice 1) y columna 'Edad'
# valor_edad_marta = df.iloc[1, 1]
# print(f"La edad de Marta es: {valor_edad_marta}")
