def solucion1():
    blocks = int(input("Ingresa el número de bloques: "))
    height = 0
    bloques_necesarios = 1  # cantidad de bloques que necesita la capa actual

    while blocks >= bloques_necesarios:
        blocks -= bloques_necesarios   # usamos esa cantidad de bloques
        height += 1        # aumentamos la altura
        bloques_necesarios += 1        # la siguiente capa necesitará uno más

    print("La altura de la pirámide es:", height)

def solucion2():
    blocks = int(input("Ingresa el número de bloques: "))
    nivel = 0
    while blocks >= 1:
        nivel = nivel +1    
        blocks = blocks - nivel
    print("La altura de la pirámide es:", nivel)


solucion2()
