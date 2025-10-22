c0 = int(input("Ingresa el valor de c0: "))
pasos = 0
while True:
    if c0 % 2 == 0:
        c0 = c0 / 2
        pasos += 1
    else:
        c0 = 3 * c0 + 1
        pasos +=1
    print(c0)
    if c0 == 1:
        print(f"Pasos: {pasos}")
        break

