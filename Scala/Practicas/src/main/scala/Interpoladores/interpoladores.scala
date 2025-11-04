package Interpoladores

case object interpoladores extends App {
  interpolators()

  def interpolators(): Unit = {
    // Variables de ejemplo
    val nombre = "Alex"
    val edad = 22
    val altura = 1.74

    // 🟢 1. Interpolador 's' → permite incrustar variables directamente
    println(s"Hola, me llamo $nombre y tengo $edad años.")
    println(s"El año que viene tendré ${edad + 1} años.")

    // 🟡 2. Interpolador 'f' → permite formato, como printf en otros lenguajes
    println(f"Mi altura es de $altura%.2f metros.") // %.2f → 2 decimales
    println(f"Edad en formato con ceros: $edad%03d") // %03d → 3 dígitos con ceros delante

    // 🔵 3. Interpolador 'raw' → ignora caracteres de escape (\n, \t, etc.)
    println(raw"Texto con salto de línea \n que no se interpreta.")
    println("Texto con salto de línea \n que sí se interpreta.")

    // 🧠 Extra: combinar lógica con interpoladores
    val mayorEdad = if (edad >= 18) "sí" else "no"
    println(s"¿Soy mayor de edad? $mayorEdad")
  }
}
