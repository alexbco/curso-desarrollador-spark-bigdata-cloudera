my_list = [1, 2, 4, 4, 1, 4, 2, 6, 2, 9]

lista_sin_repetidos = []
 
for num in my_list:
    if num not in lista_sin_repetidos:
        lista_sin_repetidos.append(num) 


print("La lista con elementos únicos:")
print(lista_sin_repetidos)


