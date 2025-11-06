package ejercicios

import scala.io.StdIn
import scala.util.Random
import scala.util.control.Breaks


object main extends App {

  //ejer1()
  //ejer2()
  //ejer3()
  //ejer4()
  //ejemplosAny(2)
  //invertir_cadena()
  omitir_duplicados()

  def ejer1(): Unit = {
    // Solicita al usuario su nombre y muestra un mensaje de bienvenida.
    val nombre = StdIn.readLine("Introduce tu nombre:")
    val apellidos = StdIn.readLine("Introduce tus apellidos:")
    println(s"Hola $nombre $apellidos")
  }

  def ejer2(): Unit = {
    // Solicita dos números y muestra la suma, resta, multiplicación y división.
    val numero1 = StdIn.readLine("Introduce numero 1:").toDouble
    val numero2 = StdIn.readLine("Introduce tu numero 2:").toDouble

    println(s"Suma: ${numero1+numero2}")
    println(s"Resta: ${numero1-numero2}")
    println(s"Multiplicacion: ${numero1*numero2}")
    println(s"Division: ${numero1/numero2}")
  }

  def ejer3(): Unit = {
    // Solicita una temperatura (flotante) en °C conviértela a °F.
    // Fórmula: (grados_celsius * 9 / 5 + 32)
    val grados_celsius = StdIn.readLine("Temperatura (flotante) en °C: ").toFloat
    val grados_celsius_a_celtius = grados_celsius * 9 / 5 + 32
    println(s"La convesion es $grados_celsius_a_celtius")

  }

  def ejer4(): Unit = {
    // solicitar al usuario que adivine un número generado aleatoriamente mediante
    //Random.nextInt(10) + 1
    //contar en cuantos intentos se adivina el numero
    //  e informar cuando fallamos de si nos hemos quedado por encima o por debajo del numero secreto
    val numero_limite = StdIn.readLine("Del un al...").toInt
    val numero_random = Random.nextInt(numero_limite) + 1
    var cont = 0
    var adivinaste = false
    while (adivinaste == false) {
      var numero_usuario = StdIn.readLine("Adivina el numero: ").toInt
      if (numero_usuario ==  numero_random){
        cont += 1
        adivinaste = true
      }else{
        if (numero_usuario>numero_random){
          println("Te has quedado por encima")
        }else{
          println("Te has quedado por debajo")
        }
        cont += 1
      }
    }
    println(s"Adivinase con $cont intentos")

  }

  def ejemplosAny(valorGenerico: Any): Unit = {
    println("El parámetro es de tipo "+ valorGenerico.getClass)

    if (valorGenerico.isInstanceOf[String]){

      val miString = valorGenerico.asInstanceOf[String]
      println(s"Y podemos invocar directamente a métodos como toUpperCase: ${miString.toUpperCase}")

    }else if (valorGenerico.isInstanceOf[Integer]){
      val miEntero = valorGenerico.asInstanceOf[Integer]
      println(s"Y podemos sumar o multiplicar el valor: ${miEntero + 10}")
    }else {
      println("El valor no es un String ni un Integer y no se puede convertir de forma segura")
    }

  }

  def ejemplosAnyCase(valorGenerico: Any): Unit = {
    valorGenerico match {
      case miString: String =>
        println(s"Has pasado un String con valor: '$miString'")

      case miEntero: Int =>
        println(s"Has pasado un número entero: $miEntero")

      case miDecimal: Double =>
        println(s"Has pasado un número decimal: $miDecimal")

      case miBooleano: Boolean =>
        println(s"Has pasado un valor booleano: $miBooleano")

      case null =>
        println("Has pasado un valor nulo (null)")

      case _ =>
        println(s"No reconozco el tipo del valor: $valorGenerico")
    }
  }

  def invertir_cadena(): Unit = {
    var cadena: String = StdIn.readLine("Introduce la cadena: ")
    cadena = cadena.reverse
    println(cadena)
  }

  def omitir_duplicados(): Unit = {
    //var cadena: String = StdIn.readLine("Introduce la cadena: ")
    val cadena = "Holaaa quee taall"
    var resultado = ""
    for (i <- cadena){
      if (i == ' '){
        if (!resultado.contains(i)) {
          resultado += i
        }
      }

    }
    print(resultado)


  }



}
