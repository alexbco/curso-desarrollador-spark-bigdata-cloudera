package bisiesto

import scala.io.StdIn

//es bisiento expresion if

//es bisiesto sentecia

//es bisiesto pattern matching

//El año tiene que ser superior al 1582
//Un año es bisiesto si es divisible por 4,
//excepto si es divisible por 100 pero no por 400.
//Por lo tanto, los años divisibles por 400 son bisiestos,
//pero los años divisibles por 100 (que no son divisibles por 400) no lo son

//horas minutos segundos añadir uno y ver resultado

object bisiesto extends App{

  horas_minutos_segundos()

  def bisiesto_expresion_if(): Unit = {
    println("Introduzca un año:")
    var año = StdIn.readInt()
    while (año<1582){
      año = if (año > 1582) año else StdIn.readInt()
    }
    val es_bisiesto = if ((año%4 == 0) && (año %100 != 0 || año %400 == 0 )) true else false
    println(es_bisiesto)
  }

  def bisiesto_sentencia_if(): Unit = {
    println("Introduzca un año:")
    var año = StdIn.readInt()
    while (año < 1582) {
      año = if (año > 1582) año else StdIn.readInt()
    }
    if ((año%4 == 0) && (año %100 != 0 || año %400 == 0 )){
      val es_bisiesto = true
    }else{
      val es_bisiesto = false
    }
  }

  def bisiesto_pattern_matching(): Unit = {
    val año = StdIn.readLine("Introduce un año: ").toInt

    // El pattern matching principal
    val resultado = año match {

      // Caso 1: año menor que 1582
      case a if a < 1582 =>
        "El cálculo solo aplica desde el año 1582 (calendario gregoriano)."

      // Caso 2: divisible entre 400 → bisiesto
      case a if a % 400 == 0 =>
        s"El año $a es bisiesto (divisible entre 400)."

      // Caso 3: divisible entre 100 → no bisiesto
      case a if a % 100 == 0 =>
        s"El año $a NO es bisiesto (divisible entre 100 pero no entre 400)."

      // Caso 4: divisible entre 4 → bisiesto
      case a if a % 4 == 0 =>
        s"El año $a es bisiesto (divisible entre 4)."

      // Caso por defecto → no bisiesto
      case _ =>
        s"El año $año NO es bisiesto."
    }

    println(resultado)

  }


  def horas_minutos_segundos(): Unit = {

    // Pedimos los datos
    print("Introduce las horas (0-23): ")
    var horas = StdIn.readInt()

    print("Introduce los minutos (0-59): ")
    var minutos = StdIn.readInt()

    print("Introduce los segundos (0-59): ")
    var segundos = StdIn.readInt()

    print("Introduce los segundos que quieres añadir: ")
    val segundosExtra = StdIn.readInt()

    // --- SUMA DE SEGUNDOS ---
    segundos = segundos + segundosExtra
    if (segundos > 59) {
      minutos = minutos + segundos / 60 // cuántos minutos se generan
      segundos = segundos % 60 // el resto de segundos
    }

    // --- SUMA DE MINUTOS ---
    if (minutos > 59) {
      horas = horas + minutos / 60 // cuántas horas se generan
      minutos = minutos % 60 // el resto de minutos
    }

    // --- CONTROL DE HORAS ---
    if (horas > 23) {
      horas = horas % 24 // si pasa de 23, vuelve a 0
    }

    // --- RESULTADO ---
    println("La nueva hora es: %02d:%02d:%02d".format(horas, minutos, segundos))
  }

}