catalogo = {
    "Manzanas": (1.5, 5),
    "Peras": (2.0, 3),
    "Plátanos": (1.2, 6),
    "Fresas": (3.0, 2)
}

carrito = {}  # ejemplo: { "Manzanas": 3, "Peras": 1 }


def mostrar_catalogo(catalogo):
    print("\n--- CATÁLOGO ---")
    print(f"{'Producto':<10} {'Precio€/u':<10} {'Stock':<10}")
    for producto, (precio, stock) in catalogo.items():
        print(f"{producto:<10} {precio:<10.2f} {stock:<10}")
    print("----------------\n")


def agregar_al_carrito(catalogo, carrito):
    while True:
        producto = input("Introduce el producto que quieres (o 'fin' para terminar): ").strip()

        if producto.lower() == "fin":
            break

        # 1. ¿Existe en el catálogo?
        if producto not in catalogo:
            print("❌ Ese producto no existe en el catálogo.\n")
            continue

        # 2. Pedimos cantidad
        cantidad_str = input(f"¿Cuántas unidades de {producto} quieres?: ").strip()

        if not cantidad_str.isdigit():
            print("❌ La cantidad debe ser un entero positivo.\n")
            continue

        cantidad = int(cantidad_str)
        if cantidad <= 0:
            print("❌ La cantidad debe ser mayor que 0.\n")
            continue

        # 3. ¿Hay stock suficiente?
        precio_unitario, stock_disponible = catalogo[producto]

        if cantidad > stock_disponible:
            print(f"⚠️ Stock insuficiente. Solo quedan {stock_disponible} unidades de {producto}.\n")
            continue

        # 4. Añadir al carrito (acumular si ya lo tenía)
        if producto in carrito:
            carrito[producto] += cantidad
        else:
            carrito[producto] = cantidad

        # 5. Actualizar stock en catálogo
        nuevo_stock = stock_disponible - cantidad
        catalogo[producto] = (precio_unitario, nuevo_stock)

        print(f"✅ Añadido al carrito: {cantidad} x {producto}\n")


def mostrar_ticket(catalogo, carrito):
    print("\n===== TICKET DE COMPRA =====")
    print(f"{'Producto':<12} {'Cant.':<6} {'€/u':<8} {'Subtotal':<10}")

    total_general = 0.0

    for producto, cantidad in carrito.items():
        precio_unitario, _ = catalogo[producto]
        subtotal = precio_unitario * cantidad
        total_general += subtotal

        print(f"{producto:<12} {cantidad:<6} {precio_unitario:<8.2f} {subtotal:<10.2f}")

    print("----------------------------")
    print(f"TOTAL A PAGAR: {total_general:.2f} €")
    print("============================\n")


def mostrar_stock_final(catalogo):
    print("📦 STOCK FINAL EN TIENDA:")
    for producto, (precio, stock) in catalogo.items():
        print(f"- {producto}: {stock} uds restantes")
    print()


# ========== Flujo principal ==========

print("Bienvenido al súper 🛒")
mostrar_catalogo(catalogo)

agregar_al_carrito(catalogo, carrito)

if len(carrito) == 0:
    print("No has comprado nada 😭")
else:
    mostrar_ticket(catalogo, carrito)

mostrar_stock_final(catalogo)
