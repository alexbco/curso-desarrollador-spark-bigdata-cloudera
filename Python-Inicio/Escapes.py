'''Ejemplos de uso de comillas y secuencias de escape en Python.

Este archivo muestra varias formas de imprimir cadenas que contienen
comillas dobles internas. Cada ejemplo usa una técnica distinta:

- Usar secuencias de escape (\") dentro de una cadena normal.
- Separar cadenas y dejar que `print` las concatene con comas.
- Usar el parámetro `sep` de `print` para insertar saltos de línea.
- Usar cadenas multilínea (triple comilla simple) para incluir
  comillas dobles y caracteres especiales tal cual.
- Construir cadenas concatenando multiplicaciones y literales.

La salida muestra tres bloques con comillas: "Estoy", ""aprendiendo""
y una línea con varias comillas dobles alrededor de la palabra Python.
'''

# 1) Uso de secuencias de escape: \" representa una comilla doble dentro
#    de una cadena delimitada por comillas simples o dobles.
print('"Estoy"\n""aprendiendo""\n"""Python"""')

# 2) Pasar varias cadenas a print separadas por comas. Aquí algunas
#    cadenas incluyen \n explícitos; print añade un espacio entre argumentos
#    a menos que se cambie `sep`.
print('"Estoy"\n','""aprendiendo""\n','"""Python"""')

# 3) Igual que el anterior, pero usando sep="\n" para que cada argumento
#    se imprima en una línea distinta sin espacios adicionales.
print('"Estoy"','""aprendiendo""','"""Python"""', sep = "\n")

# 4) Cadena multilínea literal: las triples comillas permiten incluir
#    comillas dobles y secuencias de escape como texto, y también los
#    saltos de línea se respetan tal cual en la salida.
print('''""Estoy""\n""aprendiendo""\n"""Python"""''')

# 5) Usando escapes dentro de cadenas con comillas dobles y pasando
#    `sep="\n"` para separar las salidas en líneas.
print("\"Estoy\"", "\"\"aprendiendo\"\"", "\"\"\"Python\"\"\"", sep="\n")

# 6) Construcción dinámica: multiplicamos el carácter '"' para generar
#    1, 2 o 3 comillas alrededor del texto. Esto ilustra concatenación
#    y multiplicación de cadenas.
print(1*'"' + "Estoy"+1*'"' , 2 * '"' + "aprendiendo" + 2 * '"' , 3 * '"' + "python" + 3 * '"' ,sep="\n")