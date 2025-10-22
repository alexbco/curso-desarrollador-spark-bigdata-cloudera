#Detecta si hay repetidos en una lista 
#cual es el mayor
lista = []


def cual_es_mayor(lista):
    elemento_mayor = 0
    for i in range(len(lista)):
        if (lista[i] >= elemento_mayor):
            elemento_mayor = lista[i]
    return elemento_mayor


while True:
    elemento = int(input("Introduce un elemento a la lista, introduce 0 para salir: \n"))
    if elemento == 0:
        break
    if elemento in lista:
        print("No puedes introducir un elemento añadido anteriormente.")
    else:
        lista.append(elemento)
        print("Elemento añadido correctamente.")

# Mostrar la lista final
print("\nLista final:", lista)
print("El elemento mayor es:",cual_es_mayor(lista))