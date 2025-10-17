import sys
 
print(sys.getsizeof(4), end = " bytes (entero)\n")
print(sys.getsizeof(4.0), end = " bytes (flotante)\n")

print(sys.getsizeof(""), end = " bytes (por defecto para cadenas vacías)\n")
print(sys.getsizeof("a"), end = " bytes\n")
print(sys.getsizeof("ab"), end = " bytes\n")
print(sys.getsizeof("abc"), end = " bytes\n")
print(sys.getsizeof("abcd"), end = " bytes\n")
print(sys.getsizeof("abcde"), end = " bytes\n")
print(sys.getsizeof("abcdefÑ"), end = " bytes\n")

print(len("".encode("utf-8")))  # 0 bytes de contenido real
print(len("á".encode("utf-8"))) # 2 bytes