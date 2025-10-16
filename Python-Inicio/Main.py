print("Hola mundo")

klk = 20

def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1) 
    

print(factorial(5))

# Crea una funcion que cuente chistes al azar   import random
import random       
def contar_chiste():
    chistes = [
        "¿Por qué los pájaros no usan Facebook? Porque ya tienen Twitter.",
        "¿Qué le dijo un pez a otro pez? Nada.",
        "¿Por qué el libro de matemáticas estaba triste? Porque tenía muchos problemas.",
        "¿Qué hace una abeja en el gimnasio? ¡Zum-ba!",
        "¿Por qué los esqueletos no pelean entre ellos? Porque no tienen agallas."
    ]
    print(random.choice(chistes))

contar_chiste()

