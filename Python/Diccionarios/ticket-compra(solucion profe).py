# ========================================
# TICKET DE CAJA CON FUNCIONES
# ========================================

catalogo = {
    "Manzanas": (1.5, 5),
    "Peras": (2.0, 3),
    "Plátanos": (1.2, 6),
    "Fresas": (3.0, 2)
}

carrito = {}

# -----------------------------
# Mostrar catálogo
# -----------------------------
def mostrar_catalogo(catalogo):
    print("\n=== CATÁLOGO DE PRODUCTOS ===")
    for nombre, (precio, stock) in catalogo.items():
        print(f"- {nombre:10} | Precio: {precio:.2f} € | Stock: {stock}")
    print()

# -----------------------------
# Agregar productos al carrito
# -----------------------------
def agregar_al_carrito(catalogo, carrito):
    while True:
        mostrar_catalogo(catalogo)  # Mostrar catálogo actualizado
        producto = input("Producto (o 'fin' para terminar): ").capitalize()
        if producto == "Fin":
            break

        if producto not in catalogo:
            print("El producto no existe en el catálogo.\n")
            continue

        precio, stock = catalogo[producto]

        if stock == 0:
            print(f"Lo sentimos, {producto} está agotado.\n")
            continue

        cantidad_str = input("Cantidad: ")

        # Validar que la cantidad sea un número positivo
        if not cantidad_str.isdigit():
            print("La cantidad debe ser un número entero positivo.\n")
            continue

        cantidad = int(cantidad_str)

        if cantidad <= 0:
            print("La cantidad debe ser mayor que cero.\n")
            continue

        if cantidad > stock:
            print(f"Solo quedan {stock} unidades de {producto}. No se añadió al carrito.\n")
            continue

        # Añadir al carrito
        if producto in carrito:
            carrito[producto] += cantidad
        else:
            carrito[producto] = cantidad

        # Actualizar stock inmediatamente
        nuevo_stock = stock - cantidad
        catalogo[producto] = (precio, nuevo_stock)

        print(f"{cantidad} {producto} añadidos al carrito.")
        if nuevo_stock == 0:
            print(f"Aviso: {producto} se ha quedado sin stock.\n")
        else:
            print(f"Stock restante de {producto}: {nuevo_stock}\n")

# -----------------------------
# Mostrar ticket
# -----------------------------
def mostrar_ticket(carrito, catalogo):
    if not carrito:
        print("\nNo se compró ningún producto.")
        return

    print("\n === TICKET DE COMPRA ===")
    print("-" * 50)
    total = 0

    for producto, cantidad in carrito.items():
        precio = catalogo[producto][0]
        subtotal = precio * cantidad
        total += subtotal
        print(f"{producto:10} x {cantidad:2} uds  |  {precio:5.2f} €/u  =  {subtotal:6.2f} €")

    print("-" * 50)
    print(f"TOTAL A PAGAR: {total:.2f} €")

# -----------------------------
# Mostrar stock final
# -----------------------------
def mostrar_stock_final(catalogo):
    print("\n=== STOCK FINAL ===")
    for nombre, (precio, stock) in catalogo.items():
        print(f"{nombre:10} | Stock restante: {stock}")

# -----------------------------
# Programa principal
# -----------------------------
def main():
    print("=== BIENVENIDO A LA TIENDA ===")
    agregar_al_carrito(catalogo, carrito)
    mostrar_ticket(carrito, catalogo)
    mostrar_stock_final(catalogo)

# Ejecutar programa
main()
