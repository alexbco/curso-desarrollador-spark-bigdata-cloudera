package condicionales

import scala.io.StdIn

object condicionales extends App {

  def sentenciasCondicionales(): Unit = {

    //        val num1 = 10
    //        val num2 = 20
    //
    //        if (num1 > num2) {
    //          println(s"${num1} es mayor que ${num2}")
    //        } else if (num1 < num2) {
    //          println(s"${num1} es menor que ${num2}")
    //        } else {
    //          println(s"${num1} es igual que ${num2}")
    //        }
    //
    println("Introduzca un valor numérico entero:")
    var numero = StdIn.readInt()
    //
    //        if (numero < 0)
    //          println(s"El número $numero es negativo")
    //        else if (numero > 0 )
    //          println(s"El número $numero es positivo")
    //        else
    //          println(s"El número $numero es igual a cero")

    // Expresiones if
    var resultado = if (numero < 0) "negativo"
    else if (numero > 0) "positivo"
    else "igual a cero"

    println(s"El número $numero es $resultado")

    // pattern matching para ejecutar instrucciones
    numero match {
      case menor if (numero < 0) => println(s"El número $menor es negativo")
      case mayor if (numero > 0) => println(s"El número $mayor es positivo")
      case _ => println(s"El número $numero es igual a cero")
    }

    //    pattern matching asignando valor a una variable
    resultado = numero match {
      case menor if (numero < 0) => "negativo"
      case mayor if (numero > 0) => "positivo"
      case _ => "igual a cero"
    }
    println(s"El número $numero es $resultado")

    // Preguntando por valores concretos:
    val num1 = 1

    val resultado2 = num1 match {
      case 1 | 2 | 3 => "entre 1 y 3"
      case 4 | 5 | 6 => "entre 4 y 6"
      case _ => "en otros casos"
    }
    println(s"El número $num1 está comprendido $resultado2")
    //
  }
}