"""
Introducción ampliada sobre parámetros en funciones (Python)

Este archivo muestra cómo definir y llamar funciones usando parámetros posicionales,
parámetros con valores por defecto, argumentos por nombre (keyword arguments),
*y **args, y parámetros solo por nombre.

Conceptos clave:
- Parámetros posicionales: se pasan en el orden definido.
- Valores por defecto: permiten omitir argumentos al llamar; deben ir al final de la lista
    de parámetros posicionales normales.
- Argumentos por nombre: permiten pasar parámetros en cualquier orden indicando el nombre.
- *args: recoge argumentos posicionales adicionales como una tupla.
- **kwargs: recoge argumentos por nombre adicionales como un diccionario.
- Parámetros solo por nombre: se declaran después de un '*' en la firma.
- Precaución: no usar objetos mutables (listas, dicts) como valores por defecto si van a modificarse,
    porque se comparten entre llamadas. Usar None y crear el objeto dentro.
- Buenas prácticas: documentar la función con un docstring y preferir llamadas explícitas
    con nombres cuando haya muchos parámetros o valores por defecto.
"""

def f1(p1, p2, p3='valor por defecto para p3', p4='valor por defecto para p4', p5='valor por defecto para p5'):
        """Ejemplo sencillo: imprime p1, p2 y p3.

        Parámetros:
        - p1, p2: obligatorios (posicionales).
        - p3, p4, p5: opcionales, con valores por defecto.
        """
        print("f1:", p1, p2, p3, p4, p5)

# Llamadas de ejemplo:
f1(1, 2, 3)                    # todos por posición
f1(1, 2)                       # usa valores por defecto para p3, p4, p5
f1(p1=1, p2=2, p3=3)           # por nombre
f1(1, 2, p5=5)                 # combinación: posicionales + keyword

############################################
# Uso de *args para múltiples argumentos posicionales extra

def f_args(a, b, *args):
        """a y b obligatorios; *args recoge el resto de posicionales."""
        print("f_args: a =", a, "b =", b)
        print("args como tupla:", args)
        for i, val in enumerate(args, start=1):
                print(f"  arg extra {i} =", val)

# Ejemplos:
f_args(10, 20)
f_args(10, 20, 30, 40, 50)

############################################
# Uso de **kwargs para argumentos por nombre adicionales

def f_kwargs(x, y=2, **kwargs):
        """x obligatorio; y con valor por defecto; **kwargs recoge keywords extra."""
        print("f_kwargs: x =", x, "y =", y)
        print("kwargs:", kwargs)
        if 'z' in kwargs:
                print("  z encontrado en kwargs:", kwargs['z'])

# Ejemplos:
f_kwargs(1)
f_kwargs(1, y=99, z=3, otro='valor')

############################################
# Combinar *args y **kwargs (orden: posicionales, *args, keywords normales, **kwargs)

def f_mix(a, b=0, *args, c='C', **kwargs):
        """Mezcla: a, b, luego *args, parámetro con nombre c (tiene valor por defecto),
        y **kwargs para extras por nombre."""
        print("f_mix: a =", a, "b =", b, "c =", c)
        print("args:", args)
        print("kwargs:", kwargs)

# Ejemplos:
f_mix(1)
f_mix(1, 2, 3, 4, 5, c='clave', extra=42)

############################################
# Forzar parámetros solo por nombre usando '*' en la firma

def f_kwonly(a, b, *, obligatorio, opcional='def'):
        """obligatorio solo puede pasarse por nombre."""
        print("f_kwonly:", a, b, "obligatorio =", obligatorio, "opcional =", opcional)

# Ejemplos:
f_kwonly(1, 2, obligatorio='sí')
f_kwonly(1, 2, obligatorio='sí', opcional='otro')

# Si se intenta pasar 'obligatorio' por posición ocurrirá TypeError:
# f_kwonly(1, 2, 'sí')  # <- no permitido

############################################
# Precaución con valores por defecto mutables

def append_bad(value, lista=[]):
        """MALA práctica: la lista por defecto se comparte entre llamadas."""
        lista.append(value)
        return lista

def append_good(value, lista=None):
        """BUENA práctica: crear la lista dentro para evitar compartirla."""
        if lista is None:
                lista = []
        lista.append(value)
        return lista

# Ejemplos que muestran la diferencia:
print("append_bad llamadas:")
print(append_bad(1))   # [1]
print(append_bad(2))   # [1, 2] <- resultado inesperado si no se sabe esto

print("append_good llamadas:")
print(append_good(1))  # [1]
print(append_good(2))  # [2] <- independiente

############################################
# Ejemplo práctico: sumar números recibidos por posición y por nombre

def sumar_muchos(*args, inicial=0, **kwargs):
        """Suma todos los números pasados por posición en args y por nombre en kwargs.
        'inicial' es un acumulador inicial (keyword-only con valor por defecto)."""
        total = inicial
        for v in args:
                total += v
        for k, v in kwargs.items():
                total += v
        return total

# Ejemplos:
print("sumar_muchos(1,2,3) =", sumar_muchos(1, 2, 3))
print("sumar_muchos(1,2, a=3, b=4) =", sumar_muchos(1, 2, a=3, b=4))
print("sumar_muchos(1,2, inicial=10, extra=5) =", sumar_muchos(1, 2, inicial=10, extra=5))